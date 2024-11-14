/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.NhanVienDTO;
import DTO.TaiKhoanDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author PC
 */
public class NhanVienDAO {
    ConnectDB database = new ConnectDB();
    //lay toan bo danh sach nhan vien
    public ArrayList<NhanVienDTO> getAll()
    {
        java.sql.Connection conn;
        ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
        try {
                conn = database.connect();
                String query = "select * from nhanvien";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaNV = rs.getString("MaNV");
                    String Hovaten = rs.getString("Hovaten");
                    Date NgaySinh = rs.getDate("NgaySinh");
                    String Gioitinh = rs.getString("Gioitinh");
                    String Sodienthoai = rs.getString("Sodienthoai");
                    String Email = rs.getString("Email");
                    String Diachi = rs.getString("Diachi");
                    String MaTK = rs.getString("MaTK");
                    String MaVT = rs.getString("MaVT");
                    int Trangthai = rs.getInt("Trangthai");
                    list.add(new NhanVienDTO(MaNV,Hovaten,NgaySinh,Gioitinh,Sodienthoai,Email,Diachi,MaTK,MaVT,Trangthai));
                }
            } catch (SQLException ex) {
                Logger.getLogger(TaiKhoanDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    // ham them doi tuong vao csdl
    public String themNV(NhanVienDTO nv) 
    {
        java.sql.Connection conn;
        String query = "insert into nhanvien(MaNV,Hovaten,NgaySinh,GioiTinh,Sodienthoai,Email,DiaChi,MaTK,MaVT,TrangThai) values (?,?,?,?,?,?,?,?,?,?)";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nv.getMaNV());
            pstmt.setString(2, nv.getHoVaTen());
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinhStr = formatter.format(nv.getNgaySinh());
            pstmt.setString(3, ngaySinhStr);
            pstmt.setString(4, nv.getGioiTinh());
            pstmt.setString(5, nv.getSoDienThoai());
            pstmt.setString(6, nv.getEmail());
            pstmt.setString(7, nv.getDiaChi());
            pstmt.setString(8, nv.getMaTK());
            pstmt.setString(9, nv.getMaVT());
            pstmt.setInt(10, 1);
            if (pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhaXuatBanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    // ham cap nhat doi tuong vao csdl
    public String suaNV(NhanVienDTO nv) 
    {
        java.sql.Connection conn;
        String query = "update nhanvien set Hovaten=?,NgaySinh=?,GioiTinh=?,Sodienthoai=?,Email=?,DiaChi=?,MaTK=?,MaVT=? WHERE MaNV=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            pstmt.setString(1, nv.getHoVaTen());
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String ngaySinhStr = formatter.format(nv.getNgaySinh());
            pstmt.setString(2, ngaySinhStr);
            pstmt.setString(3, nv.getGioiTinh());
            pstmt.setString(4, nv.getSoDienThoai());
            pstmt.setString(5, nv.getEmail());
            pstmt.setString(6, nv.getDiaChi());
            pstmt.setString(7, nv.getMaTK());
            pstmt.setString(8, nv.getMaVT());
            pstmt.setString(9, nv.getMaNV());

            if (pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
    
    // ham xoa doi tuong vao csdl
    public String xoaNV(NhanVienDTO nv) 
    {
        java.sql.Connection conn;
        String query = "update nhanvien set Trangthai=? where MaNV=?";
        conn = database.connect();
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, nv.getTrangThai());
            pstmt.setString(2, nv.getMaNV());

            if (pstmt.executeUpdate() > 0)
            {
                return "true";
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "false";
    }
}
