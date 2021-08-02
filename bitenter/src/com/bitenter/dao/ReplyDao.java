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

public class ReplyDao {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private final String USER = "bitenter";
    private final String PASSWORD = "bitenterpw";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 후기 작성
    public void insertReply(ReplyDto replyDto) {
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "INSERT INTO REPLY "
                       + "       (NUM, COMM, ID, REPLYDATE) "
                       + "VALUES (SEQ_REPLY.nextval, ?, ?, sysdate) ";
            
            pstmt = conn.prepareStatement(sql);
            
            SignUpLoginUI idPwd = new SignUpLoginUI();
            String loginId = idPwd.sendId();
            
            pstmt.setString(1, replyDto.getComm());
            pstmt.setString(2, loginId);
            
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCP(conn, pstmt);
        }
    } 
    
    // 후기 목록
    public List<ReplyDto> selectReplyAll() {
        List<ReplyDto> list = null;
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT R.NUM, R.COMM, C.ID, R.REPLYDATE "
                       + "  FROM CUSTOMER C, REPLY R "
                       + " WHERE C.ID = R.ID "
                       + " ORDER BY R.NUM";
            
            pstmt = conn.prepareStatement(sql);
            
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
}
