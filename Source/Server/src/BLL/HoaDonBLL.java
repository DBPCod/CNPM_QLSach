package BLL;

import DAO.HoaDonDAO;
import DTO.HoaDonDTO;
import org.json.JSONObject;

public class HoaDonBLL {
    // lay danh sach nxb
    public String getList()
    {
        HoaDonDAO hdDAO = new HoaDonDAO();
        JSONObject json = new JSONObject();
        json.put("Trangthai", "true");
        json.put("list", hdDAO.getList());
        return json.toString();
    }
    
    
    // lay 1 nxb
    public String getHoaDon(String MaHD) 
    {
        HoaDonDAO hdDAO = new HoaDonDAO();
        JSONObject json = new JSONObject();
        for (HoaDonDTO x : hdDAO.getList())
        {
            if (x.getMaHD().equals(MaHD))
            {
                json.put("Trangthai", "true");
                json.put("MaHD", x.getMaHD());
                json.put("Ngaylaphoadon", x.getNgayLapHoaDon());
                json.put("ThanhTien", x.getThanhTien());
                json.put("MaTK", x.getMaTK());
                break;
            }
        }
        
        return json.toString();
    }
}
