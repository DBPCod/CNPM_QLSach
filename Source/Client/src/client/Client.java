/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import Client.ClientListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
/**
 *
 * @author PC
 */
public class Client {
    private static String url;
    private static final int PORT = 8000;
    public Socket socket;
    ClientListener client;
    public Client()
    {
        configIP config = new configIP();
        url=config.ip;
         
        try {
            socket = new Socket(url,PORT);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("ket noi thanh cong");
    }
    
    public void dongcong()
    {
        OutputStream output;
        try {
            output = socket.getOutputStream();
            JSONObject json = new JSONObject();
            json.put("yeucau","dongcong");
            output.write((json.toString()).getBytes());
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    public void startClient()
    {
        try{
            
            //lien tuc doc du lieu tu server
            client = new ClientListener(socket);
            new Thread(client).start();
            //lien tuc ghi du lieu
            OutputStream output = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            while(true)
            {
                String message = sc.nextLine();
                output.write(message.getBytes());
                output.flush();
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    //ham xu li yeu cau xoa doi tuong
    public String xoaDT(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        switch(yeucau){
            case "DELETETG":
                return guiXoaTG(data);
            case "DELETENXB":
                return guiXoaNXB(data);
            case "DELETETL":
                return guiXoaTL(data);
            case "DELETESP":
                 return guiXoaSP(data);
            case "DELETELKM":
                return guiXoaLKM(data);
            case "DELETEKM":
                return guiXoaKM(data);
            case "DELETEPN":
                return guiXoaPN(data);
            case "DELETEHD":
                return guiXoaHD(data);
            case "DELETENV":
                return guiXoaNV(data);
            case "DELETETK":
                return guiXoaTK(data);
        }
        return "";
    }
    
    //ham gui yeu cau xoa doi tuong hoa don qua server
    private String guiXoaTK(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTK",json.getString("MaTK"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong hoa don qua server
    private String guiXoaNV(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaNV",json.getString("MaNV"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong hoa don qua server
    private String guiXoaHD(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaHD",json.getString("MaHD"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong khuyen mai qua server
    private String guiXoaPN(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaPN",json.getString("MaPN"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong khuyen mai qua server
    private String guiXoaKM(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaKM",json.getString("MaKM"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong loai khuyen mai qua server
    private String guiXoaLKM(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaLoaiKM",json.getString("MaLoaiKM"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong tac gia qua server
    private String guiXoaSP(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaSP",json.getString("MaSP"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong tac gia qua server
    private String guiXoaTG(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaDT",json.getString("MaDT"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau xoa doi tuong nxb qua server
    private String guiXoaNXB(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaNXB",json.getString("MaNXB"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }  
    
    //ham gui yeu cau xoa doi tuong nxb qua server
    private String guiXoaTL(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTL",json.getString("MaTL"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham xu li yeu cau sua doi tuong
    public String suaDT(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        switch(yeucau){
            case "UPDATETG":
                return guiSuaTG(data);
            case "UPDATENXB":
                return guiSuaNXB(data);
            case "UPDATETL":
                return guiSuaTL(data);
            case "UPDATESP":
                return guiSuaSTL(data);
            case "UPDATESLSP":
                return guiSuaSLSP(data);
            case "UPDATELKM":
                return guiSuaLKM(data);
            case "UPDATETK":
                return guiSuaTK(data);
            case "UPDATENV":
                return guiSuaNV(data);
        }
        return "";
    }
    
    private String guiSuaNV(String data)
     {
         JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaNV",json.getString("MaNV"));
             json.put("Hovaten",json.getString("Hovaten"));
             json.put("NgaySinh", json.getString("NgaySinh"));
             json.put("GioiTinh", json.getString("GioiTinh"));
             json.put("Sodienthoai", json.getString("Sodienthoai"));
             json.put("Email", json.getString("Email"));
             json.put("DiaChi", json.getString("DiaChi"));
             json.put("MaTK",json.getString("MaTK"));
             json.put("MaVT", json.getString("MaVT"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
     }
    
    private String guiSuaTK(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTK",json.getString("MaTK"));
             json.put("TenTK",json.getString("TenTK"));
             json.put("MatkhauTK",json.getString("MatkhauTK"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau sua doi tuong loai khuyen mai toi server
    private String guiSuaSLSP(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("list",json.getString("list"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau sua doi tuong loai khuyen mai toi server
    private String guiSuaLKM(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaLoaiKM",json.getString("MaLoaiKM"));
             json.put("TenLoaiKM",json.getString("TenLoaiKM"));
             json.put("Phantram",json.getInt("Phantram"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau sua doi tuong tac gia toi server
    private String guiSuaSTL(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("list",json.getString("list"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau sua doi tuong tac gia toi server
    private String guiSuaTG(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTG",json.getString("MaTG"));
             json.put("Hovaten",json.getString("Hovaten"));
             json.put("ButDanh",json.getString("ButDanh"));
             json.put("GioiTinh", json.getString("GioiTinh"));
             json.put("QuocTich",json.getString("QuocTich"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau sua doi tuong nxb toi server
    private String guiSuaNXB(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaNXB",json.getString("MaNXB"));
             json.put("TenNXB",json.getString("TenNXB"));
             json.put("Diachi",json.getString("Diachi"));
             json.put("Sodienthoai",json.getString("Sodienthoai"));
             json.put("Email",json.getString("Email"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
    
    //ham gui yeu cau sua doi tuong nxb toi server
    private String guiSuaTL(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        try {
             ClientListener client = new ClientListener(socket);
             Thread thread = new Thread(client);
             json.put("method",yeucau);
             json.put("MaTL",json.getString("MaTL"));
             json.put("TenTL",json.getString("TenTL"));
             OutputStream output;
             output = socket.getOutputStream();
             output.write((json.toString()).getBytes());
             output.flush();
             thread.start();
             thread.join();
             return client.result;
         } 
         catch (InterruptedException ex) {
                 Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
             }
         catch (IOException ex) {
             Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
         }

        return "";
    }
//ham xu li yeu cau them doi tuong
   public String themDT(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       switch (yeucau){
            case "PUTTG":
               guiThemTG(data);
               return "thanhcong";
            case "PUTNXB":
                guiThemNXB(data);
                return "thanhcong";
            case "PUTTL":
                guiThemTL(data);
                return "thanhcong";
            case "PUTSP":
                guiThemSP(data);
                return "thanhcong";
            case "PUTTLSP":
                guiThemTLSP(data);
                return "thanhcong";
            case "PUTLKM":
                guiThemLKM(data);
                return "thanhcong";
            case "PUTKM":
                guiThemKM(data);
                return "thanhcong";
            case "PUTCTKM":
                guiThemCTKM(data);
                return "thanhcong";
            case "PUTPN":
                guiThemPN(data);
                return "thanhcong";
            case "PUTCTPN":
                guiThemCTPN(data);
                return "thanhcong";
            case "PUTHD":
                guiThemHD(data);
                return "thanhcong";
            case "PUTCTHD":
                guiThemCTHD(data);
                return "thanhcong";
            case "PUTNV":
                guiThemNV(data);
                return "thanhcong";
            case "PUTTK":
                guiThemTK(data);
                return "thanhcong";
       }
       return "";
   }
   
   public String guiThemTK(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaTK",json.getString("MaTK"));
            json.put("TenTK",json.getString("TenTK"));
            json.put("MatkhauTK",json.getString("MatkhauTK"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   public String guiThemNV(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaNV",json.getString("MaNV"));
            json.put("Hovaten",json.getString("Hovaten"));
            json.put("NgaySinh", json.getString("NgaySinh"));
            json.put("GioiTinh", json.getString("GioiTinh"));
            json.put("Sodienthoai", json.getString("Sodienthoai"));
            json.put("Email", json.getString("Email"));
            json.put("DiaChi", json.getString("DiaChi"));
            json.put("MaTK",json.getString("MaTK"));
            json.put("MaVT", json.getString("MaVT"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui them phieu nhap toi server
   public String guiThemCTHD(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("list",json.getString("list"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui them phieu nhap toi server
   public String guiThemHD(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("maNV",json.getString("maNV"));
            json.put("ngayNhap",json.getString("ngayNhap"));
            json.put("thanhtien",json.getString("thanhtien"));
            json.put("maHD",json.getString("maHD"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui them phieu nhap toi server
   public String guiThemCTPN(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("list",json.getString("list"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui them phieu nhap toi server
   public String guiThemPN(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("maNV",json.getString("maNV"));
            json.put("maNXB",json.getString("maNXB"));
            json.put("ngayNhap",json.getString("ngayNhap"));
            json.put("thanhtien",json.getString("thanhtien"));
            json.put("maPN",json.getString("maPN"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui them khuyen mai toi server
   public String guiThemCTKM(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("list",json.getString("list"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui them khuyen mai toi server
   public String guiThemKM(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("maKM",json.getString("maKM"));
            json.put("tenKM",json.getString("tenKM"));
            json.put("maLoaiKM",json.getString("maLoaiKM"));
            json.put("phanTramGiam",json.getString("phanTramGiam"));
            json.put("ngayBD",json.getString("ngayBD"));
            json.put("ngayKT",json.getString("ngayKT"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui them the loai khuyen mai toi server
   public String guiThemLKM(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaLoaiKM",json.getString("MaLoaiKM"));
            json.put("TenLoaiKM", json.getString("TenLoaiKM"));
            json.put("Phantram",json.getInt("Phantram"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui them the loai cua san pham toi server
   public String guiThemTLSP(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaSP",json.getString("MaSP"));
            json.put("MaTL", json.getString("MaTL"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   //ham gui them doi tuong tac gia toi server
   public String guiThemSP(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaSP",json.getString("MaSP"));
            json.put("TenSP",json.getString("TenSP"));
            json.put("SoTrang",json.getInt("SoTrang"));
            json.put("NgonNgu",json.getString("NgonNgu"));
            json.put("GiaBia",json.getDouble("GiaBia"));
            json.put("AnhBia",json.getString("AnhBia"));
            json.put("SoLuong",json.getInt("SoLuong"));
            json.put("GiaNhap",json.getDouble("GiaNhap"));
            json.put("MaTG",json.getString("MaTG"));
            json.put("Trangthai",json.getInt("Trangthai"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   //gui yeu cau them doi tuong tac gia toi server
   public String guiThemTG(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaTG",json.getString("MaTG"));
            json.put("Hovaten",json.getString("Hovaten"));
            json.put("ButDanh",json.getString("ButDanh"));
            json.put("GioiTinh", json.getString("GioiTinh"));
            json.put("QuocTich",json.getString("QuocTich"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
      //gui yeu cau them doi tuong nxb toi server
   public String guiThemNXB(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaNXB",json.getString("MaNXB"));
            json.put("TenNXB",json.getString("TenNXB"));
            json.put("Diachi",json.getString("Diachi"));
            json.put("Sodienthoai", json.getString("Sodienthoai"));
            json.put("Email",json.getString("Email"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
      //gui yeu cau them doi tuong the loai toi server
   public String guiThemTL(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            json.put("method",yeucau);
            json.put("MaTL",json.getString("MaTL"));
            json.put("TenTL",json.getString("TenTL"));
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //dang nhap
   public String dangNhap(String taikhoan, String matkhau)
   {
          
      
            
            try {
                ClientListener client = new ClientListener(socket);
                Thread thread = new Thread(client);
                JSONObject json = new JSONObject();
                json.put("method","LOGIN");
                json.put("taikhoan",taikhoan);
                json.put("matkhau",matkhau);
                OutputStream output = socket.getOutputStream();
                output.write((json.toString()).getBytes());
                output.flush();
                thread.start();
                thread.join();
                return client.result;
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
         catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
       return "";
   }
   
   public String getNhanVien(String MaTK)
   {
        try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method","GETNV");
            json.put("MaTK",MaTK);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   public String getVaiTro(String MaVT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method","GETVT");
            json.put("MaVT",MaVT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //thuc thi yeu cau lay danh sach
   public String yeucau(String yeucau)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham gui yeu cau lay danh sach
   public String getList(String yeucau)
   {
       switch (yeucau){

            case "ListTacGia":
               return yeucau("ListTacGia");
            case "ListSanPham":
               return yeucau("ListSanPham");
            case "ListNhaXuatBan":
                return yeucau("ListNhaXuatBan");
            case "ListTheLoai":
                return yeucau("ListTheLoai");
            case "ListKhuyenMai":
                return yeucau("ListKhuyenMai");
            case "ListLoaiKhuyenMai":
                return yeucau("ListLoaiKhuyenMai");
            case "ListChiTietKhuyenMai":
                return yeucau("ListChiTietKhuyenMai");
            case "ListPhieuNhap":
                return yeucau("ListPhieuNhap");
            case "ListCTPhieuNhap":
                return yeucau("ListCTPhieuNhap");
            case "ListNhanVien":
                return yeucau("ListNhanVien");
            case "ListTaiKhoan":
                return yeucau("ListTaiKhoan");
            case "ListHoaDon":
                return yeucau("ListHoaDon");
            case "ListCTHD":
                return yeucau("ListCTHD");
            case "ListVaiTro":
                return yeucau("ListVaiTro");
               
       }
       return "";
   }
   
   //lay mot doi tuong
   public String getDoiTuong(String doituong,String maDT)
   {
      switch(doituong){
            case "TacGia":
                return xuLiGetDoiTuong("TacGia", maDT);
            case "NhaXuatBan":
                return xuLiGetNXB("NhaXuatBan", maDT);
            case "TheLoai":
                return xuLiGetTheLoai("TheLoai", maDT);
            case "SanPham":
                return xuLiGetSanPham("SanPham",maDT);
            case "AnhBia":
                return xuLiGetAnhBia("AnhBia",maDT);
            case "HoaDon":
                return xuLiGetHoaDon("HoaDon", maDT);
            case "TaiKhoan":
                return xuLiGetTK("TaiKhoan", maDT);
            case "NhanVien":
                return xuLiGetNV("NhanVien", maDT);
                
      }
       return "";
       
   }
   
    public String xuLiGetNV(String yeucau, String maDT)
      {
          try {
              ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaNV",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
          }
          catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
      }
          return "";
      }
   
     public String xuLiGetTK(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaTK",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham chuyen yeu cau lay du lieu sang server
   public String xuLiGetAnhBia(String yeucau, String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaAB",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham chuyen yeu cau lay du lieu sang server
   public String xuLiGetSanPham(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaSP",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //xu li get the loai cua san pham
   public String xuLiGetSachTheLoai(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaSP",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //xu li lay ten the loai cua san pham
   public String xuLiGetTenSachTheLoai(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaSP",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   //ham chuyen yeu cau lay du lieu sang server
   public String xuLiGetDoiTuong(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaTG",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   public String xuLiGetNXB(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaNXB",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }

   public String xuLiGetTheLoai(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaTL",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
   
   public String xuLiGetHoaDon(String yeucau,String maDT)
   {
       try {
            ClientListener client = new ClientListener(socket);
            Thread thread = new Thread(client);
            JSONObject json = new JSONObject();
            json.put("method",yeucau);
            json.put("MaHD",maDT);
            OutputStream output;
            output = socket.getOutputStream();
            output.write((json.toString()).getBytes());
            output.flush();
            thread.start();
            thread.join();
            return client.result;
        } 
        catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       return "";
   }
}
 
