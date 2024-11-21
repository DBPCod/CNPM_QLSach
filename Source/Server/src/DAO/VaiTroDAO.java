/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import DTO.NhanVienDTO;
import DTO.VaiTroDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class VaiTroDAO {
    ConnectDB database = new ConnectDB();
    //lay danh sach vai tro
    public ArrayList<VaiTroDTO> getAll()
    {
        java.sql.Connection conn;
        ArrayList<VaiTroDTO> list = new ArrayList<VaiTroDTO>();
        try {
                conn = database.connect();
                String query = "select * from vaitro";
                Statement stm = null;
                stm = conn.createStatement();
                ResultSet rs = stm.executeQuery(query);
                while(rs.next())
                {
                    String MaVT = rs.getString("MaVT");
                    String TenVT = rs.getString("TenVT");
                    list.add(new VaiTroDTO(MaVT,TenVT));
                }
            } catch (SQLException ex) {
                Logger.getLogger(VaiTroDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
}
