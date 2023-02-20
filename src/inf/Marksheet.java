package inf;

import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Marksheet extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Marksheet() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
    }

    public void tableload(){
        try {
             
             String sql = "SELECT sid AS INDEX_NUM,sub1 AS SUB_1,sub2 AS SUB_2,sub3 AS SUB_3,sub4 AS SUB_4,sub5 AS SUB_5,stotal AS TOTAL, saverage AS AVERAGE, sstatus AS STATUS FROM data";
             
             
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            table3.setModel(DbUtils.resultSetToTableModel(rs));  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        exitbtn3 = new javax.swing.JButton();
        previousebtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 153, 153,100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText(" Mark sheet of students");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 300, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1350, 50));

        exitbtn3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        exitbtn3.setText(" EXIT");
        exitbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(exitbtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 653, 190, 30));

        previousebtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        previousebtn.setText(" Previous");
        previousebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousebtnActionPerformed(evt);
            }
        });
        jPanel1.add(previousebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 653, 200, 30));

        table3.setBackground(new java.awt.Color(102, 102, 0));
        table3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table3);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1340, 550));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/1920x1080-Back .jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 700));

        setSize(new java.awt.Dimension(1386, 743));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitbtn3ActionPerformed
         System.exit(0);
    }//GEN-LAST:event_exitbtn3ActionPerformed

    private void previousebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousebtnActionPerformed
        Mainframe m2 = new Mainframe();
        m2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_previousebtnActionPerformed

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
            java.util.logging.Logger.getLogger(Marksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Marksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Marksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Marksheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Marksheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitbtn3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton previousebtn;
    private javax.swing.JTable table3;
    // End of variables declaration//GEN-END:variables
}
