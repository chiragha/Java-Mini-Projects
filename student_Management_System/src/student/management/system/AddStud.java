package student.management.system;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class AddStud extends JFrame implements ActionListener{

      JTextField tfname, tffname, tfaddress, tfphone, tfemail, tfx, tfxii,tfaadhar;
      JLabel labelrollno;
      JDateChooser dcdob;
      JComboBox cbcourse, cbbranch;
      JButton submit, details;
      
      Random ran = new Random();
      long first4 = Math.abs((ran.nextLong() %9000L) + 1000L);
      
      
      AddStud()  {

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
        JLabel heading = new JLabel("NEW STUDENT DETAILS");
        heading.setBounds(280, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.BOLD, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        
//        name
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 100, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblname.setForeground(Color.BLACK);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(180, 100, 150, 25);
        add(tfname);
        
        //father's name
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(500, 100, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(650, 100, 150, 25);
        add(tffname);
        
       //roll no
        JLabel lblrollno = new JLabel("Roll Number");
        lblrollno.setBounds(60, 150, 150, 25);
        lblrollno.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblrollno);
        
        labelrollno = new JLabel("1299" + first4);
        labelrollno.setBounds(180, 150, 150, 25);
        labelrollno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(labelrollno);
      
        
        //dob
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(500, 150, 150, 25);
        lbldob.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(650, 150, 150, 25);
        add(dcdob);
        
        
        //address
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 200, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(180, 200, 150, 25);
        add(tfaddress);
        
         //phone
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 200, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(650, 200, 150, 25);
        add(tfphone);
        
          //email
        JLabel lblemail = new JLabel("Email ID");
        lblemail.setBounds(60, 250, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(180, 250, 150, 25);
        add(tfemail);
        
         //class 10th
        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(500, 250, 150, 25);
        lblx.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblx);
        
        tfx = new JTextField();
        tfx.setBounds(650, 250, 150, 25);
        add(tfx);
        
         //class 12th
        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(60, 300, 150, 25);
        lblxii.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(180, 300, 150, 25);
        add(tfxii);
        
         //aadhar
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(500, 300, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(650, 300, 150, 25);
        add(tfaadhar);
        
        
         //course
        JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(60, 350, 150, 25);
        lblcourse.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(lblcourse);
        
        String course[] = {"B.Tech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(180, 350, 150, 25);
        add(cbcourse);
        
        //branch
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(500, 350, 200, 25);
        lblbranch.setFont(new Font("serif", Font.BOLD, 20));
        add(lblbranch);
        
        String branch[] = {"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(650, 350, 150, 25);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        //submit button
         submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,450,150,35);
        submit.addActionListener(this);
        add(submit);
        
        //view details
         details = new JButton("Details");
        details.setBackground(Color.BLACK);
        details.setForeground(Color.WHITE);
        details.setBounds(430,450,150,35);
        details.addActionListener(this);
        add(details);
       
        
        setSize(900,600);
        setLocation(250,100);
        setVisible(true);


        }
 
      public void actionPerformed(ActionEvent ae){
          
          if(ae.getSource() == submit){
              String name = tfname.getText();
              String fname = tffname.getText();
              String rollno = labelrollno.getText();
              String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
              String address = tfaddress.getText();
              String phone = tfphone.getText();
              String email = tfemail.getText();
              String x = tfx.getText();
              String xii = tfxii.getText();
              String aadhar = tfaadhar.getText();
              String course = (String) cbcourse.getSelectedItem();
              String branch = (String) cbbranch.getSelectedItem();
              
              
              try {
                  String query = "insert into student values( '"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
                  
                  Conn con = new Conn();
                  con.s.executeUpdate(query);
                   
                  JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                  setVisible(false);
              } catch (Exception e) {
                  e.printStackTrace();
              }
            
          }else{
              setVisible(false);
              new StudDetails();
          }
      }
      
      public static void main(String[] args) {
        
          new AddStud();
      }
}
 