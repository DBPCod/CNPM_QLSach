/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QL.HoaDonGUI;

import Client.Client;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import QL.HoaDonGUI.panelHoaDon;
import QL.NhapKhoGUI.themPhieuNhap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author luuis
 */
public class thongTinHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form thongTinHoaDon
     */
    private static String MaDT1;
    private static Client client1;
    public thongTinHoaDon(String MaDT, Client client) {
        initComponents();
        this.setLocationRelativeTo(null);
        MaDT1 = MaDT;
        client1 = client;
        setUp();
    }


    // ham lay danh sach
    private ArrayList<HoaDonDTO> getList(String yeucau)
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
                
                    
    
    //ham thiet lap bang danh sach
    public void setUp()
    {
        
        for(HoaDonDTO hoadon : getList("ListHoaDon"))
        {
            
            //them tung doi tuong vao bang
            if(MaDT1.equals(hoadon.getMaHD()))
            {System.out.println(hoadon.getMaHD() +"a");
                txtMaHD.setText(hoadon.getMaHD());
                jTextFieldMNV.setText(getTenNV(hoadon.getMaTK()));
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                jTextFieldNN.setText(formatter.format(hoadon.getNgayLapHoaDon()));
                jLabelThanhTien.setText(String.valueOf(hoadon.getThanhTien()) + "Đ");
                setUpSP(MaDT1);
            }
        }
    }
    
    private void setUpSP(String MaHD)
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        for(ChiTietHoaDonDTO cthd : getListCTHD("ListCTHD"))
        {
            if(MaHD.equals(cthd.getMaCTHD()))
            {
                String soluong = String.valueOf(cthd.getSoLuong());
                String dongia = String.valueOf(cthd.getDonGia());
                String MaSP = cthd.getMaSP();
               list.add(new Object[]{getTenSP(MaSP),soluong,getGiaBiaSP(MaSP),dongia});
            }
        }
        
        DefaultTableModel table = (DefaultTableModel) jTableSP.getModel();
        for(Object[] obj : list)
        {
            table.addRow(obj);
        }
    }
    
    //ham lay gia bia san pham
    private String getGiaBiaSP(String MaSP)
    {
        for(SanPhamDTO sp : getListSP("ListSanPham"))
        {
            if(MaSP.equals(sp.getMaSP()))
            {
                return String.valueOf(sp.getGiaBia());
            }
        }
        return "";
    }
    
    //ham lay ten san pham
    private String getTenSP(String MaSP)
    {
        for(SanPhamDTO sp : getListSP("ListSanPham"))
        {
            if(MaSP.equals(sp.getMaSP()))
            {
                return sp.getTenSP();
            }
        }
        return "";
    }
    
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
    
    //lay ten nhan vien tu ma tai khoan
    public String getTenNV(String MaTK)
    {
        for(NhanVienDTO nv : getListNV("ListNhanVien"))
        {
            if(MaTK.equals(nv.getMaTK()))
            {
                return nv.getHoVaTen();
            }
        }
        return "";
    }
    
    //ham lay danh sach nhan vien
    private ArrayList<NhanVienDTO> getListNV(String yeucau)
    {
        JSONObject json;
        ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
        switch (yeucau) {
            case "ListNhanVien": 

                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    System.out.println(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                          JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                          String MaNV = tacGiaObject.getString("maNV");
                          String hovaten = tacGiaObject.getString("hoVaTen");
                          String ngaySinh1 = tacGiaObject.getString("ngaySinh");
                          String gioiTinh = tacGiaObject.getString("gioiTinh");
                          String sdt = tacGiaObject.getString("soDienThoai");
                          String email = tacGiaObject.getString("email");
                          String diaChi = tacGiaObject.getString("diaChi");
                          String maTK = tacGiaObject.getString("maTK");
                          String maVT = tacGiaObject.getString("maVT");
                          int trangThai = tacGiaObject.getInt("trangThai");
                          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                           Date ngaySinh;
                            try {
                                ngaySinh = formatter.parse(ngaySinh1);
                                list.add(new NhanVienDTO(MaNV,hovaten,ngaySinh,gioiTinh,sdt,email,diaChi,maTK,maVT,trangThai));
                            } catch (ParseException ex) {
                                Logger.getLogger(themPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                            }
                }
                 return list;
        }
       
                   return new ArrayList<>();
        }
    /**
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jTextFieldMNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelThanhTien = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Giá bìa", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableSP);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Mã hoá đơn:");

        txtMaHD.setBackground(new java.awt.Color(51, 51, 51));
        txtMaHD.setForeground(new java.awt.Color(255, 255, 255));
        txtMaHD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtMaHD.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtMaHD.setEnabled(false);
        txtMaHD.setSelectionColor(new java.awt.Color(0, 0, 0));

        jTextFieldMNV.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldMNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldMNV.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldMNV.setEnabled(false);
        jTextFieldMNV.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel7.setText("Nhân viên bán:");

        jTextFieldNN.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldNN.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldNN.setEnabled(false);
        jTextFieldNN.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel8.setText("Ngày lập hoá đơn:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Tổng tiền: ");

        jLabelThanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelThanhTien.setText("xxxxx Đ");

        jButton4.setBackground(new java.awt.Color(102, 255, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Xong");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabelThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6)
                        .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(jTextFieldMNV)
                        .addComponent(jLabel8)
                        .addComponent(jTextFieldNN))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(163, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh sách sản phẩm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton4MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(thongTinHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongTinHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongTinHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongTinHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new thongTinHoaDon(MaDT1,client1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelThanhTien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSP;
    private javax.swing.JTextField jTextFieldMNV;
    private javax.swing.JTextField jTextFieldNN;
    private javax.swing.JTextField txtMaHD;
    // End of variables declaration//GEN-END:variables
}
