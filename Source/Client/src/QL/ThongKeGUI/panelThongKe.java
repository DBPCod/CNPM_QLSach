/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package QL.ThongKeGUI;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author PC
 */
public class panelThongKe extends javax.swing.JInternalFrame {

    /**
     * Creates new form panelThongKe
     */
    public panelThongKe() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        setUp();
    }

    
    private void setUp()
    {
        tongquan.setBorder(null);
        doanhthu.setBorder(null);
        nhacungcap.setBorder(null);
        tonkho.setBorder(null);
        banchay.setBorder(null);
        tongQuanGUI tongquan = new tongQuanGUI();
        panelChinh.removeAll();
        panelChinh.add(tongquan).setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelChinh = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tongquan = new javax.swing.JButton();
        doanhthu = new javax.swing.JButton();
        nhacungcap = new javax.swing.JButton();
        tonkho = new javax.swing.JButton();
        banchay = new javax.swing.JButton();

        panelChinh.setBackground(new java.awt.Color(255, 255, 255));
        panelChinh.setPreferredSize(new java.awt.Dimension(340, 340));

        javax.swing.GroupLayout panelChinhLayout = new javax.swing.GroupLayout(panelChinh);
        panelChinh.setLayout(panelChinhLayout);
        panelChinhLayout.setHorizontalGroup(
            panelChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        panelChinhLayout.setVerticalGroup(
            panelChinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tongquan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tongquan.setText("Tổng quan");
        tongquan.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        doanhthu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        doanhthu.setText("Doanh thu");
        doanhthu.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        nhacungcap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nhacungcap.setText("Nhà cung cấp");
        nhacungcap.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tonkho.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tonkho.setText("Tồn kho");
        tonkho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        banchay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        banchay.setText("Bán chạy");
        banchay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tongquan, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(doanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tonkho, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(banchay, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tongquan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doanhthu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tonkho, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(banchay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelChinh, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(panelChinh, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton banchay;
    private javax.swing.JButton doanhthu;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton nhacungcap;
    private javax.swing.JPanel panelChinh;
    private javax.swing.JButton tongquan;
    private javax.swing.JButton tonkho;
    // End of variables declaration//GEN-END:variables
}
