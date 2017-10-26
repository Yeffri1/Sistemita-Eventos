/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Modelo.Conexion;
import Modelo.Portero;
import Modelo.Visita;
import Modelo.mantenimientoVisita;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author yeffr
 */
public class frm_registrarvisita extends javax.swing.JFrame {

    /**
     * Creates new form frm_registrarvisita
     */
    public frm_registrarvisita() {
        initComponents();
        jLabel2.setText("Registrar Visita en el evento "+frm_eventoEnvivo.recibidor2.getText());
        llenar();
    }
    
    public static void llenar()
    {
         try 
        {
            Statement stm = Conexion.conectar().createStatement();
            ResultSet rs = stm.executeQuery("Select NombrePersona From Personas join Invitados on Personas.IdPersonas=Invitados.IdPersona " +
"join Invitaciones on Invitaciones.IdInvitado=Invitados.IdInvitados " +
"join Eventos on Eventos.IdEventos=Invitaciones.IdEvento " +
"where Eventos.Nombre='"+frm_eventoshoy.cmbeventoshoy.getSelectedItem().toString()+"'");
            
           
            while(rs.next())
            {
                cmbninvitado.addItem(rs.getString("NombrePersona"));
            }
            rs.close();
            stm.close();
            
        }
        catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        cmbninvitado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        guardarvisita = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Mayo-Agosto\\Programacion1\\SistemaEventos\\img\\atras.png")); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Registrar Visita");

        cmbninvitado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Nombre Invitado:");

        guardarvisita.setIcon(new javax.swing.ImageIcon("D:\\Mayo-Agosto\\Programacion1\\SistemaEventos\\img\\guardar.png")); // NOI18N
        guardarvisita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarvisitaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(43, 43, 43))
                            .addComponent(jSeparator2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbninvitado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 115, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(guardarvisita)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbninvitado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(guardarvisita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        frm_eventoEnvivo f = new frm_eventoEnvivo();
        this.setVisible(false);
        f.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void guardarvisitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarvisitaMouseClicked
        
        int idinvitacion = 0;
          try 
        {
            Statement stm = Conexion.conectar().createStatement();
            ResultSet rs = stm.executeQuery("Select IdInvitaciones From Invitaciones " +
"INNER JOIN Invitados on Invitados.IdInvitados=Invitaciones.IdInvitado " +
"INNER JOIN Personas on Personas.IdPersonas=Invitados.IdPersona " +
"INNER JOIN Eventos on Eventos.IdEventos=Invitaciones.IdEvento " +
"where Eventos.Nombre='"+frm_eventoshoy.cmbeventoshoy.getSelectedItem().toString()+"' and NombrePersona='"+cmbninvitado.getSelectedItem().toString()+"'");
            
            Visita visit = new Visita();
           
            while(rs.next())
            {
                idinvitacion=rs.getInt("IdInvitaciones");
                visit.IdInvitacion=idinvitacion;
               
            }
            
            rs.close();
            stm.close();
            Portero p = new Portero();
            
            p._mantenimientoVisita = new mantenimientoVisita();
           if(p._mantenimientoVisita.registrarVisita(visit))
           {
               JOptionPane.showMessageDialog(null, "Visita registrada");
           }
           else
           {
               JOptionPane.showMessageDialog(null, "Error Registrando");
           }
            
        }
        catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
        
    }//GEN-LAST:event_guardarvisitaMouseClicked

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
            java.util.logging.Logger.getLogger(frm_registrarvisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_registrarvisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_registrarvisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_registrarvisita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_registrarvisita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox<String> cmbninvitado;
    private javax.swing.JLabel guardarvisita;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
