/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Client.Client;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author luuis
 */
public class suaThongTin extends javax.swing.JFrame {

    /**
     * Creates new form suaThongTinCaNhan
     */
    private static panelThongTin panelThongTin1;
    private static String MaTK1;
    private static JSONObject json1;
    private static Client client1;
    public suaThongTin(JSONObject json,Client client,String MaTK,panelThongTin panelThongTin) {
        initComponents();
        this.setLocationRelativeTo(null);
        client1=client;
        json1=json;
        MaTK1=MaTK;
        panelThongTin1 = panelThongTin;
        setUp();
    }

    
    private void setUp()
    {
        hovaten.setText(json1.getString("Hovaten"));
        ngaysinh.setText(json1.getString("NgaySinh"));
        sdt.setText(json1.getString("Sodienthoai"));
        diachi.setText(json1.getString("Diachi"));
        gioitinh.setSelectedItem(json1.getString("Gioitinh"));
        if(json1.getString("Gioitinh").equals("Nam"))
        {
            gioitinh.setSelectedItem(0);
        }
        else
        {
            gioitinh.setSelectedItem(1);
        }
        email.setText(json1.getString("Email"));  
        JSONObject json2 = new JSONObject(client1.getVaiTro(json1.getString("MaVT")));
        switch (json2.getString("TenVT"))
        {
            case "Quản lý":
                 vaitro.setSelectedItem(0);
                 break;
            case "Nhập kho":
                vaitro.setSelectedItem(1);
                break;
            case "Bán hàng":
                vaitro.setSelectedItem(2);
                break;
        }
    }
    /**s
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
        hovaten = new javax.swing.JTextField();
        ngaysinh = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        diachi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        sdt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        gioitinh = new javax.swing.JComboBox<>();
        vaitro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SỬA THÔNG TIN NHÂN VIÊN");

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

        hovaten.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        hovaten.setEnabled(false);

        ngaysinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ngaysinh.setEnabled(false);

        jLabel3.setText("Ngày sinh");

        jLabel4.setText("Vai trò");

        jLabel5.setText("Địa chỉ");

        diachi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Giới tính");

        sdt.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        sdt.setEnabled(false);
        sdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sdtActionPerformed(evt);
            }
        });

        jLabel7.setText("Số điện thoại");

        email.setEditable(false);
        email.setBackground(new java.awt.Color(255, 255, 255));
        email.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("Email");

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setText("Xong");
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

        gioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        gioitinh.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        gioitinh.setEnabled(false);

        vaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhập kho", "Bán hàng" }));
        vaitro.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        vaitro.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(hovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)
                        .addComponent(ngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(vaitro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(diachi, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(email))
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(gioitinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(hovaten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(diachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ngaysinh)
                    .addComponent(gioitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(email)
                    .addComponent(vaitro, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sdt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sdtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        String hvt = hovaten.getText();
        String ngaysinh1 =ngaysinh.getText();
        String sodienthoai = sdt.getText();
        String DiaChi = diachi.getText();
        String gioitinh1 = (String) gioitinh.getSelectedItem();
        String Email = email.getText();
        String Vaitro = (String) vaitro.getSelectedItem();
        JSONObject json = new JSONObject();
        json.put("method","UPDATENV");
        json.put("MaNV", getMaNV(MaTK1));
        json.put("Hovaten", hvt);
        json.put("NgaySinh", ngaysinh1);
        json.put("GioiTinh", gioitinh1);
        json.put("Sodienthoai", sodienthoai);
        json.put("Email", Email);
        json.put("DiaChi", DiaChi);
        json.put("MaTK", MaTK1);
        json.put("MaVT", getMaVT(Vaitro));
        JSONObject json1 = new JSONObject(client1.suaDT(json.toString()));
        if(json1.getString("ketqua").equals("true"))
        {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            panelThongTin1.setUp();
            this.setVisible(false);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Sửa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private String getMaNV(String MaTK)
    {
        JSONObject json = new JSONObject(client1.getList("ListNhanVien"));
        JSONArray jsonArray = json.getJSONArray("list");
        for(int i=0;i<jsonArray.length();i++)
        {
            
            JSONObject nvObject = jsonArray.getJSONObject(i);
              String chuoi = nvObject.getString("maTK");
            if(chuoi.equalsIgnoreCase(MaTK))
            {
                return nvObject.getString("maNV");
            }
        }
        return "";
    }
    
    
    
    private String getMaVT(String tenVT)
    {
        JSONObject json = new JSONObject(client1.getList("ListVaiTro"));
        JSONArray jsonArray = json.getJSONArray("list");
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
            java.util.logging.Logger.getLogger(suaThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(suaThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(suaThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(suaThongTin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new suaThongTin(json1,client1,MaTK1,panelThongTin1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField diachi;
    private javax.swing.JTextField email;
    private javax.swing.JComboBox<String> gioitinh;
    private javax.swing.JTextField hovaten;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField ngaysinh;
    private javax.swing.JTextField sdt;
    private javax.swing.JComboBox<String> vaitro;
    // End of variables declaration//GEN-END:variables
}
