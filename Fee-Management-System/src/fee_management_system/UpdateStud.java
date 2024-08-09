package fee_management_system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateStud extends JFrame implements ActionListener {
    
    JTextField tfemail,tfcourse,tffee,tfpaid,tfphone,tfaddress;
    JButton add, back;
    String studid;

    UpdateStud(String studid) {
        this.studid = studid;
          setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);
        
        JLabel heading = new JLabel("Update Student Detail");
        heading.setBounds(250,20,350,40);
        heading.setFont(new Font("TAHOMA", Font.BOLD,25));
        heading.setForeground(Color.WHITE);
        image.add(heading);
        
      
        
        //add name
        JLabel lblname = new JLabel("Student name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblname.setForeground(Color.WHITE);
        image.add(lblname);
        
        JLabel lbname = new JLabel();
        lbname.setBounds(200, 80, 150, 25);
        image.add(lbname);
        
        //email name
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(400, 80, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblemail.setForeground(Color.WHITE);
        image.add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(500, 80, 150, 25);
        image.add(tfemail);
        
        //dob
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(60, 180, 150, 25);
        lbldob.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbldob.setForeground(Color.WHITE);
        image.add(lbldob);
        
        JLabel lbdob = new JLabel();
        lbdob.setBounds(200, 180, 150, 25);
        image.add(lbdob);
        
         //course 
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(400, 180, 150, 25);
        lblcourse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblcourse.setForeground(Color.WHITE);
        image.add(lblcourse);
        
        tfcourse = new JTextField();
        tfcourse.setBounds(500, 180, 150, 25);
        image.add(tfcourse);
        
         //fee 
        JLabel lblfee = new JLabel("Fee");
        lblfee.setBounds(60, 280, 150, 25);
        lblfee.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblfee.setForeground(Color.WHITE);
        image.add(lblfee);
        
        tffee = new JTextField();
        tffee.setBounds(200, 280, 150, 25);
        image.add(tffee);
        
        //paid 
        JLabel lblpaid = new JLabel("Paid");
        lblpaid.setBounds(400, 280, 150, 25);
        lblpaid.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblpaid.setForeground(Color.WHITE);
        image.add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(500, 280, 150, 25);
        image.add(tfpaid);
        
     
        //Contact No 
        JLabel lblphone = new JLabel("Contact No");
        lblphone.setBounds(60, 380, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblphone.setForeground(Color.WHITE);
        image.add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 380, 150, 25);
        image.add(tfphone);
        
         //address 
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(400, 380, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lbladdress.setForeground(Color.WHITE);
        image.add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(500, 380, 150, 25);
        image.add(tfaddress);
        
        //country  
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(60, 480, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblcountry.setForeground(Color.WHITE);
        image.add(lblcountry);
        
        JLabel lbcountry = new JLabel();
        lbcountry.setBounds(200, 480, 150, 25);
        image.add(lbcountry);
        
         //studid 
        JLabel lblstudid = new JLabel("Student ID");
        lblstudid.setBounds(400, 480, 150, 25);
        lblstudid.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblstudid.setForeground(Color.WHITE);
        image.add(lblstudid);
        
        JLabel lbstuid = new JLabel();
        lbstuid.setBounds(500, 480, 150, 25);
        lbstuid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        image.add(lbstuid);
        
        try {
            Conn c = new Conn();
            String query = "select * from studentd where studid ='"+studid+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                lbname.setText(rs.getString("name"));
                tfemail.setText(rs.getString("email"));
                lbdob.setText(rs.getString("dob"));
                tfcourse.setText(rs.getString("course"));
                tffee.setText(rs.getString("fee"));
                tfpaid.setText(rs.getString("paid"));
                tfphone.setText(rs.getString("phone"));
                tfaddress.setText(rs.getString("address"));
                lbcountry.setText(rs.getString("country"));
                lbstuid.setText(rs.getString("studid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        add = new JButton("Update Details");
        add.setBounds(200,580,150,40);
        add.addActionListener(this);
        image.add(add);
        
        back = new JButton("Back");
        back.setBounds(500,580,150,40);
        back.addActionListener(this);
        image.add(back);
              
        
       
        setSize(800, 700);
        setLocation(300, 20);
        setVisible(true);
   }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String email = tfemail.getText();
            String course = tfcourse.getText();
            String fee = tffee.getText();
            String paid = tfpaid.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
          
            
            
            try {
                Conn conn = new Conn();
                String query = "update studentd set email ='"+email+"',course = '"+course+"', fee = '"+fee+"',paid = '"+paid+"', phone = '"+phone+"', address = '"+address+"'  where studid = '"+studid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
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
        new UpdateStud("");
    }
}
