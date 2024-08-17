package student.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class StudDetails extends JFrame implements ActionListener{
    
    JTable table;
    Choice crollno;
    JButton search,exit;

    StudDetails(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        crollno = new Choice();
        crollno.setBounds(180, 20, 150, 20);
        add(crollno);
        
         try {
            Conn c = new Conn();
            ResultSet rs  = c.s.executeQuery("select * from student");
            while(rs.next()){
                crollno.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        table = new JTable();
         
        try {
            Conn c = new Conn();
            ResultSet rs  = c.s.executeQuery("select * from student");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,500);
        add(jsp);
        
        
       //search button
        search = new JButton("Search");
        search.setBounds(350,20,80,35);
        search.addActionListener(this);
        add(search);
        
        //search button
        exit = new JButton("Exit");
        exit.setBounds(450,20,80,35);
        exit.addActionListener(this);
        add(exit);
       
        setSize(900,600);
        setLocation(250,100);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == search){
            String query = "select * from student where rollno = '"+crollno.getSelectedItem()+"'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
             setVisible(false);
        }
    }
   
    public static void main(String[] args) {
        new StudDetails();
    }
    
}
