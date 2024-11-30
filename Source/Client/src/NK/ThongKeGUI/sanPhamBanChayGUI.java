/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package NK.ThongKeGUI;

import QL.ThongKeGUI.*;
import Client.Client;
import DTO.ChiTietHoaDonDTO;
import DTO.HoaDonDTO;
import DTO.SanPhamDTO;
import QL.HoaDonGUI.panelHoaDon;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class sanPhamBanChayGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form sanPhamBanChayGUI
     */
    private Client client1;
    public sanPhamBanChayGUI(Client client) {
        initComponents();
         this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        client1=client;
        setUpCombobox();
        getSLSP();
    }

    private void getSLSP()
    {

            
       ArrayList<ChiTietHoaDonDTO> list = getListCTHD("ListCTHD");
        ArrayList<Object[]> list1 = new ArrayList<Object[]>();
        Map<String, Double> mapTong = new HashMap<>(); // Lưu tổng theo mã sản phẩm

        for (int i = 0; i < list.size(); i++) {
            String MaSP = list.get(i).getMaSP();
            double soluong = list.get(i).getSoLuong();

            // Nếu sản phẩm chưa có trong Map, thêm vào và khởi tạo tổng giá trị
            mapTong.put(MaSP, mapTong.getOrDefault(MaSP, 0.0) + soluong);
        }

        for (Map.Entry<String, Double> entry : mapTong.entrySet()) {
            list1.add(new Object[]{entry.getKey(), String.valueOf(entry.getValue())});
        }

        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Object[] x : list1) {
            for(SanPhamDTO sp : getListSP("ListSanPham"))
            {
            
                
                if(sp.getMaSP().equals(String.valueOf(x[0])))
                {
                    dataset.setValue(sp.getTenSP(), Double.parseDouble(String.valueOf(x[1])));
                }
            }
        }
        JFreeChart pieChart = ChartFactory.createPieChart(
            "Sản phẩm bán chạy", 
            dataset, 
            true, // Hiển thị chú thích
            true, // Cho phép tương tác
            true // Không cần hiển thị thông tin
        );
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(822,320));
        mainSP.removeAll();
        mainSP.setLayout(new BorderLayout());
        mainSP.add(chartPanel,BorderLayout.CENTER);
        mainSP.revalidate();
        mainSP.repaint();
    }

    
     // ham lay danh sach
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
    
    //ham lay danh sach
    private ArrayList<SanPhamDTO> getListSP(String yeucau)
    {
        JSONObject json;
        ArrayList<SanPhamDTO> list = new ArrayList<SanPhamDTO>();
        switch (yeucau) {
            case "ListSanPham": 

                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    for (int i = 0; i < jsonArray.length(); i++) {
                          JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                          String MaSP = tacGiaObject.getString("maSP");
                          String TenSP = tacGiaObject.getString("tenSP");
                          int SoTrang =  tacGiaObject.getInt("soTrang");
                          String NgonNgu = tacGiaObject.getString("ngonNgu");
                          Double GiaBia = tacGiaObject.getDouble("giaBia");
                          int SoLuong = tacGiaObject.getInt("soLuong");
                          int Trangthai = tacGiaObject.getInt("trangThai");
                          Double giaNhap = tacGiaObject.getDouble("giaNhap");
                          String maTG = tacGiaObject.getString("maTG");
                          list.add(new SanPhamDTO(MaSP,  TenSP,  SoTrang,  NgonNgu,  GiaBia, null, SoLuong, giaNhap, maTG,Trangthai));
                }
                 return list;
        }
                    
                   
                   return new ArrayList<>();
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
        nam = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        mainSP = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(960, 552));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Chọn năm");

        nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namActionPerformed(evt);
            }
        });

        jButton1.setText("Làm mới");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout mainSPLayout = new javax.swing.GroupLayout(mainSP);
        mainSP.setLayout(mainSPLayout);
        mainSPLayout.setHorizontalGroup(
            mainSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 822, Short.MAX_VALUE)
        );
        mainSPLayout.setVerticalGroup(
            mainSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(590, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(mainSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(63, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nam, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(432, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(mainSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(98, Short.MAX_VALUE)))
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

    private void namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namActionPerformed
        // TODO add your handling code here:
        int year = Integer.parseInt(String.valueOf(nam.getSelectedItem()));
        
        getHD(year);
    }//GEN-LAST:event_namActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        getSLSP();
        nam.setSelectedIndex(0);
    }//GEN-LAST:event_jButton1MouseClicked

    private void getHD(int year)
    {
        ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
        for(HoaDonDTO x : getListHD("ListHoaDon"))
            {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(x.getNgayLapHoaDon());
                if(calendar.get(Calendar.YEAR) == year)
                {
                    list.add(x);
                }
            }
        ArrayList<ChiTietHoaDonDTO> list1 = new ArrayList<ChiTietHoaDonDTO>();
        for(HoaDonDTO x : list)
        {
            for(ChiTietHoaDonDTO a: getListCTHD("ListCTHD"))
            {
                if(x.getMaHD().equals(a.getMaCTHD()))
                {
                    list1.add(a);
                }
            } 
        }
        
        ArrayList<Object[]> list2 = new ArrayList<Object[]>();
        Map<String, Double> mapTong = new HashMap<>(); // Lưu tổng theo mã sản phẩm

        for (int i = 0; i < list.size(); i++) {
            String MaSP = list1.get(i).getMaSP();
            double soluong = list1.get(i).getSoLuong();

            // Nếu sản phẩm chưa có trong Map, thêm vào và khởi tạo tổng giá trị
            mapTong.put(MaSP, mapTong.getOrDefault(MaSP, 0.0) + soluong);
        }

        for (Map.Entry<String, Double> entry : mapTong.entrySet()) {
            list2.add(new Object[]{entry.getKey(), String.valueOf(entry.getValue())});
        }


        DefaultPieDataset dataset = new DefaultPieDataset();

        for (Object[] x : list2) {
            for(SanPhamDTO sp : getListSP("ListSanPham"))
            {  
                if(sp.getMaSP().equals(String.valueOf(x[0])))
                {
                    dataset.setValue(sp.getTenSP(), Double.parseDouble(String.valueOf(x[1])));
                }
            }
        }
        JFreeChart pieChart = ChartFactory.createPieChart(
            "Sản phẩm bán chạy", 
            dataset, 
            true, // Hiển thị chú thích
            true, // Cho phép tương tác
            true // Không cần hiển thị thông tin
        );
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(822,320));
        mainSP.removeAll();
        mainSP.setLayout(new BorderLayout());
        mainSP.add(chartPanel,BorderLayout.CENTER);
        mainSP.revalidate();
        mainSP.repaint();
        
    }
    private void setUpCombobox()
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        for(int i=year;i>year -100;i--)
        {
            nam.addItem(String.valueOf(i));
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel mainSP;
    private javax.swing.JComboBox<String> nam;
    // End of variables declaration//GEN-END:variables
}
