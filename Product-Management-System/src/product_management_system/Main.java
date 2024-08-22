
package product_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{
     JButton view, add, close, update;
  

     Main() {
         
        setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Product_Management_System/icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(650, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,650,450);
        add(image);
        
        
        add = new JButton("Add Products");
        add.setBounds(210, 50, 220, 60);
        add.setBackground(Color.red);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma", Font.BOLD, 20));
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Products");
        view.setBounds(210, 140, 220, 60);
        view.setBackground(Color.GREEN);
        view.setForeground(Color.WHITE);
        view.setFont(new Font("Tahoma", Font.BOLD, 20));
        view.addActionListener(this);
        image.add(view);
        
       
        update = new JButton("Update Products");
        update.setBounds(210, 230, 220, 60);
        update.setBackground(Color.BLUE);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma", Font.BOLD, 20));
        update.addActionListener(this);
        image.add(update);
        
        
        
        close = new JButton("Close");
        close.setBounds(260, 320, 100, 40);
        close.setBackground(Color.BLACK);
        close.setForeground(Color.WHITE);
        close.setFont(new Font("Tahoma", Font.BOLD, 20));
        close.addActionListener(this);
        image.add(close);
         
        setSize(650,450);
        setLocation(400,180);
        setVisible(true);
        
    }
     
     public void actionPerformed(ActionEvent ae){
         
         if(ae.getSource()== close){
             setVisible(false);
         }else if(ae.getSource() == add){
             setVisible(false);
             new AddProduct();
         }else if(ae.getSource() == view){
             setVisible(false);
             new ViewDetail();
         }else{
             setVisible(false);
             new UpdateProduct();
         }
         
     }
    
    public static void main(String[] args) {
        new Main();
    }
    
}
