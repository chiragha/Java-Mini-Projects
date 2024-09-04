
package crm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{
    JButton add,view,update,delete,exit;
  
    
    Main() {
        
       
        setLayout(null);
        
        
         //side image
        Color formColor = new Color(53, 59, 72);
        getContentPane().setBackground(formColor);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/crm.png"));
        Image i2 = i1.getImage().getScaledInstance(280, 280, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(30,30,280,280);
        add(image);
        
        JLabel lblcardno = new JLabel("Customer Relationship Management");
        lblcardno.setBounds(330, 30, 450, 25);
        lblcardno.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblcardno.setForeground(Color.red);
        add(lblcardno);
        
        add = new JButton("Add Customer");
        add.setBounds(380, 100, 180, 35);
        add.addActionListener(this);
        add(add);
        
        view = new JButton("View Customer Details");
        view.setBounds(600, 100, 180, 35);
        view.addActionListener(this);
        add(view);
        
        update = new JButton("Update Customer Details");
        update.setBounds(380, 160, 180, 35);
        update.addActionListener(this);
        add(update);
        
        delete = new JButton("Delete Details");
        delete.setBounds(600, 160, 180, 35);
        delete.addActionListener(this);
        add(delete);
        
       
        
         exit = new JButton("EXIT");
        exit.setBounds(620, 280, 120, 35);
        exit.addActionListener(this);
         exit.setBackground(Color.red);
         exit.setForeground(Color.WHITE);
        add(exit);
        
        
        
        setSize(800,380);
        setLocation(300,50);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         if(ae.getSource()== exit){
             System.exit(0);
         }else if(ae.getSource() == add){
             setVisible(false);
             new AddCustomer();
         }else if(ae.getSource()==view){
             setVisible(false);
             new ShowCustomer();
         }else if(ae.getSource() == update){
             setVisible(false);
             new ShowCustomer();
         }else if(ae.getSource() == delete){
             setVisible(false);
             new Delete();
         }
       
     }    
    
    
    public static void main(String[] args) {
        new Main();
    }
    
}
