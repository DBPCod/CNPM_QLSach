/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Client.Client;
import DTO.NhanVienDTO;
import GUI.Main;
import QL.NhanVienGUI.panelNhanVien;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Client client = new Client();
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtMK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    handleLogin();
                }
            }
        });

        txtTK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                    handleLogin();
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTK = new javax.swing.JTextField();
        txtMK = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        myButton2 = new Customize.MyButton();
        chkShowPassword = new checkbox.JCheckBoxCustom();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new java.awt.BorderLayout());

        img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anh1.jpg"))); // NOI18N
        panel.add(img, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG NHẬP HỆ THỐNG");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên đăng nhập:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mật khẩu:");

        txtTK.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTK.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        txtTK.setSelectionColor(new java.awt.Color(0, 0, 0));

        txtMK.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtMK.setSelectionColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTK, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(txtMK))
                .addGap(55, 55, 55))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMK, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        myButton2.setBackground(new java.awt.Color(0, 0, 0));
        myButton2.setForeground(new java.awt.Color(255, 255, 255));
        myButton2.setText("ĐĂNG NHẬP");
        myButton2.setBorderColor(new java.awt.Color(0, 0, 0));
        myButton2.setColor(new java.awt.Color(0, 0, 0));
        myButton2.setColorClick(new java.awt.Color(255, 255, 255));
        myButton2.setColorOver(new java.awt.Color(204, 204, 204));
        myButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        myButton2.setPreferredSize(new java.awt.Dimension(160, 30));
        myButton2.setRadius(10);
        myButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton2MouseClicked(evt);
            }
        });
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(myButton2);

        chkShowPassword.setBackground(new java.awt.Color(51, 51, 51));
        chkShowPassword.setText("Hiển thị mật khẩu");
        chkShowPassword.setContentAreaFilled(false);
        chkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkShowPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chkShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(chkShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton1ActionPerformed

    //ham lay danh sách
    private ArrayList<NhanVienDTO> getList(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListNhanVien": 
                
                    ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
                    json = new JSONObject(client.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject nvObject = jsonArray.getJSONObject(i);
                        String MaNV = nvObject.getString("maNV");
                        String HoVaTen = nvObject.getString("hoVaTen");
                        String NgaySinh = nvObject.getString("ngaySinh");
                        String GioiTinh = nvObject.getString("gioiTinh");
                        String SoDienThoai = nvObject.getString("soDienThoai");
                        String Email = nvObject.getString("email");
                        String DiaChi = nvObject.getString("diaChi");
                        String MaTK = nvObject.getString("maTK");
                        String MaVT = nvObject.getString("maVT");
                        int Trangthai = nvObject.getInt("trangThai");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");       
            try {
                Date ngaySinh = formatter.parse(NgaySinh);
                // Thêm vào ArrayList
                //xem lai trang thai
                list.add(new NhanVienDTO(MaNV,  HoVaTen,  ngaySinh,  GioiTinh,  SoDienThoai, Email, DiaChi, MaTK, MaVT, Trangthai));
            } catch (ParseException ex) {
                Logger.getLogger(panelNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                    return list;
                   
        }    
        return new ArrayList<>();
    }

    private void handleLogin() {
        String taikhoan = txtTK.getText();
        String matkhau = txtMK.getText();

        if (taikhoan.isEmpty() || matkhau.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập và mật khẩu không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lấy danh sách nhân viên trước
        ArrayList<NhanVienDTO> nhanVienList = getList("ListNhanVien");

        // Gửi yêu cầu đăng nhập tới server
        String response = client.dangNhap(taikhoan, matkhau);
        JSONObject json = new JSONObject(response);

        // Xử lý phản hồi từ server
        if (json.getString("Trangthai").equals("true")) {
            String maTK = json.getString("MaTK");

            // Tìm nhân viên có mã tài khoản khớp và trạng thái kích hoạt
            for (NhanVienDTO nv : nhanVienList) {
                if (nv.getMaTK().equals(maTK) && nv.getTrangThai() != 0) {
                    switch (nv.getMaVT()) {
                        case "VT_1":
                            Main main = new Main(maTK, client);
                            main.setVisible(true);
                            this.dispose();
                            return;
                        case "VT_2":
                            MainNhapKho mainnk = new MainNhapKho(maTK, client);
                            mainnk.setVisible(true);
                            this.dispose();
                            return;
                        case "VT_3":
                            MainBanHang mainbh = new MainBanHang(maTK, client);
                            mainbh.setVisible(true);
                            this.dispose();
                            return;
                    }
                }
            }

            // Nếu không tìm thấy nhân viên, thông báo lỗi
            JOptionPane.showMessageDialog(this, "Tài khoản đã bị vô hiệu hóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Nếu đăng nhập thất bại
        String errorMessage = json.optString("Thongbao", "Tên tài khoản hoặc mật khẩu không chính xác");
        JOptionPane.showMessageDialog(this, errorMessage, "Lỗi", JOptionPane.ERROR_MESSAGE);
    }
    
    private String getMaVT(String MaTK)
    {
        for(NhanVienDTO x : getList("ListNhanVien"))
        {
            if(MaTK.equals(x.getMaTK()))
            {
                return x.getMaVT();
            }
        }
        return "";
    }
    
    private void myButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton2MouseClicked
        handleLogin();
    }//GEN-LAST:event_myButton2MouseClicked

    private void chkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkShowPasswordActionPerformed
        // TODO add your handling code here:
        if (chkShowPassword.isSelected()) {
        // Hiển thị mật khẩu
        txtMK.setEchoChar((char) 0); // Đặt echoChar thành 0 để hiển thị mật khẩu
    } else {
        // Ẩn mật khẩu
        txtMK.setEchoChar('•'); // Đặt echoChar lại là dấu '*' để ẩn mật khẩu
    }
    }//GEN-LAST:event_chkShowPasswordActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FlatLightLaf.setup();
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private checkbox.JCheckBoxCustom chkShowPassword;
    private javax.swing.JLabel img;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private Customize.MyButton myButton2;
    private javax.swing.JPanel panel;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JTextField txtTK;
    // End of variables declaration//GEN-END:variables
}

