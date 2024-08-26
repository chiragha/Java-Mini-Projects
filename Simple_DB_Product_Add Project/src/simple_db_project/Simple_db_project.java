
package simple_db_project;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Simple_db_project extends JFrame implements ActionListener{
    
    JTextField txtpname,txtprice,txtqty,txtdis,txttot;
    JButton save, exit;
    
    
    public Simple_db_project(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("ADD PRODUCT DETAILS");
        heading.setBounds(80, 10, 400, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.RED);
        add(heading);
        
        JLabel lblname = new JLabel("Product Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        txtpname = new JTextField();
        txtpname.setBounds(220, 80, 150, 25);
        add(txtpname);
        
        
        JLabel lblqty = new JLabel("Quantity");
        lblqty.setBounds(60, 130, 150, 25);
        lblqty.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblqty);
        
        txtqty = new JTextField();
        txtqty.setBounds(220, 130, 150, 25);
        add(txtqty);
        
       
        
        JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(60, 180, 150, 25);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblprice);
        
        txtprice = new JTextField();
        txtprice.setBounds(220, 180, 150, 25);
        add(txtprice);
        
        JLabel lbldis = new JLabel("Discount");
        lbldis.setBounds(60, 230, 150, 25);
        lbldis.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldis);
        
        txtdis = new JTextField();
        txtdis.setBounds(220, 230, 150, 25);
        add(txtdis);
        
        JLabel lbltot = new JLabel("Total");
        lbltot.setBounds(60, 280, 150, 25);
        lbltot.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltot);
        
        txttot = new JTextField();
        txttot.setBounds(220, 280, 150, 25);
        add(txttot);
       
        
        save = new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(60, 330, 150, 30);
        save.addActionListener(this);
        add(save);
        
        exit = new JButton("EXIT");
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setBounds(220, 330, 150, 30);
        exit.addActionListener(this);
        add(exit);
        
        
        
        setSize(500,420);
        setLocation(300,150);
        setVisible(true);
    }
    
     Double total, price, discount;
         int qty;
     public void actionPerformed(ActionEvent ae){
         
        if(ae.getSource()== save){
             String pname = txtpname.getText();
          price =  Double.parseDouble(txtprice.getText());
          qty = Integer.parseInt(txtqty.getText());
          discount = Double.parseDouble(txtdis.getText());
         
        
         total= (price*qty)*discount/100;
         
         txttot.setText(Double.toString(total));
       
                
         try {
             Conn conn = new Conn();
             String query = "insert into product values('"+pname+"','"+price+"','"+qty+"','"+discount+"','"+total+"')";
             conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Product Details Added sucessfully");
             setVisible(false);
             
         } catch (Exception e) {
             e.printStackTrace();
         }
        }else{
            System.exit(0);
        }
     }
    
    public static void main(String[] args) {
        
        new Simple_db_project();
    }
    
}
