/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package NK.ThongKeGUI;

import QL.ThongKeGUI.*;
import Client.Client;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import QL.HoaDonGUI.panelHoaDon;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class tonKhoGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form tonKhoGUI
     */
    private Client client1;
    public tonKhoGUI(Client client) {
        initComponents();
        client1=client;
        getSLSP();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtable = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setText("Tìm kiếm....");

        jtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng ban đầu", "Số lượng tồn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getSLSP()
    {
        ArrayList<SanPhamDTO> list = getListSP("ListSanPham");
        ArrayList<Object[]> list1 = new ArrayList<Object[]>();
        for(SanPhamDTO x : list)
        {
            int soluong = 0;
            for(ChiTietHoaDonDTO cthd : getListCTHD("ListCTHD"))
            {
                if(x.getMaSP().equals(cthd.getMaSP()))
                {
                    soluong+=cthd.getSoLuong();
                }
            }
            list1.add(new Object[] {x.getMaSP(),soluong});
        }
        ArrayList<Object[]> list2 = new ArrayList<Object[]>();
        
            for(Object[] x : list1)
            {
                for(SanPhamDTO sp : getListSP("ListSanPham"))
                {  
                    if(sp.getMaSP().equals(String.valueOf(x[0])))
                    {
                        list2.add(new Object[] {x[0],sp.getTenSP(),Integer.parseInt(String.valueOf(x[1])) + sp.getSoLuong()});
                    }
                }
        }
        
        
        
        //mag chua so luong ton kho
        ArrayList<Object[]> list3 = new ArrayList<Object[]>();
        for(Object[] x : list2)
        {
            for(Object[] x1 : list1)
            {
                if(String.valueOf(x[0]).equals(String.valueOf(x1[0])))
                {
                    list3.add(new Object[]{x[0],x[1],x[2],Integer.parseInt(String.valueOf(x[2])) - Integer.parseInt(String.valueOf(x1[1]))});
                }
                
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) jtable.getModel();
        for(Object[] x : list3)
        {
            model.addRow(x);
            System.out.println(x[0] +" and " + x[1]+" and "+x[2] );
        }
        
        
    }

     // ham lay danh sach
    private ArrayList<HoaDonDTO> getListHD(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau)
        {
            case "ListHoaDon":
                ArrayList<HoaDonDTO> list = new ArrayList<>();
                json = new JSONObject(client1.getList(yeucau));
                
                // chuyen mang sang mang jsonArray
                JSONArray jsonArray = json.getJSONArray("list");
                for (int i = 0; i < jsonArray.length(); i++) 
                {
                    JSONObject nxbObject = jsonArray.getJSONObject(i);
                    String MaHD = nxbObject.getString("maHD");
                    String NgayLapHD = nxbObject.getString("ngayLapHoaDon");
                    Double ThanhTien = nxbObject.getDouble("thanhTien");
                    int Trangthai = nxbObject.getInt("trangThai");
                    String MaTK = nxbObject.getString("maTK");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
                    
                    try {
                        Date ngayLapHD = formatter.parse(NgayLapHD);
                        // Thêm vào ArrayList
                        //xem lai trang thai
                        list.add(new HoaDonDTO(MaHD, ngayLapHD, ThanhTien, Trangthai, MaTK));
                    } catch (ParseException ex) {
                        Logger.getLogger(panelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return list;
        }
        return new ArrayList<>();
    }
    
    //ham lay danh sach
    private ArrayList<ChiTietHoaDonDTO> getListCTHD(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListCTHD": 
                    ArrayList<ChiTietHoaDonDTO> list = new ArrayList<ChiTietHoaDonDTO>();
                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    System.out.println(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                        int soluong = tacGiaObject.getInt("soLuong");
                        Double dongia = tacGiaObject.getDouble("donGia");
                        String MaSP = tacGiaObject.getString("maSP");
                        String MaHD = tacGiaObject.getString("maCTHD");                  
                        // Thêm vào ArrayList
                        list.add(new ChiTietHoaDonDTO(MaHD, soluong, dongia, MaSP)); 
                    }
                    
                    return list;
                   
        }
                
                    
        return new ArrayList<>();
    }
    
    //ham lay danh sach
    private ArrayList<SanPhamDTO> getListSP(String yeucau)
    {
        JSONObject json;
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        switch (yeucau) {
            case "ListSanPham": 

                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    for (int i = 0; i < jsonArray.length(); i++) {
                          JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                          String MaSP = tacGiaObject.getString("maSP");
                          String TenSP = tacGiaObject.getString("tenSP");
                          int SoTrang =  tacGiaObject.getInt("soTrang");
                          String NgonNgu = tacGiaObject.getString("ngonNgu");
                          Double GiaBia = tacGiaObject.getDouble("giaBia");
                          int SoLuong = tacGiaObject.getInt("soLuong");
                          int Trangthai = tacGiaObject.getInt("trangThai");
                          Double giaNhap = tacGiaObject.getDouble("giaNhap");
                          String maTG = tacGiaObject.getString("maTG");
                          list.add(new SanPhamDTO(MaSP,  TenSP,  SoTrang,  NgonNgu,  GiaBia, null, SoLuong, giaNhap, maTG,Trangthai));
                }
                 return list;
        }
                    
                   
                   return new ArrayList<>();
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable jtable;
    // End of variables declaration//GEN-END:variables
}
