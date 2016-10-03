/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MiddleWare;
import wiki.DataModel.StoreData.CreateUserInformation;

/**
 *
 * @author Mainul35
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        this.setTitle("WikiWikiWiki");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUserLogin = new javax.swing.JButton();
        btnTutorLogin = new javax.swing.JButton();
        btnStudetLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnUserLogin.setText("Login as Admin");
        btnUserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserLoginActionPerformed(evt);
            }
        });

        btnTutorLogin.setText("Login as Tutor");
        btnTutorLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutorLoginActionPerformed(evt);
            }
        });

        btnStudetLogin.setText("Login as Student");
        btnStudetLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudetLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUserLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTutorLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnStudetLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(138, 138, 138))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnUserLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTutorLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStudetLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserLoginActionPerformed
        // TODO add your handling code here:
        MiddleWare.getAdminLoginWindowInstance().setVisible(true);
        MiddleWare.getMainWindowInstance().setVisible(false);
        CreateUserInformation.createDirectory("Admin");
    }//GEN-LAST:event_btnUserLoginActionPerformed

    private void btnTutorLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutorLoginActionPerformed
        // TODO add your handling code here:
        MiddleWare.getTutorLoginWindowInstance().setVisible(true);
        MiddleWare.getMainWindowInstance().setVisible(false);
        CreateUserInformation.createDirectory("Tutor");
    }//GEN-LAST:event_btnTutorLoginActionPerformed

    private void btnStudetLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudetLoginActionPerformed
        // TODO add your handling code here:
        MiddleWare.getStudentLoginWindowInstance().setVisible(true);
        MiddleWare.getMainWindowInstance().setVisible(false);
        CreateUserInformation.createDirectory("Student");
    }//GEN-LAST:event_btnStudetLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStudetLogin;
    private javax.swing.JButton btnTutorLogin;
    private javax.swing.JButton btnUserLogin;
    // End of variables declaration//GEN-END:variables
}
