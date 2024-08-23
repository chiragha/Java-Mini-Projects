
package pharmacymanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;

public class Main extends JFrame implements ActionListener{
    
    JTextField tfdose,tfnooftab,tfcostp,tfeddose, tfadv,tfsellp;
    JComboBox cbcomname;
    JLabel tfrefno;
    JDateChooser tfissuedt,tfexpdt;
    JButton save,exit;
    
    Random ran = new Random();
    long tot4 = Math.abs((ran.nextLong() % 9000L) + 1000L);

     Main() {
         
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pharmacymanagementsystem/icons/back.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 450, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,450);
        add(image);
        
        
        JLabel heading = new JLabel("ADD DRUG DETAILS");
        heading.setBounds(320, 10, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        heading.setForeground(Color.BLACK);
        image.add(heading);
        
        //////////////////////////////////////////////////////////////////
        
        JLabel compname = new JLabel("Name of Tablets:");
        compname.setBounds(60, 80, 200, 25);
        compname.setFont(new Font("Tahoma", Font.BOLD, 16));
        compname.setBackground(Color.WHITE);
        image.add(compname);
         
        String compnam[] = {"Paracetamol", "Cetirizine", "Albuterol", "Gabapentin", "Losartan", "Levothyroxine","Metoprolol","Ibuprofen"};
        cbcomname = new JComboBox(compnam);
        cbcomname.setBounds(240, 80, 150, 25);
        image.add(cbcomname);
        
        
        JLabel lblddose = new JLabel("Daily Dose:");
        lblddose.setBounds(500, 80, 150, 25);
        lblddose.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblddose);
        
        tfeddose= new JTextField();
        tfeddose.setBounds(650, 80, 150, 25);
        image.add(tfeddose);
        
        
        
        JLabel lblrefno = new JLabel("Reference No:");
        lblrefno.setBounds(60, 130, 150, 25);
        lblrefno.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblrefno);
        
        tfrefno = new JLabel(""+tot4);
        tfrefno.setBounds(240, 130, 150, 25);
        tfrefno.setFont(new Font("Tahoma", Font.BOLD, 16));
        tfrefno.setForeground(Color.RED);
        image.add(tfrefno);
        
        
        
        JLabel lbladvice = new JLabel("Storage Advice:");
        lbladvice.setBounds(500, 130, 150, 25);
        lbladvice.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lbladvice);
        
        tfadv= new JTextField();
        tfadv.setBounds(650, 130, 150, 25);
        image.add(tfadv);
        
       
        
        JLabel lbldose = new JLabel("Dose (mg):");
        lbldose.setBounds(60, 180, 150, 25);
        lbldose.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lbldose);
        
        tfdose = new JTextField();
        tfdose.setBounds(240, 180, 150, 25);
        image.add(tfdose);
        
        
        JLabel lblcostp = new JLabel("Cost Price:");
        lblcostp.setBounds(500, 180, 150, 25);
        lblcostp.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblcostp);
        
        tfcostp= new JTextField();
        tfcostp.setBounds(650, 180, 150, 25);
        image.add(tfcostp);
        
        JLabel lblnooftab = new JLabel("Number of Tablets:");
        lblnooftab.setBounds(60, 230, 200, 25);
        lblnooftab.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblnooftab);
        
        tfnooftab = new JTextField();
        tfnooftab.setBounds(240, 230, 150, 25);
        image.add(tfnooftab);
        
        JLabel lblsellp = new JLabel("Sell Price:");
        lblsellp.setBounds(500, 230, 150, 25);
        lblsellp.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblsellp);
        
        tfsellp= new JTextField();
        tfsellp.setBounds(650, 230, 150, 25);
        image.add(tfsellp);
        
        JLabel lblissuedt = new JLabel("Issued Date:");
        lblissuedt.setBounds(60, 280, 150, 25);
        lblissuedt.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblissuedt);
       
        tfissuedt = new JDateChooser();
        tfissuedt.setBounds(240, 280, 150, 25);
        image.add(tfissuedt);
        
        JLabel lblexpdt = new JLabel("Exp Date:");
        lblexpdt.setBounds(500, 280, 150, 25);
        lblexpdt.setFont(new Font("Tahoma", Font.BOLD, 16));
        image.add(lblexpdt);
       
        
        tfexpdt = new JDateChooser();
        tfexpdt.setBounds(650, 280, 150, 25);
        image.add(tfexpdt);
        
        
        
        
        save = new JButton("SAVE");
        save.setBackground(Color.GREEN);
        save.setForeground(Color.WHITE);
        save.setBounds(280, 350, 150, 40);
        save.addActionListener(this);
        image.add(save);
       
        exit = new JButton("EXIT");
        exit.setBackground(Color.RED);
        exit.setForeground(Color.WHITE);
        exit.setBounds(520, 350, 150, 40);
        exit.addActionListener(this);
        image.add(exit);

        
        
        
        setSize(900,450);
        setLocation(250,50);
        setVisible(true);
         
         
    }
     
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == save){
            String compname = (String) cbcomname.getSelectedItem();
            String dailydose = tfeddose.getText();
            String refno = tfrefno.getText();
            String advice = tfadv.getText();
            String dose = tfdose.getText();
            String costp = tfcostp.getText();
            String sellp = tfsellp.getText();
//            String issue = tfissuedt.getText();
            String issue = ((JTextField)tfissuedt.getDateEditor().getUiComponent()).getText();
//            String exp = tfexpdt.getText();
             String exp = ((JTextField)tfexpdt.getDateEditor().getUiComponent()).getText();
            String noftab = tfnooftab.getText();
            
            try {
                
               String query = "insert into drug values( '"+compname+"','"+refno+"','"+dose+"','"+noftab+"','"+issue+"','"+dailydose+"','"+advice+"','"+costp+"','"+sellp+"','"+exp+"')";
                  
                  Conn con = new Conn();
                  con.s.executeUpdate(query);
                   
                  JOptionPane.showMessageDialog(null, "Drug Details Added Successfully");
                  setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            
        }
    
     }
    
    public static void main(String[] args) {
        new Main();
    }
    
}
