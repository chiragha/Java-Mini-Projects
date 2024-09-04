
package crm;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JTextField tfname,tfnationality,tfaadhar,tfaddress,tfphone;
    JRadioButton rbmale, rbfemale;
    
    
    public AddCustomer(){
//        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Color formColor = new Color(53, 59, 72);
        getContentPane().setBackground(formColor);
        
        
        JLabel heading = new JLabel("ADD CUSTOMER DETAILS");
        heading.setBounds(210, 20, 500, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.WHITE);
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 80, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblname.setForeground(Color.WHITE);
        lblname.setForeground(Color.WHITE);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 80, 150, 25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 130, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblnationality.setForeground(Color.WHITE);
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 130, 150, 25);
        add(tfnationality);
        
       
        
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(60, 180, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.WHITE);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220, 180, 150, 25);
        add(tfaadhar);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbladdress.setForeground(Color.WHITE);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220, 230, 150, 25);
        add(tfaddress);
        
        
        ButtonGroup gendergroup = new ButtonGroup();
        
        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setForeground(Color.WHITE);
        add(lblgender);
        
       rbmale = new JRadioButton("Male");
       rbmale.setBounds(220, 280, 70, 25);
       rbmale.setBackground(formColor);
       rbmale.setForeground(Color.WHITE);
        add(rbmale);
       
       rbfemale = new JRadioButton("Female");
       rbfemale.setBounds(300, 280, 70, 25);
       rbfemale.setBackground(formColor);
       rbfemale.setForeground(Color.WHITE);
        add(rbfemale);
        
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
         JLabel lblphone = new JLabel("Phone Number");
         lblphone.setBounds(60, 330, 150, 25);
         lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
         lblphone.setForeground(Color.WHITE);
         add(lblphone);
         
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.RED);
        save.setForeground(Color.BLACK);
        save.setBounds(220, 380, 150, 30);
        save.addActionListener(this);
        add(save);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/add-user.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 80, 300, 300);
        add(image);
        
        
        
        setSize(800,500);
        setLocation(250,50);
        setVisible(true);
    }
    
     public void actionPerformed(ActionEvent ae){
         String name = tfname.getText();
         String nationality = tfnationality.getText();
         String aadhar = tfaadhar.getText();
         String address = tfaddress.getText();
         String phone = tfphone.getText();
         String gender = null;
         
         if(rbmale.isSelected()){
             gender = "Male";
         }else{
             gender = "Female";
         }          
         try {
             Conn conn = new Conn();
             String query = "insert into customer values('"+name+"','"+nationality+"','"+phone+"','"+address+"','"+aadhar+"','"+gender+"')";
             conn.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null, "Customer Details Added sucessfully");
             setVisible(false);
             new ShowCustomer();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
    
    public static void main(String[] args) {
        
        new AddCustomer();
    }
    
}
