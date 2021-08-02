package com.bitenter.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bitenter.dto.ItemDto;
import com.bitenter.util.UtilClose;

public class ItemDao {
    private final String DRIVER = "oracle.jdbc.OracleDriver";
    private final String URL = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
    private final String USER = "bitenter";
    private final String PASSWORD = "bitenterpw";
    
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 선택한 상품 정보 가져오기
    public List<ItemDto> selectItemInfo(int itemNum) {
        List<ItemDto> list = null;
        
        try {
            Class.forName(DRIVER);
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            String sql = "SELECT * "
                       + "  FROM ITEM "
                       + " WHERE ITEMNUM = ?";
            
            pstmt = conn.prepareStatement(sql);
            
            pstmt.setInt(1, itemNum);
            
            rs = pstmt.executeQuery();
            
            list = new ArrayList<>();
            
            while(rs.next()) {
                list.add(new ItemDto(rs.getString("itemname"),
                                     rs.getInt("price")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            UtilClose.closeCPR(conn, pstmt, rs);
        }
        return list;
    }
}
