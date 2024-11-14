/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import org.json.JSONObject;

/**
 *
 * @author PC
 */
public class ClientListener implements Runnable{
    private Socket socket;
    private InputStream input;
    public String result;
     public volatile boolean running = true;
    public ClientListener(Socket socket)
    {
        try{
           this.socket = socket;
           this.input=socket.getInputStream();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {
        try{
        
            byte[] buffer = new byte[1024 * 1024];
            int bytesRead;
            while(running && (bytesRead = input.read(buffer)) != -1)
            {
                String message = new String(buffer, 0, bytesRead);
                System.out.println(message);
                JSONObject json = new JSONObject(message);
                if(json.getString("Trangthai").equals("true") || json.getString("Trangthai").equals("false"))
                {
                    
                        this.result=message;
                        System.out.println(message);
                         stop();
//                        if(message.equals("END"))
//                        {
//                           
//                        }
                    
                }
            }
         
         
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void stop() {
        this.running = false;
    }
    
//    public int xuli(String data)
//    {
//        JSONObject jsonObject = new JSONObject(data);
//        
//        String trangthai = jsonObject.getString("method");
//        String ketqua = jsonObject.getString("ketqua");
//        if(ketqua.equals("true"))
//        {
//            this.result=ketqua;
//            return 1;
//            
//        }
//        this.result=ketqua;
//        return 0;
//    }
}
