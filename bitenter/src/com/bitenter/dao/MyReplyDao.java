package com.bitenter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bitenter.dto.ReplyDto;
import com.bitenter.ui.SignUpLoginUI;
import com.bitenter.util.UtilClose;

public class MyReplyDao {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private final String USER = "bitenter";
    private final String PASSWORD = "bitenterpw";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 내가 쓴 글 보기
    public List<ReplyDto> selectMyReply() {
        List<ReplyDto> list = null;
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT * "
                       + "  FROM REPLY "
                       + " WHERE ID = ? ";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            
            rs = pstmt.executeQuery();
            
            list = new ArrayList<>();
            
            while(rs.next()) {
                list.add(new ReplyDto(rs.getInt("num"),
                                        rs.getString("comm"),
                                        rs.getString("id"),
                                        rs.getString("replydate")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCPR(conn, pstmt, rs);
        }
        return list;
    }
    
    // 내가 쓴 글 수정 (마이페이지 - 내가 쓴 글)
    public void updateMyReply(int num, String comm) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "UPDATE REPLY "
                       + "   SET COMM = ? "
                       + " WHERE ID = ? "
                       + "   AND NUM = ? ";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, comm);
            pstmt.setString(2, loginId);
            pstmt.setInt(3, num);
            
            int updateCount = pstmt.executeUpdate();
            if(updateCount == 0) {
                System.out.println("--------------------");
                System.out.println("게시물 번호를 잘못입력하셨습니다.");
                System.out.println("--------------------");
            } else {
                System.out.println("--------------------");
                System.out.println("수정완료");
                System.out.println("--------------------");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 내가 쓴 글 삭제 (마이페이지 - 내가 쓴 글)
    public void deleteMyReply(int num) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "DELETE FROM REPLY "
                       + " WHERE ID = ? "
                       + "   AND NUM = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            pstmt.setInt(2, num);
            
            int deleteCount = pstmt.executeUpdate();
            if(deleteCount == 0) {
                System.out.println("--------------------");
                System.out.println("게시물 번호를 잘못입력하셨습니다.");
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
}
