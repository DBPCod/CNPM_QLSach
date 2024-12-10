# Chào mừng đến với phần mềm **Quản Lý Sách** 📚

Phần mềm **Quản Lý Sách** được phát triển bằng **Java**, nhằm hỗ trợ các cửa hàng sách trong việc quản lý và theo dõi các hoạt động như sách, đơn hàng, và kho. Với công nghệ **Socket**, phần mềm cho phép nhiều thiết bị kết nối và làm việc đồng thời với máy chủ, mang lại trải nghiệm mượt mà và hiệu quả.

Chúng tôi hy vọng phần mềm sẽ giúp việc quản lý cửa hàng sách của bạn trở nên đơn giản và hiệu quả hơn bao giờ hết!

---

## Điều Kiện Tiên Quyết
Trước khi bắt đầu, hãy đảm bảo rằng bạn đã cài đặt các công cụ sau:

### 1. **XAMPP**
- Dùng để thiết lập máy chủ và cơ sở dữ liệu MySQL.

### 2. **NetBeans**
- Dùng để phát triển hoặc chạy phần mềm.
- Tải tại: [https://netbeans.apache.org](https://netbeans.apache.org).
- Phiên bản khuyến nghị: **NetBeans 16** hoặc mới hơn.
- **Lưu ý:** Đảm bảo cài đặt **JDK** (Java Development Kit) trước khi cài đặt NetBeans.

---

## Hướng Dẫn Cài Đặt XAMPP

### 1. Tải và Cài Đặt XAMPP
1. Truy cập [XAMPP](https://www.apachefriends.org/index.html).
2. Tải phiên bản phù hợp với hệ điều hành của bạn.
3. Chạy file cài đặt và đảm bảo chọn **MySQL** trong quá trình cài đặt.

### 2. Khởi Chạy XAMPP
1. Mở **XAMPP Control Panel**.
2. Khởi động các dịch vụ:
   - Nhấn **Start** cho **Apache**.
   - Nhấn **Start** cho **MySQL**.

### 3. Cấu Hình Cơ Sở Dữ Liệu
1. Truy cập: [http://localhost/phpmyadmin](http://localhost/phpmyadmin).
2. Tạo cơ sở dữ liệu mới:
   - Nhập tên: `qlsach` và nhấn **Create**.
3. Import dữ liệu:
   - Vào tab **Import**.
   - Tải lên các file:
     - `db.sql` (cấu trúc cơ sở dữ liệu).
     - `insertDB.sql` (dữ liệu mẫu).
   - Nhấn **Go** để hoàn tất.

---

## Cách Sử Dụng Phần Mềm

### 1. Chạy Source Code
- Mở folder `Source` và chạy hai source code: **Client** và **Server**.

### 2. Cấu Hình IP
- Trong folder `Client`, tìm file `config.txt` và đổi IP thành địa chỉ IP của máy chạy Server.

### 3. Chạy File Chính
- Mở file `main.java` trong source code **Server** và chạy nó.
- Sau đó, chạy file `Login.java` trong source code **Client**.

---

### Tài khoản
- Tài khoản: `quanly`
- Mật khẩu: `123456`
---




## Giao diện
![App Screenshot](https://github.com/DBPCod/CNPM_QLSach/blob/main/img/login.jpg)

![App Screenshot](https://github.com/DBPCod/CNPM_QLSach/blob/main/img/trangchu.jpg)
