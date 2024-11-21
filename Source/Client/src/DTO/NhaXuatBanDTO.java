package DTO;
public class NhaXuatBanDTO {
    private String maNXB;          // Mã NXB, khóa chính
    private String tenNXB;      // Tên nhà xuất bản
    private String diaChi;      // Địa chỉ nhà xuất bản
    private String soDienThoai; // Số điện thoại
    private String email;       // Email nhà xuất bản
    private int trangThai;
    // Constructor
    public NhaXuatBanDTO(String maNXB, String tenNXB, String diaChi, String soDienThoai, String email,int trangThai) {
        this.maNXB = maNXB;
        this.tenNXB = tenNXB;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.trangThai=trangThai;
    }

    // Getters và Setters
    public String getMaNXB() {
        return maNXB;
    }

    public void setMaNXB(String maNXB) {
        this.maNXB = maNXB;
    }

    public String getTenNXB() {
        return tenNXB;
    }

    public void setTenNXB(String tenNXB) {
        this.tenNXB = tenNXB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTrangThai(int trangThai)
    {
        this.trangThai=trangThai;
    }
    public int getTrangThai() {
        return trangThai;
    }
    // Phương thức toString để in đối tượng dễ dàng
    @Override
    public String toString() {
        return "NhaXuatBanDTO{" +
               "maNXB=" + maNXB +
               ", tenNXB='" + tenNXB + '\'' +
               ", diaChi='" + diaChi + '\'' +
               ", soDienThoai='" + soDienThoai + '\'' +
               ", email='" + email + '\'' +
               '}';
    }
}
