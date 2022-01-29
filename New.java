package omadaready;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gouvo
 */

public class New extends javax.swing.JFrame {

    
    public New() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
        this.setTitle("Store an appointment");
        sec1.setVisible(false);
        sec2.setVisible(false);
        cb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                prepare();
            }
            
        });
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempname,tempphone;
                boolean go = true;
                tempname = cnamefield.getText();
                tempphone = cphonefield.getText();
                if (tempname.equals("") || tempphone.equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "You have enter all fields.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    go = false;
                }
                if (cb.getSelectedIndex()==0){
                    JOptionPane.showMessageDialog(new JFrame(), "You have to choose one of the above services.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    go = false;
                }
                
                
                if (go){
                    try {
                        Files z;
                        z = new Files();
                        z.prepare();
                        String path = z.getPath();
                        if (cb.getSelectedIndex()==4){
                            String str = sec2.getText();
                            float tmp1,tmp2;
                            tmp1 = Float.parseFloat(str);
                            tmp2 = (float) (tmp1 / 1.24);
                            String str1,str2;
                            str1 = String.format("%.02f",tmp1);
                            str2 = String.format("%.02f",tmp2);
                            
                            z.writeToFile(path, tempname, tempphone, (String) cb.getSelectedItem(), str2, str1);
                        }
                        else{
                            z.writeToFile(path, tempname, tempphone, (String) cb.getSelectedItem(), pricewn.getText(), pricetn.getText());
                        }
                        JOptionPane.showMessageDialog(new JFrame(), "Customer successfully stored.", "Message window", JOptionPane.PLAIN_MESSAGE); 
                        dispose();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(New.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(New.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(New.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }       
            }
        });
    }

    public void prepare() {
        int i = cb.getSelectedIndex();
        if(i==0){
            pricewn.setText("0");
            pricetn.setText("0");
        }
        if(i==1){
            pricewn.setText("15.31");
            pricetn.setText("18.98");
        }
        if(i==2){
            pricewn.setText("10.47");
            pricetn.setText("12.98");
        }
        if(i==3){
            pricewn.setText("40.32");
            pricetn.setText("50.00");
        }
        if(i==4){
            sec1.setVisible(true);
            sec2.setVisible(true);
        }
        
        if (!sec2.isFocusable()){
            pricewn.setText(sec2.getText());
        }
        
       
    }

    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ok = new javax.swing.JButton();
        cname = new javax.swing.JLabel();
        cphone = new javax.swing.JLabel();
        cb = new javax.swing.JComboBox<>();
        cwhat = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        pricew = new javax.swing.JLabel();
        pricet = new javax.swing.JLabel();
        pricewn = new javax.swing.JLabel();
        pricetn = new javax.swing.JLabel();
        cnamefield = new javax.swing.JTextField();
        cphonefield = new javax.swing.JTextField();
        sec2 = new javax.swing.JTextField();
        sec1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ok.setText("Save appointment");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        cname.setText("Name:");

        cphone.setText("Phone Number:");

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose one of the options below", "Appointment with specialist", "Perfect Startup", "Appointment at your door", "Custom Price" }));
        cb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActionPerformed(evt);
            }
        });

        cwhat.setText("Service:");

        price.setText("Price");

        pricew.setText("Without Tax");

        pricet.setText("Final Price");

        pricewn.setText("0");

        pricetn.setText("0");

        cnamefield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnamefieldActionPerformed(evt);
            }
        });

        sec2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sec2ActionPerformed(evt);
            }
        });

        sec1.setText("Price with Tax");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cwhat)
                    .addComponent(price)
                    .addComponent(cphone)
                    .addComponent(cname))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb, 0, 372, Short.MAX_VALUE)
                    .addComponent(ok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pricew)
                            .addComponent(pricewn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pricetn)
                            .addComponent(pricet)))
                    .addComponent(cnamefield)
                    .addComponent(cphonefield))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sec1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sec2))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cname)
                    .addComponent(cnamefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cphone)
                    .addComponent(cphonefield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(sec1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cwhat)
                    .addComponent(sec2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(price)
                    .addComponent(pricew)
                    .addComponent(pricet))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pricewn)
                    .addComponent(pricetn))
                .addGap(27, 27, 27)
                .addComponent(ok)
                .addGap(15, 15, 15))
        );

        ok.getAccessibleContext().setAccessibleName("ok");
        cname.getAccessibleContext().setAccessibleName("cname");
        cphone.getAccessibleContext().setAccessibleName("cphone");
        cb.getAccessibleContext().setAccessibleName("cb");
        cwhat.getAccessibleContext().setAccessibleName("what");
        price.getAccessibleContext().setAccessibleName("price");
        pricew.getAccessibleContext().setAccessibleName("pricew");
        pricet.getAccessibleContext().setAccessibleName("pricet");
        pricewn.getAccessibleContext().setAccessibleName("pricewn");
        pricetn.getAccessibleContext().setAccessibleName("pricetn");
        cnamefield.getAccessibleContext().setAccessibleName("name");
        cphonefield.getAccessibleContext().setAccessibleName("phone");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okActionPerformed

    private void cbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActionPerformed

    private void cnamefieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnamefieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cnamefieldActionPerformed

    private void sec2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sec2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sec2ActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JLabel cname;
    private javax.swing.JTextField cnamefield;
    private javax.swing.JLabel cphone;
    private javax.swing.JTextField cphonefield;
    private javax.swing.JLabel cwhat;
    private javax.swing.JButton ok;
    private javax.swing.JLabel price;
    private javax.swing.JLabel pricet;
    private javax.swing.JLabel pricetn;
    private javax.swing.JLabel pricew;
    private javax.swing.JLabel pricewn;
    private javax.swing.JLabel sec1;
    private javax.swing.JTextField sec2;
    // End of variables declaration//GEN-END:variables
}
