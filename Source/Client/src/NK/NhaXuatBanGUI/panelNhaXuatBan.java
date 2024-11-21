/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package NK.NhaXuatBanGUI;

import QL.NhaXuatBanGUI.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import Client.Client;
import DTO.NhaXuatBanDTO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Customize.TimKiem;
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
    private static TimKiem timkiem = new TimKiem();
    
    public panelNhaXuatBan(Client client) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        client1 = client;
        setUp();
        timkiem.setPlaceholder(timKiemField, "Tìm kiếm theo mã hoặc tên...");
        timkiem.setUpSearchListener(timKiemField, this::timKiem);
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
    
    private void timKiem() 
    {        
        String searchText = timkiem.KhongLayDau(timKiemField.getText().trim().toLowerCase());
        DefaultTableModel model = (DefaultTableModel) jTableNXB.getModel();
        model.setRowCount(0); 

        ArrayList<NhaXuatBanDTO> allPublishers = getList("ListNhaXuatBan");

        for (NhaXuatBanDTO nxb : allPublishers) {
            if (nxb.getTrangThai() == 1) {
                String maNXB = timkiem.KhongLayDau(nxb.getMaNXB().toLowerCase());
                String tenNXB = timkiem.KhongLayDau(nxb.getTenNXB().toLowerCase());

                if (maNXB.contains(searchText) || tenNXB.contains(searchText)) {
                    model.addRow(new Object[]{nxb.getMaNXB(), nxb.getTenNXB(), nxb.getDiaChi(), nxb.getSoDienThoai(), nxb.getEmail()});
                }
            }
        }

        if (model.getRowCount() == 0 && !searchText.isEmpty()) {
            // xu li thong bao khi khong tim thay
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
        chitietButton = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        timKiemField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNXB = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(942, 651));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(930, 651));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

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
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(chitietButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(382, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(chitietButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        timKiemField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        timKiemField.setSelectionColor(new java.awt.Color(0, 0, 0));
        timKiemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timKiemFieldActionPerformed(evt);
            }
        });

        jButton1.setText("Làm mới");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timKiemField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
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
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jTableNXBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableNXBMouseClicked
        DefaultTableModel table = (DefaultTableModel) jTableNXB.getModel();
        int index = jTableNXB.getSelectedRow();
        String value = table.getValueAt(index, 0).toString();
        MaDT=value;
    }//GEN-LAST:event_jTableNXBMouseClicked

    private void timKiemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timKiemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timKiemFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chitietButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNXB;
    private javax.swing.JTextField timKiemField;
    // End of variables declaration//GEN-END:variables
}