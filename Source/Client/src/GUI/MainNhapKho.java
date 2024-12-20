/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Client.Client;
import NK.NhaXuatBanGUI.panelNhaXuatBan;
import NK.NhapKhoGUI.panelKho;
import NK.SanPhamGUI.panelSanPham;
import NK.ThongKeGUI.panelThongKe;
import TrangChuImg.panelTrangChu;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import org.json.JSONObject;

/**
 *
 * @author PC
 */

public class MainNhapKho extends javax.swing.JFrame {
Color customColor = Color.decode("#C2F2E9");
    /**
     * Creates new form MainNhapKho
     */private static String MaTK1;
    private static Client client1;
    public MainNhapKho(String MaTK,Client client) {
        initComponents();
        this.setLocationRelativeTo(null);
        MaTK1 = MaTK;
        client1=client;
        setBorder();
        start();
        panel10.setVisible(false);
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
        panelTT = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tenNV = new javax.swing.JLabel();
        vaiTro = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        panel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        panel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        panel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        panel11 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        panelChange = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(195, 640));

        panelTT.setBackground(new java.awt.Color(255, 255, 255));
        panelTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelTTMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        tenNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tenNV.setText("Đinh Bá Phong");

        vaiTro.setText("Nhập kho");

        javax.swing.GroupLayout panelTTLayout = new javax.swing.GroupLayout(panelTT);
        panelTT.setLayout(panelTTLayout);
        panelTTLayout.setHorizontalGroup(
            panelTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tenNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vaiTro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTTLayout.setVerticalGroup(
            panelTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTTLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(panelTTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTTLayout.createSequentialGroup()
                        .addComponent(tenNV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(vaiTro)))
                .addGap(22, 22, 22))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel1MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon2.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Trang chủ");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel4.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 195, -1));

        panel2.setBackground(new java.awt.Color(255, 255, 255));
        panel2.setPreferredSize(new java.awt.Dimension(195, 46));
        panel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel2MouseClicked(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon3.jpg"))); // NOI18N
        jLabel6.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Sản phẩm");

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        jPanel4.add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 46, 195, -1));

