/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QL.NhapKhoGUI;

import Client.Client;
import DTO.ChiTietPhieuNhapDTO;
import DTO.NhaXuatBanDTO;
import DTO.NhanVienDTO;
import DTO.PhieuNhapDTO;
import DTO.SanPhamDTO;
import com.formdev.flatlaf.FlatLightLaf;
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
 * @author PC
 */
public class thongTinPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form thongTinPhieuNhap
     */
    private static String MaDT1;
    private static Client client1;
    public thongTinPhieuNhap(String MaDT, Client client) {
        initComponents();
        this.setLocationRelativeTo(null);
        MaDT1 = MaDT;
        client1 = client;
        setUp();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldMPN = new javax.swing.JTextField();
        jTextFieldNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelThanhTien = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jTextFieldNXB = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Giá nhập", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSP.setToolTipText("");
        jScrollPane2.setViewportView(jTableSP);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Mã phiếu nhập");

        jTextFieldMPN.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldMPN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldMPN.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldMPN.setEnabled(false);
        jTextFieldMPN.setSelectionColor(new java.awt.Color(0, 0, 0));

        jTextFieldNV.setEditable(false);
        jTextFieldNV.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldNV.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldNV.setEnabled(false);
        jTextFieldNV.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel7.setText("Nhân viên nhập");

        jTextFieldNN.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldNN.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldNN.setEnabled(false);
        jTextFieldNN.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel8.setText("Ngày nhập");

        jLabel9.setText("Nhà xuất bản");

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

        jTextFieldNXB.setBackground(new java.awt.Color(51, 51, 51));
        jTextFieldNXB.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldNXB.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextFieldNXB.setEnabled(false);
        jTextFieldNXB.setSelectionColor(new java.awt.Color(0, 0, 0));

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
                        .addComponent(jTextFieldMPN, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addComponent(jTextFieldNV)
                        .addComponent(jLabel8)
                        .addComponent(jTextFieldNN)
                        .addComponent(jLabel9)
                        .addComponent(jTextFieldNXB))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldMPN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
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
                .addContainerGap(18, Short.MAX_VALUE))
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
//ham lay danh sach
    private ArrayList<PhieuNhapDTO> getList(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListPhieuNhap": 
                    ArrayList<PhieuNhapDTO> list = new ArrayList<PhieuNhapDTO>();
                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    System.out.println(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                        String MaPN = tacGiaObject.getString("maPN");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date NgayNhap;
                        try {
                            NgayNhap = formatter.parse((tacGiaObject.getString("ngayNhap")).toString() );
                            Double Thanhtien = tacGiaObject.getDouble("thanhTien");
                            int Trangthai = tacGiaObject.getInt("trangThai");
                            String MaTK = tacGiaObject.getString("maTK");
                            String MaNXB=tacGiaObject.getString("maNXB");;
                           
                            list.add(new PhieuNhapDTO(MaPN, NgayNhap, Thanhtien, Trangthai, MaTK, MaNXB));
                              
                            
                            
                        } catch (ParseException ex) {
                            Logger.getLogger(panelKho.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    // Thêm vào ArrayList
                    //xem lai trang thai
                   
        }
                    
                    return list;
                   
        }
                
                    
        return new ArrayList<>();
    }
    //ham thiet lap bang danh sach
    public void setUp()
    {
        
        for(PhieuNhapDTO phieunhap : getList("ListPhieuNhap"))
        {
            //them tung doi tuong vao bang
            if(MaDT1.equals(phieunhap.getMaPN()))
            {
                jTextFieldMPN.setText(MaDT1);
                jTextFieldNV.setText(getTenNV(phieunhap.getMaTK()));
                jTextFieldNXB.setText(getTenNXB(phieunhap.getMaNXB()));
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                jTextFieldNN.setText(formatter.format(phieunhap.getNgayNhap()));
                jLabelThanhTien.setText(String.valueOf(phieunhap.getThanhTien()) + "Đ");
                setUpSP(MaDT1);
            }
        }
    }
    
    private void setUpSP(String MaPN)
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        for(ChiTietPhieuNhapDTO ctpn : getListCTPN("ListCTPhieuNhap"))
        {
            if(MaPN.equals(ctpn.getMaPN()))
            {
                String soluong = String.valueOf(ctpn.getSoLuongNhap());
                String dongia = String.valueOf(ctpn.getDonGia());
                String MaSP = ctpn.getMaSP();
               list.add(new Object[]{getTenSP(MaSP),soluong,getGiaNhapSP(MaSP),dongia});
            }
        }
        
        DefaultTableModel table = (DefaultTableModel) jTableSP.getModel();
        for(Object[] obj : list)
        {
            table.addRow(obj);
        }
    }
    
    
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
    
    private String getGiaNhapSP(String MaSP)
    {
        for(SanPhamDTO sp : getListSP("ListSanPham"))
        {
            if(MaSP.equals(sp.getMaSP()))
            {
                return String.valueOf(sp.getGiaNhap());
            }
        }
        return "";
    }
    
    //ham lay danh sach
    private ArrayList<ChiTietPhieuNhapDTO> getListCTPN(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListCTPhieuNhap": 
                    ArrayList<ChiTietPhieuNhapDTO> list = new ArrayList<ChiTietPhieuNhapDTO>();
                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    System.out.println(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                        int soluong = tacGiaObject.getInt("soLuongNhap");
                        Double dongia = tacGiaObject.getDouble("donGia");
                        String MaSP = tacGiaObject.getString("maSP");
                        String MaPN = tacGiaObject.getString("maPN");                  
                        // Thêm vào ArrayList
                        list.add(new ChiTietPhieuNhapDTO(soluong, dongia, MaSP, MaPN)); 
                    }
                    
                    return list;
                   
        }
                
                    
        return new ArrayList<>();
    }
    
    //lay ten nha xuat ban tu ma nha xuat ban
    
    public String getTenNXB(String MaNXB)
    {
        for(NhaXuatBanDTO nxb : getListNXB("ListNhaXuatBan"))
        {
            if(MaNXB.equals(nxb.getMaNXB()))
            {
                return nxb.getTenNXB();
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
    
     // ham lay danh sach
    private ArrayList<NhaXuatBanDTO> getListNXB(String yeucau) 
    {
        JSONObject json;
        
        switch (yeucau) 
        {
            case "ListNhaXuatBan":
                ArrayList<NhaXuatBanDTO> list = new ArrayList<>();
                json = new JSONObject(client1.getList(yeucau));
                
                // chuyen mang chuoi sang mang jsonArray
                JSONArray jsonArray = json.getJSONArray("list");
                for (int i = 0; i < jsonArray.length(); i++) 
                {
                    JSONObject nxbObject = jsonArray.getJSONObject(i);
                    String MaNXB = nxbObject.getString("maNXB");
                    String TenNXB = nxbObject.getString("tenNXB");
                    String DiaChi = nxbObject.getString("diaChi");
                    String SoDienThoai = nxbObject.getString("soDienThoai");
                    String Email = nxbObject.getString("email");
                    int Trangthai = nxbObject.getInt("trangThai");
                    // them vao arraylist
                    // xem lai trang thai
                    list.add(new NhaXuatBanDTO(MaNXB, TenNXB, DiaChi, SoDienThoai, Email, Trangthai));
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
            java.util.logging.Logger.getLogger(thongTinPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(thongTinPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(thongTinPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(thongTinPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
                new thongTinPhieuNhap(MaDT1,client1).setVisible(true);
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
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelThanhTien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSP;
    private javax.swing.JTextField jTextFieldMPN;
    private javax.swing.JTextField jTextFieldNN;
    private javax.swing.JTextField jTextFieldNV;
    private javax.swing.JTextField jTextFieldNXB;
    // End of variables declaration//GEN-END:variables
}
