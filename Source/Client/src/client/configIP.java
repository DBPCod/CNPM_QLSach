/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Client;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author PC
 */
public class configIP {
    String ip;
    configIP()
    {
        String fileName = "src/client/config.txt";
  
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String dong = line.substring(3);
                ip=dong;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
