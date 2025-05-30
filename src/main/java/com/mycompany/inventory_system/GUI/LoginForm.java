
package com.mycompany.inventory_system.GUI;

import com.mycompany.inventory_system.Tools.*;
import com.mycompany.inventory_system.Functionalities.*;
import javax.swing.JOptionPane;



public class LoginForm extends javax.swing.JFrame {

   
    public LoginForm() {
        initComponents();
        AccountHandler.InitFileLocation();
        AccountHandler.ReadFile();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new RoundedPanel(35);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new RoundedButton("LOGIN",20);
        jButton2 = new RoundedButton("REGISTER",20);
        userTextF = new javax.swing.JTextField();
        passwordTextF = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory_System");
        setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        setForeground(java.awt.Color.white);
        setMaximumSize(new java.awt.Dimension(400, 300));
        setMinimumSize(new java.awt.Dimension(720, 500));
        setPreferredSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(24, 26, 27));
        jPanel1.setForeground(new java.awt.Color(23, 21, 59));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(44, 47, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 42, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Password:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 73, -1, -1));

        jButton1.setBackground(new java.awt.Color(80, 180, 120));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 119, -1, -1));
        jButton1.getAccessibleContext().setAccessibleName("");

        jButton2.setBackground(new java.awt.Color(80, 180, 120));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("REGISTER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 119, -1, -1));
        jButton2.getAccessibleContext().setAccessibleName("");

        userTextF.setBackground(new java.awt.Color(182, 176, 159));
        jPanel2.add(userTextF, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 39, 175, -1));
        userTextF.getAccessibleContext().setAccessibleName("");

        passwordTextF.setBackground(new java.awt.Color(182, 176, 159));
        jPanel2.add(passwordTextF, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 67, 175, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/inventory_system_images/Untitled design (2).png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 2960, 2250));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 153, 290, 170));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/inventory_system_images/Untitled design.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-450, -260, 1550, 1090));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            /*
            String username = userTextF.getText();
            String password = passwordTextF.getText();
            CheckUserlogin checkUserLogin = new CheckUserlogin();
            String result = checkUserLogin.checkUser(username,password);
            
            if (result.equals("correct")){
                 ProductDashboard productD = new ProductDashboard();
                 productD.setVisible(true);
                 this.dispose();
            }else{
                JOptionPane.showMessageDialog(null,"Wrong Username or Password");
            }
            */
            if(CheckUserlogin.Login(userTextF.getText(), passwordTextF.getText()) != 0) {
                return;
            } else {
                ProductDashboard.username = AccountHandler.username;
                ProductDashboard.main(null);
                this.dispose();
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //register
        if(CheckUserlogin.SignUp(userTextF.getText(), passwordTextF.getText()) != 0) {
                return;
            } else {
                ProductDashboard.username = AccountHandler.username;
                ProductDashboard.main(null);
                this.dispose();
            }
    }//GEN-LAST:event_jButton2ActionPerformed

   
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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField passwordTextF;
    private javax.swing.JTextField userTextF;
    // End of variables declaration//GEN-END:variables
}
