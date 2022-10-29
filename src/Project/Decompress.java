/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author dipak
 */
public class Decompress {
    public static void method(File file ) throws IOException {
        String fileDirectory = file.getParent();
        System.out.print(fileDirectory);
        
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory + "/Decompress.txt");
        GZIPInputStream gis = new GZIPInputStream(fis);
        
        byte[] buffer = new byte[1024];
        int len;
        
        while((len = gis.read(buffer)) != -1){
            fos.write(buffer , 0 ,len);
        }
        gis.close();
        fis.close();
        fos.close();
    }
    public static void main(String args[])throws IOException{
        File file = new File("C:\\Users\\dipak\\Desktop\\compressed.gz");
        method(file);
    }
}
