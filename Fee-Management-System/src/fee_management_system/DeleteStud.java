package fee_management_system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.*;


public class DeleteStud extends JFrame implements ActionListener{
     Choice cStudid;
     JButton delete, back;
    DeleteStud() {
        
        setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.png"));
        Image i2 = i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 500, 500);
        add(image);
        
        JLabel lblstudid = new JLabel("Student ID");
        lblstudid.setBounds(50,50,80,30);
        image.add(lblstudid);
        
        cStudid = new Choice();
        cStudid.setBounds(130, 50, 150, 20);
        image.add(cStudid);
        
        try {
            Conn c = new Conn();
            String query = "select * from studentd";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                cStudid.add(rs.getString("studid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,80,30);
        image.add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,80,30);
        image.add(lblname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,80,30);
        image.add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,80,30);
        image.add(lblphone);
        
         JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,80,30);
        image.add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,100,30);
        image.add(lblemail);
        
        
         try {
            Conn c = new Conn();
            String query = "select * from studentd where studid = '"+cStudid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblemail.setText(rs.getString("email"));
                lblphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
         
         cStudid.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent ie){
                 
        
         try {
            Conn c = new Conn();
            String query = "select * from studentd where studid = '"+cStudid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblemail.setText(rs.getString("email"));
                lblphone.setText(rs.getString("phone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         }
             
         });
         
         delete = new JButton("Delete");
         delete.setBounds(80,300,100,30);
         delete.addActionListener(this);
         image.add(delete);
         
         back = new JButton("Back");
         back.setBounds(230,300,100,30);
         back.addActionListener(this);
         image.add(back);
        
        setSize(500,500);
        setLocation(300,100);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()== delete){
            try {
                Conn c = new Conn();
                String query = "delete from studentd where studid = '"+cStudid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Student Information Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
       new DeleteStud();
    }
}
