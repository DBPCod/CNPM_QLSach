/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QL.khuyenMaiGUI;

import Client.Client;
import DTO.LoaiKhuyenMaiDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
import Customize.TimKiem;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class loaiKhuyenMai extends javax.swing.JFrame {

    /**
     * Creates new form loaiKhuyenMai
     */
    private static String MaDT="0";
    private static Client client1;
    private static TimKiem timkiem = new TimKiem();
    
    public loaiKhuyenMai(Client client) {
        initComponents();
        this.setLocationRelativeTo(null);
        client1=client;
        setUp();
        timkiem.setPlaceholder(timKiemField, "Tìm kiếm theo mã hoặc tên loại...");
//        timkiem.setPlaceholder(txtLKM, "Nhập tên loại khuyến mãi");
        timkiem.setUpSearchListener(timKiemField, this::timKiem);
    }

    //ham lay danh sach
    private ArrayList<LoaiKhuyenMaiDTO> getList(String yeucau)
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
    public void setUp()
    {
        
        DefaultTableModel model = (DefaultTableModel) jTableLKM.getModel();
        model.setRowCount(0);
        for(LoaiKhuyenMaiDTO khuyenmaiDTO : getList("ListLoaiKhuyenMai"))
        {
            //them tung doi tuong vao bang
            if(khuyenmaiDTO.getTrangThai()==1)
            {
                model.addRow(new Object[] {khuyenmaiDTO.getMaLoaiKM(),khuyenmaiDTO.getTenLoaiKM(),khuyenmaiDTO.getPhanTramGiam()});
            }
        }
        txtMaLKM.setText(setMaLKM());
    }
    
    private void timKiem() 
    {        
        String searchText = timkiem.KhongLayDau(timKiemField.getText().trim().toLowerCase());
        DefaultTableModel model = (DefaultTableModel) jTableLKM.getModel();
        model.setRowCount(0); 

        ArrayList<LoaiKhuyenMaiDTO> allDiscountType = getList("ListLoaiKhuyenMai");

        for (LoaiKhuyenMaiDTO khuyenmai : allDiscountType) {
            if (khuyenmai.getTrangThai() == 1) {
                String maLKM = timkiem.KhongLayDau(khuyenmai.getMaLoaiKM().toLowerCase());
                String tenLKM = timkiem.KhongLayDau(khuyenmai.getTenLoaiKM().toLowerCase());
                
                if (maLKM.contains(searchText) || tenLKM.contains(searchText)){
                    model.addRow(new Object[] {khuyenmai.getMaLoaiKM(),khuyenmai.getTenLoaiKM(),khuyenmai.getPhanTramGiam()});
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
        jPanel8 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLKM = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtLKM = new javax.swing.JTextField();
        jSpinnerLKM = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        txtMaLKM = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        timKiemField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 72, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTableLKM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableLKM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TL1", null, "Viễn tưởng"},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Phần trăm giảm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLKM.setFocusable(false);
        jTableLKM.setGridColor(new java.awt.Color(0, 0, 0));
        jTableLKM.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTableLKM.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableLKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLKMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLKM);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconthem.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thêm");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconsua.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sửa");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconxoa.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Xóa");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );

        txtLKM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtLKM.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtLKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLKMMouseClicked(evt);
            }
        });
        txtLKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLKMActionPerformed(evt);
            }
        });

        jSpinnerLKM.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));

        jLabel7.setText("Phần trăm giảm");

        txtMaLKM.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtMaLKM.setEnabled(false);
        txtMaLKM.setSelectionColor(new java.awt.Color(0, 0, 0));
        txtMaLKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMaLKMMouseClicked(evt);
            }
        });
        txtMaLKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLKMActionPerformed(evt);
            }
        });

        jLabel8.setText("Tên khuyến mãi");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtMaLKM))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLKM)
                            .addComponent(jSpinnerLKM, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(txtMaLKM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLKM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSpinnerLKM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        timKiemField.setText("Tìm kiếm....");
        timKiemField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        timKiemField.setSelectionColor(new java.awt.Color(0, 0, 0));
        timKiemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemFieldActionPerformed(evt);
            }
        });

        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(466, 466, 466)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isDuplicateName(String tenLoaiKM) {
        ArrayList<LoaiKhuyenMaiDTO> allDiscountType = getList("ListLoaiKhuyenMai");
        for (LoaiKhuyenMaiDTO khuyenmai : allDiscountType) {
            if (khuyenmai.getTrangThai() == 1 && khuyenmai.getTenLoaiKM().equalsIgnoreCase(tenLoaiKM)) {
                return true; // Tên đã tồn tại
            }
        }
        return false; // Tên không trùng
    }
    
    private boolean isFieldEmpty(JTextField textField, String fieldName) {
    String value = textField.getText().trim(); // Lấy giá trị và loại bỏ khoảng trắng
    if (value.isEmpty()) {
        JOptionPane.showMessageDialog(null, fieldName + " không được để trống!", "Thông báo", JOptionPane.WARNING_MESSAGE);
        return true; // Trả về true nếu trường bị bỏ trống
    }
    return false; // Trả về false nếu trường không bị bỏ trống
}

    
    private void resetFields() {
        txtLKM.setText(""); // Đặt tên loại khuyến mãi về trống
        txtMaLKM.setText(setMaLKM()); // Tạo lại mã loại khuyến mãi mới
        jSpinnerLKM.setValue(0); // Đặt giá trị của JSpinner về 0
        jSpinnerLKM.repaint(); // Cập nhật lại giao diện của JSpinner (nếu cần)
    }
    
    private String setMaLKM()
    {
     
        JSONObject json = new JSONObject(client1.getList("ListLoaiKhuyenMai"));
        JSONArray jsonArray = json.getJSONArray("list");
        int max=0;
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject tacGiaObject = jsonArray.getJSONObject(i);
              String chuoi = tacGiaObject.getString("maLoaiKM");
            if(Integer.parseInt(chuoi.substring(4)) > max)
            {
                max = Integer.parseInt(chuoi.substring(4));
            }
            
        }
        return ("LKM_"+ String.valueOf(max+1));
    }
    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        try {
            // Cập nhật giá trị trong JSpinner
            jSpinnerLKM.commitEdit();
        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(null, "Giá trị không hợp lệ trong spinner!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

            // Kiểm tra nếu trường nhập tên khuyến mãi bị bỏ trống
        if (isFieldEmpty(txtLKM, "Tên loại khuyến mãi")) {
            return; // Kết thúc hàm nếu tên bị bỏ trống
        }
        
        // Lấy giá trị từ JSpinner sau khi commit
        int value = (Integer) jSpinnerLKM.getValue();
        String txtLKM1 = txtLKM.getText();

         if (value <= 0 || value >= 100) {
                JOptionPane.showMessageDialog(null, "Phần trăm giảm phải lớn hơn 0 và nhỏ hơn 100!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            } else if (isDuplicateName(txtLKM1)) {
                JOptionPane.showMessageDialog(null, "Tên loại khuyến mãi đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
            JSONObject json = new JSONObject();
            json.put("method","PUTLKM");
            json.put("MaLoaiKM",setMaLKM());
            json.put("TenLoaiKM",txtLKM1);
            json.put("Phantram",value);
            if(client1.themDT(json.toString()).equals("thanhcong")) {
                JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                setUp();
                resetFields(); // Đặt lại các trường nhập liệu
            }
        }
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
            try {
            jSpinnerLKM.commitEdit(); // Cập nhật giá trị của JSpinner
        } catch (java.text.ParseException e) {
            JOptionPane.showMessageDialog(null, "Phần trăm giảm phải lớn hơn 0 và nhỏ hơn 100!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            return;
        }

            // Kiểm tra nếu trường nhập tên khuyến mãi bị bỏ trống
        if (isFieldEmpty(txtLKM, "Tên loại khuyến mãi")) {
            return; // Kết thúc hàm nếu tên bị bỏ trống
        }    
            
        int value = (Integer) jSpinnerLKM.getValue();
        String maLKM = txtMaLKM.getText();
        String txtLKM1 = txtLKM.getText().trim();

        if (value <= 0 || value >= 100) {
            JOptionPane.showMessageDialog(null, "Phần trăm giảm phải lớn hơn 0 và nhỏ hơn 100!", "Thông báo", JOptionPane.ERROR_MESSAGE);
        } else {
            ArrayList<LoaiKhuyenMaiDTO> allDiscountType = getList("ListLoaiKhuyenMai");
            boolean isDuplicate = false;

            for (LoaiKhuyenMaiDTO khuyenmai : allDiscountType) {
                if (khuyenmai.getTrangThai() == 1 
                    && khuyenmai.getMaLoaiKM().equalsIgnoreCase(maLKM)) {
                    continue; // Bỏ qua loại khuyến mãi đang sửa
                }
                if (khuyenmai.getTrangThai() == 1 
                    && khuyenmai.getTenLoaiKM().equalsIgnoreCase(txtLKM1)) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                JOptionPane.showMessageDialog(null, "Tên loại khuyến mãi đã tồn tại!", "Thông báo", JOptionPane.WARNING_MESSAGE);
            } else {
                JSONObject json = new JSONObject();
                json.put("method", "UPDATELKM");
                json.put("MaLoaiKM", maLKM);
                json.put("TenLoaiKM", txtLKM1);
                json.put("Phantram", value);

                JSONObject json1 = new JSONObject(client1.suaDT(json.toString()));
                if (json1.getString("ketqua").equals("true")) {
                    JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    setUp(); // Cập nhật danh sách
                    resetFields(); // Đặt lại các trường nhập liệu
                } else {
                    JOptionPane.showMessageDialog(null, "Sửa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        txtMaLKM.setText("");
        txtLKM.setText("");
        jSpinnerLKM.setValue(0);
        jSpinnerLKM.repaint();
    }//GEN-LAST:event_jPanel9MouseClicked

    private void txtLKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLKMActionPerformed

    private void txtLKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLKMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLKMMouseClicked

    private void jTableLKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLKMMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) jTableLKM.getModel();
        
        int index = jTableLKM.getSelectedRow();
        String TenLKM = table.getValueAt(index, 1).toString();
        String Phantram = table.getValueAt(index, 2).toString();
        txtMaLKM.setText(table.getValueAt(index, 0).toString());
        txtLKM.setText(TenLKM);
        jSpinnerLKM.setValue(Integer.parseInt(Phantram));
        String maLKM = txtMaLKM.getText();
        MaDT=maLKM;
    }//GEN-LAST:event_jTableLKMMouseClicked

    private void txtMaLKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaLKMMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLKMMouseClicked

    private void txtMaLKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLKMActionPerformed

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
        
        if(MaDT.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JSONObject json = new JSONObject();
        json.put("method","DELETELKM");
        json.put("MaLoaiKM",MaDT);
        json.put("Trangthai",0);
        JSONObject json1 = new JSONObject(client1.xoaDT(json.toString()));
        if(json1.getString("ketqua").equals("true"))
        {
            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            setUp();
            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jPanel10MouseClicked

    private void timKiemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timKiemFieldActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setUp();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(loaiKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loaiKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loaiKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loaiKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loaiKhuyenMai(client1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinnerLKM;
    private javax.swing.JTable jTableLKM;
    private javax.swing.JTextField timKiemField;
    private javax.swing.JTextField txtLKM;
    private javax.swing.JTextField txtMaLKM;
    // End of variables declaration//GEN-END:variables
}
