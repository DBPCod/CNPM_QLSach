/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package QL.SanPhamGUI;

import Client.Client;
import DTO.TheLoaiDTO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class JInternalSuaSP extends javax.swing.JInternalFrame {

    /**
     * Creates new form JInternalSuaSP
     */
    private static panelSanPham pnsp1;
    //byte[] dung de luu anh
    private String maDT="0";
    byte[] imageInByteArray1=null;
    private Client client1;
    private suaSanPham ssp1;
    private String MaTL1="";
    private String TenTL1="";
    private doiTuongGUI1 dt1;
    private static String MaDT1;
    public JInternalSuaSP(suaSanPham ssp,Client client, String MaTL, String TenTL, doiTuongGUI1 dt,panelSanPham pnsp,String MaDT) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        client1=client;
        MaDT1 = MaDT;
        dt1=dt;
        ssp1=ssp;
        pnsp1=pnsp;
        if(dt1.getList().size()==0)
        {
            setUp();
        }
        else
        {
            txtTMaSP.setText(MaDT1);
            txtTSP1.setText(dt1.getTenSP());
            txtGN.setText(String.valueOf(dt1.getGiaNhap()));
            txtGB.setText(String.valueOf(dt1.getGiaBia()));
            spinnerST.setValue(dt1.getSoTrang());
            txtNN.setText(dt1.getNgonNgu());
            txtTG.setText(dt1.getTenTG());
            byte[] imageInByteArray = dt1.getAnhBia();
            imageInByteArray1=imageInByteArray;
            InputStream is = new ByteArrayInputStream(imageInByteArray);
            BufferedImage bi1;          
            try {
                bi1 = ImageIO.read(is);
                Image img = bi1.getScaledInstance(185,238,Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                lb_img.setIcon(icon);
            } catch (IOException ex) {
                Logger.getLogger(JInternalSuaSP.class.getName()).log(Level.SEVERE, null, ex);
            }
            //hien thi anh len giao dien
            
            setUpTL();
        }
//        setUp();
//        setUpTL();
    }
    
    //ham thiet lap the loai cua san pham
    private void setUpTL() {
    if (dt1.list.size() != 0) {
        DefaultTableModel model = (DefaultTableModel) jTableTheLoai.getModel();
        model.setRowCount(0);
        ArrayList<Object[]> newList = new ArrayList<>();

        // Sử dụng HashSet để theo dõi các giá trị đã thấy
        HashSet<String> seenValues = new HashSet<>();

        // Giả sử dt1.list chứa các đối tượng mảng mà bạn muốn kiểm tra
        for (int i = 0; i < dt1.list.size(); i++) {
            System.out.println((String) dt1.list.get(i)[0]);
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
                    for(TheLoaiDTO x1 : getListTL("ListTheLoai"))
                    {
                        if(x1.getMaTL().equals(String.valueOf(x[0])))
                        {
                            model.addRow(new Object[]{x1.getTenTL()});
                        }
                    }
                    
                }
                
            }
        }
        
    }
    else
    {
        DefaultTableModel model = (DefaultTableModel) jTableTheLoai.getModel();
        model.setRowCount(0);
    }
}

    // ham lay danh sach
    private ArrayList<TheLoaiDTO> getListTL(String yeucau) 
    {
        JSONObject json;
        
        switch (yeucau) 
        {
            case "ListTheLoai":
                ArrayList<TheLoaiDTO> list = new ArrayList<>();
                json = new JSONObject(client1.getList(yeucau));
                
                // chuyen mang chuoi sang mang jsonArray
                JSONArray jsonArray = json.getJSONArray("list");
                for (int i = 0; i < jsonArray.length(); i++) 
                {
                    JSONObject tlObject = jsonArray.getJSONObject(i);
                    String MaTL = tlObject.getString("maTL");
                    String TenTL = tlObject.getString("tenTL");
                    int Trangthai = tlObject.getInt("trangThai");
                    // them vao arraylist
                    // xem lai trang thai
                    list.add(new TheLoaiDTO(MaTL, TenTL, Trangthai));
                    
                }
                return list;
        }
                
        return new ArrayList<>();
    }
    
   private void setUp()
    {
        String data = client1.getDoiTuong("SanPham",MaDT1);
        String data1 = client1.getDoiTuong("AnhBia",MaDT1);
        client1.xuLiGetSachTheLoai("SachTheLoai", MaDT1);
        JSONObject json = new JSONObject(data);
        JSONObject json1 = new JSONObject(data1);

        try {
            byte[] imageBytes = Base64.getDecoder().decode(json1.getString("anhbia"));
            imageInByteArray1 = imageBytes;
            InputStream is = new ByteArrayInputStream(imageBytes);
            BufferedImage bi1;
            bi1 = ImageIO.read(is);
            if(bi1!=null)
            {
                Image img = bi1.getScaledInstance(185,238,Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(img);
                lb_img.setIcon(icon);
            }
            
        } catch (IOException ex) {
            System.out.println("loi");
            Logger.getLogger(thongTinSanPhamQL.class.getName()).log(Level.SEVERE, null, ex);
        }
            //hien thi anh len giao dien
            
          txtTMaSP.setText(json.getString("MaSP"));
          txtTSP1.setText(json.getString("TenSP"));
          txtGN.setText(String.valueOf(json.getDouble("GiaNhap")));
          txtGB.setText(String.valueOf(json.getDouble("GiaBia")));
          spinnerST.setValue(json.getInt("SoTrang"));
          txtNN.setText(json.getString("NgonNgu"));
          String data2 = client1.getDoiTuong("TacGia", json.getString("MaTG"));
          JSONObject json3 = new JSONObject(data2);
          System.out.println(data2+" a");
          txtTG.setText(json3.getString("Hovaten"));
          setSTL(); 
    }

    private void setSTL()
    {
        JSONObject json;
        ArrayList<TheLoaiDTO> list = new ArrayList<TheLoaiDTO>();
        json = new JSONObject(client1.xuLiGetSachTheLoai("SachTheLoai", MaDT1));
        //chuyen mang chuoi sang mang jsonArray
        JSONArray jsonArray = new JSONArray(json.getString("ketqua"));
        for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                String MaTL = tacGiaObject.getString("maTL");
                list.add(new TheLoaiDTO(MaTL,"",1));
                dt1.list.add(new Object[]{MaTL});
             }
        
        DefaultTableModel table = (DefaultTableModel) jTableTheLoai.getModel();
        for(TheLoaiDTO tl: list)
        {
            table.addRow(new Object[]{getTenTL(tl.getMaTL())});
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

        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTMaSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelIMG = new javax.swing.JPanel();
        lb_img = new javax.swing.JLabel();
        txtGB = new javax.swing.JTextField();
        txtNN = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        spinnerST = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        txtGN = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTSP1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtTG = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableTheLoai = new javax.swing.JTable();

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Mã sản phẩm");

        txtTMaSP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTMaSP.setEnabled(false);

        jLabel3.setText("Tác giả");

        jLabel6.setText("Số trang");

        jLabel8.setText("Giá bìa");

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

        txtGB.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtNN.setEnabled(false);

        jLabel9.setText("Ngôn ngữ");

        spinnerST.setEnabled(false);

        jLabel10.setText("Giá nhập");

        txtGN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtGN.setEnabled(false);

        jLabel5.setText("Tên sản phẩm");

        txtTSP1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTSP1.setEnabled(false);

        jButton1.setBackground(new java.awt.Color(102, 255, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton1.setText("Sửa");
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

        jLabel11.setText("Số lượng");

        txtSL.setText("0");
        txtSL.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtSL.setEnabled(false);

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

        txtTG.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTG.setEnabled(false);

        jButton5.setBackground(new java.awt.Color(255, 12, 12));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton5.setText("Hủy thể loại");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
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
        jTableTheLoai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTheLoaijTableTheLoaiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableTheLoai);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelIMG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtTG, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(txtTSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(spinnerST, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(txtGN, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel8)
                                    .addComponent(txtGB, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNN, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(jLabel9)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(86, 86, 86))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTSP1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(spinnerST, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txtTG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addGap(22, 22, 22)
                                                        .addComponent(txtGB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtGN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel4Layout.createSequentialGroup()
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                                .addGap(0, 34, Short.MAX_VALUE))
                            .addComponent(panelIMG, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(156, 156, 156))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel11)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 973, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 453, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

          //ham chon the loai cho san pham
           String tenSP = txtTSP1.getText();
           String tenTG = txtTG.getText();
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
                for(TheLoaiDTO x : getListTL("ListTheLoai"))
                {
                    if(x.getTenTL().equals(tenTL))
                    {
                        list.add(new Object[]{x.getMaTL()});
                    }
                }
                
            }
           //tao doi tuong de truyen du lieu
           //de xet lai gia tri
           if(imageInByteArray1==null)
           {
               imageInByteArray1=dt1.getAnhBia();
           }
           doiTuongGUI1 dt = new doiTuongGUI1(tenSP, soTrang, ngonNgu, Double.parseDouble(giaBia),imageInByteArray1, Double.parseDouble(giaNhap),  tenTG, list);
           
           chonTheLoai1 ctl = new chonTheLoai1(ssp1,client1,dt,pnsp1,MaDT1);
           ssp1.mainSSP.removeAll();
           ssp1.mainSSP.add(ctl).setVisible(true);
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        ssp1.setVisible(false);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // nhan gui du lieu vua sua toi server
        String maSP = txtTMaSP.getText();
        String giaBia = txtGB.getText();
        String giaNhap = txtGN.getText();
        
        // Kiểm tra giá bìa
        if (giaBia.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Giá bìa không được để trống!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (!giaBia.matches("^\\d+(\\.\\d{1,2})?$")) {
            JOptionPane.showMessageDialog(null, "Giá bìa phải là số dương và có thể có tối đa 2 chữ số sau dấu thập phân!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double giaNhapDouble = Double.parseDouble(giaNhap);
        if (giaNhapDouble <= 0) {
            JOptionPane.showMessageDialog(null, "Giá nhập phải lớn hơn 0!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double giaBiaDouble = Double.parseDouble(giaBia);
        if (giaBiaDouble <= giaNhapDouble) {
            JOptionPane.showMessageDialog(null, "Giá bìa phải lớn hơn giá nhập!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        DefaultTableModel table = (DefaultTableModel) jTableTheLoai.getModel();
        int row = table.getRowCount();
        int col = table.getColumnCount();
        ArrayList<TheLoaiDTO> list= new ArrayList<TheLoaiDTO>();
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                String maTL = (String)table.getValueAt(i,j);
                list.add(new TheLoaiDTO(getMaTL(maTL),"",1));
            }
        }
        
        if (jTableTheLoai.getRowCount() == 0) {
        JOptionPane.showMessageDialog(null, "Vui lòng chọn ít nhất một thể loại cho sản phẩm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        return;
        }   
        JSONObject json = new JSONObject();
        json.put("method","UPDATESP");
        json.put("MaSP",maSP);
        json.put("GiaBia",giaBia);
        JSONArray jsonArray = new JSONArray(list);
        String jsonString = jsonArray.toString();
        json.put("list",jsonString);
       
        JSONObject json1 = new JSONObject(client1.suaDT(json.toString()));
        if(json1.getString("ketqua").equals("true"))
        {
            JOptionPane.showMessageDialog(null, "Sửa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            pnsp1.setUp();
            ssp1.setVisible(false);
            this.setVisible(false);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Sửa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private String getMaTL(String tenTL)
    {
        for(TheLoaiDTO x : getListTL("ListTheLoai"))
        {
            if(x.getTenTL().equals(tenTL))
            {
                return x.getMaTL();
            }
        }
        return "";
    }
    
    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:

        if(!maDT.equals("0"))
        {
            Iterator<Object[]> iterator = dt1.list.iterator();
            while (iterator.hasNext()) {
                
                Object[] x = iterator.next();
                if (String.valueOf(x[0]).equals(getMaTL(maDT))) {
                    System.out.println(String.valueOf(x[0])+"conlai");
                    iterator.remove(); // Sử dụng iterator để xóa
                }
            }
            
            System.out.println(dt1.list.size()+"soluong");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

        setUpTL();
    }//GEN-LAST:event_jButton5MouseClicked

    
    private String getTenTL(String maTL)
    {
        for(TheLoaiDTO x : getListTL("ListTheLoai"))
        {
            if(x.getMaTL().equals(maTL))
            {
                return x.getTenTL();
            }
        }
        return "";
    }
    
    
    private void jTableTheLoaijTableTheLoaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTheLoaijTableTheLoaiMouseClicked
        // TODO add your handling code here:
        DefaultTableModel table = (DefaultTableModel) jTableTheLoai.getModel();
        int index = jTableTheLoai.getSelectedRow();
        String value = table.getValueAt(index, 0).toString();
        maDT=value;
    }//GEN-LAST:event_jTableTheLoaijTableTheLoaiMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableTheLoai;
    private javax.swing.JLabel lb_img;
    private javax.swing.JPanel panelIMG;
    private javax.swing.JSpinner spinnerST;
    private javax.swing.JTextField txtGB;
    private javax.swing.JTextField txtGN;
    private javax.swing.JTextField txtNN;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTG;
    private javax.swing.JTextField txtTMaSP;
    private javax.swing.JTextField txtTSP1;
    // End of variables declaration//GEN-END:variables
}
