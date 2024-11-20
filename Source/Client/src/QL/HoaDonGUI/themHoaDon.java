/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QL.HoaDonGUI;

import Client.Client;
import DTO.NhanVienDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import QL.NhapKhoGUI.themPhieuNhap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import Customize.TimKiem;

/**
 *
 * @author luuis
 */
public class themHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form themHoaDon
     */
    private static Client client1;
    private static String nguoiNhap1;
    private static panelHoaDon panelHoaDon1;
    private double thanhTien1=0;
    private Object[] objRemove;
    private static TimKiem timkiem = new TimKiem();
    
    private ArrayList<Object[]> list = new ArrayList<Object[]>();
    public themHoaDon(Client client, String nguoiNhap,panelHoaDon panelHoaDon) {
        initComponents();
        this.setLocationRelativeTo(null);
        client1=client;
        nguoiNhap1=nguoiNhap;
        panelHoaDon1=panelHoaDon;
        MaNV.setText(nguoiNhap);
        ngayNhapDate.setDate(new Date());
        setMaHD();
        setUp();
        timkiem.setPlaceholder(timKiemField, "Tìm kiếm theo mã hoặc tên...");
        timkiem.setUpSearchListener(timKiemField, this::timKiem);
    }

    
    private void setMaHD()
    {
     
        JSONObject json = new JSONObject(client1.getList("ListHoaDon"));
        JSONArray jsonArray = json.getJSONArray("list");
        int max=0;
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject tacGiaObject = jsonArray.getJSONObject(i);
              String chuoi = tacGiaObject.getString("maHD");
            if(Integer.parseInt(chuoi.substring(3)) > max)
            {
                max = Integer.parseInt(chuoi.substring(3));
            }
            
        }
        MaHD.setText("HD_"+ String.valueOf(max+1));
    }
    
    //ham thiet lap danh sach san pham
    //ham thiet lap bang danh sach
    public void setUp()
    {
        
        DefaultTableModel model = (DefaultTableModel) jTableSP.getModel();
        model.setRowCount(0);
        
        for(SanPhamDTO sanpham : getList("ListSanPham"))
        {
            System.out.println(sanpham.getTrangThai());
            //them tung doi tuong vao bang
            if(sanpham.getTrangThai()==1)
            {
                model.addRow(new Object[] {sanpham.getMaSP(),sanpham.getTenSP(),String.valueOf(sanpham.getSoLuong()),String.valueOf(sanpham.getGiaBia())});
            }
        }
    }
    
    //ham lay danh sach
    private ArrayList<SanPhamDTO> getList(String yeucau)
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
    
    private void timKiem()
    {
        String searchText = timkiem.KhongLayDau(timKiemField.getText().trim().toLowerCase());
        DefaultTableModel model = (DefaultTableModel) jTableSP.getModel();
        model.setRowCount(0); 
        

        ArrayList<SanPhamDTO> allItems = getList("ListSanPham");

        for (SanPhamDTO sp : allItems) {
            if (sp.getTrangThai() == 1) {
                
                String MaSP = timkiem.KhongLayDau(sp.getMaSP().toLowerCase());
                String TenSP = timkiem.KhongLayDau(sp.getTenSP().toLowerCase());
                

                if (MaSP.contains(searchText) || TenSP.contains(searchText)) {
                    model.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),String.valueOf(sp.getSoLuong()),String.valueOf(sp.getGiaBia())});
                }
            }
        }

        if (model.getRowCount() == 0 && !searchText.isEmpty()) {
            // xu li thong bao khi khong tim thay
        }
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
        timKiemField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSP = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSPC = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        MaHD = new javax.swing.JTextField();
        MaNV = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        thanhTien = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        ngayNhapDate = new com.toedter.calendar.JDateChooser();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        timKiemField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        timKiemField.setSelectionColor(new java.awt.Color(0, 0, 0));
        timKiemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemFieldActionPerformed(evt);
            }
        });

        jTableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng tồn", "Giá bìa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableSP);

        jButton1.setBackground(new java.awt.Color(154, 154, 238));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Chọn sản phẩm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jTableSPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableSPC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSPCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableSPC);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Mã sản phẩm");

        jTextField2.setBackground(new java.awt.Color(51, 51, 51));
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextField2.setEnabled(false);
        jTextField2.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel2.setText("Tên sản phẩm");

        jTextField3.setBackground(new java.awt.Color(51, 51, 51));
        jTextField3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField3.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextField3.setEnabled(false);
        jTextField3.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel5.setText("Số lượng");

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jSpinner1))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Mã hóa đơn");

        MaHD.setBackground(new java.awt.Color(51, 51, 51));
        MaHD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MaHD.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        MaHD.setEnabled(false);
        MaHD.setSelectionColor(new java.awt.Color(0, 0, 0));

        MaNV.setBackground(new java.awt.Color(51, 51, 51));
        MaNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MaNV.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        MaNV.setEnabled(false);
        MaNV.setSelectionColor(new java.awt.Color(0, 0, 0));

        jLabel7.setText("Nhân viên nhập");

        jLabel8.setText("Ngày nhập");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Tổng tiền: ");

        thanhTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        thanhTien.setText("xxxxx Đ");

        jButton4.setBackground(new java.awt.Color(102, 255, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setText("Xuất hoá đơn");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        ngayNhapDate.setBackground(new java.awt.Color(51, 51, 51));
        ngayNhapDate.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(MaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(MaNV)
                            .addComponent(jLabel8)
                            .addComponent(ngayNhapDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ngayNhapDate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(thanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jButton5.setBackground(new java.awt.Color(154, 154, 238));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setText("Bỏ sản phẩm");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                            .addComponent(timKiemField)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(timKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSPMouseClicked
        // TODO add your handling code here:
        jSpinner1.setValue(0);
        DefaultTableModel table = (DefaultTableModel) jTableSP.getModel();
        int index = jTableSP.getSelectedRow();
        String MaSP = table.getValueAt(index, 0).toString();
        String TenSP = table.getValueAt(index, 1).toString();
        String GiaNhap = table.getValueAt(index, 3).toString();
        int value = (int) jSpinner1.getValue();
        jTextField2.setText(MaSP);
        jTextField3.setText(TenSP);
    }//GEN-LAST:event_jTableSPMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel table1 = (DefaultTableModel) jTableSP.getModel();
        int index = jTableSP.getSelectedRow();
        int value = (int) jSpinner1.getValue();
        if (value < 1) {
        JOptionPane.showMessageDialog(this, "Số lượng không được nhỏ hơn 1!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return; // Dừng xử lý nếu giá trị không hợp lệ
        }
        String MaSP = table1.getValueAt(index, 0).toString();
        String TenSP = table1.getValueAt(index, 1).toString();
        String GiaBia1 = String.valueOf(Double.parseDouble(table1.getValueAt(index, 3).toString()) * value);
        Object[] obj1 = {MaSP,TenSP,value,GiaBia1};
        list.add(obj1);
        DefaultTableModel table = (DefaultTableModel) jTableSPC.getModel();
        table.setRowCount(0);
        
        ArrayList<Object[]> newList = new ArrayList<>();
        // Sử dụng HashSet để theo dõi các giá trị đã thấy
        HashSet<String> seenValues = new HashSet<>();

        // Giả sử list chứa các đối tượng mảng mà bạn muốn kiểm tra
        for (int i = 0; i < list.size(); i++) {
            String maSP = (String) list.get(i)[0]; // Lấy giá trị từ cột đầu tiên của mỗi đối tượng
            String ten = (String) list.get(i)[1]; 
            String SoLuong = String.valueOf(list.get(i)[2]);
            String GiaBia = (String) list.get(i)[3];
            
            if (!seenValues.contains(ten)) { // Kiểm tra xem giá trị đã được thêm chưa
                seenValues.add(ten); // Thêm vào HashSet
                newList.add(new Object[]{maSP,ten,SoLuong,GiaBia});// Thêm vào newList nếu chưa có
                
            }
        }
        list.clear();
        list.addAll(newList);
        for(Object[] obj2 : list)
        {     
            table.addRow(obj2);
        }
        thanhTien1=0;
        for (int i = 0; i < list.size(); i++) {
            String SoLuong = String.valueOf(list.get(i)[2]);
            String GiaBia = (String) list.get(i)[3];
            thanhTien1+= Double.parseDouble(GiaBia);
        }

        System.out.println(thanhTien1);
        thanhTien.setText(String.valueOf(thanhTien1)+" Đ");
        jSpinner1.setValue(0);
        jTextField2.setText("");
        jTextField3.setText("");
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) jTableSPC.getModel();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)[0].equals((String) objRemove[0]))
            {
                thanhTien1-= (Double.parseDouble((String) list.get(i)[3]));
                list.remove(list.get(i));
            }
        }
        table.setRowCount(0);
        for(Object[] obj2 : list)
        {
            table.addRow(obj2);
        }
         thanhTien.setText(String.valueOf(thanhTien1)+" Đ");
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTableSPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSPCMouseClicked
        // TODO add your handling code here:
        jSpinner1.setValue(0);
        jTextField2.setText("");
        jTextField3.setText("");
        DefaultTableModel table = (DefaultTableModel) jTableSPC.getModel();
        int index = jTableSPC.getSelectedRow();
        String MaSP = table.getValueAt(index, 0).toString();
        String TenSP = table.getValueAt(index, 1).toString();
        String SoLuong = table.getValueAt(index, 2).toString();
        String Thanhtien = table.getValueAt(index, 3).toString();
        Object[] obj = {MaSP,TenSP,SoLuong,Thanhtien};
        objRemove=obj;
    }//GEN-LAST:event_jTableSPCMouseClicked

    
    //ham lay ma tai khoan tu nhan vien
    private String getMaNV(String tenNV)
    {
        for(NhanVienDTO nv : getListNV("ListNhanVien"))
        {
            if(tenNV.equals(nv.getHoVaTen()))
            {
                return nv.getMaTK();
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
    
    private String getMaTK(String MaNV)
    {
        for(TaiKhoanDTO x : getListTK("ListTaiKhoan"))
        {
            if(x.getMaTK().equals(MaNV))
            {
                return x.getMaTK();
            }
        }
        return "";
    }
    
    private ArrayList<TaiKhoanDTO> getListTK(String yeucau)
    {
        JSONObject json;
        ArrayList<TaiKhoanDTO> list = new ArrayList<TaiKhoanDTO>();
        switch (yeucau) {
            case "ListTaiKhoan": 
                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    
                    for (int i = 0; i < jsonArray.length(); i++) {
                          JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                          String MaTK = tacGiaObject.getString("maTK");
                          String tenTK = tacGiaObject.getString("tenTK");
                          String matkhau = tacGiaObject.getString("matKhauTK");
                          int trangThai = tacGiaObject.getInt("trangThai");
                          list.add(new TaiKhoanDTO(MaTK,tenTK,matkhau,trangThai));
                }
                 return list;
        }
       
                   return new ArrayList<>();
        }
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        String maNV = getMaTK(getMaNV(MaNV.getText()));
        Date ngayNhap = ngayNhapDate.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        String thanhtien = thanhTien.getText().substring(0,thanhTien.getText().length()-1);
        String maHD = MaHD.getText();
        JSONObject json = new JSONObject();
        json.put("method","PUTHD");
        json.put("maNV",maNV);
        json.put("ngayNhap",dateFormat.format(ngayNhap));
        json.put("thanhtien",thanhtien);
        json.put("maHD",maHD);
        
        //xet dieu kien dau vao
        if(list.size()==0)
        {
           
            JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            
            JSONObject json1 = new JSONObject();
            json1.put("method","PUTCTHD");
            JSONArray jsonArray = new JSONArray(list);
            json1.put("maHD",maHD);
            json1.put("list",jsonArray.toString()); 
            
            JSONObject json2 = new JSONObject();
            json2.put("method","UPDATESLSP");
            json2.put("theloai","hoadon");
            json2.put("list",jsonArray.toString());
            System.out.println(json2.toString() + "aaaa");
            if(client1.themDT(json.toString()).equals("thanhcong"))
            {
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                client1.themDT(json1.toString());
                client1.suaDT(json2.toString());
                panelHoaDon1.setUp();
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButton4MouseClicked

    private void timKiemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timKiemFieldActionPerformed

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
            java.util.logging.Logger.getLogger(themHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(themHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(themHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(themHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new themHoaDon(client1,nguoiNhap1,panelHoaDon1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MaHD;
    private javax.swing.JTextField MaNV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTable jTableSP;
    private javax.swing.JTable jTableSPC;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private com.toedter.calendar.JDateChooser ngayNhapDate;
    private javax.swing.JLabel thanhTien;
    private javax.swing.JTextField timKiemField;
    // End of variables declaration//GEN-END:variables
}
