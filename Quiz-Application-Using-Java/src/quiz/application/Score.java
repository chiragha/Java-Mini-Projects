
package quiz.application;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Score extends JFrame implements ActionListener{

    Score(String name, int score) {
         setBounds(290,120,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         
        ImageIcon img1 = new ImageIcon(ClassLoader.getSystemResource("icons/sc.jpg"));
        Image img2 = img1.getImage().getScaledInstance(300, 250, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,100,300,250);
        add(image);
         
        
        JLabel heading = new JLabel("Thankyou " + name + " for Playing Mini Quiz");
        heading.setBounds(220,30,700,30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        heading.setForeground(Color.red);
        add(heading);
        
        JLabel lblscore = new JLabel("Your Score is " + score);
        lblscore.setBounds(490,200,300,30);
        lblscore.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblscore.setForeground(Color.red);
        add(lblscore);
        
        
        JButton submit = new JButton("Play Again");
        submit.setBounds(520,270,120,30);
        submit.setFont(new Font("Tahoma",Font.PLAIN,16));
        submit.setBackground(new Color(30,144,254));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    
    
    public static void main(String[] args) {
        new Score("User",0);
    }
}
