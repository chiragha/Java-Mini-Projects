
package quiz.application;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener{
    
    JButton rules,back;
    JTextField tfname;
    
    
    Login(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/quizt.png"));
        JLabel image = new JLabel(img1);
        image.setBounds(0,0,500,500);
        add(image);
        
        
        
        JLabel heading = new JLabel("Mini Quiz");
        heading.setBounds(650,60,300,45);
        heading.setFont(new Font("Tahoma", Font.BOLD, 40));
        heading.setForeground(new Color(30,144,254));
        add(heading);
        
        
         JLabel name = new JLabel("Enter Your Name");
        name.setBounds(670,150,300,20);
        name.setFont(new Font("Tahoma", Font.BOLD, 18));
        name.setForeground(Color.BLACK);
        add(name);
        
        
        tfname = new JTextField();
        tfname.setBounds(610,200,300,25);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(tfname);
        
        rules = new JButton("Rules");
        rules.setBounds(610,270,115,25);
        rules.setBackground(new Color(30,144,254));
        rules.setForeground(Color.WHITE);
        rules.addActionListener(this);
        add(rules);
        
        back = new JButton("Back");
        back.setBounds(800,270,115,25);
        back.setBackground(new Color(30,144,254));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(1000,500);
        setLocation(200, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== rules){
            String name = tfname.getText();
            setVisible(false);
            new Rules_page(name);
        }else if(ae.getSource()== back){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
