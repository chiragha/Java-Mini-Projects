package crud_application;


import java.awt.*;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.*;

public class AddData extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tfemail,tffee,tfpaid,tfphone,tfaddress,tfcountry;
    JLabel lblstuid;
    JDateChooser dcdob;
    JButton add, update,delete;
    JComboBox cbcourse;

   AddData(){
       
        setLayout(null);

        JLabel heading = new JLabel("Add Student Detail");
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
        
        tfname = new JTextField();
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
        
        dcdob = new JDateChooser();
        dcdob.setBounds(200, 140, 150, 25);
        add(dcdob);
        
         //course 
       
          //course
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(400, 140, 150, 25);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);
        
        String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(500, 140, 150, 25);
        add(cbcourse);
        
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
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 320, 150, 25);
        add(tfcountry);
        
         //studid 
        JLabel lblstudid = new JLabel("Student ID");
        lblstudid.setBounds(400, 320, 150, 25);
        lblstudid.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblstudid.setForeground(Color.BLACK);
        add(lblstudid);
        
        lblstuid = new JLabel("" + number);
        lblstuid.setBounds(500, 320, 150, 25);
        lblstuid.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblstuid);
        
        
        add = new JButton("Add Details");
        add.setBounds(120,400,150,40);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("Update");
        update.setBounds(320,400,150,40);
        update.addActionListener(this);
        add(update);
        
        delete = new JButton("Delete");
        delete.setBounds(520,400,150,40);
        delete.addActionListener(this);
        add(delete);
              
        
       
        setSize(800, 520);
        setLocation(300, 20);
        setVisible(true);
   }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
             
            String name = tfname.getText();
            String email = tfemail.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String course = (String) cbcourse.getSelectedItem();
            String fee = tffee.getText();
            String paid = tfpaid.getText();
            String phone = tfphone.getText();
            String address = tfaddress.getText();
            String country = tfcountry.getText();
            String studid = lblstuid.getText();
            
            
            try {
                
                String query = "insert into adddata values('"+name+"','"+email+"','"+dob+"','"+course+"','"+fee+"','"+paid+"','"+phone+"','"+address+"','"+country+"','"+studid+"')";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Successfully");
                setVisible(false);
//                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
             
        }else if(ae.getSource() == update){
            setVisible(false);
            new Viewdata();
        }else{
            setVisible(false);
        }
         }
    public static void main(String[] args) {
        new AddData();
    }
}
