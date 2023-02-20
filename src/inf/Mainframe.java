package inf;
 
import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Mainframe extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Mainframe() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }

    public void tableload(){
        try {
            String sql = "SELECT sid AS INDEX_NUM,sname AS NAME,sage AS AGE,sgender AS GENDER, sub1,sub2,sub3,sub4,sub5,stotal AS TOTAL,saverage AS AVERAGE, sstatus AS STATUS FROM data";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void tabledata(){ 
        int r = table1.getSelectedRow();
        
        String id = table1.getValueAt(r, 0).toString();
        String name = table1.getValueAt(r, 1).toString();
        String age = table1.getValueAt(r, 2).toString();
        String gender = table1.getValueAt(r, 3).toString();
        String sub1 = table1.getValueAt(r, 4).toString();
        String sub2 = table1.getValueAt(r, 5).toString();
        String sub3 = table1.getValueAt(r, 6).toString();
        String sub4 = table1.getValueAt(r, 7).toString();
        String sub5 = table1.getValueAt(r, 8).toString();
        String total = table1.getValueAt(r, 9).toString();
        String average = table1.getValueAt(r, 10).toString();
        String status = table1.getValueAt(r, 11).toString();
         
        
        
        idbox.setText(id);
        namebox.setText(name);
        agebox.setText(age);
        genderbox.setSelectedItem(gender);
        sub1box.setText(sub1);
        sub2box.setText(sub2);
        sub3box.setText(sub3);
        sub4box.setText(sub4);
        sub5box.setText(sub5);
        totallbl.setText(total);
        averagelbl.setText(average);
        statuslbl.setText(status);
    }
    
    public void search(){ 
        String srch = searchbox.getText();
        
        try {
            String sql = "SELECT *FROM data WHERE sid LIKE '%"+srch+"%' "; 
            
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
            String id = table1.getValueAt(0, 0).toString();
            String name = table1.getValueAt(0, 1).toString();
            String age = table1.getValueAt(0, 2).toString();
            String gender = table1.getValueAt(0, 3).toString();   
            String sub1 = table1.getValueAt(0, 4).toString();
            String sub2 = table1.getValueAt(0, 5).toString();
            String sub3 = table1.getValueAt(0, 6).toString();
            String sub4 = table1.getValueAt(0, 7).toString();
            String sub5 = table1.getValueAt(0, 8).toString();
            String total = table1.getValueAt(0, 9).toString();
            String average = table1.getValueAt(0, 10).toString();
            String status = table1.getValueAt(0, 11).toString();
        
        idbox.setText(id);
        namebox.setText(name);
        agebox.setText(age);
        genderbox.setSelectedItem(gender); 
        sub1box.setText(sub1);
        sub2box.setText(sub2);
        sub3box.setText(sub3);
        sub4box.setText(sub4);
        sub5box.setText(sub5);
        totallbl.setText(total);
        totallbl.setText(average);
        totallbl.setText(status);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
       // tabledata(); 
    }
    
    public void update(){
        int check = JOptionPane.showConfirmDialog(null, "Do you want to update?");
            
        if(check==0){
        int id = Integer.parseInt(idbox.getText()); 
        String name = namebox.getText();
        int age = Integer.parseInt(agebox.getText());
        String gender = (String) genderbox.getSelectedItem();
        int sub1 = Integer.parseInt(sub1box.getText());
        int sub2 = Integer.parseInt(sub2box.getText());
        int sub3 = Integer.parseInt(sub3box.getText());
        int sub4 = Integer.parseInt(sub4box.getText());
        int sub5 = Integer.parseInt(sub5box.getText());
 
        int total;
        Double average ;
        String status="FAIL";
         
        total = sub1 + sub2 + sub3 + sub4 + sub5 ;
        totallbl.setText(Double.toString(total));
        
        average = total*0.2;
        averagelbl.setText(Double.toString(average));
        
        if(average>35)
        {
            status="PASS";
        }
        statuslbl.setText(status);
        
        try {
            
            String sql = "UPDATE data SET sname='"+name+"', sage='"+age+"', sgender='"+gender+"',sub1='"+sub1+"',sub2='"+sub2+"',sub3='"+sub3+"',sub4='"+sub4+"',sub5='"+sub5+"', stotal='"+total+"', saverage='"+average+"', sstatus='"+status+"' WHERE sid='"+id+"'  ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "not updated!");
        }
        }
    }
    
    public void clear(){
        
        searchbox.setText("");
        idbox.setText("");
        namebox.setText("");
        agebox.setText("");
        genderbox.setSelectedItem("Select");
        sub1box.setText("");
        sub2box.setText("");
        sub3box.setText("");
        sub4box.setText("");
        sub5box.setText("");
        totallbl.setText("TOTAL");
        averagelbl.setText("AVERAGE");
        statuslbl.setText("STATUS");
        
        
        tableload();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        searchbox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        namebox = new javax.swing.JTextField();
        agebox = new javax.swing.JTextField();
        genderbox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        idbox = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sub1box = new javax.swing.JTextField();
        sub2box = new javax.swing.JTextField();
        sub3box = new javax.swing.JTextField();
        sub4box = new javax.swing.JTextField();
        sub5box = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        updatebtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        deletebtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        insertbtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        totallbl = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        averagelbl = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        statuslbl = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        markbtn = new javax.swing.JButton();
        studentdetailbox = new javax.swing.JButton();
        exitbtn = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(1080, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchbox.setToolTipText("Search by index");
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel4.add(searchbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 650, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 690, 60));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102,100));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Information", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" Name");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Age");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(" Gender");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        namebox.setToolTipText("enter your name");
        jPanel6.add(namebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 340, -1));

        agebox.setToolTipText("enter your age");
        jPanel6.add(agebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 340, -1));

        genderbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Female", "Male" }));
        jPanel6.add(genderbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 340, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Indx");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        idbox.setToolTipText("enter the index num");
        jPanel6.add(idbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 60, -1));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 480, 270));

        jPanel8.setBackground(new java.awt.Color(102, 102, 102,100));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Marks", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(" Subject 1 ");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(" Subject 2");
        jPanel8.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText(" Subject 3");
        jPanel8.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        sub1box.setToolTipText("enter marks");
        jPanel8.add(sub1box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 320, -1));

        sub2box.setToolTipText("enter marks");
        jPanel8.add(sub2box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 320, -1));

        sub3box.setToolTipText("enter marks");
        jPanel8.add(sub3box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 320, -1));

        sub4box.setToolTipText("enter marks");
        jPanel8.add(sub4box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 320, -1));

        sub5box.setToolTipText("enter marks");
        jPanel8.add(sub5box, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 320, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(" Subject 4");
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 70, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(" Subject 5");
        jPanel8.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 500, 270));

        updatebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        updatebtn.setText(" update");
        updatebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebtnActionPerformed(evt);
            }
        });
        jPanel2.add(updatebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 150, -1));

        clearbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clearbtn.setText(" clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 160, -1));

        deletebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deletebtn.setText(" delete");
        deletebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebtnActionPerformed(evt);
            }
        });
        jPanel2.add(deletebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText(" Student Information System ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 14, 500, 40));

        insertbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insertbtn.setText(" insert");
        insertbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertbtnActionPerformed(evt);
            }
        });
        jPanel2.add(insertbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 140, -1));

        jPanel10.setBackground(new java.awt.Color(0, 0, 0));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(" Total Marks     :");
        jPanel10.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        totallbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        totallbl.setForeground(new java.awt.Color(204, 0, 51));
        totallbl.setText("TOTAL");
        jPanel10.add(totallbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(" Average Marks :");
        jPanel10.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        averagelbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        averagelbl.setForeground(new java.awt.Color(204, 0, 51));
        averagelbl.setText("AVERAGE");
        jPanel10.add(averagelbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText(" Status             :");
        jPanel10.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 10));

        statuslbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        statuslbl.setForeground(new java.awt.Color(204, 0, 51));
        statuslbl.setText(" STATUS");
        jPanel10.add(statuslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jPanel2.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 100, 240, 260));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/1920x1080-Back .jpg"))); // NOI18N
        jLabel15.setText("jLabel15");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 440));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 440));

        jPanel7.setBackground(new java.awt.Color(153, 0, 51,100));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        markbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        markbtn.setText(" Mark sheet");
        markbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markbtnActionPerformed(evt);
            }
        });
        jPanel7.add(markbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 150, -1));

        studentdetailbox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        studentdetailbox.setText(" Student Details");
        studentdetailbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentdetailboxActionPerformed(evt);
            }
        });
        jPanel7.add(studentdetailbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 150, -1));

        exitbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        exitbtn.setText(" Exit");
        exitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtnActionPerformed(evt);
            }
        });
        jPanel7.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, -1));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 460, 230, 220));

        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setBackground(new java.awt.Color(153, 0, 51));
        table1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                table1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel9.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 220));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 1030, 220));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 710));

        setSize(new java.awt.Dimension(1384, 746));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void insertbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertbtnActionPerformed
      
        String name;
        int age;
        String gender;
        int id;
        int total;
        Double average;
        String status="FAIL";
        
        id = Integer.parseInt(idbox.getText()); 
        name = namebox.getText();
        age = Integer.parseInt(agebox.getText());
        gender = (String) genderbox.getSelectedItem();
        int sub1 = Integer.parseInt(sub1box.getText());
        int sub2 = Integer.parseInt(sub2box.getText());
        int sub3 = Integer.parseInt(sub3box.getText());
        int sub4 = Integer.parseInt(sub4box.getText());
        int sub5 = Integer.parseInt(sub5box.getText());
        
        total = sub1 + sub2 + sub3 + sub4 + sub5 ;
        totallbl.setText(Double.toString(total));
        
        average = total*0.2;
        averagelbl.setText(Double.toString(average));
        
        if(average>35)
        {
            status="PASS";
        }
        statuslbl.setText(status);
        
        
        
        try {
            String sql = "INSERT INTO data (sid,sname,sage,sgender,sub1,sub2,sub3,sub4,sub5,stotal,saverage,sstatus) VALUES ('"+id+"','"+name+"','"+age+"','"+gender+"','"+sub1+"','"+sub2+"','"+sub3+"','"+sub4+"','"+sub5+"','"+total+"','"+average+"','"+status+"') ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Inserted");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);        
        }
        
        tableload();
    }//GEN-LAST:event_insertbtnActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
       tabledata();
    }//GEN-LAST:event_table1MouseClicked

    private void table1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyReleased
        tabledata(); 
    }//GEN-LAST:event_table1KeyReleased

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
         search();
         
    }//GEN-LAST:event_searchboxKeyReleased

    private void updatebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebtnActionPerformed
         update();
         tableload();
    }//GEN-LAST:event_updatebtnActionPerformed

    private void deletebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebtnActionPerformed
         int check = JOptionPane.showConfirmDialog(null, "Do you want to delete?");
         
         if(check==0)
         {
             String id = idbox.getText();
             
             try {
                 String sql = "DELETE FROM data WHERE sid='"+id+"' ";
                 pst = conn.prepareStatement(sql);
                 pst.execute();
                 JOptionPane.showMessageDialog(null,"Deleted!");
                 
             } catch (Exception e) {
                 JOptionPane.showMessageDialog(null," Not Deleted!");
             }
             tableload();
         }
         tableload();
         clear();
    }//GEN-LAST:event_deletebtnActionPerformed

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
       clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void markbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markbtnActionPerformed
        Marksheet m2 = new Marksheet();
        m2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_markbtnActionPerformed

    private void studentdetailboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentdetailboxActionPerformed
        Studentdetail m3 = new Studentdetail();
        m3.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_studentdetailboxActionPerformed

    private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtnActionPerformed
           System.exit(0);
    }//GEN-LAST:event_exitbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mainframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agebox;
    private javax.swing.JLabel averagelbl;
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deletebtn;
    private javax.swing.JButton exitbtn;
    private javax.swing.JComboBox genderbox;
    private javax.swing.JTextField idbox;
    private javax.swing.JButton insertbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton markbtn;
    private javax.swing.JTextField namebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JLabel statuslbl;
    private javax.swing.JButton studentdetailbox;
    private javax.swing.JTextField sub1box;
    private javax.swing.JTextField sub2box;
    private javax.swing.JTextField sub3box;
    private javax.swing.JTextField sub4box;
    private javax.swing.JTextField sub5box;
    private javax.swing.JTable table1;
    private javax.swing.JLabel totallbl;
    private javax.swing.JButton updatebtn;
    // End of variables declaration//GEN-END:variables
}
