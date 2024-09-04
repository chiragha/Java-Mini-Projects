package crm;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Updatedata extends JFrame implements ActionListener{
    
    
    JTextField tfphone,tfaddress;
    JLabel tfname,tfnationality,tfgender;
    JButton add;
    String aadhar;

   Updatedata(String aadhar){
       this.aadhar = aadhar;
       
        setLayout(null);

        JLabel heading = new JLabel("Update Customer Detail");
        heading.setBounds(250,20,350,40);
        heading.setFont(new Font("TAHOMA", Font.BOLD,25));
        heading.setForeground(Color.WHITE);
        add(heading);
        
         Color formColor = new Color(53, 59, 72);
        getContentPane().setBackground(formColor);
        
        //add name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblname.setForeground(Color.WHITE);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(200, 80, 150, 30);
        tfname.setForeground(Color.WHITE);
        add(tfname);
        
        //nationality name
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(400, 80, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblnationality.setForeground(Color.WHITE);
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(500, 80, 150, 25);
        tfnationality.setForeground(Color.WHITE);
        add(tfnationality);
     
        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(400, 140, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
        lbladdress.setForeground(Color.WHITE);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(500, 140, 150, 25);
        tfaddress.setForeground(Color.BLACK);
        add(tfaddress);
        
        //gender
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 200, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblgender.setForeground(Color.WHITE);
        add(lblgender);
        
        tfgender = new JLabel();
        tfgender.setBounds(200, 200, 150, 25);
        tfgender.setForeground(Color.WHITE);
        add(tfgender);
        
        //paid 
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 200, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblphone.setForeground(Color.WHITE);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(500, 200, 150, 25);
        tfphone.setForeground(Color.BLACK);
        add(tfphone);
        
    
         try {
            Conn c = new Conn();
            String query = "select * from customer where aadhar ='"+aadhar+"'";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()){
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                tfgender.setText(rs.getString("gender"));
                tfphone.setText(rs.getString("phone"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        add = new JButton("Update Details");
        add.setBounds(300,280,150,40);
        add.addActionListener(this);
        add(add);
        
          
        setSize(800, 420);
        setLocation(300, 20);
        setVisible(true);
   }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){

            String phone = tfphone.getText();
            String address = tfaddress.getText();

            
            try {
                
                String query = "update customer set address='"+address+"', phone='"+phone+"' where aadhar = '"+aadhar+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                setVisible(false);
                new ShowCustomer();
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
