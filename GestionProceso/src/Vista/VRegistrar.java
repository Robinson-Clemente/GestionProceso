package Vista;

import Controlador.ControlProceso;
import Modelo.Proceso;
import javax.swing.JOptionPane;

public class VRegistrar extends javax.swing.JFrame {

    ControlProceso b = new ControlProceso();

    public VRegistrar() {
        initComponents();
        this.setSize(470, 410);
        this.setDefaultCloseOperation(2);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    private void addToQueue() {

        boolean status = false;

        if (txtNombre.getText().isEmpty() || txtLlegada.getText().isEmpty()
                || txtTiempo.getText().isEmpty() || txtPrioridad.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Llene todas las casillas", null, 2);

        } else {

            String nombre = txtNombre.getText();
            int llegada = Integer.parseInt(txtLlegada.getText());
            int tiempo = Integer.parseInt(txtTiempo.getText());
            int prioridad = Integer.parseInt(txtPrioridad.getText());

            if (llegada < 0 | tiempo <= 0 | prioridad <=0) {

                JOptionPane.showMessageDialog(null, "Datos negativos o no admitidos", null, 2);

            } else {

                Proceso proc = new Proceso(nombre, llegada, tiempo, prioridad);

                for (Proceso p : b.getColaProceso()) {

                    if (proc.getNombre().equals(p.getNombre()) & proc.getLlegada()==p.getLlegada() 
                        & proc.getProceso()==p.getProceso() & proc.getPrioridad()==p.getPrioridad()) {
                        status = true;
                        break;
                    }
                }

                if (status) {

                    JOptionPane.showMessageDialog(null, "El proceso ya existe por favor digite otro", null, 2);

                } else {

                    b.getColaProceso().offer(proc);
                    VistaPrincipal.refreshTableProcess();
                    this.dispose();

                }

            }

        }

    }

 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtLlegada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTiempo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPrioridad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 53, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 47, 147, 28));

        txtLlegada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLlegadaKeyTyped(evt);
            }
        });
        jPanel1.add(txtLlegada, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 93, 147, 28));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("LLegada");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 99, -1, -1));

        txtTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTiempoActionPerformed(evt);
            }
        });
        txtTiempo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTiempoKeyTyped(evt);
            }
        });
        jPanel1.add(txtTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 139, 147, 28));

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setText("Tiempo");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 145, -1, -1));

        txtPrioridad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrioridadKeyTyped(evt);
            }
        });
        jPanel1.add(txtPrioridad, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 185, 147, 28));

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setText("Prioridad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 191, -1, -1));

        btnIngresar.setText("REGISTRAR");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 300, 110, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 35, 410, 350));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setText("INGRESO DE PROCESOS");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 12, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTiempoActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        addToQueue();

    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       
        char a = evt.getKeyChar();
        if (Character.isDigit(a)) {
            evt.consume();
        }

        
        
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtLlegadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLlegadaKeyTyped
       
        char a = evt.getKeyChar();
        if(!Character.isDigit(a)){        
        evt.consume();        
        }
        
    }//GEN-LAST:event_txtLlegadaKeyTyped

    private void txtTiempoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTiempoKeyTyped
       
        char a = evt.getKeyChar();
        if(!Character.isDigit(a)){        
        evt.consume();        
        }
        
    }//GEN-LAST:event_txtTiempoKeyTyped

    private void txtPrioridadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrioridadKeyTyped
       
        char a = evt.getKeyChar();
        if(!Character.isDigit(a)){        
        evt.consume();        
        }
        
        
    }//GEN-LAST:event_txtPrioridadKeyTyped

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
            java.util.logging.Logger.getLogger(VRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VRegistrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtLlegada;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrioridad;
    private javax.swing.JTextField txtTiempo;
    // End of variables declaration//GEN-END:variables
}
