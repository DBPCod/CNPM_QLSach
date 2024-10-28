/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.NhanVienDTO;
import DTO.TacGiaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import org.json.JSONObject;
/**
 *
 * @author PC
 */
public class TacGiaDAO {
    ConnectDB database = new ConnectDB();
    public ArrayList<TacGiaDTO> getList()
    {
        java.sql.Connection conn;
        ArrayList<TacGiaDTO> list = new ArrayList<TacGiaDTO>();
        try {
                conn = database.connect();
                String query = "select * from tacgia";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaTG = rs.getString("MaTG");
                    String Hovaten = rs.getString("Hovaten");
                    String ButDanh = rs.getString("ButDanh");
                    String gioitinh = rs.getString("GioiTinh");
                    String QuocTich = rs.getString("QuocTich");
                    list.add(new TacGiaDTO(MaTG,Hovaten,ButDanh,gioitinh,QuocTich));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    public String themDT(TacGiaDTO tg)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO tacgia(MaTG,Hovaten,ButDanh,GioiTinh,QuocTich) values(?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,tg.getMaTG());
            pstmt.setString(2,tg.getHoVaTen());
            pstmt.setString(3,tg.getButDanh());
            pstmt.setString(4,tg.getGioiTinh());
            pstmt.setString(5,tg.getQuocTich());
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
