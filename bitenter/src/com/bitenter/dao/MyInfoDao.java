package com.bitenter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bitenter.dto.SelectMyInfoDto;
import com.bitenter.dto.UpdateMyInfoDto;
import com.bitenter.ui.SignUpLoginUI;
import com.bitenter.util.UtilClose;

public class MyInfoDao {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private final String USER = "bitenter";
    private final String PASSWORD = "bitenterpw";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 내 정보 보기 (마이페이지)
    public List<SelectMyInfoDto> selectMyInfo() {
        List<SelectMyInfoDto> list = null;
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT * "
                       + "  FROM CUSTOMER "
                       + " WHERE ID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, loginId);
            
            rs = pstmt.executeQuery();
            
            list = new ArrayList<>();
            
            while(rs.next()) {
                list.add(new SelectMyInfoDto(rs.getString("id"),
                                             rs.getString("name"),
                                             rs.getString("phone"),
                                             rs.getString("address")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCPR(conn, pstmt, rs);
        }
        return list;
    }
    
    // 내 정보 전부 수정 (마이페이지)
    public void updateMyInfo(UpdateMyInfoDto updateMyInfoDto) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "UPDATE CUSTOMER "
                       + "   SET PWD = ?, "
                       + "       NAME = ?, "
                       + "       PHONE = ?, "
                       + "       ADDRESS = ? "
                       + " WHERE ID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, updateMyInfoDto.getPwd());
            pstmt.setString(2, updateMyInfoDto.getName());
            pstmt.setString(3, updateMyInfoDto.getPhone());
            pstmt.setString(4, updateMyInfoDto.getAddress());
            pstmt.setString(5, loginId);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 내 비밀번호 수정 (마이페이지)
    public void updatePwd(UpdateMyInfoDto updateMyInfoDto) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "UPDATE CUSTOMER "
                       + "   SET PWD = ? "
                       + " WHERE ID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, updateMyInfoDto.getPwd());
            pstmt.setString(2, loginId);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 내 이름 수정 (마이페이지)
    public void updateName(UpdateMyInfoDto updateMyInfoDto) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "UPDATE CUSTOMER "
                       + "   SET NAME = ? "
                       + " WHERE ID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, updateMyInfoDto.getName());
            pstmt.setString(2, loginId);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 내 번호 수정 (마이페이지)
    public void updatePhone(UpdateMyInfoDto updateMyInfoDto) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "UPDATE CUSTOMER "
                       + "   SET PHONE = ? "
                       + " WHERE ID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, updateMyInfoDto.getPhone());
            pstmt.setString(2, loginId);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 내 주소 수정 (마이페이지)
    public void updateAddress(UpdateMyInfoDto updateMyInfoDto) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "UPDATE CUSTOMER "
                       + "   SET ADDRESS = ? "
                       + " WHERE ID = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, updateMyInfoDto.getAddress());
            pstmt.setString(2, loginId);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
}
