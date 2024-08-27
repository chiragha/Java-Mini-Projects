package crud_application;


import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Updatedata extends JFrame implements ActionListener{
    
    
    JTextField tfemail,tffee,tfpaid,tfphone,tfaddress,tfcountry;
    JLabel tfname,lblstuid,lbcourse;
    JDateChooser dcdob;
    JButton add, update,delete;
    String studid;

   Updatedata(String studid){
       this.studid = studid;
       
        setLayout(null);

        JLabel heading = new JLabel("Update Student Detail");
        heading.setBounds(250,20,350,40);
        heading.setFont(new Font("TAHOMA", Font.BOLD,25));
        heading.setForeground(Color.BLACK);
        add(heading);
        
      
        
        //add name
        JLabel lblname = new JLabel("Student name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(200, 80, 150, 25);
        add(tfname);
        
        //email name
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(400, 80, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblemail.setForeground(Color.BLACK);
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(500, 80, 150, 25);
        add(tfemail);
        
        //dob
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(60, 140, 150, 25);
        lbldob.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbldob.setForeground(Color.BLACK);
        add(lbldob);
        
         JLabel lbdob = new JLabel();
        lbdob.setBounds(200, 140, 150, 25);
        add(lbdob);
        
         //course 
       
          //course
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(400, 140, 150, 25);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);
        
        lbcourse = new JLabel();
        lbcourse.setBounds(500, 140, 150, 25);
        add(lbcourse);
        
         //fee 
        JLabel lblfee = new JLabel("Fee");
        lblfee.setBounds(60, 200, 150, 25);
        lblfee.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblfee.setForeground(Color.BLACK);
        add(lblfee);
        
        tffee = new JTextField();
        tffee.setBounds(200, 200, 150, 25);
        add(tffee);
        
        //paid 
        JLabel lblpaid = new JLabel("Paid");
        lblpaid.setBounds(400, 200, 150, 25);
        lblpaid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblpaid.setForeground(Color.BLACK);
        add(lblpaid);
        
        tfpaid = new JTextField();
        tfpaid.setBounds(500, 200, 150, 25);
        add(tfpaid);
        
     
        //Contact No 
        JLabel lblphone = new JLabel("Contact No");
        lblphone.setBounds(60, 260, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblphone.setForeground(Color.BLACK);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(200, 260, 150, 25);
        add(tfphone);
        
         //address 
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(400, 260, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbladdress.setForeground(Color.BLACK);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(500, 260, 150, 25);
        add(tfaddress);
        
        //country  
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(60, 320, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblcountry.setForeground(Color.BLACK);
       add(lblcountry);
        
        JLabel lbcountry = new JLabel();
        lbcountry.setBounds(200, 320, 150, 25);
        add(lbcountry);
        
         //studid 
        JLabel lblstudid = new JLabel("Student ID");
        lblstudid.setBounds(400, 320, 150, 25);
        lblstudid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblstudid.setForeground(Color.BLACK);
        add(lblstudid);
        
        
        JLabel lbstuid = new JLabel();
        lbstuid.setBounds(500, 320, 150, 25);
        lbstuid.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(lbstuid);
        
        
         try {
            Conn c = new Conn();
            String query = "select * from adddata where studid ='"+studid+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfemail.setText(rs.getString("email"));
                lbdob.setText(rs.getString("dob"));
                lbcourse.setText(rs.getString("course"));
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
        add.setBounds(320,400,150,40);
        add.addActionListener(this);
        add(add);
        
              
        
       
        setSize(800, 520);
        setLocation(300, 20);
        setVisible(true);
   }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
           
            String email = tfemail.getText();
//            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
//            String course = lbcourse.getText();
            String fee = tffee.getText();
            String paid = tfpaid.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
//            String country = tfcountry.getText();
//            String studid = lblstuid.getText();
            
            
            try {
                
                String query = "update adddata set email='"+email+"', fee='"+fee+"',paid='"+paid+"',phone='"+phone+"',address='"+address+"' where studid = '"+studid+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
//                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
             
        }else{
            setVisible(false);
//           
        }
         }
    public static void main(String[] args) {
        new Updatedata("");
    }
}
