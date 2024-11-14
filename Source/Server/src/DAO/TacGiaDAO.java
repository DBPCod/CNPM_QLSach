/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.NhanVienDTO;
import DTO.TacGiaDTO;
import com.sun.jdi.connect.spi.Connection;
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
                    int Trangthai = rs.getInt("Trangthai");
                    list.add(new TacGiaDTO(MaTG,Hovaten,ButDanh,gioitinh,QuocTich,Trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    //ham them doi tuong vao csdl
    public String themDT(TacGiaDTO tg)
    {
        java.sql.Connection conn;
        String query = "INSERT INTO tacgia(MaTG,Hovaten,ButDanh,GioiTinh,QuocTich,Trangthai) values(?,?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,tg.getMaTG());
            pstmt.setString(2,tg.getHoVaTen());
            pstmt.setString(3,tg.getButDanh());
            pstmt.setString(4,tg.getGioiTinh());
            pstmt.setString(5,tg.getQuocTich());
            pstmt.setInt(6,1);
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    //ham cap nhat doi tuong len csdl
    public String suaTG(TacGiaDTO tg)
    {
        java.sql.Connection conn;
        String query = "UPDATE tacgia SET Hovaten=?,ButDanh=?,GioiTinh=?,QuocTich=? WHERE MaTG=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,tg.getHoVaTen());
            pstmt.setString(2,tg.getButDanh());
            pstmt.setString(3,tg.getGioiTinh());
            pstmt.setString(4,tg.getQuocTich());
            pstmt.setString(5,tg.getMaTG());
            if(pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(TacGiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
        
    }
    
    public String xoaTG(TacGiaDTO tg)
    {
        java.sql.Connection conn;
        String query = "UPDATE tacgia SET Trangthai=? WHERE MaTG=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1,tg.getTrangThai());
            pstmt.setString(2,tg.getMaTG());
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
