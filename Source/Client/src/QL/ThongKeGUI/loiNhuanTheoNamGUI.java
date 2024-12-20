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
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
public class loiNhuanTheoNamGUI extends javax.swing.JInternalFrame {

    /**
     * Creates new form loiNhuanTheoNam
     */
    Client client1;
    public loiNhuanTheoNamGUI(Client client) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        setUpCombobox();
        client1=client;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLN = new javax.swing.JTable();
        mainLNTN = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nam3 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

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

        jTableLN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Năm", "Vốn", "Doanh thu", "Lời", "Lỗ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLN.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableLN);
        if (jTableLN.getColumnModel().getColumnCount() > 0) {
            jTableLN.getColumnModel().getColumn(0).setResizable(false);
            jTableLN.getColumnModel().getColumn(1).setResizable(false);
            jTableLN.getColumnModel().getColumn(2).setResizable(false);
            jTableLN.getColumnModel().getColumn(3).setResizable(false);
            jTableLN.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout mainLNTNLayout = new javax.swing.GroupLayout(mainLNTN);
        mainLNTN.setLayout(mainLNTNLayout);
        mainLNTNLayout.setHorizontalGroup(
            mainLNTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        mainLNTNLayout.setVerticalGroup(
            mainLNTNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
        );

        jLabel2.setText("Đến năm");

        nam3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nam3ActionPerformed(evt);
            }
        });

        jButton2.setText("Làm mới");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nam2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nam3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
                    .addComponent(mainLNTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(nam3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(nam2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainLNTN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
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

    private void setUpCombobox()
    {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        for(int i=year;i>year -100;i--)
        {
            nam2.addItem(String.valueOf(i));
            nam3.addItem(String.valueOf(i));
        }
    }
    private void nam2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nam2ActionPerformed
        // TODO add your handling code here:
//        int year = Integer.parseInt(String.valueOf(nam.getSelectedItem()));
//
//        getHD(year);
    }//GEN-LAST:event_nam2ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        //lay ra nam bat dau va ket thuc
        String nambd = String.valueOf(nam2.getSelectedItem());
        String namkt = String.valueOf(nam3.getSelectedItem());
        DefaultTableModel model = (DefaultTableModel) jTableLN.getModel();
        model.setRowCount(0);
        ArrayList<HoaDonDTO> listHD = getListHD("ListHoaDon");
        ArrayList<PhieuNhapDTO> listPN = getListPN("ListPhieuNhap");
        if(Integer.parseInt(nambd) < Integer.parseInt(namkt) || Integer.parseInt(nambd) == Integer.parseInt(namkt))
        {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(int i=Integer.parseInt(nambd);i<=Integer.parseInt(namkt);i++)
            {
                
                dataset.addValue(getTongTienPN(i, Integer.parseInt(namkt),listPN) /1000000,"Vốn (Triệu)",String.valueOf(i));
                dataset.addValue(getTongTienHD(i, Integer.parseInt(namkt),listHD)/1000000,"Doanh thu (Triệu)",String.valueOf(i));
                double loilo=0;
                if(getTongTienPN(i, Integer.parseInt(namkt),listPN) > getTongTienHD(i, Integer.parseInt(namkt),listHD))
                {
                    loilo =getTongTienPN(i, Integer.parseInt(namkt),listPN) - getTongTienHD(i, Integer.parseInt(namkt),listHD);
                    dataset.addValue(loilo/1000000 ,"Lỗ",String.valueOf(i));
                    String tienPN = swapTien(getTongTienPN(i, Integer.parseInt(namkt),listPN));
                    String tienHD = swapTien(getTongTienHD(i, Integer.parseInt(namkt),listHD));
                    String tienLoiLo = swapTien(loilo);
                    model.addRow(new Object[]{String.valueOf(i),tienPN,tienHD,0,tienLoiLo});
                }
                else
                {
                    loilo =getTongTienHD(i, Integer.parseInt(namkt),listHD) - getTongTienPN(i, Integer.parseInt(namkt),listPN);
                    String tienPN = swapTien(getTongTienPN(i, Integer.parseInt(namkt),listPN));
                    String tienHD = swapTien(getTongTienHD(i, Integer.parseInt(namkt),listHD));
                    String tienLoiLo = swapTien(loilo);
                    dataset.addValue(loilo/1000000,"Lời",String.valueOf(i));
                    model.addRow(new Object[]{String.valueOf(i),tienPN,tienHD,tienLoiLo,0});
                }
                
                
            }
            setUp(dataset);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Năm bắt đầu phải nhỏ hơn năm kết thúc!","Cảnh báo",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    
    private String swapTien(Double thanhTien1)
    {
        if(thanhTien1 >= 1000000 && thanhTien1 < 1000000000)
        {
//            thanhTien.setText(formattedMoney+" triệu");
            return String.valueOf(thanhTien1 / 1000000)+" triệu";
        }
        else if(thanhTien1 >= 1000000000)
        {
            return String.valueOf(thanhTien1 / 1000000000)+" tỷ";
        }
        else
        {
            DecimalFormat df = new DecimalFormat("#,###");
            String formattedMoney = df.format(thanhTien1);
            return formattedMoney+" ngàn";
        }
    }
    
    private ArrayList<HoaDonDTO> getTTHD(int nambd,int namkt,ArrayList<HoaDonDTO> listHD)
    {
        ArrayList<HoaDonDTO> listHD1 = new ArrayList<HoaDonDTO>();
        for(HoaDonDTO x : listHD)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x.getNgayLapHoaDon());
            int year = calendar.get(Calendar.YEAR);
            System.out.println(year);
            if(year > nambd || year <namkt || year == nambd || year == namkt)
            {
                if(x.getTrangThai()!=0)
                {
                    listHD1.add(x);
                }
            }
        }
        return listHD1;
    }
    
    private ArrayList<PhieuNhapDTO> getTTPN(int nambd,int namkt,ArrayList<PhieuNhapDTO> listPN)
    {
        ArrayList<PhieuNhapDTO> listPN1 = new ArrayList<PhieuNhapDTO>();
        for(PhieuNhapDTO x : listPN)
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x.getNgayNhap());
            int year = calendar.get(Calendar.YEAR);
            if(year > nambd || year <namkt || year == nambd || year == namkt)
            {
                if(x.getTrangThai()!=0)
                {
                    listPN1.add(x);
                }
            }
        }  
        return listPN1;
    }

    private double getTongTienHD(int nambd,int namkt,ArrayList<HoaDonDTO> listHD)
    {
        double tong=0;
        for(HoaDonDTO x : getTTHD(nambd,namkt,listHD))
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x.getNgayLapHoaDon());
            int year = calendar.get(Calendar.YEAR);
            if(year==nambd)
            {
                tong+=x.getThanhTien();
            }
        }
        return tong;
    }
    
    private double getTongTienPN(int nambd,int namkt,ArrayList<PhieuNhapDTO> listPN)
    {
        double tong=0;
        for(PhieuNhapDTO x : getTTPN(nambd,namkt,listPN))
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(x.getNgayNhap());
            int year = calendar.get(Calendar.YEAR);
            if(year==nambd)
            {
                tong+=x.getThanhTien();
            }
        }
        return tong;
    }
    
    private void setUp(CategoryDataset dataset1)
    {
        CategoryDataset dataset = dataset1;
        JFreeChart chart = ChartFactory.createBarChart("Thống kê lợi nhuận","Year","Số tiền",dataset,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(300, 300));
        //set panel

        mainLNTN.setLayout(new BorderLayout());
        mainLNTN.removeAll();
        mainLNTN.add(panel,BorderLayout.CENTER);
        mainLNTN.revalidate();
        mainLNTN.repaint();
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
    
    private void nam3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nam3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nam3ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:

        nam2.setSelectedIndex(0);
        nam3.setSelectedIndex(0);
        
        String nambd = String.valueOf(nam2.getSelectedItem());
        String namkt = String.valueOf(nam3.getSelectedItem());
        DefaultTableModel model = (DefaultTableModel) jTableLN.getModel();
        model.setRowCount(0);
        ArrayList<HoaDonDTO> listHD = getListHD("ListHoaDon");
        ArrayList<PhieuNhapDTO> listPN = getListPN("ListPhieuNhap");
        if(Integer.parseInt(nambd) < Integer.parseInt(namkt) || Integer.parseInt(nambd) == Integer.parseInt(namkt))
        {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(int i=Integer.parseInt(nambd);i<=Integer.parseInt(namkt);i++)
            {                
                dataset.addValue(getTongTienPN(i, Integer.parseInt(namkt),listPN) /1000000,"Vốn (Triệu)",String.valueOf(i));
                dataset.addValue(getTongTienHD(i, Integer.parseInt(namkt),listHD)/1000000,"Doanh thu (Triệu)",String.valueOf(i));
                double loilo=0;
                if(getTongTienPN(i, Integer.parseInt(namkt),listPN) > getTongTienHD(i, Integer.parseInt(namkt),listHD))
                {
                    loilo =getTongTienPN(i, Integer.parseInt(namkt),listPN) - getTongTienHD(i, Integer.parseInt(namkt),listHD);
                    dataset.addValue(loilo/1000000 ,"Lỗ",String.valueOf(i));
                    String tienPN = swapTien(getTongTienPN(i, Integer.parseInt(namkt),listPN));
                    String tienHD = swapTien(getTongTienHD(i, Integer.parseInt(namkt),listHD));
                    String tienLoiLo = swapTien(loilo);
                    model.addRow(new Object[]{String.valueOf(i),tienPN,tienHD,0,tienLoiLo});
                }
                else
                {
                    loilo =getTongTienHD(i, Integer.parseInt(namkt),listHD) - getTongTienPN(i, Integer.parseInt(namkt),listPN);
                    String tienPN = swapTien(getTongTienPN(i, Integer.parseInt(namkt),listPN));
                    String tienHD = swapTien(getTongTienHD(i, Integer.parseInt(namkt),listHD));
                    String tienLoiLo = swapTien(loilo);
                    dataset.addValue(loilo/1000000,"Lời",String.valueOf(i));
                    model.addRow(new Object[]{String.valueOf(i),tienPN,tienHD,tienLoiLo,0});
                }
                
            }
            setUp(dataset);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Năm bắt đầu phải nhỏ hơn năm kết thúc!","Cảnh báo",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLN;
    private javax.swing.JPanel mainLNTN;
    private javax.swing.JComboBox<String> nam2;
    private javax.swing.JComboBox<String> nam3;
    // End of variables declaration//GEN-END:variables
}
