/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class server {
    private static final int PORT = 8000;
    private ArrayList<ClientHandle> clients = new ArrayList<>();
    
    public void startServer()
    {
        try{
            //websocket
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("Server bat dau dang chay");
            
            //clients ket noi toi server
            while(true)
            {
                Socket clientSocket = server.accept();
                System.out.println("client moi vua ket noi: " + clientSocket.getInetAddress());
                ClientHandle clienthandle = new ClientHandle(clientSocket,System.currentTimeMillis()+ "",this);
                clients.add(clienthandle);
                Thread thread = new Thread(clienthandle);
                thread.start();
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public void broadcastMessage(String message)
    {
        for(ClientHandle client : clients)
        {
            client.sendMessage(message);
        }
    }
}
