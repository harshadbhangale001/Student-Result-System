/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.io.*;
import java.util.zip.GZIPOutputStream;


/**
 *
 * @author dipak
 */
public class Compress {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        System.out.print(fileDirectory);
        
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/compressed.gz");
        GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
        
        byte[] buffer = new byte[1024];
        int len ;
        while((len = fis.read(buffer)) != -1){
            gzipOS.write(buffer , 0 , len);
        }
        gzipOS.close();
        fos.close();
        fis.close();
    }
    
    public static void main(String args[]) throws IOException{
        File path = new File("C:\\Users\\dipak\\Desktop\\test.txt");
        method(path);
    }
}
