package omadaready;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gouvo
 */

public class JChange extends javax.swing.JFrame {

    private File theDir,fileDir;
    
    public JChange() {
        initComponents();
        this.setTitle("Change the credentials of an appointment");
        jLabel1.setText("<html>Day<br>(e.g. 04)</html>");
        jLabel2.setText("<html>Month<br>(e.g. December)<html>");
        jLabel3.setText("<html>Year<br>(e.g. 2021)</html>");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        prepare();
    }

    public void prepare(){
        
        String day,day1,month,year;  
        DateTimeFormatter dtf,dtf1,dtfm,dtfy;
        dtf = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        dtfm = DateTimeFormatter.ofPattern("MM");
        dtfy = DateTimeFormatter.ofPattern("yyyy");
        dtf1 = DateTimeFormatter.ofPattern("dd");
        LocalDateTime now = LocalDateTime.now();
        day = dtf.format(now);
        day1 = dtf1.format(now);
        month = dtfm.format(now);
        year = dtfy.format(now);
        
        String month1 = "";
        jTextField1.setText(day1);
        jTextField2.setText(year);
        if (month.equals("01")){
            month1 = "January";
        }else if (month.equals("02")){
            month1 = "February";
        }else if (month.equals("03")){
            month1 = "March";
        }else if (month.equals("04")){
            month1 = "April";
        }else if (month.equals("05")){
            month1 = "May";
        }else if (month.equals("06")){
            month1 = "June";
        }else if (month.equals("07")){
            month1 = "July";
        }else if (month.equals("08")){
            month1 = "August";
        }else if (month.equals("09")){
            month1 = "September";
        }else if (month.equals("10")){
            month1 = "October";
        }else if (month.equals("11")){
            month1 = "November";
        }else if (month.equals("12")){
            month1 = "December";
        }
        jComboBox1.setSelectedItem(month1);
        
        search.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String day = jTextField1.getText();
                String month = (String) jComboBox1.getSelectedItem();
                String month2 = " ";
                String year = jTextField2.getText();
                String user = System.getProperty("user.name");

                if (month.equals("January")){
                    month = "01";
                    month2 = "January";
                }else if (month.equals("February")){
                    month = "02";
                    month2 = "February";
                }else if (month.equals("March")){
                    month = "03";
                    month2 = "March";
                }else if (month.equals("April")){
                    month = "04";
                    month2 = "April";
                }else if (month.equals("May")){
                    month = "05";
                    month2 = "May";
                }else if (month.equals("June")){
                    month = "06";
                    month2 = "June";
                }else if (month.equals("July")){
                    month = "07";
                    month2 = "July";
                }else if (month.equals("August")){
                    month = "08";
                    month2 = "August";
                }else if (month.equals("September")){
                    month = "09";
                    month2 = "September";
                }else if (month.equals("October")){
                    month = "10";
                    month2 = "Octover";
                }else if (month.equals("November")){
                    month = "11";
                    month2 = "November";
                }else if (month.equals("December")){
                    month = "12";
                    month2 = "December";
                }
                String path = "C:\\Users\\"+user+"\\Documents\\#omadaReady\\" + month2 + " " + year;//"+day + "_"+month+"_"+year;
                theDir = new File(path);
                String path2 = path+"\\"+day + "_"+month+"_"+year+".txt";
                fileDir = new File(path2);
                if (!fileDir.exists()){
                    JOptionPane.showMessageDialog(new JFrame(), "Could not find an appointment for the day specified.","Error", JOptionPane.ERROR_MESSAGE);
                }else{
                    JChange2 c = new JChange2();
                    try {
                        c.prepare(path2);
                    } catch (IOException ex) {
                        Logger.getLogger(JChange.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("01");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Day");

        jLabel2.setText("Month");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));

        jLabel3.setText("Year");

        jTextField2.setText("2021");

        search.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2))
                .addContainerGap(149, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(search)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(JChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JChange.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JChange().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
