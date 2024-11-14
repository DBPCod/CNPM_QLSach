/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import BLL.ChiTietHoaDonBLL;
import BLL.ChiTietKhuyenMaiBLL;
import BLL.ChiTietPhieuNhapBLL;
import BLL.KhuyenMaiBLL;
import BLL.LoaiKhuyenMaiBLL;
import BLL.HoaDonBLL;
import BLL.NhanVienBLL;
import BLL.SanPhamBLL;
import BLL.TacGiaBLL;
import BLL.TaiKhoanBLL;
import BLL.VaiTroBLL;
import BLL.NhaXuatBanBLL;
import BLL.PhieuNhapBLL;
import BLL.SachTheLoaiBLL;
import BLL.TheLoaiBLL;
import DAO.ChiTietKhuyenMaiDAO;
import DTO.HoaDonDTO;
import DTO.KhuyenMaiDTO;
import DTO.LoaiKhuyenMaiDTO;
import DTO.TacGiaDTO;
import DTO.NhaXuatBanDTO;
import DTO.NhanVienDTO;
import DTO.PhieuNhapDTO;
import DTO.SachTheLoaiDTO;
import DTO.SanPhamDTO;
import DTO.TaiKhoanDTO;
import DTO.TheLoaiDTO;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
/**
 *
 * @author PC
 */
public class ClientHandle implements Runnable{
    private Socket mysocket;
    private String id;
    private InputStream input;
    private OutputStream output;
    private server server;
    public ClientHandle(Socket mysocket,String id,server server)
    {
        this.mysocket = mysocket;
        this.id = id;
        this.server=server;
        try{
            this.input=mysocket.getInputStream();
            this.output = mysocket.getOutputStream();
        }catch(IOException e)
        {
            e.printStackTrace();
            
        }
        // Thực hiện thử kết nối lại hoặc thông báo cho người dùng
    }

