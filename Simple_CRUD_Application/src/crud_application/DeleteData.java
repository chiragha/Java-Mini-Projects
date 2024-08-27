
package crud_application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;


public class DeleteData extends JFrame implements ActionListener{
    
    Choice cstudid;
    JButton delete;

    DeleteData() {
        
         setLayout(null);
         
         
        JLabel lblstudid = new JLabel("Student ID");
        lblstudid.setBounds(50, 30, 100, 30);
        lblstudid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblstudid.setForeground(Color.BLACK);
        
        cstudid = new Choice();
        cstudid.setBounds(150, 30, 200, 30);
        add(cstudid);
        
        
        try {
            Conn c = new Conn();
            String query = "select * from adddata";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                cstudid.add((rs.getString("studid")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
         //add name
        JLabel lblname = new JLabel("Student name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        JLabel  tfname = new JLabel();
        tfname.setBounds(200, 80, 150, 25);
        tfname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfname);
        
        //email name
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(400, 80, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblemail.setForeground(Color.BLACK);
        add(lblemail);
        
        JLabel tfemail = new JLabel();
        tfemail.setBounds(500, 80, 150, 25);
        tfemail.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfemail);
        
        //dob
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(60, 140, 150, 25);
        lbldob.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbldob.setForeground(Color.BLACK);
        add(lbldob);
        
         JLabel lbdob = new JLabel();
        lbdob.setBounds(200, 140, 150, 25);
        lbdob.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbdob);
        
         //course 
       
          //course
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(400, 140, 150, 25);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);
        
        JLabel lbcourse = new JLabel();
        lbcourse.setBounds(500, 140, 150, 25);
        lbcourse.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbcourse);
        
         //fee 
        JLabel lblfee = new JLabel("Fee");
        lblfee.setBounds(60, 200, 150, 25);
        lblfee.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblfee.setForeground(Color.BLACK);
        add(lblfee);
        
        JLabel tffee = new JLabel();
        tffee.setBounds(200, 200, 150, 25);
        tffee.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tffee);
        
        //paid 
        JLabel lblpaid = new JLabel("Paid");
        lblpaid.setBounds(400, 200, 150, 25);
        lblpaid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblpaid.setForeground(Color.BLACK);
        add(lblpaid);
        
        JLabel tfpaid = new JLabel();
        tfpaid.setBounds(500, 200, 150, 25);
        tfpaid.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfpaid);
        
     
        //Contact No 
        JLabel lblphone = new JLabel("Contact No");
        lblphone.setBounds(60, 260, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblphone.setForeground(Color.BLACK);
        add(lblphone);
        
        JLabel tfphone = new JLabel();
        tfphone.setBounds(200, 260, 150, 25);
        tfphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfphone);
        
         //address 
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(400, 260, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 15));
        lbladdress.setForeground(Color.BLACK);
        add(lbladdress);
        
        JLabel tfaddress = new JLabel();
        tfaddress.setBounds(500, 260, 150, 25);
        tfaddress.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfaddress);
        
        //country  
        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(60, 320, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblcountry.setForeground(Color.BLACK);
       add(lblcountry);
        
        JLabel lbcountry = new JLabel();
        lbcountry.setBounds(200, 320, 150, 25);
        lbcountry.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lbcountry);
        
          try {
            Conn c = new Conn();
            String query = "select * from adddata where studid = '"+cstudid.getSelectedItem()+"'";
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
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
            cstudid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                
                 try {
            Conn c = new Conn();
            String query = "select * from adddata where studid = '"+cstudid.getSelectedItem()+"'";
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
               
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
               
            }
            });
       
        delete = new JButton("Delete");
        delete.setBounds(400,320,150,40);
        delete.addActionListener(this);
        add(delete);
       
        setSize(800, 420);
        setLocation(300, 20);
        setVisible(true);
        
    }
    
    
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == delete){
           
            try {  
                Conn con = new Conn();
                
                String query = "delete from adddata where studid = '"+cstudid.getSelectedItem()+"'";
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Details Deleted Successfully");
                setVisible(false);
//                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
             
        }else{
            setVisible(false);
            new AddData();
//           
        }
         }
    
    public static void main(String[] args) {
        new DeleteData();
    }
  
}