        panel5.setBackground(new java.awt.Color(255, 255, 255));
        panel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel5MouseClicked(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Nhà xuất bản");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon6.jpg"))); // NOI18N
        jLabel14.setText("jLabel4");

        javax.swing.GroupLayout panel5Layout = new javax.swing.GroupLayout(panel5);
        panel5.setLayout(panel5Layout);
        panel5Layout.setHorizontalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel5Layout.setVerticalGroup(
            panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(panel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 195, -1));

        panel6.setBackground(new java.awt.Color(255, 255, 255));
        panel6.setPreferredSize(new java.awt.Dimension(195, 46));
        panel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel6MouseClicked(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon7.jpg"))); // NOI18N
        jLabel12.setText("jLabel4");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Phiếu nhập");

        javax.swing.GroupLayout panel6Layout = new javax.swing.GroupLayout(panel6);
        panel6.setLayout(panel6Layout);
        panel6Layout.setHorizontalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel6Layout.setVerticalGroup(
            panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap())
        );

        jPanel4.add(panel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 136, 195, -1));

        panel10.setBackground(new java.awt.Color(255, 255, 255));
        panel10.setPreferredSize(new java.awt.Dimension(195, 46));
        panel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel10MouseClicked(evt);
            }
        });

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon11.jpg"))); // NOI18N
        jLabel22.setText("jLabel4");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setText("Thống kê");

        javax.swing.GroupLayout panel10Layout = new javax.swing.GroupLayout(panel10);
        panel10.setLayout(panel10Layout);
        panel10Layout.setHorizontalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panel10Layout.setVerticalGroup(
            panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel4.add(panel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 182, 195, 50));

        panel11.setBackground(new java.awt.Color(255, 255, 255));
        panel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel11MouseClicked(evt);
            }
        });

        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon12.jpg"))); // NOI18N
        jLabel24.setText("jLabel4");

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setText("Đăng xuất");

        javax.swing.GroupLayout panel11Layout = new javax.swing.GroupLayout(panel11);
        panel11.setLayout(panel11Layout);
        panel11Layout.setHorizontalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        panel11Layout.setVerticalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(panel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 506, 195, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelChange.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelChangeLayout = new javax.swing.GroupLayout(panelChange);
        panelChange.setLayout(panelChangeLayout);
        panelChangeLayout.setHorizontalGroup(
            panelChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        panelChangeLayout.setVerticalGroup(
            panelChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(panelChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1169, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void start()
    {
        panel1.setBackground(customColor);
        panelTrangChu  tt = new panelTrangChu();
        panelChange.removeAll();
        panelChange.add(tt).setVisible(true);
        setUp();
    }
    
    public void setUp()
    {
       
        JSONObject json = new JSONObject(client1.getNhanVien(MaTK1));
        JSONObject json1 = new JSONObject(client1.getVaiTro(json.getString("MaVT")));
        tenNV.setText(json.getString("Hovaten"));
        vaiTro.setText(json1.getString("TenVT"));
    }
    private void setBorder()
    {
        Border border = BorderFactory.createMatteBorder(0,0,0,1,Color.BLACK);
        Border border1 = BorderFactory.createMatteBorder(1,0,0,1,Color.BLACK);
        Border border2 = BorderFactory.createMatteBorder(1,0,1,1,Color.BLACK);
        panel1.setBorder(border);
        panel2.setBorder(border);
       jPanel4.setBorder(border);
        panel5.setBorder(border);
        panel6.setBorder(border);
       
        panel10.setBorder(border);
        panel11.setBorder(border1);
        panelTT.setBorder(border2);
    }
    
    private void panelTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelTTMouseClicked
        // TODO add your handling code here:
        panelTT.setBackground(customColor);
        panel11.setBackground(Color.WHITE);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);

        panel5.setBackground(Color.WHITE);
        panel6.setBackground(Color.WHITE);
        panel10.setBackground(Color.WHITE);
        panelThongTin tt = new panelThongTin(MaTK1,client1);
        panelChange.removeAll();
        panelChange.add(tt).setVisible(true);
    }//GEN-LAST:event_panelTTMouseClicked

    private void panel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel1MouseClicked
        // TODO add your handling code here:

        panel1.setBackground(customColor);
        panel2.setBackground(Color.WHITE);
        
        panel5.setBackground(Color.WHITE);
        panel6.setBackground(Color.WHITE);
      
        panel10.setBackground(Color.WHITE);
        panel11.setBackground(Color.WHITE);
        panelTT.setBackground(Color.WHITE);
        panelTrangChu  tt = new panelTrangChu();
        panelChange.removeAll();
        panelChange.add(tt).setVisible(true);
    }//GEN-LAST:event_panel1MouseClicked

    private void panel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel2MouseClicked
        // TODO add your handling code here:
        panel2.setBackground(customColor);
        panel1.setBackground(Color.WHITE);
        
        panel5.setBackground(Color.WHITE);
        panel6.setBackground(Color.WHITE);
        
        panel10.setBackground(Color.WHITE);
        panel11.setBackground(Color.WHITE);
        panelTT.setBackground(Color.WHITE);
        panelSanPham sp = new panelSanPham(client1);
        panelChange.removeAll();
        panelChange.add(sp).setVisible(true);
    }//GEN-LAST:event_panel2MouseClicked

    private void panel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel5MouseClicked
        // TODO add your handling code here:
        panel5.setBackground(customColor);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        
        panel6.setBackground(Color.WHITE);
        
        panel10.setBackground(Color.WHITE);
        panel11.setBackground(Color.WHITE);
        panelTT.setBackground(Color.WHITE);
        panelNhaXuatBan nxb = new panelNhaXuatBan(client1);
        panelChange.removeAll();
        panelChange.add(nxb).setVisible(true);
    }//GEN-LAST:event_panel5MouseClicked

    private void panel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel6MouseClicked
        // TODO add your handling code here:
        panel6.setBackground(customColor);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        
        panel5.setBackground(Color.WHITE);
        
        panel10.setBackground(Color.WHITE);
        panel11.setBackground(Color.WHITE);
        panelTT.setBackground(Color.WHITE);
        
        panelKho nk = new panelKho(client1, tenNV.getText());
        panelChange.removeAll();
        panelChange.add(nk).setVisible(true);
    }//GEN-LAST:event_panel6MouseClicked

    private void panel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel10MouseClicked
        // TODO add your handling code here:
        panel10.setBackground(customColor);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
       
        panel5.setBackground(Color.WHITE);
        panel6.setBackground(Color.WHITE);
      
        panel11.setBackground(Color.WHITE);
        panelTT.setBackground(Color.WHITE);
        panelThongKe tk = new panelThongKe(client1);
        panelChange.removeAll();
        panelChange.add(tk).setVisible(true);
    }//GEN-LAST:event_panel10MouseClicked

    private void panel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel11MouseClicked
        // TODO add your handling code here:
        panel11.setBackground(Color.RED);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        
        panel5.setBackground(Color.WHITE);
        panel6.setBackground(Color.WHITE);
        
        panel10.setBackground(Color.WHITE);
        panelTT.setBackground(Color.WHITE);
        
        this.setVisible(false);
        System.out.println("a");
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_panel11MouseClicked

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
            java.util.logging.Logger.getLogger(MainNhapKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainNhapKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainNhapKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainNhapKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FlatLightLaf.setup();
                new MainNhapKho(MaTK1,client1).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel10;
    private javax.swing.JPanel panel11;
    private javax.swing.JPanel panel2;
    private javax.swing.JPanel panel5;
    private javax.swing.JPanel panel6;
    private javax.swing.JPanel panelChange;
    private javax.swing.JPanel panelTT;
    private javax.swing.JLabel tenNV;
    private javax.swing.JLabel vaiTro;
    // End of variables declaration//GEN-END:variables
}
