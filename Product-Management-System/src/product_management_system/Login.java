
package product_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
     JButton submit, reset, close;
     JTextField tfusername;
    JPasswordField tfpassword;

    Login(){
          getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Product_Management_System/icons/user.png"));
        Image i2 = i1.getImage().getScaledInstance(160, 160, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(370,10,160,160);
        add(image);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20);
        
         
        lblusername.setForeground(Color.BLACK);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
       
        add(tfusername);
        
        
        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(20, 60, 100, 20);
        
        lblpassword.setForeground(Color.BLACK);
        lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lblpassword);
        
        tfpassword = new JPasswordField();
        tfpassword.setBounds(130, 60, 200, 20);
        add(tfpassword);
        
        submit = new JButton("Submit");
        submit.setBounds(40, 120, 120, 30);
        submit.addActionListener(this);
        add(submit);
        
        reset = new JButton("Reset");
        reset.setBounds(190, 120, 120, 30);
        reset.addActionListener(this);
        add(reset);
       
        
        close = new JButton("Close");
        close.setBounds(120, 160, 120, 30);
        close.addActionListener(this);
        add(close);
        
        setSize(600,250);
        setLocation(500,250);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == close){
            setVisible(false);
        }else if (ae.getSource() == reset){
             tfusername.setText("");
             tfpassword.setText("");
        }else{
            String username = tfusername.getText();
            String password = tfpassword.getText();
            
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Main();
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
     public static void main(String[] args) {
        new Login();
    }
    
}
