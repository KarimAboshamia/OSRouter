package my_RouterInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;




public class RouterInterface extends javax.swing.JFrame {

    int numOfRouterConnections, numOfDevices;
    
    public RouterInterface() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitBtn = new javax.swing.JButton();
        routerConnectionTxt = new javax.swing.JTextField();
        routerConnectionsLbl = new javax.swing.JLabel();
        clientsLbl = new javax.swing.JLabel();
        clientsTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Input = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        outputLbl = new javax.swing.JLabel();
        devicesNamesLbl = new javax.swing.JLabel();
        inputSubmitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Router Interface");
        setName("routerName"); // NOI18N

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        routerConnectionTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                routerConnectionTxtActionPerformed(evt);
            }
        });

        routerConnectionsLbl.setText("Router Connections");

        clientsLbl.setText("Clients");

        clientsTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsTxtActionPerformed(evt);
            }
        });

        Input.setColumns(20);
        Input.setRows(5);
        jScrollPane1.setViewportView(Input);

        Output.setColumns(20);
        Output.setRows(5);
        jScrollPane2.setViewportView(Output);

        outputLbl.setText("Output");

        devicesNamesLbl.setText("Devices Names");

        inputSubmitBtn.setText("OK");
        inputSubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputSubmitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(routerConnectionsLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(routerConnectionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clientsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clientsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(devicesNamesLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(inputSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(outputLbl)))
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(routerConnectionTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(routerConnectionsLbl)
                    .addComponent(clientsLbl)
                    .addComponent(clientsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputLbl)
                    .addComponent(devicesNamesLbl)
                    .addComponent(inputSubmitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void routerConnectionTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_routerConnectionTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_routerConnectionTxtActionPerformed

    private void clientsTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clientsTxtActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        
        numOfRouterConnections = Integer.parseInt(routerConnectionTxt.getText());
        numOfDevices = Integer.parseInt(clientsTxt.getText());
    }//GEN-LAST:event_submitBtnActionPerformed

    private void inputSubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputSubmitBtnActionPerformed
        String text = Input.getText();
        String[] devicesNames = text.split("\\n");  
        try {
            Router myRouter = new Router(numOfRouterConnections, numOfDevices, devicesNames);
        } catch (Exception ex) {
            Logger.getLogger(RouterInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_inputSubmitBtnActionPerformed

   
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(RouterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RouterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RouterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RouterInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RouterInterface().setVisible(true);
            }
        }); 
        File file = new File("Output.txt");
        PrintStream stream = new PrintStream(file);
        /*PrintStream out = new PrintStream(new OutputStream() {
        @Override
            public void write(int b) throws IOException {
                str = String.valueOf((char)b);   
            } 
        });*/
        
        System.setOut(stream);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Input;
    public static javax.swing.JTextArea Output;
    private javax.swing.JLabel clientsLbl;
    private javax.swing.JTextField clientsTxt;
    private javax.swing.JLabel devicesNamesLbl;
    private javax.swing.JButton inputSubmitBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel outputLbl;
    private javax.swing.JTextField routerConnectionTxt;
    private javax.swing.JLabel routerConnectionsLbl;
    private javax.swing.JButton submitBtn;
    // End of variables declaration//GEN-END:variables
}
