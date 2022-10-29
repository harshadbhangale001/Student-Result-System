/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Project.Compress;
import Project.Decompress;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dipak
 */
public class View extends JFrame implements ActionListener{

    JButton compressButton;
    JButton decompressButton;
    View(){
        //this.setDefaultCloseOperation(Jframe.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        compressButton = new JButton("Select a file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20 , 100 , 200 , 30);
        decompressButton = new JButton("Select a file to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250 , 100 , 200 , 30);
        this.setLocationRelativeTo(null);
        this.add(compressButton);
        this.add(decompressButton);
        
        this.setSize(500 , 200);
        this.getContentPane().setBackground(Color.red);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == APPROVE_OPTION ){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    Compress.method(file);
                    JOptionPane.showMessageDialog(null , "Compression Successful");      
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
        
         if(e.getSource() == decompressButton){
             JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            
            if(response == APPROVE_OPTION ){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);

                try{
                    Decompress.method(file);
                    JOptionPane.showMessageDialog(null , "Decompression Successful");      
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
         }

    }
    public static void main(String args[]){
        View view = new View();
        view.setVisible(true);
    }
  
}
