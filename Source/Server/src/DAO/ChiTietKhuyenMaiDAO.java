/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.ChiTietKhuyenMaiDTO;
import DTO.TacGiaDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author PC
 */
public class ChiTietKhuyenMaiDAO {
    ConnectDB database = new ConnectDB();
    //ham them doi tuong vao csdl
    
    public ArrayList<ChiTietKhuyenMaiDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<ChiTietKhuyenMaiDTO> list = new ArrayList<ChiTietKhuyenMaiDTO>();
        try {
                conn = database.connect();
                String query = "select * from chitietkm";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaKM = rs.getString("MaKM");
                    String MaSP = rs.getString("MaSP");
                    list.add(new ChiTietKhuyenMaiDTO(MaKM,MaSP));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    public String themDT(ChiTietKhuyenMaiDTO ctkm)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO chitietkm(MaKM,MaSP) values(?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,ctkm.getMaKM());
            pstmt.setString(2,ctkm.getMaSP());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
}
