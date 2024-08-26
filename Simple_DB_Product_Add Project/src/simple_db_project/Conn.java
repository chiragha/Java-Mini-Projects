
package simple_db_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    
        public Conn(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                c = DriverManager.getConnection("jdbc:mysql:///salesmanagementsystem", "root", "SS30@krhps");
                s = c.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
 
}
