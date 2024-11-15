/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QL.NhanVienGUI;

import Client.Client;
import DTO.TaiKhoanDTO;
import QL.NhanVienGUI.panelNhanVien;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Administrator
 */

public class themNhanVien extends javax.swing.JFrame {

    private static panelNhanVien panelNhanVien1;
    private static Client client1;
    /**
     * Creates new form themNhanVien
     */
    public themNhanVien(Client client, panelNhanVien panelNhanVien) {
        initComponents();
        this.setLocationRelativeTo(null);
        client1=client;
        panelNhanVien1=panelNhanVien;
        setMaNV();
        NgaySinh.setDate(new java.util.Date());
    }
    
    private void setMaNV()
    {
     
        JSONObject json = new JSONObject(client1.getList("ListNhanVien"));
        JSONArray jsonArray = json.getJSONArray("list");
        int max=0;
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject nvObject = jsonArray.getJSONObject(i);
              String chuoi = nvObject.getString("maNV");
            if(Integer.parseInt(chuoi.substring(3)) > max)
            {
                max = Integer.parseInt(chuoi.substring(3));
            }
            
        }
        MaNV.setText("NV_"+ String.valueOf(max+1));
        MaTK.setText("TK_"+ String.valueOf(max+1));
        setMaTK();
    }

    private String setMaTK()
    {
        JSONObject json = new JSONObject(client1.getList("ListTaiKhoan"));
        JSONArray jsonArray = json.getJSONArray("list");
        int max=0;
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject tacGiaObject = jsonArray.getJSONObject(i);
              String chuoi = tacGiaObject.getString("maTK");
            if(Integer.parseInt(chuoi.substring(3)) > max)
            {
                max = Integer.parseInt(chuoi.substring(3));
            }
            
        }
        return "TK_" + (max+1);
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
                    System.out.println(jsonArray);
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
        HoVaTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        soDienThoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nutThem = new javax.swing.JButton();
        GioiTinh = new javax.swing.JComboBox<>();
        MaVT = new javax.swing.JComboBox<>();
        MaNV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        NgaySinh = new com.toedter.calendar.JDateChooser();
        MaTK = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÊM NHÂN VIÊN");

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

        HoVaTen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        HoVaTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoVaTenActionPerformed(evt);
            }
        });

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Vai trò");

        jLabel5.setText("Địa chỉ");

        DiaChi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Giới tính");

        soDienThoai.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Số điện thoại");

        email.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Email");

        nutThem.setBackground(new java.awt.Color(102, 255, 102));
        nutThem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nutThem.setText("Thêm");
        nutThem.setBorder(null);
        nutThem.setBorderPainted(false);
        nutThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nutThemMouseClicked(evt);
            }
        });
        nutThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutThemActionPerformed(evt);
            }
        });

        GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        MaVT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhập kho", "Bán hàng" }));

        MaNV.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MaNV.setEnabled(false);
        MaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaNVActionPerformed(evt);
            }
        });

        jLabel9.setText("Mã nhân viên");

        NgaySinh.setDateFormatString("yyyy-MM-dd");

        MaTK.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MaTK.setEnabled(false);
        MaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaTKActionPerformed(evt);
            }
        });

        jLabel10.setText("Mã tài khoản");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel7)
                                .addComponent(soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(MaVT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(93, 93, 93))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(MaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nutThem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(HoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel8)
                        .addComponent(GioiTinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(HoVaTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MaVT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(GioiTinh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MaTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nutThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HoVaTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoVaTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoVaTenActionPerformed

    private void nutThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutThemMouseClicked
        // TODO add your handling code here:
    
    }//GEN-LAST:event_nutThemMouseClicked

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
    
    private void MaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaNVActionPerformed

    private void MaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaTKActionPerformed

    private void nutThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutThemActionPerformed
        // TODO add your handling code here:
        String tenNV = HoVaTen.getText();
    String maNV = MaNV.getText();
    String diaChiNV = DiaChi.getText();
    String emailNV = email.getText();
    String sdtNV = soDienThoai.getText();
    String vaitro = MaVT.getSelectedItem().toString();
    Date layngaySinh = NgaySinh.getDate();  // Định dạng "yyyy-MM-dd"
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    if (layngaySinh == null) {
    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh!", "Lỗi", JOptionPane.ERROR_MESSAGE);
    return;
    }
    String ngaySinh = sdf.format(layngaySinh);
    String gioiTinh = GioiTinh.getSelectedItem().toString();  // giả định là combo box
    String maTK = MaTK.getText();

    // Kiểm tra họ và tên
    if (tenNV.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Họ và tên không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!tenNV.matches("^[\\p{L}\\s]+$")) {
        JOptionPane.showMessageDialog(null, "Họ và tên chỉ được chứa chữ cái và khoảng trắng!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (tenNV.matches(".*\\s{2,}.*")) {
        JOptionPane.showMessageDialog(null, "Họ và tên không được chứa khoảng trắng liên tiếp!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Kiểm tra số điện thoại
    if (sdtNV.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Số điện thoại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!sdtNV.matches("^0\\d{9}$")) {
        JOptionPane.showMessageDialog(null, "Số điện thoại phải bắt đầu bằng 0 và có 10 chữ số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Kiểm tra địa chỉ
    if (diaChiNV.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Kiểm tra email
    if (emailNV.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Email không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    } else if (!emailNV.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
        JOptionPane.showMessageDialog(null, "Email không hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Kiểm tra ngày sinh
    if (layngaySinh == null) {
        JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
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

    //tao doi tuong tai khoan
    JSONObject json1 = new JSONObject();
    json1.put("method", "PUTTK");
    json1.put("MaTK", setMaTK());
    json1.put("TenTK",soDienThoai.getText());
    json1.put("MatkhauTK","123456");
    
    
    JSONObject json = new JSONObject();
    json.put("method", "PUTNV");
    json.put("MaNV", maNV);
    json.put("Hovaten", tenNV);
    json.put("NgaySinh", ngaySinh);
    json.put("GioiTinh", gioiTinh);
    json.put("DiaChi", diaChiNV);
    json.put("Sodienthoai", sdtNV);
    json.put("MaVT", getMaVT(vaitro));
    json.put("Email", emailNV);
    json.put("MaTK", setMaTK());
    // Gửi thông tin nhân viên và kiểm tra kết quả
    if(client1.themDT(json1.toString()).equals("thanhcong"))
    {
        
        if (client1.themDT(json.toString()).equals("thanhcong")) {
        JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        
        // Cập nhật lại danh sách nhân viên trên giao diện
        panelNhanVien1.setUp();
        
        this.setVisible(false);
    
        }
    }
    
    }//GEN-LAST:event_nutThemActionPerformed

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
            java.util.logging.Logger.getLogger(themNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(themNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(themNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(themNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new themNhanVien(client1,panelNhanVien1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DiaChi;
    private javax.swing.JComboBox<String> GioiTinh;
    private javax.swing.JTextField HoVaTen;
    private javax.swing.JTextField MaNV;
    private javax.swing.JTextField MaTK;
    private javax.swing.JComboBox<String> MaVT;
    private com.toedter.calendar.JDateChooser NgaySinh;
    private javax.swing.JTextField email;
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
    private javax.swing.JButton nutThem;
    private javax.swing.JTextField soDienThoai;
    // End of variables declaration//GEN-END:variables
}
