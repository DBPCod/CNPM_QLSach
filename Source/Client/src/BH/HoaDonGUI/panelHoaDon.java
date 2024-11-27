package BH.HoaDonGUI;

import QL.HoaDonGUI.*;
import Client.Client;
import DTO.HoaDonDTO;
import DTO.NhanVienDTO;
import QL.NhanVienGUI.panelNhanVien;
import QL.NhapKhoGUI.thongTinPhieuNhap;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luuis
 */
public class panelHoaDon extends javax.swing.JInternalFrame {

    /**
     * Creates new form panelHoaDon
     */
    private String MaDT = "0";
    private String nguoiNhap1;
    private static Client client1;
    private boolean check=true;
    private String locTenNhanVien = null; 
    private Date locNgayBatDau = null;   
    private Date locNgayKetThuc = null;  
    private Double locSoTienBatDau = null; 
    private Double locSoTienKetThuc = null; 

    public panelHoaDon(Client client,String nguoiNhap) {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
        bui.setNorthPane(null);
        client1 = client;
        nguoiNhap1=nguoiNhap;
        setUp();
//        setUpComboBoxNhanVien();
    }
    
    
    
    // ham lay danh sach
    private ArrayList<HoaDonDTO> getList(String yeucau)
    {
        JSONObject json;
        
        switch (yeucau) {
            case "ListHoaDon": 
                    ArrayList<HoaDonDTO> list = new ArrayList<HoaDonDTO>();
                    json = new JSONObject(client1.getList(yeucau));
                    //chuyen mang chuoi sang mang jsonArray
                    JSONArray jsonArray = json.getJSONArray("list");
                    System.out.println(jsonArray);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject hdObject = jsonArray.getJSONObject(i);
                        String MaHD = hdObject.getString("maHD");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date NgayLap;
                        try {
                            NgayLap = formatter.parse((hdObject.getString("ngayLapHoaDon")).toString() );
                            Double Thanhtien = hdObject.getDouble("thanhTien");
                            int Trangthai = hdObject.getInt("trangThai");
                            String MaTK = hdObject.getString("maTK");
                            for(NhanVienDTO nv : getListNV("ListNhanVien"))
                            {
                                if(MaTK.equals(nv.getMaTK()))
                                {
                                    list.add(new HoaDonDTO(MaHD, NgayLap, Thanhtien, Trangthai, nv.getMaTK()));
                                }
                            }
                            
                        } catch (ParseException ex) {
                            Logger.getLogger(panelHoaDon.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void setUp() 
    {
//        System.out.println(nguoiNhap1+"aaa");
        DefaultTableModel model = (DefaultTableModel) jTableHD.getModel();
        model.setRowCount(0);
        for (HoaDonDTO hd : getList("ListHoaDon")) 
        {
            System.out.println(hd.getTrangThai());
            // them tung doi tuong vao bang
            if (hd.getTrangThai() == 1 && getMaTK(nguoiNhap1).equals(hd.getMaTK())) 
            {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngayLapHD = formatter.format(hd.getNgayLapHoaDon());
                System.out.println(hd.getMaHD());
                model.addRow(new Object[] {hd.getMaHD(), ngayLapHD, hd.getThanhTien()});
            }
        }
    }
    
    private String getMaTK(String tenNV)
    {
        for(NhanVienDTO nv : getListNV("ListNhanVien"))
        {
            if(nv.getHoVaTen().equals(tenNV))
            {
                return nv.getMaTK();
            }
        }
        return "";
    }
    
    public void setUpDelete() 
    {
        DefaultTableModel model = (DefaultTableModel) jTableHD.getModel();
        model.setRowCount(0);
        for (HoaDonDTO hd : getList("ListHoaDon")) 
        {
            // them tung doi tuong vao bang
            if (hd.getTrangThai() == 0) 
            {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String ngayLapHD = formatter.format(hd.getNgayLapHoaDon());
                System.out.println(hd.getMaHD());
                model.addRow(new Object[] {hd.getMaHD(), ngayLapHD, hd.getThanhTien()});
            }
        }
    }
    
//    private void setUpComboBoxNhanVien() 
//    {
//        locNV.removeAllItems(); // Xóa các item cũ
//        locNV.addItem("Tất cả"); // Thêm tùy chọn mặc định
//        for (NhanVienDTO nv : getListNV("ListNhanVien")) {
//            if (nv.getTrangThai() == 1) {
//                locNV.addItem(nv.getHoVaTen());
//            }
//        }
//    }


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
        chiTietButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        huyButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dsHuyButton = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHD = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        locNBD = new com.toedter.calendar.JDateChooser();
        locNKT = new com.toedter.calendar.JDateChooser();
        locTienBD = new javax.swing.JTextField();
        locTienKT = new javax.swing.JTextField();
        nutLoc = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(970, 640));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        themButton.setBackground(new java.awt.Color(255, 255, 255));
        themButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        chiTietButton.setBackground(new java.awt.Color(255, 255, 255));
        chiTietButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                chiTietButtonMouseClicked(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconCT.jpg"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Chi tiết");

        javax.swing.GroupLayout chiTietButtonLayout = new javax.swing.GroupLayout(chiTietButton);
        chiTietButton.setLayout(chiTietButtonLayout);
        chiTietButtonLayout.setHorizontalGroup(
            chiTietButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chiTietButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(chiTietButtonLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        chiTietButtonLayout.setVerticalGroup(
            chiTietButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(chiTietButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4))
        );

        huyButton.setBackground(new java.awt.Color(255, 255, 255));
        huyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                huyButtonMouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconxoa.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Huỷ");

        javax.swing.GroupLayout huyButtonLayout = new javax.swing.GroupLayout(huyButton);
        huyButton.setLayout(huyButtonLayout);
        huyButtonLayout.setHorizontalGroup(
            huyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(huyButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(huyButtonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        huyButtonLayout.setVerticalGroup(
            huyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(huyButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6))
        );

        dsHuyButton.setBackground(new java.awt.Color(255, 255, 255));
        dsHuyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsHuyButtonMouseClicked(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/iconRac.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Danh sách huỷ");

        javax.swing.GroupLayout dsHuyButtonLayout = new javax.swing.GroupLayout(dsHuyButton);
        dsHuyButton.setLayout(dsHuyButtonLayout);
        dsHuyButtonLayout.setHorizontalGroup(
            dsHuyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsHuyButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(dsHuyButtonLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dsHuyButtonLayout.setVerticalGroup(
            dsHuyButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dsHuyButtonLayout.createSequentialGroup()
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
                .addComponent(chiTietButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(huyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dsHuyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(huyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(themButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chiTietButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(dsHuyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTableHD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày lập hóa đơn", "Thành tiền"
            }
        ));
        jTableHD.setFocusable(false);
        jTableHD.setGridColor(new java.awt.Color(0, 0, 0));
        jTableHD.setSelectionBackground(new java.awt.Color(0, 102, 255));
        jTableHD.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHD);

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

        nutLoc.setText("Lọc");
        nutLoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nutLocMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(locNBD, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(locNKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(locTienBD)
                    .addComponent(locTienKT)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(nutLoc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locNBD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locNKT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locTienBD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(locTienKT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(nutLoc))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
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

    private void themButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_themButtonMouseClicked
        // TODO add your handling code here:
        themHoaDon thd = new themHoaDon(client1,nguoiNhap1,this);
        thd.setDefaultCloseOperation(thd.DISPOSE_ON_CLOSE);
        thd.setVisible(true);
    }//GEN-LAST:event_themButtonMouseClicked

    private void dsHuyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsHuyButtonMouseClicked
        // TODO add your handling code here:
        check=false;
        setUpDelete();
    }//GEN-LAST:event_dsHuyButtonMouseClicked

    private void chiTietButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_chiTietButtonMouseClicked
        // TODO add your handling code here:
        if (MaDT.equals("0")) {
            JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            thongTinHoaDon tthd = new thongTinHoaDon(MaDT,client1);
            tthd.setDefaultCloseOperation(tthd.DISPOSE_ON_CLOSE);
            tthd.setVisible(true);
        }
    }//GEN-LAST:event_chiTietButtonMouseClicked

    private void jTableHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHDMouseClicked
        DefaultTableModel table = (DefaultTableModel) jTableHD.getModel();
        int index = jTableHD.getSelectedRow();
        String value = table.getValueAt(index, 0).toString();
        MaDT = value;
    }//GEN-LAST:event_jTableHDMouseClicked

    private void huyButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_huyButtonMouseClicked
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(
                null, 
                "Bạn có chắc chắn muốn tiếp tục?", // Nội dung thông báo
                "Xác nhận", // Tiêu đề của hộp thoại
                JOptionPane.YES_NO_OPTION, // Loại thông báo (YES/NO)
                JOptionPane.QUESTION_MESSAGE // Icon (QUESTION)
        );
        if (response == JOptionPane.YES_OPTION && check==true) {
            
//            System.out.println("Người dùng chọn Có.");
            if(MaDT.equals("0"))
            {
                JOptionPane.showMessageDialog(null, "Chưa chọn đối tượng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            JSONObject json = new JSONObject();
            json.put("method","DELETEHD");
            json.put("MaHD", MaDT);
            JSONObject json1 = new JSONObject(client1.xoaDT(json.toString()));
            if(json1.getString("ketqua").equals("true"))
            {
                getCTHD();
                JOptionPane.showMessageDialog(null, "Xóa thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                setUp();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else if(check==false)
        {
            JOptionPane.showMessageDialog(null, "Không thể xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_huyButtonMouseClicked

    
    private void getCTHD()
    {
        ArrayList<Object[]> list = new ArrayList<Object[]>();
        JSONObject json = new JSONObject(client1.getDoiTuong("CTHoaDon", MaDT));
        JSONArray jsonArray = json.getJSONArray("list");
        for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject tacGiaObject = jsonArray.getJSONObject(i);
                        String MaHD = tacGiaObject.getString("maCTHD");
                        String MaSP = tacGiaObject.getString("maSP");
                        int soLuong = tacGiaObject.getInt("soLuong");
                        list.add(new Object[]{MaHD,MaSP,String.valueOf(soLuong)});
        }
        
        JSONArray jsonArray1 = new JSONArray(list);
        JSONObject json2 = new JSONObject();
        json2.put("method","UPDATEHuySLSP");
        json2.put("theloai","hoadon");
        json2.put("list",jsonArray.toString());
        
        client1.suaDT(json2.toString());
    }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        check=true;
        setUp();
    }//GEN-LAST:event_jButton1MouseClicked

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

    private void nutLocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nutLocMouseClicked
        DefaultTableModel model = (DefaultTableModel) jTableHD.getModel();
        model.setRowCount(0);

//        String tenNhanVien = locNV.getSelectedItem().toString();
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
        for (HoaDonDTO hd : getList("ListHoaDon")) {
            if (hd.getTrangThai() == 1) { // Chỉ lọc hóa đơn có trạng thái hợp lệ

                boolean tenNhanVienThoaMan = getMaTK(nguoiNhap1).equals(hd.getMaTK()); 
                boolean ngayThoaMan = (ngayBatDau == null || ngayKetThuc == null ||
                                       (!hd.getNgayLapHoaDon().before(ngayBatDau) && !hd.getNgayLapHoaDon().after(ngayKetThuc)));
                boolean tienThoaMan = (soTienBatDau == null || hd.getThanhTien() >= soTienBatDau) &&
                                      (soTienKetThuc == null || hd.getThanhTien() <= soTienKetThuc);

                // Chỉ thêm vào bảng nếu tất cả các điều kiện đều thỏa mãn
                if (tenNhanVienThoaMan && ngayThoaMan && tienThoaMan) {
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    String ngayLapHD = formatter.format(hd.getNgayLapHoaDon());
                    model.addRow(new Object[]{hd.getMaHD(), ngayLapHD, hd.getThanhTien(), hd.getMaTK()});
                }
            }
        }

        // Xóa các trường nhập sau khi lọc
//        locNV.setSelectedIndex(0); // Đặt lại về "Tất cả"
        locNBD.setDate(null);
        locNKT.setDate(null);
        locTienBD.setText("");
        locTienKT.setText("");

        // Hiển thị thông báo nếu không có kết quả nào
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Không tìm thấy kết quả phù hợp!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            setUp();
        }
    }//GEN-LAST:event_nutLocMouseClicked

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
    private javax.swing.JPanel chiTietButton;
    private javax.swing.JPanel dsHuyButton;
    private javax.swing.JPanel huyButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JTable jTableHD;
    private com.toedter.calendar.JDateChooser locNBD;
    private com.toedter.calendar.JDateChooser locNKT;
    private javax.swing.JTextField locTienBD;
    private javax.swing.JTextField locTienKT;
    private javax.swing.JButton nutLoc;
    private javax.swing.JPanel themButton;
    // End of variables declaration//GEN-END:variables
}
