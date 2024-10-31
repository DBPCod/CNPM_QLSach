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
    
    //ham xu li yeu cau sua doi tuong
    public String suaDT(String data)
    {
        JSONObject json = new JSONObject(data);
        String yeucau = json.getString("method");
        switch(yeucau){
            case "UPDATETG":
                return guiSuaTG(data);
 
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
    
//ham xu li yeu cau them doi tuong
   public String themDT(String data)
   {
       JSONObject json = new JSONObject(data);
       String yeucau = json.getString("method");
       switch (yeucau){
           case "PUTTG":
               guiThemTG(data);
               return "thanhcong";
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
       }
       return "";
   }
   
   
   //lay mot doi tuong
   public String getDoiTuong(String doituong,String maDT)
   {
      switch(doituong){
            case "TacGia":
              return xuLiGetDoiTuong("TacGia", maDT);
              
      }
       return"";
       
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
}
 
