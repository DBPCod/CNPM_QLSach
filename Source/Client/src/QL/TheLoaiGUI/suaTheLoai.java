/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QL.TheLoaiGUI;

import Client.Client;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author Administrator
 */
public class suaTheLoai extends javax.swing.JFrame {

    /**
     * Creates new form suaTheLoai
     */
    private static panelTheLoai panelTheLoai1;
    private static String MaDT1;
    private static Client client1;
    
    public suaTheLoai(String MaDT, Client client, panelTheLoai panelTheLoai) {
        initComponents();
        this.setLocationRelativeTo(null);
        MaDT1 = MaDT;
        client1 = client;
        panelTheLoai1 = panelTheLoai;
        setUp();
    }
    
    private void setUp()
    {
        String data = client1.getDoiTuong("TheLoai", MaDT1);
        JSONObject json = new JSONObject(data);
        MaTL.setText(json.getString("MaTL"));
        TenTL.setText(json.getString("TenTL"));
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
        MaTL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TenTL = new javax.swing.JTextField();
        nutSua = new javax.swing.JButton();
        nutHuy = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SỬA THỂ LOẠI");

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

        jLabel2.setText("Mã thể loại");

        MaTL.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        MaTL.setEnabled(false);
        MaTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaTLActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên thể loại");

        TenTL.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nutSua.setBackground(new java.awt.Color(102, 255, 102));
        nutSua.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nutSua.setText("Sửa");
        nutSua.setBorder(null);
        nutSua.setBorderPainted(false);
        nutSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutSuaActionPerformed(evt);
            }
        });

        nutHuy.setBackground(new java.awt.Color(255, 12, 12));
        nutHuy.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        nutHuy.setText("Hủy");
        nutHuy.setBorder(null);
        nutHuy.setMaximumSize(new java.awt.Dimension(43, 22));
        nutHuy.setMinimumSize(new java.awt.Dimension(43, 22));
        nutHuy.setOpaque(true);
        nutHuy.setPreferredSize(new java.awt.Dimension(43, 22));
        nutHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(MaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nutSua, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nutHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(TenTL, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(40, 40, 40))
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
                        .addComponent(MaTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TenTL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nutSua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nutHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MaTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaTLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MaTLActionPerformed

    private void nutSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutSuaActionPerformed
        // TODO add your handling code here:
        String maTL = MaTL.getText();
        String tenTL = TenTL.getText();
        
        // kiem tra ten the loai
        if (tenTL.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tên thể loại không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (tenTL.matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Tên thể loại không được chứa số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // kiem tra trung lap
        if (kiemtraTrungTL(tenTL)) {
            JOptionPane.showMessageDialog(null, "Tên thể loại đã tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JSONObject json = new JSONObject();
        json.put("method","UPDATETL");
        json.put("MaTL", maTL);
        json.put("TenTL", tenTL);
        
        //tao json de lay ket qua xu li cap nhat doi tuong
        JSONObject json1 = new JSONObject(client1.suaDT(json.toString()));
        if(json1.getString("ketqua").equals("true"))
        {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            panelTheLoai1.setUp();
            this.setVisible(false);
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "Sửa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_nutSuaActionPerformed

        // ham kiem tra trung ten the loai
    private boolean kiemtraTrungTL(String tenTL) {
        JSONObject json = new JSONObject(client1.getList("ListTheLoai"));
        JSONArray jsonArray = json.getJSONArray("list");
        
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject tlObject = jsonArray.getJSONObject(i);
            String existingName = tlObject.getString("tenTL").trim().toLowerCase();

            if (existingName.equals(tenTL.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    private void nutHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutHuyActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_nutHuyActionPerformed

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
            java.util.logging.Logger.getLogger(suaTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(suaTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(suaTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(suaTheLoai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new suaTheLoai(MaDT1, client1, panelTheLoai1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MaTL;
    private javax.swing.JTextField TenTL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nutHuy;
    private javax.swing.JButton nutSua;
    // End of variables declaration//GEN-END:variables
}