    @Override
    public void run() {
        try{
            
            byte[] buffer = new byte[1024*1024];
            int bytesRead;
            StringBuilder resultBuilder = new StringBuilder();
            while((bytesRead= input.read(buffer)) != -1)
            {
                String message = new String(buffer,0,bytesRead);
                System.out.println(message);
                xetDK(message);
            }
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void sendMessage(String message)
    {
        
        try{
            output.write(message.getBytes());
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    //ham de xem client yeu cau gi
    public void xetDK(String data)
    {
        JSONObject json = new JSONObject(data);
        String dieukien = json.getString("method");
        System.out.println(dieukien);
        switch(dieukien)
        {
            case "LOGIN":
                    //dang nhap
                    TaiKhoanBLL tkBLL = new TaiKhoanBLL();
                    System.out.println(String.valueOf(tkBLL.login(data)));
                    sendMessage(String.valueOf(tkBLL.login(data)));
                  
                    break;
            case "GETNV":
                    //lat 1 doi tuong nhan vien
                    NhanVienBLL nvBLL = new NhanVienBLL();
                    nvBLL.getNV(data);
                    sendMessage(String.valueOf(nvBLL.getNV(data)));
                    
                    break;
            case "GETVT":
                    //lay vai tro de hien thi thong tin
                    VaiTroBLL vtBLL = new VaiTroBLL();
                    sendMessage(String.valueOf(vtBLL.getVaiTro(data)));
                    
                    break;
            case "ListVaiTro":
                    VaiTroBLL vtBLL1 = new VaiTroBLL();
                    sendMessage(String.valueOf(vtBLL1.getList()));
                    break;
            case "ListTacGia":
                    //lay danh sach tac gia
                    TacGiaBLL tgBLL = new TacGiaBLL();
                    sendMessage(String.valueOf(tgBLL.getList()));
                    break;
            case "TacGia":
                //lay doi tuong de xem thong tin tac gia
                    TacGiaBLL tgBLL1 = new TacGiaBLL();
                    String MaTG = json.getString("MaTG");
                    sendMessage(String.valueOf(tgBLL1.getTacGia(MaTG)));
                    
                    break;
            case "ListTaiKhoan":
                    //lay danh sach san pham
                    TaiKhoanBLL tkBLL1 = new TaiKhoanBLL();
                    sendMessage(String.valueOf(tkBLL1.getList()));
                    
                    break;
            case "PUTTK":
                    TaiKhoanBLL tkBLL2 = new TaiKhoanBLL();
                    String maTK1 = json.getString("MaTK");
                    String tenTK = json.getString("TenTK");
                    String matKhauTK = json.getString("MatkhauTK");
                    sendMessage(tkBLL2.themTK(new TaiKhoanDTO( maTK1, tenTK, matKhauTK,1)));
                    break;
            case "PUTTG":
                //them doi tuong tac gia
                    TacGiaBLL tgBLL2 = new TacGiaBLL();
                    TacGiaDTO tgDTO = new TacGiaDTO(json.getString("MaTG"),json.getString("Hovaten"),json.getString("ButDanh"),json.getString("GioiTinh"),json.getString("QuocTich"),1);
                    sendMessage(String.valueOf(tgBLL2.themTG(tgDTO)));
                    
                    break;
            case "UPDATETG":
                //sau doi tuong tacgia
                    TacGiaBLL tgBLL3 = new TacGiaBLL();
                    TacGiaDTO tgDTO1 = new TacGiaDTO(json.getString("MaTG"),json.getString("Hovaten"),json.getString("ButDanh"),json.getString("GioiTinh"),json.getString("QuocTich"),1);
                    sendMessage(String.valueOf(tgBLL3.suaTG(tgDTO1)));
                    
                    break;
            case "DELETETG":
                //xoa doi tuong tac gia
                    TacGiaBLL tgBLL4 = new TacGiaBLL();
                    String MaTG1 = json.getString("MaDT");
                    TacGiaDTO tgDTO3 = new TacGiaDTO(MaTG1,"","","","",0);
                    sendMessage(String.valueOf(tgBLL4.xoaTG(tgDTO3)));
                   
                    break;
                    
            // Xu li nha xuat ban
            case "ListNhaXuatBan":
                    NhaXuatBanBLL nxbBLL = new NhaXuatBanBLL();
                    sendMessage(String.valueOf(nxbBLL.getList()));
                    
                    break;
            case "NhaXuatBan":
                //lay doi tuong de xem thong tin nxb
                    NhaXuatBanBLL nxbBLL1 = new NhaXuatBanBLL();
                    String MaNXB = json.getString("MaNXB");
                    sendMessage(String.valueOf(nxbBLL1.getNhaXuatBan(MaNXB)));
                   
                    break;
            case "PUTNXB":
                //them doi tuong nxb
                    NhaXuatBanBLL nxbBLL2 = new NhaXuatBanBLL();
                    NhaXuatBanDTO nxbDTO = new NhaXuatBanDTO(json.getString("MaNXB"), json.getString("TenNXB"), json.getString("Diachi"), json.getString("Sodienthoai"), json.getString("Email"), 1);
                    sendMessage(String.valueOf(nxbBLL2.themNXB(nxbDTO))); 
                   
                    break;
            case "UPDATENXB":
                //sua doi tuong nxb
                    NhaXuatBanBLL nxbBLL3 = new NhaXuatBanBLL();
                    NhaXuatBanDTO nxbDTO1 = new NhaXuatBanDTO(json.getString("MaNXB"), json.getString("TenNXB"), json.getString("Diachi"), json.getString("Sodienthoai"), json.getString("Email"), 1);
                    sendMessage(String.valueOf(nxbBLL3.suaNXB(nxbDTO1))); 
                    
                    break;
            case "DELETENXB":
                //xoa doi tuong nxb
                    NhaXuatBanBLL nxbBLL4 = new NhaXuatBanBLL();
                    String MaNXB1 = json.getString("MaNXB");
                    NhaXuatBanDTO nxbDTO3 = new NhaXuatBanDTO(MaNXB1,"","","","",0);
                    sendMessage(String.valueOf(nxbBLL4.xoaNXB(nxbDTO3)));      
                    break;

            // Xu li the loai
            case "ListTheLoai":
                    TheLoaiBLL tlBLL = new TheLoaiBLL();
                    sendMessage(String.valueOf(tlBLL.getList()));
                    
                    break;
            case "TheLoai":
                    //lay doi tuong de xem thong tin the loai
                    TheLoaiBLL tlBLL1 = new TheLoaiBLL();
                    String MaTL = json.getString("MaTL");
                    sendMessage(String.valueOf(tlBLL1.getTheLoai(MaTL)));
                    
                    break;
            case "PUTTL":
                    //them doi tuong the loai
                    TheLoaiBLL tlBLL2 = new TheLoaiBLL();
                    TheLoaiDTO tlDTO = new TheLoaiDTO(json.getString("MaTL"), json.getString("TenTL"), 1);
                    sendMessage(String.valueOf(tlBLL2.themTheLoai(tlDTO)));
                    
                    break;
            case "UPDATETL":
                    //sua doi tuong the loai
                    TheLoaiBLL tlBLL3 = new TheLoaiBLL();
                    TheLoaiDTO tlDTO1 = new TheLoaiDTO(json.getString("MaTL"), json.getString("TenTL"), 1);
                    sendMessage(String.valueOf(tlBLL3.suaTheLoai(tlDTO1)));
                    
                    break;
            case "DELETETL":
                    //xoa doi tuong the loai
                    TheLoaiBLL tlBLL4 = new TheLoaiBLL();
                    String MaTL1 = json.getString("MaTL");
                    TheLoaiDTO tlDTO3 = new TheLoaiDTO(MaTL1, "", 0);
                    sendMessage(String.valueOf(tlBLL4.xoaTheLoai(tlDTO3)));
                    break;

             case "ListSanPham":
                    //lay danh sach san pham
                    SanPhamBLL spBLL = new SanPhamBLL();
                    sendMessage(String.valueOf(spBLL.getList()));
                    break;
                    
             case "SanPham":
                    SanPhamBLL spBLL2 = new SanPhamBLL();
                    String MaSP = json.getString("MaSP");
                    sendMessage(String.valueOf(spBLL2.getSanPham(MaSP)));
                    
                    break;
             case "AnhBia":
                    SanPhamBLL spBLL3 = new SanPhamBLL();
                    String MaAB = json.getString("MaAB");
                    sendMessage(String.valueOf(spBLL3.getAnhBia(MaAB)));
                    break;
             case "SachTheLoai":
                    SachTheLoaiBLL stl1 = new SachTheLoaiBLL();
                    String MaSP3 = json.getString("MaSP");
                    sendMessage(String.valueOf(stl1.getSachTheLoai(new SachTheLoaiDTO(MaSP3,""))));
                    break;
             case "TenSachTheLoai":
                    SachTheLoaiBLL stl2 = new SachTheLoaiBLL();
                    String MaSP4 = json.getString("MaSP");
                    sendMessage(String.valueOf(stl2.getSachTenTheLoai(new SachTheLoaiDTO(MaSP4,""))));
                    break;
             case "PUTSP":
                     //them doi tuong san pham
                     SanPhamBLL spBLL1 = new SanPhamBLL();
                     byte[] anhBiaBytes = Base64.getDecoder().decode(json.getString("AnhBia"));
                     String base64String = Base64.getEncoder().encodeToString(anhBiaBytes);
                     SanPhamDTO sp = new SanPhamDTO(json.getString("MaSP"),json.getString("TenSP"),json.getInt("SoTrang"),json.getString("NgonNgu"),json.getDouble("GiaBia"),base64String,json.getInt("SoLuong"),json.getDouble("GiaNhap"),json.getString("MaTG"),json.getInt("Trangthai"));
                     sendMessage(String.valueOf(spBLL1.themSP(sp)));
                     break;
             case "PUTTLSP":
                    // them the loai cua san pham
                    SachTheLoaiBLL stl = new SachTheLoaiBLL();
                    String MaSP1 = json.getString("MaSP");
                    String MaTL2 = json.getString("MaTL");
                    sendMessage(String.valueOf(stl.themSTL(new SachTheLoaiDTO(MaSP1,MaTL2))));
                    break;
             case "UPDATESP":
                 //cap nhat the loai cua san pham va gia bia
                    SachTheLoaiBLL stl4 = new SachTheLoaiBLL();
                    String MaSP2 = json.getString("MaSP");
                    stl4.updateSachTheLoai(json);
                    SanPhamBLL sp4 = new SanPhamBLL();
                    sp4.suaSP(json);
                    sendMessage(String.valueOf(stl4.updateSachTheLoai(json)));
                    break;
             case "DELETESP":
                    SanPhamBLL stl5 = new SanPhamBLL ();
                    String MaSP5 = json.getString("MaSP");
                    
                    SanPhamDTO sp1 = new SanPhamDTO(json.getString("MaSP"),"",0,"",0,null,0,0,"",json.getInt("Trangthai"));
                    sendMessage(String.valueOf(stl5.xoaTheLoai(sp1)));
                    break;
              case "ListKhuyenMai":
                    //lay danh sach san pham
                    KhuyenMaiBLL kmBLL = new KhuyenMaiBLL();
                    sendMessage(String.valueOf(kmBLL.getList()));
                    break;
              case "ListLoaiKhuyenMai":
                    LoaiKhuyenMaiBLL lkmBLL = new LoaiKhuyenMaiBLL();
                    sendMessage(String.valueOf(lkmBLL.getList()));
                    break;
              case "PUTLKM":
                    //them loai khuyen mai
                    LoaiKhuyenMaiBLL lkmBLL1 = new LoaiKhuyenMaiBLL();
                    String MaloaiKM = json.getString("MaLoaiKM");
                    String TenLoaiKM = json.getString("TenLoaiKM");
                    int phantram = json.getInt("Phantram");
                    LoaiKhuyenMaiDTO lkmDTO = new LoaiKhuyenMaiDTO(MaloaiKM,TenLoaiKM,phantram,1);
                    sendMessage(String.valueOf(lkmBLL1.themLKM(lkmDTO)));
                    break;
              case "UPDATELKM":
                    //sua loai khuyen mai
                    LoaiKhuyenMaiBLL lkmBLL2 = new LoaiKhuyenMaiBLL();
                    String MaloaiKM1 = json.getString("MaLoaiKM");
                    String TenLoaiKM1 = json.getString("TenLoaiKM");
                    int phantram1 = json.getInt("Phantram");
                    LoaiKhuyenMaiDTO lkmDTO1 = new LoaiKhuyenMaiDTO(MaloaiKM1,TenLoaiKM1,phantram1,1);
                    sendMessage(String.valueOf(lkmBLL2.suaLKM(lkmDTO1)));
                    break;
              case "DELETELKM":
                    //xoa loai khuyen mai
                    LoaiKhuyenMaiBLL lkmBLL3 = new LoaiKhuyenMaiBLL();
                    String MaloaiKM2 = json.getString("MaLoaiKM");
                    LoaiKhuyenMaiDTO lkmDTO2 = new LoaiKhuyenMaiDTO(MaloaiKM2,"",0,0);
                    sendMessage(String.valueOf(lkmBLL3.xoaLKM(lkmDTO2)));
                    break;
              case "PUTKM":
                    //them khuyen mai
                    KhuyenMaiBLL kmBLL1 = new KhuyenMaiBLL();
//                     json.put("method","PUTKM");
                    try {
                        String maKM = json.getString("maKM");
                        String tenKM = json.getString("tenKM");
                        String maLoaiKM = json.getString("maLoaiKM");
                        String phanTramGiam=json.getString("phanTramGiam");
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date ngayBD = dateFormat.parse(json.getString("ngayBD"));
                        Date ngayKT = dateFormat.parse(json.getString("ngayKT"));
                        sendMessage(String.valueOf(kmBLL1.themKM(new KhuyenMaiDTO(maKM,tenKM, ngayBD, ngayKT, maLoaiKM,1,Integer.parseInt(phanTramGiam)))));
                    } catch (ParseException ex) {
                        Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                    
               case "ListChiTietKhuyenMai":
                    ChiTietKhuyenMaiBLL ctkmBLL1 = new ChiTietKhuyenMaiBLL();
                    sendMessage(String.valueOf(ctkmBLL1.getList()));
                    break;
                    
               case "PUTCTKM":
                   //them chi tiet khuyen mai
                   ChiTietKhuyenMaiBLL ctkmBLL = new ChiTietKhuyenMaiBLL();
                   String list = json.getString("list");
                   String maKM = json.getString("maKM");
//                   ctkmBLL.themCTKM(list,maKM);
                   sendMessage(String.valueOf(ctkmBLL.themCTKM(list,maKM)));
                   break;
               case "DELETEKM":
                   KhuyenMaiBLL kmBLL2 = new KhuyenMaiBLL();
                   String maKM1 = json.getString("MaKM");
                   sendMessage(String.valueOf(kmBLL2.xoaKM(new KhuyenMaiDTO(maKM1,"",null,null,"",0,0))));
                   break;
               case "ListPhieuNhap":
                   PhieuNhapBLL pnBLL = new PhieuNhapBLL();
                   sendMessage(String.valueOf(pnBLL.getList()));
                   break;
               case "PUTPN":
                   PhieuNhapBLL pnBLL1 = new PhieuNhapBLL();
                   String maPN = json.getString("maPN");
                   String maNV = json.getString("maNV");
                   String maNXB = json.getString("maNXB");
                   String ngayNhap = json.getString("ngayNhap");
                   String thanhtien = json.getString("thanhtien");
                   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    {
                        try {
                            sendMessage(String.valueOf(pnBLL1.themPN(new PhieuNhapDTO (maPN,dateFormat.parse(ngayNhap), Double.parseDouble(thanhtien), 1, maNV, maNXB))));
                        } catch (ParseException ex) {
                            Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "ListCTPhieuNhap":
                   ChiTietPhieuNhapBLL ctpnBLL1 = new ChiTietPhieuNhapBLL();
                   sendMessage(String.valueOf(ctpnBLL1.getList()));
                   break;
               case "PUTCTPN":
                    ChiTietPhieuNhapBLL ctpnBLL = new ChiTietPhieuNhapBLL();
                    String list1 = json.getString("list");
                    String maPN1 = json.getString("maPN");
                    sendMessage(String.valueOf(ctpnBLL.themCTPN(list1,maPN1)));
                    break;
               case "DELETEPN":
                    PhieuNhapBLL ctpnBLL2 = new PhieuNhapBLL();
                    String maPN2 = json.getString("MaPN");
                    sendMessage(String.valueOf(ctpnBLL2.xoaPN(new PhieuNhapDTO(maPN2, null, 0, 0, "", ""))));
                    break;
               case "ListNhanVien":
                   NhanVienBLL nv = new NhanVienBLL();
                   sendMessage(String.valueOf(nv.getList()));
                
                   break; 
                case "NhanVien":
                    NhanVienBLL nvBLL2 = new NhanVienBLL();
                    String MaNV = json.getString("MaNV");
                    sendMessage(String.valueOf(nvBLL2.getNhanVien(MaNV)));
                    break;   
                   
                case "PUTNV":
                    NhanVienBLL nvBLL3 = new NhanVienBLL();
                     try {
                        String ngaySinhStr = json.getString("NgaySinh");
                        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng này phải khớp với định dạng của chuỗi ngày sinh trong JSON
                        java.util.Date parsedDate = dateFormat2.parse(ngaySinhStr);
                        Date ngaySinh = new Date(parsedDate.getTime()); // Chuyển đổi sang java.sql.Date
        
                        NhanVienDTO nvDTO = new NhanVienDTO(
                            json.getString("MaNV"), 
                            json.getString("Hovaten"), 
                            ngaySinh, 
                            json.getString("GioiTinh"), 
                            json.getString("Sodienthoai"), 
                            json.getString("Email"), 
                            json.getString("DiaChi"), 
                            json.getString("MaTK"), 
                            json.getString("MaVT"), 1
                        );
                        sendMessage(String.valueOf(nvBLL3.themNV(nvDTO))); 
                        break;
                    } catch (Exception e) {
                       e.printStackTrace();
                    }
            case "UPDATENV":
                    NhanVienBLL nvBLL4 = new NhanVienBLL();
                    try {
                        String ngaySinhStr = json.getString("NgaySinh");
                        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd"); // Định dạng này phải khớp với định dạng của chuỗi ngày sinh trong JSON
                        java.util.Date parsedDate = dateFormat1.parse(ngaySinhStr);
                        Date ngaySinh = new Date(parsedDate.getTime()); // Chuyển đổi sang java.sql.Date
        
                        NhanVienDTO nvDTO = new NhanVienDTO(
                            json.getString("MaNV"), 
                            json.getString("Hovaten"), 
                            ngaySinh, 
                            json.getString("GioiTinh"), 
                            json.getString("Sodienthoai"), 
                            json.getString("Email"), 
                            json.getString("DiaChi"), 
                            json.getString("MaTK"), 
                            json.getString("MaVT"), 1
                        );
                        sendMessage(String.valueOf(nvBLL4.suaNV(nvDTO))); 
                        break;
                    } catch (Exception e) {
                       e.printStackTrace();
                    }
            case "DELETENV":
                NhanVienBLL nvBLL5 = new NhanVienBLL();
                String MaNV1 = json.getString("MaNV");
                NhanVienDTO nvDTO = new NhanVienDTO(MaNV1, "", null, "", "", "", "", "", "", 0);
                sendMessage(String.valueOf(nvBLL5.xoaNV(nvDTO)));
                break;
            // Xu li hoa don
            case "ListHoaDon":
                    HoaDonBLL hdBLL = new HoaDonBLL();
                    sendMessage(String.valueOf(hdBLL.getList()));
                    break;
            case "HoaDon":
                    //lay doi tuong de xem thong tin the loai
                    HoaDonBLL hdBLL1 = new HoaDonBLL();
                    String MaHD = json.getString("MaHD");
                    sendMessage(String.valueOf(hdBLL1.getHoaDon(MaHD)));
                    break;
            case "PUTHD":
                    //lay doi tuong de xem thong tin the loai
                    HoaDonBLL hdBLL2 = new HoaDonBLL();
                    String maHD =json.getString("maHD");
                    String maTK = json.getString("maNV");
                    String ngayNhap1 = json.getString("ngayNhap");
                    String thanhtien1 = json.getString("thanhtien");
                    SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                    {
                        try {
                            sendMessage(String.valueOf(hdBLL2.themHD(new HoaDonDTO (maHD, dateFormat1.parse(ngayNhap1), Double.parseDouble(thanhtien1), 1, maTK))));
                        } catch (ParseException ex) {
                            Logger.getLogger(ClientHandle.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
            case "DELETEHD":
                    HoaDonBLL hdBLL3 = new HoaDonBLL();
                    String maHD2 = json.getString("MaHD");
                    sendMessage(String.valueOf(hdBLL3.xoaHD(new HoaDonDTO (maHD2, null,0, 0,""))));
                    break;
            case "PUTCTHD":
                    ChiTietHoaDonBLL cthdBLL = new ChiTietHoaDonBLL();
                    String list2 = json.getString("list");
                    String maCTHD1 = json.getString("maHD");
                    sendMessage(String.valueOf(cthdBLL.themCTHD(list2,maCTHD1)));
                    break; 
            case "ListCTHD":
                    ChiTietHoaDonBLL cthdBLL1 = new ChiTietHoaDonBLL();
                    sendMessage(String.valueOf(cthdBLL1.getList()));
                    break;
                    
                    
            //Xu ly tai khoan
//            case "ListTaiKhoan":
//                    TaiKhoanBLL tkBLL3 = new TaiKhoanBLL();
//                    sendMessage(String.valueOf(tkBLL3.getList()));
//                    break;
            case "UPDATETK":
                    TaiKhoanBLL tkBLL4 = new TaiKhoanBLL();
                    TaiKhoanDTO tkDTO = new TaiKhoanDTO(json.getString("MaTK"),json.getString("TenTK"),json.getString("MatkhauTK"),1);
                    sendMessage(String.valueOf(tkBLL4.suaTK(tkDTO)));
                    break;
            case "TaiKhoan":
                    TaiKhoanBLL tkBLL5 = new TaiKhoanBLL();
                    String MaTK = json.getString("MaTK");
                    sendMessage(String.valueOf(tkBLL5.getTaiKhoan(MaTK)));
                    break;
            case "DELETETK":
                    TaiKhoanBLL tkBLL6 = new TaiKhoanBLL();
                    String MaTK1 = json.getString("MaTK");
                    sendMessage(String.valueOf(tkBLL6.xoaTK(new TaiKhoanDTO( MaTK1, "", "",0))));
                    break;
        }
    }
}
