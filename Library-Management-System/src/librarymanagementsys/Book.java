/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package librarymanagementsys;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Book extends javax.swing.JFrame {

    /**
     * Creates new form Book
     */
    public Book() {
        initComponents();
         Connect();
         Category();
         Author();
         Publisher();
        Book_Load();
    }
    
    //for category
    public class CategoryItem
    {
        int id;
        String name;
        
        
        public CategoryItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        
        public String toString()
        {
            return name;
        }
    }
    
    
    //for author
    
     public class AuthorItem
    {
        int id;
        String name;
        
        
        public AuthorItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        
        public String toString()
        {
            return name;
        }
    }
     
     //for publisher
    
     public class PublisherItem
    {
        int id;
        String name;
        
        
        public PublisherItem(int id, String name)
        {
            this.id = id;
            this.name = name;
        }
        
        public String toString()
        {
            return name;
        }
    }
   
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public void Connect()
    {
        try 
          {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/librarymgmtsys","root","");
           } catch (Exception e) 
           {
               e.printStackTrace();
           }
            
    }
  
    
    public void Category()
    {
        try {
            pst = con.prepareStatement("select * from category");
            rs = pst.executeQuery();
            txtcategory.removeAllItems();
            
            
            while(rs.next())
            {
                txtcategory.addItem(new CategoryItem(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
    }
    
    public void Author()
    {
        try {
            pst = con.prepareStatement("select * from author");
            rs = pst.executeQuery();
            txtauthor.removeAllItems();
            
            
            while(rs.next())
            {
                txtauthor.addItem(new AuthorItem(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
    }
    
     public void Publisher()
    {
        try {
            pst = con.prepareStatement("select * from publisher");
            rs = pst.executeQuery();
            txtpublisher.removeAllItems();
            
            
            while(rs.next())
            {
                txtpublisher.addItem(new PublisherItem(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
    }
   
     
     
     
     
     
     //code for print data on table
      public void Book_Load(){
        try {
            int c;
            
            pst = con.prepareStatement("Select b.id, b.name, c.catname, a.name, p.name , b.content, b.pages, b.edition from book b JOIN category c On b.category = c.id JOIN author a On b.author = a.id JOIN publisher p On b.publisher = p.id ");
            rs = pst.executeQuery();
            
            ResultSetMetaData rsd = rs.getMetaData();
            c = rsd.getColumnCount();
            
            DefaultTableModel model2 = (DefaultTableModel) jTable1.getModel();
            model2.setRowCount(0);
            
            while(rs.next()){
                Vector vec = new Vector();
                
                for(int i=1; i<=c; i++){
                    vec.add(rs.getString("b.id"));
                    vec.add(rs.getString("b.name"));
                    vec.add(rs.getString("c.catname"));
                    vec.add(rs.getString("a.name"));
                    vec.add(rs.getString("p.name"));
                    vec.add(rs.getString("b.content"));
                    vec.add(rs.getString("b.pages"));
                    vec.add(rs.getString("b.edition"));
                }
                
                model2.addRow(vec);
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtbookname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        txtcancel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtcontent = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtedition = new javax.swing.JTextField();
        txtpages = new javax.swing.JTextField();
        txtcategory = new javax.swing.JComboBox();
        txtauthor = new javax.swing.JComboBox();
        txtpublisher = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book");

        jLabel2.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Category");

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Book Name:");

        txtbookname.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N

        jTable1.setBackground(new java.awt.Color(255, 255, 102));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Book Name", "Category", "Author", "Publisher", "Content", "Pages", "Edition"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        add.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        txtcancel.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        txtcancel.setText("Cancel");
        txtcancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Publisher:");

        txtcontent.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Author:");

        jLabel6.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Edition:");

        jLabel7.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Contents:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("No Of Pages");

        txtedition.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N

        txtpages.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtcategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtbookname)
                                            .addComponent(txtcontent)
                                            .addComponent(txtedition, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtpages, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtauthor, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtpublisher, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtcancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(3, 3, 3)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtbookname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtauthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcontent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpages, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtedition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add)
                    .addComponent(update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(txtcancel))
                .addGap(28, 28, 28))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model2 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();

        int id = Integer.parseInt(model2.getValueAt(selectIndex, 0).toString());
        txtbookname.setText(model2.getValueAt(selectIndex, 1).toString());
        
        txtcategory.setSelectedItem(model2.getValueAt(selectIndex, 2).toString());
        txtauthor.setSelectedItem(model2.getValueAt(selectIndex, 3).toString());
        txtpublisher.setSelectedItem(model2.getValueAt(selectIndex, 4).toString());
        
        txtcontent.setText(model2.getValueAt(selectIndex, 5).toString());
        txtpages.setText(model2.getValueAt(selectIndex, 6).toString());
        txtedition.setText(model2.getValueAt(selectIndex, 7).toString());

        add.setEnabled(false);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        
        String name = txtbookname.getText();
        CategoryItem ci = (CategoryItem) txtcategory.getSelectedItem();
        AuthorItem ai = (AuthorItem) txtauthor.getSelectedItem();
        PublisherItem pi = (PublisherItem) txtpublisher.getSelectedItem();
        String content = txtcontent.getText();
        String pages = txtpages.getText();
        String edition = txtedition.getText();
        
        
        
        try {
            pst = con.prepareStatement("insert into book(name,category,author,publisher,content,pages,edition)values(?,?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setInt(2, ci.id);
            pst.setInt(3, ai.id);
            pst.setInt(4, pi.id);
            pst.setString(5, content);
            pst.setString(6, pages);
            pst.setString(7, edition);
            int k = pst.executeUpdate();

            if(k==1){
                JOptionPane.showMessageDialog(this, "Book Data Added");
                txtbookname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpublisher.setSelectedIndex(-1);
                txtcontent.setText("");
                txtpages.setText("");
                txtedition.setText("");
                Book_Load();
               
            }else{
                JOptionPane.showMessageDialog(this, "Author details not Created!! there is some ERROR!!");
            }

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model2 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
         
        int id = Integer.parseInt(model2.getValueAt(selectIndex, 0).toString());
        String name = txtbookname.getText();
       CategoryItem ci = (CategoryItem) txtcategory.getSelectedItem();
        AuthorItem ai = (AuthorItem) txtauthor.getSelectedItem();
        PublisherItem pi = (PublisherItem) txtpublisher.getSelectedItem();
         String content = txtcontent.getText();
         String pages = txtpages.getText();
         String edition = txtedition.getText();
           
         
        
        try {
            pst = con.prepareStatement("update book set name = ? ,category =? ,author = ? ,publisher =?,content = ? ,pages =?,edition = ? where id = ?");
            pst.setString(1, name);
            pst.setInt(2, ci.id);
            pst.setInt(3, ai.id);
            pst.setInt(4, pi.id);
            pst.setString(5, content);
            pst.setString(6, pages);
            pst.setString(7, edition);
            pst.setInt(8, id);
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Book Updated");
                txtbookname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpublisher.setSelectedIndex(-1);
                txtcontent.setText("");
                txtpages.setText("");
                txtedition.setText("");
                txtbookname.requestFocus();
                Book_Load();
                add.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Book not Updated!! there is some ERROR!!");
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        

    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
         DefaultTableModel model2 = (DefaultTableModel)jTable1.getModel();
        int selectIndex = jTable1.getSelectedRow();
         
        int id = Integer.parseInt(model2.getValueAt(selectIndex, 0).toString());
       
        
        try {
            pst = con.prepareStatement("delete from book where id = ?");
        
            pst.setInt(1, id);
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this, "Book Deleted");
               txtbookname.setText("");
                txtcategory.setSelectedIndex(-1);
                txtauthor.setSelectedIndex(-1);
                txtpublisher.setSelectedIndex(-1);
                txtcontent.setText("");
                txtpages.setText("");
                txtedition.setText("");
                txtbookname.requestFocus();
                Book_Load();
                add.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Book not Deleted!! there is some ERROR!!");
            }
            
            
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_deleteActionPerformed

    private void txtcancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_txtcancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtauthor;
    private javax.swing.JTextField txtbookname;
    private javax.swing.JButton txtcancel;
    private javax.swing.JComboBox txtcategory;
    private javax.swing.JTextField txtcontent;
    private javax.swing.JTextField txtedition;
    private javax.swing.JTextField txtpages;
    private javax.swing.JComboBox txtpublisher;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
