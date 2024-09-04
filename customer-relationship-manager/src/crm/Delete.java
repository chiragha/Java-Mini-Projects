
package crm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;


public class Delete extends JFrame implements ActionListener{
    
    Choice caadhar;
    JButton delete;

    Delete() {
        
         setLayout(null);
         
         
        JLabel lablaadhar = new JLabel("Aadhar");
        lablaadhar.setBounds(50, 30, 100, 30);
        lablaadhar.setFont(new Font("Tahoma", Font.BOLD, 15));
        lablaadhar.setForeground(Color.BLACK);
        
        caadhar = new Choice();
        caadhar.setBounds(150, 30, 200, 30);
        add(caadhar);
        
        
        try {
            Conn c = new Conn();
            String query = "select * from customer";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                caadhar.add((rs.getString("aadhar")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        
         //add name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        JLabel  tfname = new JLabel();
        tfname.setBounds(200, 80, 150, 25);
        tfname.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfname);
        
        //email name
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(400, 80, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnationality.setForeground(Color.BLACK);
        add(lblnationality);
        
        JLabel tfnationality = new JLabel();
        tfnationality.setBounds(500, 80, 150, 25);
        tfnationality.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfnationality);
        
        //dob
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 140, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblaadhar.setForeground(Color.BLACK);
        add(lblaadhar);
        
         JLabel tfaadhar = new JLabel();
        tfaadhar.setBounds(200, 140, 150, 25);
        tfaadhar.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(400, 140, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbladdress);
        
        JLabel tfaddress = new JLabel();
        tfaddress.setBounds(500, 140, 150, 25);
        tfaddress.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfaddress);
        
         //fee 
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 200, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblgender.setForeground(Color.BLACK);
        add(lblgender);
        
        JLabel tfgender = new JLabel();
        tfgender.setBounds(200, 200, 150, 25);
        tfgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(tfgender);
        
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
      

        
          try {
            Conn c = new Conn();
            String query = "select * from customer where aadhar = '"+caadhar.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaadhar.setText(rs.getString("aadhar"));
                tfaddress.setText(rs.getString("address"));
                tfgender.setText(rs.getString("gender"));
                tfphone.setText(rs.getString("phone"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
            caadhar.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                
                 try {
            Conn c = new Conn();
            String query = "select * from customer where aadhar = '"+caadhar.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaadhar.setText(rs.getString("aadhar"));
                tfaddress.setText(rs.getString("address"));
                tfgender.setText(rs.getString("gender"));
                tfphone.setText(rs.getString("phone"));
               
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
                
                String query = "delete from customer where aadhar = '"+caadhar.getSelectedItem()+"'";
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Details Deleted Successfully");
                setVisible(false);
               new ShowCustomer();
            } catch (Exception e) {
                e.printStackTrace();
            }
             
        }else{
            setVisible(false);
            new AddCustomer();
//           
        }
         }
    
    public static void main(String[] args) {
        new Delete();
    }
  
}
