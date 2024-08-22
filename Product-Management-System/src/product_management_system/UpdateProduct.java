
package product_management_system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import javax.swing.*;

public class UpdateProduct extends JFrame implements ActionListener{
    
    JTextField tfslvl,tfnofo,tfcost,tfdis;
    JButton update, exit, viedetail;
    Choice cpid;
    JLabel labelpid;
   
 
    UpdateProduct() {
        
        setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Product_Management_System/icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,500);
        add(image);
        
        
        JLabel heading = new JLabel("UPDATE PRODUCT");
        heading.setBounds(320, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        heading.setForeground(Color.RED);
        image.add(heading);
        
        
        JLabel lblpid = new JLabel("Select Product ID");
        lblpid.setBounds(140, 80, 190, 20);
        lblpid.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblpid.setForeground(Color.RED);
        image.add(lblpid);
        
        cpid = new Choice();
        cpid.setBounds(340, 80, 150, 20);
        image.add(cpid);
        
         try {
            Conn c = new Conn();
            ResultSet rs  = c.s.executeQuery("select * from product");
            while(rs.next()){
                cpid.add(rs.getString("proid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
        //product details
        
        JLabel lblpID = new JLabel("Product ID:");
        lblpID.setBounds(60, 120, 150, 25);
        lblpID.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblpID.setForeground(Color.BLACK);
        image.add(lblpID);
        
        labelpid = new JLabel();
        labelpid.setBounds(220, 120, 150, 25);
        labelpid.setFont(new Font("Tahoma", Font.BOLD, 15));
        image.add(labelpid);
      
        JLabel lblpname = new JLabel("Product Name:");
        lblpname.setBounds(500, 120, 150, 25);
        lblpname.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblpname);
        
        JLabel labelpname = new JLabel();
        labelpname.setBounds(660, 120, 150, 25);
        labelpname.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(labelpname);
        
       //////////////////////////////////////////////////////

        
        JLabel lblslvl = new JLabel("Stock Level");
        lblslvl.setBounds(500, 160, 150, 25);
        lblslvl.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblslvl);
        
        tfslvl = new JTextField();
        tfslvl.setBounds(660, 160, 150, 25);
        image.add(tfslvl);
        
        ////////////////////////////////
        
        JLabel lblcost = new JLabel("Cost");
        lblcost.setBounds(60, 160, 150, 25);
        lblcost.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblcost);
        
        tfcost = new JTextField();
        tfcost.setBounds(220, 160, 150, 25);
        image.add(tfcost);
        
        JLabel lblnofo = new JLabel("Number of Order:");
        lblnofo.setBounds(500, 200, 150, 25);
        lblnofo.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblnofo);
         
        tfnofo = new JTextField();
        tfnofo.setBounds(660, 200, 150, 25);
        image.add(tfnofo);
        
        ////////////////////////////////////////////
        JLabel compname = new JLabel("Company Name:");
        compname.setBounds(60, 200, 150, 25);
        compname.setFont(new Font("Tahoma", Font.BOLD, 16));
        compname.setBackground(Color.WHITE);
        image.add(compname);
         
       
        JLabel tfcomname = new JLabel();
        tfcomname.setBounds(220, 200, 150, 25);
        tfcomname.setFont(new Font("Tahoma", Font.BOLD, 18));
        image.add(tfcomname);
        
        
        JLabel head = new JLabel("Product Available ");
        head.setBounds(60, 240, 250, 25);
        head.setFont(new Font("Tahoma", Font.BOLD, 20));
        head.setForeground(Color.RED);
        image.add(head);
        
        JLabel lbldis = new JLabel("Discount:");
        lbldis.setBounds(500, 240, 150, 25);
        lbldis.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lbldis);
         
        tfdis = new JTextField();
        tfdis.setBounds(660, 240, 150, 25);
        image.add(tfdis);
        
        
        //fetch data from database
        
      try {
            Conn c = new Conn();
            String query = "select * from product where proid='"+cpid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelpid.setText(rs.getString("proid"));
                labelpname.setText(rs.getString("pname"));
                tfslvl.setText(rs.getString("stock"));
                tfcost.setText(rs.getString("cost"));
                tfnofo.setText(rs.getString("noorder"));
                tfcomname.setText(rs.getString("cname"));
                tfdis.setText(rs.getString("discount"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
      cpid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
            Conn c = new Conn();
            String query = "select * from product where proid='"+cpid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelpid.setText(rs.getString("proid"));
                labelpname.setText(rs.getString("pname"));
                tfslvl.setText(rs.getString("stock"));
                tfcost.setText(rs.getString("cost"));
                tfnofo.setText(rs.getString("noorder"));
                tfcomname.setText(rs.getString("cname"));
                tfdis.setText(rs.getString("discount"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
            }
        });
        ////////////////////////////////////
        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(200, 340, 150, 40);
        update.addActionListener(this);
        image.add(update);
        
        exit = new JButton("Exit");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(400, 340, 150, 40);
        exit.addActionListener(this);
        image.add(exit);
        
        viedetail = new JButton("View Details");
        viedetail.setBackground(Color.BLACK);
        viedetail.setForeground(Color.WHITE);
        viedetail.setBounds(580, 340, 150, 40);
        viedetail.addActionListener(this);
        image.add(viedetail);
       
        setSize(900,500);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == update){
            String proid = labelpid.getText();
            String stock = tfslvl.getText();
            String cost = tfcost.getText();
            String noorder = tfnofo.getText();
            String discount = tfdis.getText();
            
            
         try {
                String query = "update product set proid='"+proid+"', stock='"+stock+"', cost='"+cost+"', noorder='"+noorder+"', discount='"+discount+"' where proid='"+proid+"'";
                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "product Details Updated Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if(ae.getSource() == exit) {
            setVisible(false);
        }else{
            setVisible(false);
            new ViewDetail();
        }
    }
    
    public static void main(String[] args) {
        new UpdateProduct();
    }

    
}
