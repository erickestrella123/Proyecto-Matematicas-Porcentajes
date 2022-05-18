/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.ImageIcon;

/**
 *
 * @author User
 */
public class Presentacion1 extends javax.swing.JFrame {

    /**
     * Creates new form Presentacion1
     */
    public Presentacion1() {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/Img_Icono.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Jbtn_Jugar = new javax.swing.JButton();
        Jbtn_Tabla = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Jbtn_Creditoss = new javax.swing.JButton();
        Jbtn_Salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(740, 572));
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Jbtn_Jugar.setBackground(new java.awt.Color(255, 255, 255));
        Jbtn_Jugar.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        Jbtn_Jugar.setText("Jugar");
        Jbtn_Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_JugarActionPerformed(evt);
            }
        });
        jPanel1.add(Jbtn_Jugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 100, 40));

        Jbtn_Tabla.setBackground(new java.awt.Color(255, 255, 255));
        Jbtn_Tabla.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        Jbtn_Tabla.setText("Tabla");
        Jbtn_Tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_TablaActionPerformed(evt);
            }
        });
        jPanel1.add(Jbtn_Tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 100, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Porcentaje");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        Jbtn_Creditoss.setBackground(new java.awt.Color(255, 255, 255));
        Jbtn_Creditoss.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        Jbtn_Creditoss.setText("Creditos");
        Jbtn_Creditoss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_CreditossActionPerformed(evt);
            }
        });
        jPanel1.add(Jbtn_Creditoss, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 120, 40));

        Jbtn_Salir.setBackground(new java.awt.Color(255, 255, 255));
        Jbtn_Salir.setFont(new java.awt.Font("Verdana", 1, 20)); // NOI18N
        Jbtn_Salir.setText("Salir");
        Jbtn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Jbtn_SalirActionPerformed(evt);
            }
        });
        jPanel1.add(Jbtn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 100, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Img_Profesor.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 610, 410));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Jbtn_JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_JugarActionPerformed
        // iniciamos el juego
        Jfrm_Juego inicio_juego = new Jfrm_Juego();
        this.dispose();
        inicio_juego.setVisible(true);
    }//GEN-LAST:event_Jbtn_JugarActionPerformed

    private void Jbtn_TablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_TablaActionPerformed
        Jfrm_Tabla Tabla = new Jfrm_Tabla();
        Tabla.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Jbtn_TablaActionPerformed

    private void Jbtn_CreditossActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_CreditossActionPerformed
        // Nos lleva a la ventana de creditos
        Jfrm_Creditos Creditos = new Jfrm_Creditos();
        Creditos.setVisible(true);
    }//GEN-LAST:event_Jbtn_CreditossActionPerformed

    private void Jbtn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Jbtn_SalirActionPerformed
        // Permite Salir del Juego
        dispose();
    }//GEN-LAST:event_Jbtn_SalirActionPerformed

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
            java.util.logging.Logger.getLogger(Presentacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Presentacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Presentacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Presentacion1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Presentacion1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jbtn_Creditoss;
    private javax.swing.JButton Jbtn_Jugar;
    private javax.swing.JButton Jbtn_Salir;
    private javax.swing.JButton Jbtn_Tabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
