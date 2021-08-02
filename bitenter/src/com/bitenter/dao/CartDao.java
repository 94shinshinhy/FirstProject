package com.bitenter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bitenter.dto.CartDto;
import com.bitenter.dto.OrdersDto;
import com.bitenter.ui.SignUpLoginUI;
import com.bitenter.util.UtilClose;

public class CartDao {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private final String USER = "bitenter";
    private final String PASSWORD = "bitenterpw";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 장바구니에 담기
    public void insertCart(int itemNum) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "INSERT INTO CART "
                       + "       (ID, ITEMNUM, CARTID) "
                       + "VALUES (?, ?, SEQ_CART.NEXTVAL) ";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            pstmt.setInt(2, itemNum);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 장바구니 확인하기 (마이페이지)
    public List<CartDto> selectCartInfo() {
        List<CartDto> list = null;
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT T.CARTID, C.ID, I.ITEMNAME, I.PRICE "
                       + "  FROM CUSTOMER C, ITEM I, CART T "
                       + " WHERE C.ID = T.ID "
                       + "   AND I.ITEMNUM = T.ITEMNUM "
                       + "   AND C.ID = ?"
                       + " ORDER BY T.CARTID";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            
            rs = pstmt.executeQuery();
            
            list = new ArrayList<>();
            
            while(rs.next()) {
                list.add(new CartDto(rs.getString("id"),
                                     rs.getString("itemname"),
                                     rs.getInt("price"),
                                     rs.getInt("cartid")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCPR(conn, pstmt, rs);
        }
        return list;
    }
    
    // 장바구니에서 선택 구매
    public void insertCartOrders(int number) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "INSERT INTO ORDERS "
                       + "       (ID, ITEMNUM, ORDERDATE, ORDERID) "
                       + "VALUES (?, (SELECT ITEMNUM FROM CART WHERE CARTID = ?), sysdate, SEQ_ORDER.NEXTVAL) ";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            pstmt.setInt(2, number);
            
            int deleteCount = pstmt.executeUpdate();
            if(deleteCount == 0) {
                System.out.println("--------------------");
                System.out.println("상품 번호를 잘못입력하셨습니다.");
                System.out.println("--------------------");
            } else {
                System.out.println("--------------------");
                System.out.println("구매완료");
                System.out.println("--------------------");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 장바구니에서 전체 구매
    public void selectOrdersBuy() {
        List<OrdersDto> list = null;
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT ID, ITEMNUM "
                       + "  FROM CART WHERE ID = ? ";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            
            rs = pstmt.executeQuery();
            
            list = new ArrayList<>();
            
            while(rs.next()) {
                list.add(new OrdersDto(rs.getString("id"),
                                       rs.getString("itemnum")));
                
                insertOrdersString(rs.getString("id"), rs.getString("itemnum"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCPR(conn, pstmt, rs);
        }
    }
    
    public void insertOrdersString(String id, String itemnum) {
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "INSERT INTO ORDERS "
                       + "       (ID, ITEMNUM, ORDERDATE, ORDERID) "
                       + "VALUES (?, ?, sysdate, SEQ_ORDER.NEXTVAL) ";
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, id);
            pstmt.setString(2, itemnum);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 장바구니에서 선택 삭제
    public void deleteCartInfo(int number) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "DELETE FROM CART "
                       + " WHERE ID = ? "
                       + "   AND CARTID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            pstmt.setInt(2, number);
            
            int deleteCount = pstmt.executeUpdate();
            if(deleteCount == 0) {
                System.out.println("--------------------");
                System.out.println("상품 번호를 잘못입력하셨습니다.");
                System.out.println("--------------------");
            } else {
                System.out.println("--------------------");
                System.out.println("삭제완료");
                System.out.println("--------------------");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    
    // 장바구니 전체 삭제
    public void deleteCartInfoAll() {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "DELETE FROM CART "
                       + " WHERE ID = ? ";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 장바구니에서 선택 구매할 때 삭제
    public void deleteCartInfo2(int number) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "DELETE FROM CART "
                    + " WHERE ID = ? "
                    + "   AND CARTID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            pstmt.setInt(2, number);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
}
