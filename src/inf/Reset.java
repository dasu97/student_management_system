 
package inf;
    
import codes.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Dasu
 */
public class Reset extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
     
    
    /**
     * Creates new form Reset
     */
    public Reset() {
        initComponents();
        conn = DBconnect.connect();
        
    }
    //public Reset(String username){
        //this.user=username;
         //initComponents();
    //}
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        resetbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        unamebox = new javax.swing.JTextField();
        pwordbox = new javax.swing.JPasswordField();
        pwordbox2 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText(" Reset");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 80, 160, 50));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0,100));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Reset", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 102, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("New Password ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 100, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirm Password");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 20));

        resetbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resetbtn.setText(" Reset");
        resetbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnActionPerformed(evt);
            }
        });
        jPanel2.add(resetbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 290, 100, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("User name");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, 20));
        jPanel2.add(unamebox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 150, -1));
        jPanel2.add(pwordbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 140, 150, -1));
        jPanel2.add(pwordbox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 150, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 390, 380));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inf/1920x1080-Back .jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 710));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Do you want to reset?");
            
        if(check==0){
        String uname = unamebox.getText();
        String pword = pwordbox.getText();
        String vpword = pwordbox2.getText();
        
        if(pwordbox.getText().equals(pwordbox2.getText())){
        //if(vpword == pword){
            try {
                String sql = "UPDATE fogotpword SET username='"+uname+"', password='"+pword+"'  ";
                 
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null,"Reset Successfully!");
                Login m3 = new Login();
                m3.setVisible(true);
                this.dispose();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"password do not match!");
        }
    }//GEN-LAST:event_resetbtnActionPerformed
    }
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
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reset.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reset().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField pwordbox;
    private javax.swing.JPasswordField pwordbox2;
    private javax.swing.JButton resetbtn;
    private javax.swing.JTextField unamebox;
    // End of variables declaration//GEN-END:variables
}