/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import Modelo.Conexion;
import static Principal.Principal.tbl_eventos_hoy;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yeffr
 */
public class frm_eventoEnvivo extends javax.swing.JFrame {

    /**
     * Creates new form frm_eventoEnvivo
     */
    
    public frm_eventoEnvivo() {
        initComponents();
        rrellenarListaInvitado();
        invitadofaltan();
        recibidor2.setText(frm_eventoshoy.cmbeventoshoy.getSelectedItem().toString());
    }
    
    public static  void rrellenarListaInvitado()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre Invitado");
        model.addColumn("Apellido");
        model.addColumn("Sexo");
        model.addColumn("Email");
         try 
        {
            Statement stm = Conexion.conectar().createStatement();
            ResultSet rs = stm.executeQuery("Select NombrePersona,Apellido,Sexo,Email From " +
" Personas join Invitados on " +
" Personas.IdPersonas=Invitados.IdPersona " +
"  join Invitaciones on " +
"  Invitaciones.IdInvitado=Invitados.IdInvitados " +
"   join EventosHoy on EventosHoy.Id=Invitaciones.IdEvento  " +
"   where EventosHoy.Evento='"+frm_eventoshoy.cmbeventoshoy.getSelectedItem().toString()+"'");
           
            Object[] obj = new Object[4];
            while(rs.next())
            {
                
                obj[0]=rs.getString("NombrePersona" );
                obj[1]=rs.getString("Apellido");
                obj[2]=rs.getString("Sexo");
                obj[3]=rs.getString("Email");
               model.addRow(obj);
            }
            tbl_invitados.setModel(model);
            rs.close();
            stm.close();
            
        }
        catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public static void invitadofaltan()
    {
        try 
        {
            Statement stm = Conexion.conectar().createStatement();
            ResultSet rs = stm.executeQuery("Select count(*) as contador From Personas join Invitados on Personas.IdPersonas=Invitados.IdPersona " +
" join Invitaciones on Invitaciones.IdInvitado=Invitados.IdInvitados " +
" join EventosHoy on EventosHoy.Id=Invitaciones.IdEvento join "
 + "Visitas on Visitas.IdInvitacion=Invitaciones.IdInvitaciones" +
" where EventosHoy.Evento='"+frm_eventoshoy.cmbeventoshoy.getSelectedItem().toString()+"' and Invitaciones.IdInvitaciones not in(Select IdInvitaciones From Visitas)");
            
           
            Object[] obj = new Object[1];
            while(rs.next())
            {
                obj[0]=rs.getInt("contador");
                faltante.setText("Invitados que faltan: "+obj[0].toString());
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
        jPanel2 = new javax.swing.JPanel();
        blblatra = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        recibidor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_invitados = new javax.swing.JTable();
        faltante = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        recibidor2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnregistrarvisita = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        blblatra.setIcon(new javax.swing.ImageIcon("D:\\Mayo-Agosto\\Programacion1\\SistemaEventos\\img\\atras.png")); // NOI18N
        blblatra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blblatraMouseClicked(evt);
            }
        });

        recibidor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        tbl_invitados.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_invitados);

        faltante.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        faltante.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Buscar: ");

        recibidor2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        recibidor2.setText("jLabel2");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Mayo-Agosto\\Programacion1\\SistemaEventos\\img\\buz.png")); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Registrar Visita:");

        btnregistrarvisita.setBackground(new java.awt.Color(255, 255, 255));
        btnregistrarvisita.setIcon(new javax.swing.ImageIcon("D:\\Mayo-Agosto\\Programacion1\\SistemaEventos\\img\\lapiz.png")); // NOI18N
        btnregistrarvisita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregistrarvisitaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(blblatra)
                                .addGap(101, 101, 101)
                                .addComponent(recibidor)
                                .addGap(18, 18, 18)
                                .addComponent(recibidor2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(faltante)
                                .addGap(128, 128, 128)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnregistrarvisita, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(recibidor)
                            .addComponent(recibidor2))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(blblatra)
                        .addGap(18, 18, 18)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(faltante)))
                    .addComponent(jButton1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnregistrarvisita, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void blblatraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blblatraMouseClicked
      
        frm_eventoshoy frm = new frm_eventoshoy();
        this.setVisible(false);
        frm.setVisible(true);
        
    }//GEN-LAST:event_blblatraMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        frm_buscarinvitado f = new frm_buscarinvitado();
        this.setVisible(false);
        f.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnregistrarvisitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistrarvisitaMouseClicked
        frm_registrarvisita f = new frm_registrarvisita();
        this.setVisible(false);
        f.setVisible(true);
    }//GEN-LAST:event_btnregistrarvisitaMouseClicked

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
            java.util.logging.Logger.getLogger(frm_eventoEnvivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_eventoEnvivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_eventoEnvivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_eventoEnvivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_eventoEnvivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blblatra;
    private javax.swing.JButton btnregistrarvisita;
    private static javax.swing.JLabel faltante;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public javax.swing.JLabel recibidor;
    public static javax.swing.JLabel recibidor2;
    private static javax.swing.JTable tbl_invitados;
    // End of variables declaration//GEN-END:variables
}