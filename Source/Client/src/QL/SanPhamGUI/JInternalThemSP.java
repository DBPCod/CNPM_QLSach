/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package QL.SanPhamGUI;

import Client.Client;
import DTO.SanPhamDTO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class JInternalThemSP extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalThemSP
     */
    private static panelSanPham pnsp1;
    //byte[] dung de luu anh
    byte[] imageInByteArray1=null;
    private Client client1;
    private themSanPham tsp1;
    private String MaTL1="";
    private String TenTL1="";
    private doiTuongGUI dt1;
    public JInternalThemSP(themSanPham tsp,Client client, String MaTL, String TenTL, doiTuongGUI dt,panelSanPham pnsp) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        client1=client;
        tsp1=tsp;
        MaTL1=MaTL;
        TenTL1=TenTL;
        dt1=dt;
        pnsp1=pnsp;
        setButDanh();
        setUpTL();
        setMaSP();
        System.out.println("a");
    }
    private void setUpTL() {
    if (dt1.list.size() != 0) {
        DefaultTableModel model = (DefaultTableModel) jTableTheLoai.getModel();
        model.setRowCount(0);
        ArrayList<Object[]> newList = new ArrayList<>();

        // Sử dụng HashSet để theo dõi các giá trị đã thấy
        HashSet<String> seenValues = new HashSet<>();

        // Giả sử dt1.list chứa các đối tượng mảng mà bạn muốn kiểm tra
        for (int i = 0; i < dt1.list.size(); i++) {
            String chuoi = (String) dt1.list.get(i)[0]; // Lấy giá trị từ cột đầu tiên của mỗi đối tượng
            if (!seenValues.contains(chuoi)) { // Kiểm tra xem giá trị đã được thêm chưa
                seenValues.add(chuoi); // Thêm vào HashSet
                newList.add(new Object[]{chuoi}); // Thêm vào newList nếu chưa có
            }
        }
        
        // Thêm các giá trị duy nhất vào model
        if(newList.size()!=0)
        {
            for (Object[] x : newList) {
                if(!x[0].equals(""))
                {
                    model.addRow(x);
                }
                
            }
        }
        setUpAll();
    }
}

    //ham thiet lap maSP
    private void setMaSP()
    {
     
        JSONObject json = new JSONObject(client1.getList("ListSanPham"));
        JSONArray jsonArray = json.getJSONArray("list");
        int max=0;
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject tacGiaObject = jsonArray.getJSONObject(i);
              String chuoi = tacGiaObject.getString("maSP");
              System.out.println(chuoi+"â");
            if(Integer.parseInt(chuoi.substring(3)) > max)
            {
                max = Integer.parseInt(chuoi.substring(3));
            }
            
        }
        txtTMaSP.setText("SP_"+ String.valueOf(max+1));
    }
    
    
    //ham thiet lap but danh cua tac gia
    private void setButDanh()
    {
        JSONObject json = new JSONObject(client1.getList("ListTacGia"));
        JSONArray jsonArray = json.getJSONArray("list");
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject tacGiaObject = jsonArray.getJSONObject(i);
            String chuoi = tacGiaObject.getString("butDanh");
            comboboxTG.addItem(chuoi);
        }
    }
    //ham thiet lap cho giao dien
    private void setUpAll()
    {
        txtTSP1.setText(dt1.getTenSP());
        comboboxTG.setSelectedIndex(dt1.getTenTG());
        txtGN.setText(String.valueOf(dt1.getGiaNhap()));
        txtGB.setText(String.valueOf(dt1.getGiaBia()));
        txtNN.setText(dt1.getNgonNgu());
        spinnerST.setValue(dt1.getSoTrang());
        try {
            if(dt1.getAnhBia()==null)
            {
                
            }else
            {
                InputStream is = new ByteArrayInputStream(dt1.getAnhBia());
                BufferedImage bi1 = ImageIO.read(is);          
                //hien thi anh len giao dien
                Image img = bi1.getScaledInstance(185,238,Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                lb_img.setIcon(icon);
            }
        } catch (IOException ex) {
            Logger.getLogger(JInternalThemSP.class.getName()).log(Level.SEVERE, null, ex);
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

        jToggleButton1 = new javax.swing.JToggleButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTMaSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelIMG = new javax.swing.JPanel();
        lb_img = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        txtGB = new javax.swing.JTextField();
        txtNN = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        comboboxTG = new javax.swing.JComboBox<>();
        spinnerST = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTheLoai = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtGN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTSP1 = new javax.swing.JTextField();

        jToggleButton1.setText("jToggleButton1");

        jCheckBox1.setText("jCheckBox1");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Mã sản phẩm");

        txtTMaSP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTMaSP.setEnabled(false);

        jLabel3.setText("Bút danh");

        jLabel6.setText("Số trang");

        jLabel8.setText("Giá bìa");

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

        panelIMG.setBackground(new java.awt.Color(204, 204, 204));
        panelIMG.setPreferredSize(new java.awt.Dimension(185, 200));

        javax.swing.GroupLayout panelIMGLayout = new javax.swing.GroupLayout(panelIMG);
        panelIMG.setLayout(panelIMGLayout);
        panelIMGLayout.setHorizontalGroup(
            panelIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_img, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
        );
        panelIMGLayout.setVerticalGroup(
            panelIMGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jButton2.setBackground(new java.awt.Color(102, 255, 102));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton2.setText("Chọn ảnh bìa");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtGB.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNN.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("Ngôn ngữ");

        jButton3.setBackground(new java.awt.Color(255, 12, 12));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton3.setText("Hủy");
        jButton3.setBorder(null);
        jButton3.setMaximumSize(new java.awt.Dimension(43, 22));
        jButton3.setMinimumSize(new java.awt.Dimension(43, 22));
        jButton3.setOpaque(true);
        jButton3.setPreferredSize(new java.awt.Dimension(43, 22));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTableTheLoai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Thể loại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableTheLoai.setPreferredSize(new java.awt.Dimension(75, 75));
        jScrollPane1.setViewportView(jTableTheLoai);

        jButton4.setBackground(new java.awt.Color(102, 255, 102));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton4.setText("Chọn thể loại");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
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

        jLabel10.setText("Giá nhập");

        txtGN.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Tên sản phẩm");

        txtTSP1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(panelIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(txtGN, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8)
                                            .addComponent(txtGB, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(spinnerST))
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(comboboxTG, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTMaSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTSP1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNN, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                            .addComponent(jLabel9))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel10)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtGB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtGN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                                                .addComponent(comboboxTG, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                                .addComponent(spinnerST, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(panelIMG, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(159, 159, 159))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
            //ham chon the loai cho san pham
           String tenSP = txtTSP1.getText();
           int tenTG = comboboxTG.getSelectedIndex();
           String giaNhap = txtGN.getText();
           String giaBia = txtGB.getText();
           int soTrang = (Integer) spinnerST.getValue();
           String ngonNgu = txtNN.getText();
           //kiem tra xem gia nhap hoac gia bia co bang chuoi rong khong
           if(giaNhap.equals(""))
           {
               giaNhap="0";
           }
           if(giaBia.equals(""))
           {
               giaBia="0";
           }
            
           DefaultTableModel table = (DefaultTableModel) jTableTheLoai.getModel();
           
           ArrayList<Object[]> list = new ArrayList<Object[]>();
           
           for (int row = 0; row < table.getRowCount(); row++) {
                String tenTL = String.valueOf(table.getValueAt(row, 0));
                list.add(new Object[]{tenTL});
            }
           //tao doi tuong de truyen du lieu
           //de xet lai gia tri
           if(imageInByteArray1==null)
           {
               imageInByteArray1=dt1.getAnhBia();
           }
           doiTuongGUI dt = new doiTuongGUI(tenSP, soTrang, ngonNgu, Double.parseDouble(giaBia),imageInByteArray1, Double.parseDouble(giaNhap),  tenTG, list);
           chonTheLoai ctl = new chonTheLoai(tsp1,client1,dt,pnsp1);
           tsp1.mainTSP.removeAll();
           tsp1.mainTSP.add(ctl).setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

        //chon anh cua san pham
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String path = f.getAbsolutePath();
        BufferedImage bi;
        try {
            bi = ImageIO.read(new File(path));
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi,"jpg",baos);
            //chuyen sang byte de chuyen du lieu len database
            byte[] imageInByteArray = baos.toByteArray();
            imageInByteArray1=imageInByteArray;
            InputStream is = new ByteArrayInputStream(imageInByteArray);
            BufferedImage bi1 = ImageIO.read(is);          
            //hien thi anh len giao dien
            Image img = bi1.getScaledInstance(185,238,Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lb_img.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(JInternalThemSP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2MouseClicked

    
    //ham xu li lay ma tac gia
    private String getMaTG(String butDanh)
    {
        JSONObject json = new JSONObject(client1.getList("ListTacGia"));
        JSONArray jsonArray = json.getJSONArray("list");
        for(int i=0;i<jsonArray.length();i++)
        {
            JSONObject tacGiaObject = jsonArray.getJSONObject(i);
            String chuoi = tacGiaObject.getString("butDanh");
            if(butDanh.equals(chuoi))
            {
                return tacGiaObject.getString("maTG");
            }
        }
        return "";
    }
    
    private boolean checkDL(String maSP,String tenSP,int tenTG,String giaNhap,String giaBia,int soTrang,String ngonNgu,byte[] anhbia)
    {
        if(giaNhap.equals(""))
        {
            return false;
        }
        if(giaBia.equals(""))
        {
            return false;
        }
        return true;
    }
    
    //gui du lieu toi server
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        //lay du lieu de them moi 1 san pham
        String maSP = txtTMaSP.getText();
        String tenSP = txtTSP1.getText();
        int tenTG = comboboxTG.getSelectedIndex();
        String giaNhap = txtGN.getText();
        String giaBia = txtGB.getText();
        int soTrang = (Integer) spinnerST.getValue();
        String ngonNgu = txtNN.getText();
        byte[] anhbia;
        //neu anh ma null la do chua chon nut chon the loai
        if(dt1.getAnhBia()==null)
        {
            anhbia = imageInByteArray1;
        }
        else
        {
            anhbia = dt1.getAnhBia();
        }
        
        if(checkDL( maSP, tenSP, tenTG, giaNhap, giaBia, soTrang, ngonNgu, anhbia))
        {
            SanPhamDTO sp = new SanPhamDTO( maSP, tenSP, soTrang, ngonNgu, Double.parseDouble(giaBia), anhbia, 0, Double.parseDouble(giaNhap),getMaTG(comboboxTG.getItemAt(tenTG)), 1);
            JSONObject json = new JSONObject();
            json.put("method","PUTSP");
            json.put("MaSP", sp.getMaSP());
            json.put("TenSP",sp.getTenSP());
            json.put("SoTrang",sp.getSoTrang());
            json.put("NgonNgu",sp.getNgonNgu());
            json.put("GiaBia",sp.getGiaBia());
  
            if(sp.getAnhBia()!=null)
            {
                String anhBiaBase64 = Base64.getEncoder().encodeToString(sp.getAnhBia());
                json.put("AnhBia",anhBiaBase64);
                json.put("SoLuong",sp.getSoLuong());
                json.put("GiaNhap",sp.getGiaNhap());
                json.put("MaTG",sp.getMaTG());
                json.put("Trangthai",sp.getTrangThai());
                if(client1.themDT(json.toString()).equals("thanhcong"))
                {
                    //ham de them the loai san pham
                    setTL();
                    JOptionPane.showMessageDialog(null, "Thêm thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    tsp1.setVisible(false);
                    pnsp1.setUp();
                }
            }
            else
            {
                System.out.println("chua co");
            }
             
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Kiểm tra lại thông tin!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
//        setTL();
    }//GEN-LAST:event_jButton3MouseClicked

    //ham de them the loai cua san pham
    private void setTL()
    {
        String maSP = txtTMaSP.getText();
        DefaultTableModel table = (DefaultTableModel) jTableTheLoai.getModel();
        int row = table.getRowCount();
        int col = table.getColumnCount();
        JSONObject json = new JSONObject();
        json.put("method","PUTTLSP");
        json.put("MaSP",maSP);
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                Object value = table.getValueAt(i, j);
                json.put("MaTL", value);
                // gui yeu cau toi server
                client1.themDT(json.toString());
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboboxTG;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTheLoai;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lb_img;
    private javax.swing.JPanel panelIMG;
    private javax.swing.JSpinner spinnerST;
    private javax.swing.JTextField txtGB;
    private javax.swing.JTextField txtGN;
    private javax.swing.JTextField txtNN;
    private javax.swing.JTextField txtTMaSP;
    private javax.swing.JTextField txtTSP1;
    // End of variables declaration//GEN-END:variables
}
