/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QL.NhanVienGUI;

import Client.Client;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author Administrator
 */
public class suaNhanVien extends javax.swing.JFrame {

    /**
     * Creates new form suaNhanVien
     */
    private static panelNhanVien panelNhanvien1;
    private static String MaDT1;
    private static Client client1;
    
    public suaNhanVien(String MaDT, Client client, panelNhanVien panelNhanVien) {
        initComponents();
        this.setLocationRelativeTo(null);
        MaDT1 = MaDT;
        client1 = client;
        panelNhanvien1 = panelNhanVien;
        setUp();
    }

    private void setUp()
    {
        String data = client1.getDoiTuong("NhanVien", MaDT1);
        JSONObject json = new JSONObject(data);
        MaNV.setText(json.getString("MaNV"));
        TenNV.setText(json.getString("Hovaten"));
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(json.getString("NgaySinh"));
            NgaySinh.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        GioiTinh.setSelectedItem(json.getString("GioiTinh"));
        soDienThoai.setText(json.getString("Sodienthoai"));
        Email.setText(json.getString("Email"));
        DiaChi.setText(json.getString("DiaChi"));
        MaTK.setText(json.getString("MaTK"));
        String maVT = json.getString("MaVT");
        switch (maVT) {
            case "VT_1":
                MaVT.setSelectedIndex(0);
                break;
            case "VT_2":
                MaVT.setSelectedIndex(1);
                break;
            case "VT_3":
                MaVT.setSelectedIndex(2);
                break;
            default:
                MaVT.setSelectedItem("Không xác định");
                break;
        }
//        MaVT.setSelectedItem(json.getString("MaVT"));
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
        TenNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        soDienThoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        GioiTinh = new javax.swing.JComboBox<>();
        MaVT = new javax.swing.JComboBox<>();
        MaTK = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        MaNV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        NgaySinh = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SỬA NHÂN VIÊN");

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

        jLabel2.setText("Họ và tên");

        TenNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TenNV.setEnabled(false);

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Vai trò");

        jLabel5.setText("Địa chỉ");

        DiaChi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Giới tính");

        soDienThoai.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Số điện thoại");

        Email.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Email");

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setText("Sửa");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        GioiTinh.setEnabled(false);

        MaVT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhập kho", "Bán hàng" }));

        MaTK.setEditable(false);
        MaTK.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaTKActionPerformed(evt);
            }
        });

        jLabel10.setText("Mã tài khoản");

        MaNV.setEditable(false);
        MaNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaNVActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã nhân viên");

        NgaySinh.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(jLabel7)
                        .addComponent(soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MaVT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(DiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(Email))
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel10)
                    .addComponent(MaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Email, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(MaVT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
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
        String tenNV = TenNV.getText();
        String maNV = MaNV.getText();
        String diaChiNV = DiaChi.getText().trim();
        String emailNV = Email.getText().trim();
        String sdtNV = soDienThoai.getText().trim();
        String vaitro = MaVT.getSelectedItem().toString();
        Date layngaySinh = NgaySinh.getDate();  // Định dạng "yyyy-MM-dd"
        if (layngaySinh == null) {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngaySinh = sdf.format(layngaySinh);
        String gioiTinh = GioiTinh.getSelectedItem().toString(); 
        String maTK = MaTK.getText();
        JSONObject json = new JSONObject();
        
            // Kiểm tra số điện thoại
        if (!sdtNV.matches("^0\\d{9}$")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại phải bắt đầu bằng 0 và có 10 chữ số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra email
        if (!emailNV.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ email không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra địa chỉ
        if (diaChiNV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
            // Kiểm tra ngày sinh không quá xa hoặc gần
        Calendar currentDate = Calendar.getInstance();
        Calendar birthDate = Calendar.getInstance();
        birthDate.setTime(layngaySinh);

        // Kiểm tra không được dưới 18 tuổi (tính theo ngày)
        birthDate.add(Calendar.YEAR, 18); // Thêm 18 năm vào ngày sinh
        if (birthDate.after(currentDate)) {
            JOptionPane.showMessageDialog(this, "Ngày sinh phải ít nhất là 18 tuổi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kiểm tra không được quá 70 tuổi (tính theo ngày)
        Calendar maxBirthDate = Calendar.getInstance();
        maxBirthDate.add(Calendar.YEAR, -70); // Trừ đi 70 năm từ ngày hiện tại
        if (birthDate.before(maxBirthDate)) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không thể quá 70 tuổi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Kiểm tra không được lớn hơn ngày hiện tại
        if (layngaySinh.after(new Date())) {
            JOptionPane.showMessageDialog(this, "Ngày sinh không thể lớn hơn ngày hiện tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        json.put("method","UPDATENV");
        json.put("MaNV", maNV);
        json.put("Hovaten", tenNV);
        json.put("NgaySinh", ngaySinh);
        json.put("GioiTinh", gioiTinh);
        json.put("Sodienthoai", sdtNV);
        json.put("Email", emailNV);
        json.put("DiaChi", diaChiNV);
        json.put("MaTK", maTK);
        json.put("MaVT", getMaVT(vaitro));
        switch (getMaVT(vaitro)) {
            case "VT_1":
                json.put("TrangThai", 2);
                
                break;
            case "VT_2":
                json.put("TrangThai", 1);
                break;
            case "VT_3":
                json.put("TrangThai", 1);
                break;
            default:
                MaVT.setSelectedItem("Không xác định");
                break;
        }
        //tao json de lay ket qua xu li cap nhat doi tuong
        JSONObject json1 = new JSONObject(client1.suaDT(json.toString()));
        if(json1.getString("ketqua").equals("true"))
        {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            panelNhanvien1.setUp();
            this.setVisible(false);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Sửa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private String getMaVT(String tenVT)
    {
        JSONObject json = new JSONObject(client1.getList("ListVaiTro"));
        JSONArray jsonArray = json.getJSONArray("list");
        System.out.println(jsonArray);
        for(int i=0;i<jsonArray.length();i++)
        {
            
            JSONObject nvObject = jsonArray.getJSONObject(i);
              String chuoi = nvObject.getString("tenVT");
            if(chuoi.equalsIgnoreCase(tenVT))
            {
                return nvObject.getString("maVT");
            }
        }
        return "";
    }
    
    
    private void MaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaTKActionPerformed

    private void MaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaNVActionPerformed

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
            java.util.logging.Logger.getLogger(suaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(suaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(suaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(suaNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new suaNhanVien(MaDT1, client1, panelNhanvien1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DiaChi;
    private javax.swing.JTextField Email;
    private javax.swing.JComboBox<String> GioiTinh;
    private javax.swing.JTextField MaNV;
    private javax.swing.JTextField MaTK;
    private javax.swing.JComboBox<String> MaVT;
    private com.toedter.calendar.JDateChooser NgaySinh;
    private javax.swing.JTextField TenNV;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField soDienThoai;
    // End of variables declaration//GEN-END:variables
}
