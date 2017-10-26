/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import javax.swing.table.DefaultTableModel;
import Modelo.Conexion;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author yeffr
 */
public class Principal extends javax.swing.JFrame {

    
    /**
     * Creates new form Principal
     */

    public Principal() {
        
        initComponents();
        eventosDeHoy();
    }
    public static void eventosDeHoy()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre de Evento");
        model.addColumn("Tipo");
        model.addColumn("Ubicacion");
         try 
        {
            Statement stm = Conexion.conectar().createStatement();
            ResultSet rs = stm.executeQuery("Select * from EventosHoy");
            
           
            Object[] obj = new Object[3];
            
            while(rs.next())
            {
                obj[0]=rs.getString("Evento");
                obj[1]=rs.getString("Tipo");
                obj[2]=rs.getString("Direccion");
                
                
                
               
               model.addRow(obj);
            }
            tbl_eventos_hoy.setModel(model);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelPrincipal = new javax.swing.JPanel();
        lbl_mantenimiento = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelInfoUser = new javax.swing.JPanel();
        lblrol = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_eventos_hoy = new javax.swing.JTable();
        iniciarevento = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        lbl_mantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lbl_mantenimiento.setIcon(new javax.swing.ImageIcon("D:\\Mayo-Agosto\\Programacion1\\SistemaEventos\\img\\config.png")); // NOI18N
        lbl_mantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_mantenimientoMouseClicked(evt);
            }
        });
        lbl_mantenimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbl_mantenimientoKeyPressed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Mantenimiento");

        panelInfoUser.setBackground(new java.awt.Color(222, 244, 246));

        lblrol.setText("jLabel1");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Rol:");

        lblnombre.setBackground(new java.awt.Color(255, 255, 255));
        lblnombre.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblnombre.setForeground(new java.awt.Color(204, 204, 204));
        lblnombre.setText("Nombre:");

        javax.swing.GroupLayout panelInfoUserLayout = new javax.swing.GroupLayout(panelInfoUser);
        panelInfoUser.setLayout(panelInfoUserLayout);
        panelInfoUserLayout.setHorizontalGroup(
            panelInfoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoUserLayout.createSequentialGroup()
                .addGroup(panelInfoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInfoUserLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblrol, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblnombre))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        panelInfoUserLayout.setVerticalGroup(
            panelInfoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInfoUserLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(panelInfoUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblrol))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblnombre)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        tbl_eventos_hoy.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_eventos_hoy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_eventos_hoyMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbl_eventos_hoyMouseEntered(evt);
            }
        });
        tbl_eventos_hoy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_eventos_hoyKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_eventos_hoy);

        iniciarevento.setIcon(new javax.swing.ImageIcon("D:\\Mayo-Agosto\\Programacion1\\SistemaEventos\\img\\play.png")); // NOI18N
        iniciarevento.setText("jLabel1");
        iniciarevento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciareventoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInfoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(iniciarevento, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_mantenimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelInfoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lbl_mantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addGroup(panelPrincipalLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(iniciarevento)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_mantenimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbl_mantenimientoKeyPressed
           
//        Mantenimiento mante = new Mantenimiento();
//        this.setVisible(false);
//        mante.setVisible(true);
        
    }//GEN-LAST:event_lbl_mantenimientoKeyPressed

    private void lbl_mantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_mantenimientoMouseClicked
        
        Mantenimiento mante = new Mantenimiento();
        this.setVisible(false);
        mante.setVisible(true);
        
        
    }//GEN-LAST:event_lbl_mantenimientoMouseClicked

    private void tbl_eventos_hoyMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_eventos_hoyMouseEntered
     
    }//GEN-LAST:event_tbl_eventos_hoyMouseEntered

    private void tbl_eventos_hoyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_eventos_hoyMouseClicked
  
    }//GEN-LAST:event_tbl_eventos_hoyMouseClicked

    private void tbl_eventos_hoyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_eventos_hoyKeyReleased
   

        
        
    }//GEN-LAST:event_tbl_eventos_hoyKeyReleased

    private void iniciareventoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciareventoMouseClicked
        frm_eventoshoy frm = new frm_eventoshoy();
        this.setVisible(false);
        frm.setVisible(true);
    }//GEN-LAST:event_iniciareventoMouseClicked

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iniciarevento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_mantenimiento;
    private javax.swing.JLabel lblnombre;
    public static javax.swing.JLabel lblrol;
    private javax.swing.JPanel panelInfoUser;
    private javax.swing.JPanel panelPrincipal;
    public static javax.swing.JTable tbl_eventos_hoy;
    // End of variables declaration//GEN-END:variables
}
