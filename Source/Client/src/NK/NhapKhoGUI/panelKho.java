/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package NK.NhapKhoGUI;

import QL.NhapKhoGUI.*;
import Client.Client;
import DTO.NhaXuatBanDTO;
import DTO.PhieuNhapDTO;
import com.formdev.flatlaf.FlatLightLaf;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class panelKho extends javax.swing.JInternalFrame {

    /**
     * Creates new form panelKho
     */
    private String MaDT = "0";
    private static Client client1;
    private String nguoiNhap1;
    
    private String locTenNXB = null; 
    private Date locNgayBatDau = null;   
    private Date locNgayKetThuc = null;  
    private Double locSoTienBatDau = null; 
    private Double locSoTienKetThuc = null;
    
    public panelKho(Client client,String nguoiNhap) {
        
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        client1=client;
        nguoiNhap1=nguoiNhap;
        setUp();
        setUpComboBoxNXB();
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
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePN = new javax.swing.JTable();
        locNXB = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        locNBD = new com.toedter.calendar.JDateChooser();
        locNKT = new com.toedter.calendar.JDateChooser();
        nutLoc = new javax.swing.JButton();
        locTienBD = new javax.swing.JTextField();
        locTienKT = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconCT.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Chi tiết");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconRac.jpg"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Danh sách xóa");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Làm mới");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(328, 328, 328)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTablePN.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTablePN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TG01", "ádsad", "ádasd", "ád"},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Ngày nhập", "Thành tiền", "Tên nhà xuất bản"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablePN.setFocusable(false);
        jTablePN.setGridColor(new java.awt.Color(0, 0, 0));
        jTablePN.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTablePN.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTablePN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePNMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePN);

        locNXB.setPreferredSize(new java.awt.Dimension(72, 40));
        locNXB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locNXBActionPerformed(evt);
            }
        });

        jLabel12.setText("Nhà xuất bản");

        jLabel13.setText("Từ ngày");

        jLabel14.setText("Đến ngày");

        jLabel15.setText("Từ số tiền");

        jLabel16.setText("Đến số tiền");

        locNBD.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                locNBDPropertyChange(evt);
            }
        });

        locNKT.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                locNKTPropertyChange(evt);
            }
        });

        nutLoc.setText("Lọc");
        nutLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutLocActionPerformed(evt);
            }
        });

        locTienBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locTienBDActionPerformed(evt);
            }
        });

        locTienKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locTienKTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(nutLoc))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(locTienKT, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(locTienBD, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(jLabel14)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(locNXB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(locNBD, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(locNKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locNXB, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locNBD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locNKT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locTienBD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locTienKT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nutLoc)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
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

    //ham lay danh sach
    private ArrayList<PhieuNhapDTO> getList(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListPhieuNhap": 
                    ArrayList<PhieuNhapDTO> list = new ArrayList<PhieuNhapDTO>();
                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                        String MaPN = tacGiaObject.getString("maPN");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date NgayNhap;
                        try {
                            NgayNhap = formatter.parse((tacGiaObject.getString("ngayNhap")).toString() );
                            Double Thanhtien = tacGiaObject.getDouble("thanhTien");
                            int Trangthai = tacGiaObject.getInt("trangThai");
                            String MaTK = tacGiaObject.getString("maTK");
                            String MaNXB=tacGiaObject.getString("maNXB");;
                            for(NhaXuatBanDTO nxb : getListNXB("ListNhaXuatBan"))
                            {
                                if(MaNXB.equals(nxb.getMaNXB()))
                                {
                                    list.add(new PhieuNhapDTO(MaPN, NgayNhap, Thanhtien, Trangthai, MaTK, nxb.getTenNXB()));
                                }
                            }
                            
                        } catch (ParseException ex) {
                            Logger.getLogger(panelKho.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    // Thêm vào ArrayList
                    //xem lai trang thai
                        
                    // Thêm vào ArrayList
                    //xem lai trang thai
                   
        }
                    
                    return list;
                   
        }
                
                    
        return new ArrayList<>();
    }
    //ham thiet lap bang danh sach
    public void setUp()
    {
        
        DefaultTableModel model = (DefaultTableModel) jTablePN.getModel();
        model.setRowCount(0);
        for(PhieuNhapDTO phieunhap : getList("ListPhieuNhap"))
        {
            //them tung doi tuong vao bang
            if(phieunhap.getTrangThai()==1)
            {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngayNhap = formatter.format(phieunhap.getNgayNhap());
                model.addRow(new Object[] {phieunhap.getMaPN(),ngayNhap,phieunhap.getThanhTien(),phieunhap.getMaNXB()});
            }
        }
    }
    
    //ham thiet lap bang danh sach
    public void setUpDelete()
    {
        
        DefaultTableModel model = (DefaultTableModel) jTablePN.getModel();
        model.setRowCount(0);
        for(PhieuNhapDTO phieunhap : getList("ListPhieuNhap"))
        {
            //them tung doi tuong vao bang
            if(phieunhap.getTrangThai()==0)
            {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngayNhap = formatter.format(phieunhap.getNgayNhap());
                System.out.println(phieunhap.getMaPN());
                model.addRow(new Object[] {phieunhap.getMaPN(),ngayNhap,phieunhap.getThanhTien(),phieunhap.getMaNXB()});
            }
        }
    }
    
    // ham lay danh sach
    private ArrayList<NhaXuatBanDTO> getListNXB(String yeucau) 
    {
        JSONObject json;
        
        switch (yeucau) 
        {
            case "ListNhaXuatBan":
                ArrayList<NhaXuatBanDTO> list = new ArrayList<>();
                json = new JSONObject(client1.getList(yeucau));
                
                // chuyen mang chuoi sang mang jsonArray
                JSONArray jsonArray = json.getJSONArray("list");
                for (int i = 0; i < jsonArray.length(); i++) 
                {
                    JSONObject nxbObject = jsonArray.getJSONObject(i);
                    String MaNXB = nxbObject.getString("maNXB");
                    String TenNXB = nxbObject.getString("tenNXB");
                    String DiaChi = nxbObject.getString("diaChi");
                    String SoDienThoai = nxbObject.getString("soDienThoai");
                    String Email = nxbObject.getString("email");
                    int Trangthai = nxbObject.getInt("trangThai");
                    // them vao arraylist
                    // xem lai trang thai
                    list.add(new NhaXuatBanDTO(MaNXB, TenNXB, DiaChi, SoDienThoai, Email, Trangthai));
                }
                return list;
        }
                
        return new ArrayList<>();
    }
    
    private void setUpComboBoxNXB() 
    {
        locNXB.removeAllItems(); // Xóa các item cũ
        locNXB.addItem("Tất cả"); // Thêm tùy chọn mặc định
        for (NhaXuatBanDTO nxb : getListNXB("ListNhaXuatBan")) {
            locNXB.addItem(nxb.getTenNXB());
        }
    }
    
    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        themPhieuNhap tpn = new themPhieuNhap(client1,nguoiNhap1,this);
        tpn.setDefaultCloseOperation(tpn.DISPOSE_ON_CLOSE);
        tpn.setVisible(true);
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
        // TODO add your handling code here:
        
        if (MaDT.equals("0")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            thongTinPhieuNhap ttpn = new thongTinPhieuNhap(MaDT,client1);
            ttpn.setDefaultCloseOperation(ttpn.DISPOSE_ON_CLOSE);
            ttpn.setVisible(true);
        }

    }//GEN-LAST:event_jPanel11MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        // hien thi danh sach phieu nhap da xoa
        
        setUpDelete();
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jTablePNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePNMouseClicked
        // TODO add your handling code here:
         DefaultTableModel table = (DefaultTableModel) jTablePN.getModel();
        int index = jTablePN.getSelectedRow();
        String value = table.getValueAt(index, 0).toString();
        MaDT=value;
    }//GEN-LAST:event_jTablePNMouseClicked

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        // TODO add your handling code here:
        
        if(MaDT.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        JSONObject json = new JSONObject();
        json.put("method","DELETEPN");
        json.put("MaPN", MaDT);
        JSONObject json1 = new JSONObject(client1.xoaDT(json.toString()));
        if(json1.getString("ketqua").equals("true"))
        {
            getCTPN();
            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            setUp();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jPanel10MouseClicked

    private void getCTPN()
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        JSONObject json = new JSONObject(client1.getDoiTuong("CTPhieuNhap", MaDT));
        JSONArray jsonArray = json.getJSONArray("list");
        for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                        String MaPN = tacGiaObject.getString("maPN");
                        String MaSP = tacGiaObject.getString("maSP");
                        int soLuong = tacGiaObject.getInt("soLuongNhap");
                        list.add(new Object[]{MaPN,MaSP,String.valueOf(soLuong)});
        }
        
        JSONArray jsonArray1 = new JSONArray(list);
        JSONObject json2 = new JSONObject();
        json2.put("method","UPDATEHuySLSP");
        json2.put("theloai","phieunhap");
        json2.put("list",jsonArray.toString());
        
        client1.suaDT(json2.toString());
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        setUp();
    }//GEN-LAST:event_jButton1MouseClicked

    private void nutLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutLocActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTablePN.getModel();
        model.setRowCount(0);

        String tenNXB = locNXB.getSelectedItem().toString();
        Date ngayBatDau = locNBD.getDate();
        Date ngayKetThuc = locNKT.getDate();
        Double soTienBatDau = null;
        Double soTienKetThuc = null;

        // Lấy giá trị lọc số tiền
        try {
            if (!locTienBD.getText().trim().isEmpty()) {
                soTienBatDau = Double.parseDouble(locTienBD.getText().trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số tiền bắt đầu không hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            locTienBD.setText(""); // Xóa giá trị không hợp lệ
        }

        try {
            if (!locTienKT.getText().trim().isEmpty()) {
                soTienKetThuc = Double.parseDouble(locTienKT.getText().trim());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số tiền kết thúc không hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            locTienKT.setText(""); // Xóa giá trị không hợp lệ
        }

        // Lọc danh sách hóa đơn
        for (PhieuNhapDTO pn : getList("ListPhieuNhap")) {
            if (pn.getTrangThai() == 1) { // Chỉ lọc hóa đơn có trạng thái hợp lệ

                boolean tenNXBThoaMan = tenNXB.equals("Tất cả") || pn.getMaNXB().equals(tenNXB);
                boolean ngayThoaMan = (ngayBatDau == null || ngayKetThuc == null ||
                                       (!pn.getNgayNhap().before(ngayBatDau) && !pn.getNgayNhap().after(ngayKetThuc)));
                boolean tienThoaMan = (soTienBatDau == null || pn.getThanhTien() >= soTienBatDau) &&
                                      (soTienKetThuc == null || pn.getThanhTien() <= soTienKetThuc);

                // Chỉ thêm vào bảng nếu tất cả các điều kiện đều thỏa mãn
                if (tenNXBThoaMan && ngayThoaMan && tienThoaMan) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String ngayLapHD = formatter.format(pn.getNgayNhap());
                    model.addRow(new Object[]{pn.getMaPN(), ngayLapHD, pn.getThanhTien(), pn.getMaNXB()});
                }
            }
        }

        // Xóa các trường nhập sau khi lọc
        locNXB.setSelectedIndex(0); // Đặt lại về "Tất cả"
        locNBD.setDate(null);
        locNKT.setDate(null);
        locTienBD.setText("");
        locTienKT.setText("");

        // Hiển thị thông báo nếu không có kết quả nào
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_nutLocActionPerformed

    private void locNXBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locNXBActionPerformed
        // Lấy tên nxb được chọn và lưu vào biến
        locTenNXB = locNXB.getSelectedItem().toString();
        if (locTenNXB.equals("Tất cả")) {
            locTenNXB = null; // Không áp dụng điều kiện nếu chọn "Tất cả"
        }
    }//GEN-LAST:event_locNXBActionPerformed

    private void locNBDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_locNBDPropertyChange
        locNgayBatDau = locNBD.getDate();
    }//GEN-LAST:event_locNBDPropertyChange

    private void locNKTPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_locNKTPropertyChange
        locNgayKetThuc = locNKT.getDate();
    }//GEN-LAST:event_locNKTPropertyChange

    private void locTienBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locTienBDActionPerformed
        try {
            String input = locTienBD.getText().trim();
            if (!input.isEmpty()) {
                locSoTienBatDau = Double.parseDouble(input);
            } else {
                locSoTienBatDau = null; // Không áp dụng điều kiện nếu không nhập
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số tiền bắt đầu không hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            locTienBD.setText(""); // Xóa giá trị không hợp lệ
            locSoTienBatDau = null;
        }
    }//GEN-LAST:event_locTienBDActionPerformed

    private void locTienKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locTienKTActionPerformed
        try {
            String input = locTienKT.getText().trim();
            if (!input.isEmpty()) {
                locSoTienKetThuc = Double.parseDouble(input);
            } else {
                locSoTienKetThuc = null; // Không áp dụng điều kiện nếu không nhập
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Số tiền kết thúc không hợp lệ!", "Thông báo", JOptionPane.ERROR_MESSAGE);
            locTienKT.setText(""); // Xóa giá trị không hợp lệ
            locSoTienKetThuc = null;
        }
    }//GEN-LAST:event_locTienKTActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePN;
    private com.toedter.calendar.JDateChooser locNBD;
    private com.toedter.calendar.JDateChooser locNKT;
    private javax.swing.JComboBox<String> locNXB;
    private javax.swing.JTextField locTienBD;
    private javax.swing.JTextField locTienKT;
    private javax.swing.JButton nutLoc;
    // End of variables declaration//GEN-END:variables
}
