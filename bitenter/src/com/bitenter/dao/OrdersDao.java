package com.bitenter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bitenter.dto.OrdersDto;
import com.bitenter.ui.SignUpLoginUI;
import com.bitenter.util.UtilClose;

public class OrdersDao {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private final String USER = "bitenter";
    private final String PASSWORD = "bitenterpw";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 구매하기
    public void insertOrders(int itemNum) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "INSERT INTO ORDERS "
                       + "       (ID, ITEMNUM, ORDERDATE, ORDERID) "
                       + "VALUES (?, ?, sysdate, SEQ_ORDER.NEXTVAL) ";
            
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
    
    // 구매내역 확인하기 (마이페이지)
    public List<OrdersDto> selectOrdersInfo() {
        List<OrdersDto> list = null;
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT O.ORDERID, C.ID, I.ITEMNAME, I.PRICE, C.ADDRESS, O.ORDERDATE "
                       + "  FROM CUSTOMER C, ITEM I, ORDERS O "
                       + " WHERE C.ID = O.ID "
                       + "   AND I.ITEMNUM = O.ITEMNUM "
                       + "   AND C.ID = ? "
                       + " ORDER BY O.ORDERID";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            
            rs = pstmt.executeQuery();
            
            list = new ArrayList<>();
            
            while(rs.next()) {
                list.add(new OrdersDto(rs.getString("id"),
                                       rs.getString("itemname"),
                                       rs.getInt("price"),
                                       rs.getString("orderdate"),
                                       rs.getInt("orderid")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCPR(conn, pstmt, rs);
        }
        return list;
    }
    
    // 구매 선택 취소
    public void deleteOrdersInfo(int num) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "DELETE FROM ORDERS "
                       + " WHERE ID = ? "
                       + "   AND ORDERID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            pstmt.setInt(2, num);
            
            int deleteCount = pstmt.executeUpdate();
            if(deleteCount == 0) {
                System.out.println("--------------------");
                System.out.println("상품 번호를 잘못입력하셨습니다.");
                System.out.println("--------------------");
            } else {
                System.out.println("--------------------");
                System.out.println("취소완료");
                System.out.println("--------------------");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 구매 전체 취소
    public void deleteOrdersInfoAll() {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "DELETE FROM ORDERS "
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
}
