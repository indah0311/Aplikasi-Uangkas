
package Indah_Lestari_22220095;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author Rafli
 */
public class TabelMahasiswa extends javax.swing.JFrame {
    private Connection con;
    private Statement stat;
    private ResultSet res;
    /**
     * Creates new form TabelMahasiswa
     */
   
    public TabelMahasiswa() {
        initComponents();
        setTitle("TABLE DATA MAHASISWA");
        koneksi ();
        tabel ();
        Tabel.setAutoCreateRowSorter(true);
    }
    private void koneksi (){
        try {
         con=DriverManager.getConnection("jdbc:mysql://127.0.0.1/database_m.rafli_mauludin", "root", "");
         stat=con.createStatement();
         } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e);}
        }
        
        private void tabel (){
        DefaultTableModel t= new DefaultTableModel();
        t.addColumn("Nim");
        t.addColumn("Nama");
        t.addColumn("Jenis_Kelamin");
        t.addColumn("No_HP");
        t.addColumn("Alamat");
        Tabel.setModel(t); 
        try{ res= stat.executeQuery("select * from mahasiswa");
while (res.next()) {
    t.addRow(new Object[]{ res.getString("Nim"),
      res.getString("Nama"),
      res.getString("Jenis_Kelamin"),
      res.getString("No_Hp"),
      res.getString("Alamat")
        });
    }
}catch (Exception e) {
    JOptionPane.showMessageDialog(rootPane, e);
}    
        }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        kembali = new javax.swing.JButton();
        mahasiswa_1 = new javax.swing.JButton();
        uang_kas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kembali.setBackground(new java.awt.Color(102, 102, 102));
        kembali.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        kembali.setForeground(new java.awt.Color(255, 0, 0));
        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        jPanel2.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 80, 30));

        mahasiswa_1.setBackground(new java.awt.Color(102, 102, 102));
        mahasiswa_1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        mahasiswa_1.setForeground(new java.awt.Color(0, 204, 204));
        mahasiswa_1.setText("Pilih Mahasiswa");
        mahasiswa_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mahasiswa_1ActionPerformed(evt);
            }
        });
        jPanel2.add(mahasiswa_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 303, 160, 50));

        uang_kas.setBackground(new java.awt.Color(102, 102, 102));
        uang_kas.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        uang_kas.setForeground(new java.awt.Color(0, 51, 204));
        uang_kas.setText("Pilih Uang Kas");
        uang_kas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uang_kasActionPerformed(evt);
            }
        });
        jPanel2.add(uang_kas, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 170, 50));

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Tabel);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 710, 100));
        jPanel2.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
Mahasiswa data = new  Mahasiswa();
    private void mahasiswa_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mahasiswa_1ActionPerformed
        // TODO add your handling code here:
         int index = Tabel.getSelectedRow();
        
        TableModel model = Tabel.getModel();
        
        String nim = model.getValueAt(index, 0).toString();
        String nama = model.getValueAt(index, 1).toString();
        String jk = model.getValueAt(index, 2).toString();
        String nohp = model.getValueAt(index, 3).toString();
        String alamat = model.getValueAt(index, 4).toString();
      
       
        data.setVisible(true);
        data.pack();
        data.setLocationRelativeTo(null);
        data.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        data.nim_text.setText(nim);
        data.nama.setText(nama);
        data.status.setSelectedItem(jk);
        data.no_hp.setText(nohp);
        data.alamat.setText(alamat);
        dispose();
    }//GEN-LAST:event_mahasiswa_1ActionPerformed
Uang_Kas mahasiswa = new  Uang_Kas();
    private void uang_kasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uang_kasActionPerformed
        // TODO add your handling code here:
        int index = Tabel.getSelectedRow();
        
        TableModel model = Tabel.getModel();
        
        String nama = model.getValueAt(index, 1).toString();
      
       
        mahasiswa.setVisible(true);
        mahasiswa.pack();
        mahasiswa.setLocationRelativeTo(null);
        mahasiswa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        mahasiswa.Nama1.setText(nama);
        dispose();
    }//GEN-LAST:event_uang_kasActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        new Mahasiswa().setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

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
            java.util.logging.Logger.getLogger(TabelMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TabelMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TabelMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TabelMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TabelMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JLabel bg;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    private javax.swing.JButton mahasiswa_1;
    private javax.swing.JButton uang_kas;
    // End of variables declaration//GEN-END:variables
}
