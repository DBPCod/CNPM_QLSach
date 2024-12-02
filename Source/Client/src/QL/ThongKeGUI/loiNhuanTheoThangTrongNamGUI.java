/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package QL.ThongKeGUI;

import Client.Client;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import DTO.PhieuNhapDTO;
import NK.NhapKhoGUI.panelKho;
import QL.HoaDonGUI.panelHoaDon;
import QL.NhanVienGUI.panelNhanVien;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class loiNhuanTheoThangTrongNamGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form loiNhuanTheoThangTrongNamGUI
     */
    Client client1;
    public loiNhuanTheoThangTrongNamGUI(Client client) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        setUpCombobox();
        client1=client;
    }

    private void setUpCombobox()
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        for(int i=year;i>year -100;i--)
        {
            nam2.addItem(String.valueOf(i));
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
        jLabel1 = new javax.swing.JLabel();
        nam2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        mainLNTN = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLN = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Chọn năm");

        nam2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nam2ActionPerformed(evt);
            }
        });

        jButton1.setText("Thống kê");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Làm mới");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainLNTNLayout = new javax.swing.GroupLayout(mainLNTN);
        mainLNTN.setLayout(mainLNTNLayout);
        mainLNTNLayout.setHorizontalGroup(
            mainLNTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 814, Short.MAX_VALUE)
        );
        mainLNTNLayout.setVerticalGroup(
            mainLNTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        jTableLN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tháng", "Vốn", "Doanh thu", "Lời", "Lỗ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLN.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableLN);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(nam2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(mainLNTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nam2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(mainLNTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
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

     private ArrayList<HoaDonDTO> getTTHD(int nambd,ArrayList<HoaDonDTO> listHD)
    {
        ArrayList<HoaDonDTO> listHD1 = new ArrayList<HoaDonDTO>();
        for(HoaDonDTO x : listHD)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x.getNgayLapHoaDon());
            int year = calendar.get(Calendar.YEAR);
            if(year == nambd)
            {
                if(x.getTrangThai()!=0)
                {
                    listHD1.add(x);
                }
            }
        }
        return listHD1;
    }
    
     private double getTongTienHD(int nambd,int thang,ArrayList<HoaDonDTO> listHD)
    {
        double tong=0;
        for(HoaDonDTO x : getTTHD(nambd,listHD))
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x.getNgayLapHoaDon());
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            if(year==nambd && thang == month)
            {
                tong+=x.getThanhTien();
            }
        }
        return tong;
    }
     
    private double getTongTienPN(int nambd,int thang,ArrayList<PhieuNhapDTO> listPN)
    {
        double tong=0;
        for(PhieuNhapDTO x : getTTPN(nambd,listPN))
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x.getNgayNhap());
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            if(year==nambd && month == thang)
            {
                tong+=x.getThanhTien();
            }
        }
        return tong;
    }
    
    private ArrayList<PhieuNhapDTO> getTTPN(int nambd,ArrayList<PhieuNhapDTO> listPN)
    {
        ArrayList<PhieuNhapDTO> listPN1 = new ArrayList<PhieuNhapDTO>();
        for(PhieuNhapDTO x : listPN)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x.getNgayNhap());
            int year = calendar.get(Calendar.YEAR);
            if(year == nambd)
            {
                if(x.getTrangThai()!=0)
                {
                    listPN1.add(x);
                }
            }
        }  
        return listPN1;
    }
     
    private ArrayList<PhieuNhapDTO> getListPN(String yeucau)
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
//                            String MaNXB=tacGiaObject.getString("maNXB");;
                            for(NhanVienDTO nv : getListNV("ListNhanVien"))
                            {
                                if(MaTK.equals(nv.getMaTK()))
                                {
                                    list.add(new PhieuNhapDTO(MaPN, NgayNhap, Thanhtien, Trangthai, MaTK, nv.getMaTK()));
                                }
                            }
                            
                        } catch (ParseException ex) {
                            Logger.getLogger(panelKho.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   
        }
                    
                    return list;
                   
        }
                
                    
        return new ArrayList<>();
    }
    
    private ArrayList<NhanVienDTO> getListNV(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListNhanVien": 
                
                    ArrayList<NhanVienDTO> list = new ArrayList<NhanVienDTO>();
                    json = new JSONObject(client1.getList(yeucau));
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
    
    private ArrayList<HoaDonDTO> getListHD(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau)
        {
            case "ListHoaDon":
                ArrayList<HoaDonDTO> list = new ArrayList<>();
                json = new JSONObject(client1.getList(yeucau));
                
                // chuyen mang sang mang jsonArray
                JSONArray jsonArray = json.getJSONArray("list");
                for (int i = 0; i < jsonArray.length(); i++) 
                {
                    JSONObject nxbObject = jsonArray.getJSONObject(i);
                    String MaHD = nxbObject.getString("maHD");
                    String NgayLapHD = nxbObject.getString("ngayLapHoaDon");
                    Double ThanhTien = nxbObject.getDouble("thanhTien");
                    int Trangthai = nxbObject.getInt("trangThai");
                    String MaTK = nxbObject.getString("maTK");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
                    
                    try {
                        Date ngayLapHD = formatter.parse(NgayLapHD);
                        // Thêm vào ArrayList
                        //xem lai trang thai
                        list.add(new HoaDonDTO(MaHD, ngayLapHD, ThanhTien, Trangthai, MaTK));
                    } catch (ParseException ex) {
                        Logger.getLogger(panelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return list;
        }
        return new ArrayList<>();
    }
    
    //ham lay danh sach
    private ArrayList<ChiTietHoaDonDTO> getListCTHD(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListCTHD": 
                    ArrayList<ChiTietHoaDonDTO> list = new ArrayList<ChiTietHoaDonDTO>();
                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    System.out.println(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                        int soluong = tacGiaObject.getInt("soLuong");
                        Double dongia = tacGiaObject.getDouble("donGia");
                        String MaSP = tacGiaObject.getString("maSP");
                        String MaHD = tacGiaObject.getString("maCTHD");                  
                        // Thêm vào ArrayList
                        list.add(new ChiTietHoaDonDTO(MaHD, soluong, dongia, MaSP)); 
                    }
                    
                    return list;
                   
        }
                
                    
        return new ArrayList<>();
    }
    
    private void nam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nam2ActionPerformed

    }//GEN-LAST:event_nam2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String nambd = String.valueOf(nam2.getSelectedItem());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultTableModel model = (DefaultTableModel) jTableLN.getModel();
        ArrayList<HoaDonDTO> listHD = getListHD("ListHoaDon");
        ArrayList<PhieuNhapDTO> listPN = getListPN("ListPhieuNhap");
        model.setRowCount(0);
            for(int i=1;i<=12;i++)
            {   
                dataset.addValue(getTongTienPN(Integer.parseInt(nambd), i,listPN),"Vốn",String.valueOf(nambd));
                dataset.addValue(getTongTienHD(Integer.parseInt(nambd),i,listHD),"Doanh thu",String.valueOf(nambd));
                double loilo=0;
                if(getTongTienPN(Integer.parseInt(nambd), i,listPN) > getTongTienHD(Integer.parseInt(nambd),i,listHD))
                {
                    loilo =getTongTienPN(Integer.parseInt(nambd), i,listPN) - getTongTienHD(Integer.parseInt(nambd),i,listHD);
                    dataset.addValue(loilo ,"Lỗ",String.valueOf(i));
                    model.addRow(new Object[]{String.valueOf(i),String.valueOf(getTongTienPN(Integer.parseInt(nambd), i,listPN)),String.valueOf(getTongTienHD(Integer.parseInt(nambd),i,listHD)),0,loilo});
                }
                else
                {
                    loilo =getTongTienHD(Integer.parseInt(nambd), i,listHD) - getTongTienPN(Integer.parseInt(nambd),i,listPN);
                    dataset.addValue(loilo ,"Lời",String.valueOf(i));
                    model.addRow(new Object[]{String.valueOf(i),String.valueOf(getTongTienHD(Integer.parseInt(nambd), i,listHD)),String.valueOf(getTongTienPN(Integer.parseInt(nambd),i,listPN)),loilo,0});
                }
                
                
            }
            setUp(dataset);
    }//GEN-LAST:event_jButton1MouseClicked

    private void setUp(CategoryDataset dataset1)
    {
        CategoryDataset dataset = dataset1;
        JFreeChart chart = ChartFactory.createBarChart("Thống kê lợi nhuận","Year","Số tiền",dataset,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(814, 250));
        //set panel

        mainLNTN.setLayout(new BorderLayout());
        mainLNTN.removeAll();
        mainLNTN.add(panel,BorderLayout.CENTER);
        mainLNTN.revalidate();
        mainLNTN.repaint();
    }
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        nam2.setSelectedIndex(0);
        String nambd = String.valueOf(nam2.getSelectedItem());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        DefaultTableModel model = (DefaultTableModel) jTableLN.getModel();
        model.setRowCount(0);
        ArrayList<HoaDonDTO> listHD = getListHD("ListHoaDon");
        ArrayList<PhieuNhapDTO> listPN = getListPN("ListPhieuNhap");
            for(int i=1;i<=12;i++)
            {   
                dataset.addValue(getTongTienPN(Integer.parseInt(nambd), i,listPN),"Vốn",String.valueOf(nambd));
                dataset.addValue(getTongTienHD(Integer.parseInt(nambd),i,listHD),"Doanh thu",String.valueOf(nambd));
                double loilo=0;
                if(getTongTienPN(Integer.parseInt(nambd), i,listPN) > getTongTienHD(Integer.parseInt(nambd),i,listHD))
                {
                    loilo =getTongTienPN(Integer.parseInt(nambd), i,listPN) - getTongTienHD(Integer.parseInt(nambd),i,listHD);
                    dataset.addValue(loilo ,"Lỗ",String.valueOf(i));
                    model.addRow(new Object[]{String.valueOf(i),String.valueOf(getTongTienPN(Integer.parseInt(nambd), i,listPN)),String.valueOf(getTongTienHD(Integer.parseInt(nambd),i,listHD)),0,loilo});
                }
                else
                {
                    loilo =getTongTienHD(Integer.parseInt(nambd), i,listHD) - getTongTienPN(Integer.parseInt(nambd),i,listPN);
                    dataset.addValue(loilo ,"Lời",String.valueOf(i));
                    model.addRow(new Object[]{String.valueOf(i),String.valueOf(getTongTienHD(Integer.parseInt(nambd), i,listHD)),String.valueOf(getTongTienPN(Integer.parseInt(nambd),i,listPN)),loilo,0});
                }
                
                
            }
            setUp(dataset);
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLN;
    private javax.swing.JPanel mainLNTN;
    private javax.swing.JComboBox<String> nam2;
    // End of variables declaration//GEN-END:variables
}
