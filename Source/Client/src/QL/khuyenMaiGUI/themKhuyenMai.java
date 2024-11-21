/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QL.khuyenMaiGUI;

import Client.Client;
import DTO.LoaiKhuyenMaiDTO;
import DTO.SanPhamDTO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONObject;
import org.json.JSONArray;
/**
 *
 * @author PC
 */
public class themKhuyenMai extends javax.swing.JFrame {

    /**
     * Creates new form themKhuyenMai
     */
    private static panelKhuyenMai panelKhuyenMai1;
    private Object[] objRemove;
    private Object[] obj1;
    private static Client client1;
    private String maLoaiKM;
    private ArrayList<Object[]> list = new ArrayList<Object[]>();
    public themKhuyenMai(Client client,panelKhuyenMai panelKhuyenMai) {
        initComponents();
        this.setLocationRelativeTo(null);
        client1=client;
        panelKhuyenMai1=panelKhuyenMai;
        setMaKM();
        setUp();
        setUpLKM();
        jDateChooserNBD.setDate(new Date());
    }

    
    private void setMaKM()
    {
     
        JSONObject json = new JSONObject(client1.getList("ListKhuyenMai"));
        JSONArray jsonArray = json.getJSONArray("list");
        int max=0;
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject tacGiaObject = jsonArray.getJSONObject(i);
              String chuoi = tacGiaObject.getString("maKM");
              System.out.println(chuoi);
            if(Integer.parseInt(chuoi.substring(3)) > max)
            {
                max = Integer.parseInt(chuoi.substring(3));
            }
            
        }
        maLKM.setText("KM_"+ String.valueOf(max+1));
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
                model.addRow(new Object[] {sanpham.getTenSP(),String.valueOf(sanpham.getSoLuong()),String.valueOf(sanpham.getGiaBia())});
            }
        }
    }
    
    //ham lay danh sach
    private ArrayList<LoaiKhuyenMaiDTO> getListLKM(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListLoaiKhuyenMai": 
                    ArrayList<LoaiKhuyenMaiDTO> list = new ArrayList<LoaiKhuyenMaiDTO>();
                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                        String MaLoaiKM = tacGiaObject.getString("maLoaiKM");
                        String TenLoaiKM = tacGiaObject.getString("tenLoaiKM");
                        int PhanTramGiam = tacGiaObject.getInt("phanTramGiam");
                        int Trangthai = tacGiaObject.getInt("trangThai");
                    // Thêm vào ArrayList
                    //xem lai trang thai
                    list.add(new LoaiKhuyenMaiDTO(MaLoaiKM, TenLoaiKM, PhanTramGiam, Trangthai));
        }  
                    return list;              
        }           
        return new ArrayList<>();
    }
    //ham thiet lap bang danh sach
    public void setUpLKM()
    {
//        jComboBoxLKM.addItem("Tự nhập");
        for(LoaiKhuyenMaiDTO khuyenmaiDTO : getListLKM("ListLoaiKhuyenMai"))
        {
            jComboBoxLKM.addItem(khuyenmaiDTO.getTenLoaiKM());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtTenKM = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldKM = new javax.swing.JTextField();
        jDateChooserNBD = new com.toedter.calendar.JDateChooser();
        jDateChooserNKT = new com.toedter.calendar.JDateChooser();
        jComboBoxLKM = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSP = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSPC = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        maLKM = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM KHUYẾN MÃI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel2.setText("Tên khuyến mãi");

        txtTenKM.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Ngày bắt đầu");

        jLabel5.setText("Loại khuyến mãi");

        jLabel6.setText("Ngày kết thúc");

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(255, 12, 12));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton5.setText("Hủy");
        jButton5.setBorder(null);
        jButton5.setMaximumSize(new java.awt.Dimension(43, 22));
        jButton5.setMinimumSize(new java.awt.Dimension(43, 22));
        jButton5.setOpaque(true);
        jButton5.setPreferredSize(new java.awt.Dimension(43, 22));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel4.setText("Phần trăm khuyến mãi");

        jTextFieldKM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextFieldKM.setEnabled(false);

        jComboBoxLKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLKMActionPerformed(evt);
            }
        });

        jTextField2.setText("Tìm kiếm...");
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField2.setSelectionColor(new java.awt.Color(0, 0, 0));

        jTableSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Giá bìa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jButton2.setBackground(new java.awt.Color(154, 154, 238));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("Chọn sản phẩm");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jTableSPC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Số lượng", "Giá bìa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jButton6.setBackground(new java.awt.Color(154, 154, 238));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton6.setText("Bỏ sản phẩm");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã khuyến mãi");

        maLKM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        maLKM.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(maLKM, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTenKM)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jComboBoxLKM, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooserNKT, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(211, 211, 211))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldKM, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooserNBD, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(maLKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxLKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(10, 10, 10)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jDateChooserNBD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(62, 62, 62))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jDateChooserNKT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jComboBoxLKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLKMActionPerformed

        //ham xét điều kiện
        if(((String) jComboBoxLKM.getSelectedItem()).equals("Tự nhập"))
        {
            jTextFieldKM.setEnabled(true);
            jTextFieldKM.setText("");
            maLoaiKM = "LKM001";
        }
        else
        {
            jTextFieldKM.setEnabled(false);
            for(LoaiKhuyenMaiDTO khuyenmaiDTO : getListLKM("ListLoaiKhuyenMai"))
            {
                if(((String) jComboBoxLKM.getSelectedItem()).equals(khuyenmaiDTO.getTenLoaiKM()))
                {
                    maLoaiKM = khuyenmaiDTO.getMaLoaiKM();
                    jTextFieldKM.setText(String.valueOf(khuyenmaiDTO.getPhanTramGiam()));
                }
            }
        }
    }//GEN-LAST:event_jComboBoxLKMActionPerformed

    private void jTableSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSPMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) jTableSP.getModel();
        int index = jTableSP.getSelectedRow();
        String TenSP = table.getValueAt(index, 0).toString();
        String SoLuong = table.getValueAt(index, 1).toString();
        String GiaBia = table.getValueAt(index, 2).toString();
        Object[] obj = {TenSP,SoLuong,GiaBia};
        obj1=obj;
    }//GEN-LAST:event_jTableSPMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        //chon san pham
        list.add(obj1);
        DefaultTableModel table = (DefaultTableModel) jTableSPC.getModel();
        table.setRowCount(0);
        
        ArrayList<Object[]> newList = new ArrayList<>();

        // Sử dụng HashSet để theo dõi các giá trị đã thấy
        HashSet<String> seenValues = new HashSet<>();

        // Giả sử list chứa các đối tượng mảng mà bạn muốn kiểm tra
        for (int i = 0; i < list.size(); i++) {
            String ten = (String) list.get(i)[0]; // Lấy giá trị từ cột đầu tiên của mỗi đối tượng
            String soluong = (String) list.get(i)[1];
            String giabia = (String) list.get(i)[2];
            if (!seenValues.contains(ten)) { // Kiểm tra xem giá trị đã được thêm chưa
                seenValues.add(ten); // Thêm vào HashSet
                newList.add(new Object[]{ten,soluong,giabia}); // Thêm vào newList nếu chưa có
            }
        }
        list.clear();
        list.addAll(newList);
        for(Object[] obj2 : list)
        {
            table.addRow(obj2);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTableSPCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSPCMouseClicked
      
        DefaultTableModel table = (DefaultTableModel) jTableSPC.getModel();
        int index = jTableSPC.getSelectedRow();
        String TenSP = table.getValueAt(index, 0).toString();
        String SoLuong = table.getValueAt(index, 1).toString();
        String GiaBia = table.getValueAt(index, 2).toString();
        Object[] obj = {TenSP,SoLuong,GiaBia};
        objRemove=obj;
    }//GEN-LAST:event_jTableSPCMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) jTableSPC.getModel();
        for(int i=0;i<list.size();i++)
        {
            if(list.get(i)[0].equals((String) objRemove[0]))
            {
                list.remove(list.get(i));
            }
        }
        table.setRowCount(0);
        for(Object[] obj2 : list)
        {
            table.addRow(obj2);
        }
        
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //xet dieu kien dau vao
        if(list.size()==0)
        {
           
            JOptionPane.showMessageDialog(null, "Chưa chọn sản phẩm!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            String maKM = maLKM.getText();
            String tenKM = txtTenKM.getText();
            String phanTramKM = jTextFieldKM.getText();
            Date ngayBD = jDateChooserNBD.getDate();
            Date ngayKT = jDateChooserNKT.getDate();
            
            JSONObject json = new JSONObject();
            json.put("method","PUTKM");
            json.put("maKM",maKM);
            json.put("tenKM",tenKM);
            json.put("maLoaiKM",maLoaiKM);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateNBD = dateFormat.format(ngayBD);
            String dateNKT = dateFormat.format(ngayKT);
            json.put("ngayBD",dateNBD);
            json.put("ngayKT",dateNKT);
            json.put("phanTramGiam",phanTramKM);
            JSONObject json1 = new JSONObject();
            json1.put("method","PUTCTKM");
            json1.put("maKM", maKM);
            //chuyen mang thanh chuoi de truyen du lieu
            JSONArray jsonArray = new JSONArray(list);
            String jsonString = jsonArray.toString();
            json1.put("list",jsonString);
            if(client1.themDT(json.toString()).equals("thanhcong"))
            {
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                client1.themDT(json1.toString());
                panelKhuyenMai1.setUp();
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(themKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(themKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(themKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(themKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new themKhuyenMai(client1,panelKhuyenMai1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBoxLKM;
    private com.toedter.calendar.JDateChooser jDateChooserNBD;
    private com.toedter.calendar.JDateChooser jDateChooserNKT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableSP;
    private javax.swing.JTable jTableSPC;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextFieldKM;
    private javax.swing.JTextField maLKM;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables
}
