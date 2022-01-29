package omadaready;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gouvo
 */

public class JSearchE extends javax.swing.JFrame {

    public String user;
    public String month, year;
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    
    public JSearchE() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        
    }
    
    public void choose(String x, String y){
        month = x;
        year = y;
        
    }
    
    public void prepare() {
        
        this.setTitle("Appointments for a month"); 
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        user = System.getProperty("user.name");
        String path = "C:\\Users\\"+user+"\\Documents\\#omadaReady\\" + month + " " + year;
        
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files == null){
            JOptionPane.showMessageDialog(new JFrame(), "Could not find an appointment for the month specified.", "Error",
            JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }else{
            this.setVisible(true);
            for(File f : files){
                if(f.isFile()){
                    try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            Scanner read = new Scanner(line);
                            read.useDelimiter("-");
                            while (read.hasNext()){
                                ArrayList<String> list = new ArrayList<String>();
                                String s1=read.next();
                                String s2=read.next();
                                String s3=read.next();
                                String s4=read.next();
                                String s5=read.next();
                                
                                list.add(s1);
                                list.add(s2);
                                list.add(s3);
                                list.add(s4);
                                list.add(s5);
                                String s6 = f.getName();
                                s6 = s6.substring(0, s6.length()-4);
                                list.add(s6);
                                model.addRow(list.toArray());
                            }
                        read.close();
                        }
                    } catch (FileNotFoundException ex) {
                    } catch (IOException ex) {
                        Logger.getLogger(JSearchE.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            table.setModel(model);
            int z = model.getRowCount();
            float x = 0;
            float y = 0;
            String temp;
            for (int i = 0; i < z; i++){
                temp = (String) model.getValueAt(i, 3);
                x = x +Float.parseFloat(temp);
                temp = (String) model.getValueAt(i, 4);
                y = y + Float.parseFloat(temp);
            }
            temp = df.format(x);
            jpricew.setText(temp);
            temp = df.format(y);
            jpricet.setText(temp);
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jpricew = new javax.swing.JLabel();
        jpricet = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone", "Service", "Price without Tax", "Price with Tax included", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel11.setText("Total money received without Tax");

        jLabel22.setText("Total money received with Tax included:");

        jpricew.setText("0");

        jpricet.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpricew)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(jpricet))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jpricet)
                    .addComponent(jpricew))
                .addGap(0, 33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JSearchE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JSearchE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JSearchE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JSearchE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JSearchE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jpricet;
    private javax.swing.JLabel jpricew;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
