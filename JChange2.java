package omadaready;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

public class JChange2 extends javax.swing.JFrame {

    public String user;
    private static DecimalFormat df = new DecimalFormat("0.00");
    
    public JChange2() {
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    
    public void prepare(String path) throws FileNotFoundException, IOException{
        this.setLocationRelativeTo(null);
        this.setTitle("Change credentials"); 
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        DefaultTableModel model1 = (DefaultTableModel) table.getModel();
        user = System.getProperty("user.name");
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            if (br.readLine() == null){
                JOptionPane.showMessageDialog(new JFrame(), "Could not find an appointment for the day specified.", "Error",
            JOptionPane.ERROR_MESSAGE);
                this.dispose();
            }else{
                try (BufferedReader br1 = new BufferedReader(new FileReader(path))){
                    this.setVisible(true);
                    while ((line = br1.readLine()) != null) {
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
                            model.addRow(list.toArray());
                       }
                        read.close();
                    }
                    br1.close();
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
                br.close();
            }
        }
        
        save.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                FileWriter myWriter = null;
                try {
                    int r = table.getRowCount();
                    int c = table.getColumnCount();
                    System.out.println(r);
                    myWriter = new FileWriter(path, false);
                    BufferedWriter bf = new BufferedWriter(myWriter);
                    for (int i = 0; i < r; i++){
                        for (int j = 0; j < c; j++ ){
                            String temp;
                            temp = (String) table.getValueAt(i, j);
                            System.out.println(temp);
                            bf.write(temp);
                            if (j != 4){
                                bf.write("-");
                            }
                        }
                        bf.newLine();      
                    }
                    bf.close();
                } catch (IOException ex) {
                    Logger.getLogger(JChange2.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    try {
                        myWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(JChange2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }
    
    
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jpricew = new javax.swing.JLabel();
        jpricet = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Total money received without Tax");

        jLabel2.setText("Total money received with Tax included");

        jpricew.setText("0");

        jpricet.setText("0");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone Number", "Service", "Price without Tax", "Price with Tax included"
            }
        ));
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        save.setText("Save changes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jpricew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 251, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jpricet))
                .addGap(65, 65, 65))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpricet)
                    .addComponent(jpricew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(save)
                .addGap(16, 16, 16))
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
            java.util.logging.Logger.getLogger(JChange2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JChange2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JChange2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JChange2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JChange2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jpricet;
    private javax.swing.JLabel jpricew;
    private javax.swing.JButton save;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
