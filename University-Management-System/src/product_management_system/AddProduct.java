
package product_management_system;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class AddProduct extends JFrame implements ActionListener{
    
    JTextField tfpid,tfpname,tfdesc,tfslvl,tfnofo,tfcost,tfdis;
    JComboBox cbcomname;
    JLabel labelpid;
    JButton save, exit, viedetail;
    Random ran = new Random();
    long tot4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
   
    AddProduct() {
        
         setLayout(null);
         
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Product_Management_System/icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,400);
        add(image);
        
        
        JLabel heading = new JLabel("ADD PRODUCT");
        heading.setBounds(320, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 35));
        heading.setForeground(Color.RED);
        image.add(heading);
        
        //add product details
        
        JLabel lblpID = new JLabel("Product ID:");
        lblpID.setBounds(60, 80, 150, 25);
        lblpID.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblpID.setForeground(Color.BLACK);
        image.add(lblpID);
        
        labelpid = new JLabel(""+tot4);
        labelpid.setBounds(220, 80, 150, 25);
        labelpid.setFont(new Font("Tahoma", Font.BOLD, 15));
        image.add(labelpid);
        
        
        JLabel lblpname = new JLabel("Product Name:");
        lblpname.setBounds(500, 80, 150, 25);
        lblpname.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblpname);
        
        tfpname = new JTextField();
        tfpname.setBounds(660, 80, 150, 25);
        image.add(tfpname);
        
       //////////////////////////////////////////////////////
        
        JLabel head = new JLabel("Product Available ");
        head.setBounds(60, 120, 250, 25);
        head.setFont(new Font("Tahoma", Font.BOLD, 20));
        head.setForeground(Color.RED);
        image.add(head);
        
        
        
        JLabel lblslvl = new JLabel("Stock Level");
        lblslvl.setBounds(500, 120, 150, 25);
        lblslvl.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblslvl);
        
        tfslvl = new JTextField();
        tfslvl.setBounds(660, 120, 150, 25);
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
        lblnofo.setBounds(500, 160, 150, 25);
        lblnofo.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblnofo);
         
        tfnofo = new JTextField();
        tfnofo.setBounds(660, 160, 150, 25);
        image.add(tfnofo);
        
        ////////////////////////////////////////////
        JLabel compname = new JLabel("Company Name:");
        compname.setBounds(60, 200, 150, 25);
        compname.setFont(new Font("Tahoma", Font.BOLD, 16));
        compname.setBackground(Color.WHITE);
        image.add(compname);
         
        String compnam[] = {"Britania", "Sunsilk", "Ponds", "Parle-G", "Joy", "Dettol","Haldiram","Horlicks"};
        cbcomname = new JComboBox(compnam);
        cbcomname.setBounds(220, 200, 150, 25);
        image.add(cbcomname);
        
        JLabel lbldis = new JLabel("Discount:");
        lbldis.setBounds(500, 200, 150, 25);
        lbldis.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lbldis);
         
        tfdis = new JTextField();
        tfdis.setBounds(660, 200, 150, 25);
        image.add(tfdis);
        
        
        
        ////////////////////////////////////
        
        save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220, 260, 150, 40);
        save.addActionListener(this);
        image.add(save);
        
        exit = new JButton("Exit");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(400, 260, 150, 40);
        exit.addActionListener(this);
        image.add(exit);
        
        viedetail = new JButton("View Details");
        viedetail.setBackground(Color.BLACK);
        viedetail.setForeground(Color.WHITE);
        viedetail.setBounds(580, 260, 150, 40);
        viedetail.addActionListener(this);
        image.add(viedetail);
       
        setSize(900,400);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == save){
            
            String proid = labelpid.getText();
            String pname = tfpname.getText();
            String stock = tfslvl.getText();
            String cost = tfcost.getText();
            String noorder = tfnofo.getText();
            String cname = (String) cbcomname.getSelectedItem();
            String discount = tfdis.getText();
            
            try {
                
               String query = "insert into product values( '"+proid+"','"+pname+"','"+stock+"','"+cost+"','"+noorder+"','"+cname+"','"+discount+"')";
                  
                  Conn con = new Conn();
                  con.s.executeUpdate(query);
                   
                  JOptionPane.showMessageDialog(null, "Product Details Added Successfully");
                  setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == exit){
            setVisible(false);
            
        }else{
            new ViewDetail();
            setVisible(false);
        }
    
    }
    
    
    public static void main(String[] args) {
        new AddProduct();
    }

    
}
