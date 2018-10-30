
package Vista;

import Controlador.ControlProceso;
import Modelo.Proceso;
import Modelo.TablaProceso;
import Modelo.TablaResultado;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Queue;





public class VistaPrincipal extends javax.swing.JFrame {

    ControlProceso a = new ControlProceso();
    private static TablaProceso tableProc = new TablaProceso();
    private static TablaResultado tableResult = new TablaResultado();
    
    
     
    
    
    public VistaPrincipal() {       
        initComponents();
        
        this.setSize(1000, 795);
        this.setResizable(false);
        this.setLocationRelativeTo(null);        
        tableProceso.setModel(tableProc.getModel());    
        tableResultado.setModel(tableResult.getModel());   
        tableResultado.setAutoResizeMode(0);
   
        
    }

   
    public static void refreshTableProcess(){
    
        tableProc.getModel().setNumRows(0);
        tableProc.setData();
        
    }
    
    
    public static void refreshTR(){
    tableResult.getModel().setNumRows(0);
    tableResult.getModel().setColumnCount(0);
    
    
    }
    
    
    private void llenartest(){
    
       ControlProceso b = new ControlProceso();
       b.getColaProceso().add(new Proceso("A",0,7,1));
       b.getColaProceso().add(new Proceso("B",2,4,1));
       b.getColaProceso().add(new Proceso("C",4,1,1));  
       b.getColaProceso().add(new Proceso("D",5,4,1));        
       
           refreshTableProcess(); 
       
  
    }
    
  
 
   private void escribir(){
      
        Queue<Proceso> colita =  a.getColaProceso();
        
       
        try {
            FileOutputStream fileout = new FileOutputStream("data1.txt");           
            try {               
                
                ObjectOutputStream obout = new ObjectOutputStream(fileout);               
                obout.writeObject(colita);
                obout.close();
                
            } catch (IOException r) {
            
               
            
            }
            } catch (FileNotFoundException e) {
            
                
               
            }

        
    }

    
    
     
         
         
         
         
         
         
         
   
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProceso = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSFJ = new javax.swing.JButton();
        btnPrio = new javax.swing.JButton();
        btnFCFS = new javax.swing.JButton();
        btnSRJF = new javax.swing.JButton();
        btnRR = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResultado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 44, 120, 50));

        tableProceso.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableProceso);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(293, 44, -1, 210));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("PROCESOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 9, -1, -1));

        jToggleButton1.setText("LLenar");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 113, -1, 32));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("<------ Si tiene Flojera!!");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 112, -1, 32));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 760, 260));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSFJ.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnSFJ.setText("SFJ");
        btnSFJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSFJActionPerformed(evt);
            }
        });
        jPanel2.add(btnSFJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(347, 21, 80, 39));

        btnPrio.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnPrio.setText("Prioridad");
        btnPrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrioActionPerformed(evt);
            }
        });
        jPanel2.add(btnPrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 70, -1, 39));

        btnFCFS.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnFCFS.setText("FCFS");
        btnFCFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFCFSActionPerformed(evt);
            }
        });
        jPanel2.add(btnFCFS, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 21, 80, 39));

        btnSRJF.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnSRJF.setText("SRTF");
        btnSRJF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSRJFActionPerformed(evt);
            }
        });
        jPanel2.add(btnSRJF, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 21, 80, 39));

        btnRR.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        btnRR.setText("RoundRobin");
        btnRR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRRActionPerformed(evt);
            }
        });
        jPanel2.add(btnRR, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 70, -1, 39));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 580, 120));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setText("RESULTADOS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, -1, -1));

        tableResultado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tableResultado);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 882, 90));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       
            VRegistrar va = new VRegistrar();
            va.setVisible(true);
        
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnFCFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFCFSActionPerformed
        escribir();
        tableResult.fCFS();
        a.llenar();
    }//GEN-LAST:event_btnFCFSActionPerformed

    private void btnSRJFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSRJFActionPerformed
        escribir();
        tableResult.sRTF();
        a.llenar();
    }//GEN-LAST:event_btnSRJFActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
      llenartest();
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btnRRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRRActionPerformed
        escribir();
        tableResult.roundRobin();
        a.llenar();
    }//GEN-LAST:event_btnRRActionPerformed

    private void btnSFJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSFJActionPerformed
       escribir();
       tableResult.sJF();
       a.llenar();
    }//GEN-LAST:event_btnSFJActionPerformed

    private void btnPrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrioActionPerformed
     escribir();
     tableResult.prioridad();
     a.llenar();
    }//GEN-LAST:event_btnPrioActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnFCFS;
    private javax.swing.JButton btnPrio;
    private javax.swing.JButton btnRR;
    private javax.swing.JButton btnSFJ;
    private javax.swing.JButton btnSRJF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTable tableProceso;
    private javax.swing.JTable tableResultado;
    // End of variables declaration//GEN-END:variables
}
