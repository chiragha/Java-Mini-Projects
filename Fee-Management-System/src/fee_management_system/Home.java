package fee_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame implements ActionListener{
    
    JButton add, view,update,delete,logout;
    Home() {
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 400);
        add(image);
        
        JLabel heading = new JLabel("Fee Management System");
        heading.setBounds(250,20,350,40);
        heading.setFont(new Font("TAHOMA", Font.BOLD,25));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        
        
        
        add = new JButton("Add Student");
        add.setBounds(200,80,150,40);
        add.addActionListener(this);
        image.add(add);
        
        view = new JButton("View Students");
        view.setBounds(450,80,150,40);
        view.addActionListener(this);
        image.add(view);
        
        update = new JButton("Update Student");
        update.setBounds(200,150,150,40);
        update.addActionListener(this);
        image.add(update);
        
        delete = new JButton("Delete Student");
        delete.setBounds(450,150,150,40);
        delete.addActionListener(this);
        image.add(delete);
        
        logout = new JButton("LogOut");
        logout.setBounds(320,230,150,40);
        logout.addActionListener(this);
        image.add(logout);
        
        setSize(800, 400);
        setLocation(400, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            setVisible(false);
            new AddStud();
            
        }else if(ae.getSource()== view){
            setVisible(false);
            new ViewStud();
        }else if(ae.getSource() == update){
            setVisible(false);
            new ViewStud();
            
        }else if(ae.getSource() == delete){
            setVisible(false);
            new DeleteStud();
        }else if(ae.getSource() == logout){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Home();
    }
}
