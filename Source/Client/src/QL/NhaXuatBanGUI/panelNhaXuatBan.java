/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package QL.NhaXuatBanGUI;

import javax.swing.plaf.basic.BasicInternalFrameUI;
import Client.Client;
import DTO.NhaXuatBanDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 *
 * @author luuis
 */
public class panelNhaXuatBan extends javax.swing.JInternalFrame {

    /**
     * Creates new form panelNhaXuatBan
     */
    private String MaDT = "0";
    private static Client client1;
    
    public panelNhaXuatBan(Client client) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        client1 = client;
        setUp();
    }
    
    // ham lay danh sach
    private ArrayList<NhaXuatBanDTO> getList(String yeucau) 
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
    
    // ham thiet lap bang danh sach
    public void setUp() 
    {
        DefaultTableModel model = (DefaultTableModel) jTableNXB.getModel();
        model.setRowCount(0);
        for (NhaXuatBanDTO nxb : getList("ListNhaXuatBan")) 
        {
            System.out.println(nxb.getTrangThai());
            // them tung doi tuong vao bang
            if (nxb.getTrangThai() == 1) 
            {
                System.out.println(nxb.getTenNXB());
                model.addRow(new Object[] {nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSoDienThoai(), nxb.getEmail()});
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        themButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        suaButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        xoaButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        chitietButton = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        cbxType = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNXB = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        themButton.setBackground(new java.awt.Color(255, 255, 255));
        themButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                themButtonMouseClicked(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconthem.jpg"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thêm");

        javax.swing.GroupLayout themButtonLayout = new javax.swing.GroupLayout(themButton);
        themButton.setLayout(themButtonLayout);
        themButtonLayout.setHorizontalGroup(
            themButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(themButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(themButtonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        themButtonLayout.setVerticalGroup(
            themButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(themButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2))
        );

        suaButton.setBackground(new java.awt.Color(255, 255, 255));
        suaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suaButtonMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconsua.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sửa");

        javax.swing.GroupLayout suaButtonLayout = new javax.swing.GroupLayout(suaButton);
        suaButton.setLayout(suaButtonLayout);
        suaButtonLayout.setHorizontalGroup(
            suaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suaButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(suaButtonLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        suaButtonLayout.setVerticalGroup(
            suaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(suaButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );

        xoaButton.setBackground(new java.awt.Color(255, 255, 255));
        xoaButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xoaButtonMouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconxoa.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Xóa");

        javax.swing.GroupLayout xoaButtonLayout = new javax.swing.GroupLayout(xoaButton);
        xoaButton.setLayout(xoaButtonLayout);
        xoaButtonLayout.setHorizontalGroup(
            xoaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xoaButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(xoaButtonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        xoaButtonLayout.setVerticalGroup(
            xoaButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xoaButtonLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );

        chitietButton.setBackground(new java.awt.Color(255, 255, 255));
        chitietButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chitietButtonMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconCT.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Chi tiết");

        javax.swing.GroupLayout chitietButtonLayout = new javax.swing.GroupLayout(chitietButton);
        chitietButton.setLayout(chitietButtonLayout);
        chitietButtonLayout.setHorizontalGroup(
            chitietButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(chitietButtonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        chitietButtonLayout.setVerticalGroup(
            chitietButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chitietButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(themButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(suaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(xoaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chitietButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(xoaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(themButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(suaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chitietButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jTextField1.setText("Tìm kiếm....");
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField1.setSelectionColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTableNXB.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableNXB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã nhà xuất bản", "Tên nhà xuất bản", "Địa chỉ", "Số điện thoại", "Email"
            }
        ));
        jTableNXB.setFocusable(false);
        jTableNXB.setGridColor(new java.awt.Color(0, 0, 0));
        jTableNXB.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTableNXB.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableNXB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableNXBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableNXB);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void themButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themButtonMouseClicked
        themNhaXuatBan tnxb = new themNhaXuatBan(client1, this);
        tnxb.setDefaultCloseOperation(tnxb.DISPOSE_ON_CLOSE);
        tnxb.setVisible(true);
    }//GEN-LAST:event_themButtonMouseClicked

    private void suaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suaButtonMouseClicked
        // neu chua chon doi tuong thi khong cho sua
        if (MaDT.equals("0")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        suaNhaXuatBan snxb = new suaNhaXuatBan(MaDT, client1, this);
        snxb.setDefaultCloseOperation(snxb.DISPOSE_ON_CLOSE);
        snxb.setVisible(true);
    }//GEN-LAST:event_suaButtonMouseClicked

    private void chitietButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chitietButtonMouseClicked
        // neu chua chon doi tuong thi khong cho xem
        if (MaDT.equals("0")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            thongTinNhaXuatBan ttnxb = new thongTinNhaXuatBan(MaDT, client1);
            ttnxb.setDefaultCloseOperation(ttnxb.DISPOSE_ON_CLOSE);
            ttnxb.setVisible(true);
        }
    }//GEN-LAST:event_chitietButtonMouseClicked

    private void xoaButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xoaButtonMouseClicked
        // neu chua chon doi tuong thi khong cho xoa
        if(MaDT.equals("0"))
        {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        JSONObject json = new JSONObject();
        json.put("method","DELETENXB");
        json.put("MaNXB", MaDT);
        JSONObject json1 = new JSONObject(client1.xoaDT(json.toString()));
        if(json1.getString("ketqua").equals("true"))
        {
            JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            setUp();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_xoaButtonMouseClicked

    private void jTableNXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNXBMouseClicked
        DefaultTableModel table = (DefaultTableModel) jTableNXB.getModel();
        int index = jTableNXB.getSelectedRow();
        String value = table.getValueAt(index, 0).toString();
        MaDT=value;
    }//GEN-LAST:event_jTableNXBMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> cbxType;
    private javax.swing.JPanel chitietButton;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNXB;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel suaButton;
    private javax.swing.JPanel themButton;
    private javax.swing.JPanel xoaButton;
    // End of variables declaration//GEN-END:variables
}
