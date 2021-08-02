package com.bitenter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.bitenter.ui.SignUpLoginUI;
import com.bitenter.util.UtilClose;

public class WithDrawDao {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private final String USER = "bitenter";
    private final String PASSWORD = "bitenterpw";
    
    private Connection conn;
    private PreparedStatement pstmt;

    // 회원탈퇴 (마이페이지)
    public void deleteMyInfo(String pwd) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "DELETE FROM CUSTOMER "
                       + " WHERE ID = ? "
                       + "   AND PWD = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            pstmt.setString(2, pwd);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
}
