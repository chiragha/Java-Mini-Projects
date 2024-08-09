package fee_management_system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewStud extends JFrame implements ActionListener{
   
    JTable table;
    Choice cstudentid;
    JButton search, print,update,back;
    
    
    ViewStud() {
        setLayout(null);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/home.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);
        
        JLabel searchlbl = new JLabel("Search by Student ID");
        searchlbl.setBounds(40,40,150,20);
        searchlbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
        image.add(searchlbl);
        
        table = new JTable();
        cstudentid = new Choice();
        cstudentid.setBounds(220,40,150,20);
        image.add(cstudentid);
        
          try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentd");
            while(rs.next()){
                cstudentid.add(rs.getString("studid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from studentd");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
            e.printStackTrace();
        }
        
         
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,120,900,150);
        image.add(jsp);
        
        search = new JButton("Search");
        search.setBounds(220, 80, 80,20);
        search.addActionListener(this);
        image.add(search);
        
        print = new JButton("Print");
        print.setBounds(320, 80, 80,20);
        print.addActionListener(this);
        image.add(print);
        
        update = new JButton("Update");
        update.setBounds(420, 80, 80,20);
        update.addActionListener(this);
        image.add(update);
        
        back = new JButton("Back");
        back.setBounds(520, 80, 80,20);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== search){
            String query = "select * from studentd where studid = '"+cstudentid.getSelectedItem()+"' ";
             try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource()== print){
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == update){
            setVisible(false);
            new UpdateStud(cstudentid.getSelectedItem());
        }else{
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new ViewStud();
    }
}
