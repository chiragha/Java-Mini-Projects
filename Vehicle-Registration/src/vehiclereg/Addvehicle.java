package vehiclereg;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Addvehicle extends JFrame implements ActionListener{

      JTextField tfname, tfmname, tfcolor, tfcost;
      JLabel vehicleid;
      JDateChooser dcmy;
      JComboBox cbtype;
      JButton submit, details,exit;
      
      Random ran = new Random();
      long first4 = Math.abs((ran.nextLong() %9000L) + 1000L);
      
      
      Addvehicle()  {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/v.png"));
        Image i2 = i1.getImage().getScaledInstance(600, 200, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(130, 0, 600, 200);
        add(lblimage);
        
        JLabel heading = new JLabel("ADD VEHICLE DETAILS");
        heading.setBounds(280, 210, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        
        
         //id
        JLabel lblid = new JLabel("Vehicle-ID");
        lblid.setBounds(60, 290, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblid);
        
        vehicleid = new JLabel("BU-" + first4);
        vehicleid.setBounds(200, 290, 150, 25);
        vehicleid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(vehicleid);
        
//        name
        JLabel lblname = new JLabel("VEHICLE-NAME");
        lblname.setBounds(500, 290, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(700, 290, 150, 25);
        add(tfname);
        
        //model name
        JLabel lblmname = new JLabel("MODEL");
        lblmname.setBounds(60, 340, 150, 25);
        lblmname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblmname);
        
        tfmname = new JTextField();
        tfmname.setBounds(200, 340, 150, 25);
        add(tfmname);
        
      
      
        
        //year
        JLabel lblmy = new JLabel("MANUFACTURE-YEAR");
        lblmy.setBounds(500, 340, 200, 25);
        lblmy.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblmy);
        
        dcmy = new JDateChooser();
        dcmy.setBounds(700, 340, 150, 25);
        add(dcmy);
        
        
        //color
        JLabel lblcolor = new JLabel("COLOR");
        lblcolor.setBounds(60, 390, 150, 25);
        lblcolor.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcolor);
        
        tfcolor = new JTextField();
        tfcolor.setBounds(200, 390, 150, 25);
        add(tfcolor);
        
         //cost
        JLabel lblcost = new JLabel("COST");
        lblcost.setBounds(500, 390, 150, 25);
        lblcost.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcost);
        
        tfcost = new JTextField();
        tfcost.setBounds(700, 390, 150, 25);
        add(tfcost);
        
       
        
         //type
        JLabel lbltype = new JLabel("Fuel-Type");
        lbltype.setBounds(60, 440, 150, 25);
        lbltype.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbltype);
        
        String type[] = {"Petrol", "Diesel"};
        cbtype = new JComboBox(type);
        cbtype.setBounds(200, 440, 150, 25);
        add(cbtype);
        
        
        
        //submit button
         submit = new JButton("Add");
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,500,150,35);
        submit.addActionListener(this);
        add(submit);
        
        //view details
         details = new JButton("Details");
        details.setBackground(Color.BLUE);
        details.setForeground(Color.WHITE);
        details.setBounds(380,500,150,35);
        details.addActionListener(this);
        add(details);
        
         //EXIT
         exit = new JButton("EXIT");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setBounds(560,500,150,35);
        exit.addActionListener(this);
        add(exit);
       
        
        setSize(900,600);
        setLocation(250,50);
        setVisible(true);


        }
 
      public void actionPerformed(ActionEvent ae){
          
          if(ae.getSource() == submit){
            
              String vid = vehicleid.getText();
              String name = tfname.getText();
              String mname = tfmname.getText();
              String manuf = ((JTextField)dcmy.getDateEditor().getUiComponent()).getText();
              String color = tfcolor.getText();
              String cost = tfcost.getText();
              String type = (String) cbtype.getSelectedItem();
              
              
              try {
             Conn conn = new Conn();
             String query = "insert into vehicle values('"+vid+"','"+name+"','"+mname+"','"+manuf+"','"+color+"','"+cost+"','"+type+"')";
             conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Vehicle Details Added sucessfully");
             setVisible(false);
              } catch (Exception e) {
                  e.printStackTrace();
              }
            
          }else{
              setVisible(false);
              new vinfo();
          }
      }
      
      public static void main(String[] args) {
        
          new Addvehicle();
      }
}
 