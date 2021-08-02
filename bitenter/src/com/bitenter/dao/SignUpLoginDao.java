package com.bitenter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bitenter.dto.SignUpLoginDto;
import com.bitenter.util.UtilClose;

public class SignUpLoginDao {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private final String USER = "bitenter";
    private final String PASSWORD = "bitenterpw";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 회원가입
    public void insertCustomerInfo(SignUpLoginDto signUpDto) {
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "INSERT INTO CUSTOMER "
                       + "       (ID, PWD, NAME, PHONE, ADDRESS, SSN) "
                       + "VALUES (?, ?, ?, ?, ?, ?) ";
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, signUpDto.getId());
            pstmt.setString(2, signUpDto.getPwd());
            pstmt.setString(3, signUpDto.getName());
            pstmt.setString(4, signUpDto.getPhone());
            pstmt.setString(5, signUpDto.getAddress());
            pstmt.setString(6, signUpDto.getSsn());
            
            int insertCount = pstmt.executeUpdate();
            if(insertCount == 1) {
                System.out.println("--------------------");
                System.out.println("회원가입 완료");
                System.out.println("--------------------");
            }
            
        } catch (Exception e) {
            System.out.println("--------------------");
            System.out.println("이미 있는 아이디입니다.");
            System.out.println("--------------------");
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    }
    
    // 로그인
    public int login(SignUpLoginDto loginDto) {
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT PWD "
                       + "  FROM CUSTOMER "
                       + " WHERE ID = ? ";
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, loginDto.getId());
            
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                if (rs.getString(1).contentEquals(loginDto.getPwd())) {
                    return 1; // 로그인 성공
                } else {
                    return 0; // 비밀번호 불일치
                }
            }
            return -1; // 아이디가 없음
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
        return -2; // DB 오류
    }
    
    // 아이디 찾기
    public void selectId(SignUpLoginDto idDto) {
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT ID "
                       + "  FROM CUSTOMER "
                       + " WHERE NAME = ? "
                       + "   AND SSN = ? ";
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1, idDto.getName());
            pstmt.setString(2, idDto.getSsn());
            
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
                String str = "";
                str += rs.getString("id");
                
                System.out.println("--------------------");
                System.out.println("회원님의 아이디는 "+str+" 입니다.");
                System.out.println("--------------------");
            } else {
                System.out.println("--------------------");
                System.out.println("일치하는 정보가 없습니다.");
                System.out.println("--------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCPR(conn, pstmt, rs);
        }
    }
    
    // 비밀번호 찾기
    public void selectPwd(SignUpLoginDto pwdDto) {
        try {
            Class.forName(DRIVER);
                
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
                
            String sql = "SELECT PWD "
                       + "  FROM CUSTOMER "
                       + " WHERE ID = ? "
                       + "   AND NAME = ? "
                       + "   AND SSN = ? ";
                
            pstmt = conn.prepareStatement(sql);
               
            pstmt.setString(1, pwdDto.getId());
            pstmt.setString(2, pwdDto.getName());
            pstmt.setString(3, pwdDto.getSsn());
                
            rs = pstmt.executeQuery();
                
            if(rs.next()) {
                String str = "";
                str += rs.getString("pwd");
                    
                System.out.println("--------------------");
                System.out.println("회원님의 비밀번호는 "+str+" 입니다.");
                System.out.println("--------------------");
            } else {
                System.out.println("--------------------");
                System.out.println("일치하는 정보가 없습니다.");
                System.out.println("--------------------");
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCPR(conn, pstmt, rs);
        }
    }
}
