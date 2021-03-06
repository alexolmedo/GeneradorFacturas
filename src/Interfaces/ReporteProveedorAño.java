/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import conexionBDD.Conexionn;
import groovy.sql.ResultSetMetaDataWrapper;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author vengatus
 */
public class ReporteProveedorAño extends javax.swing.JInternalFrame {

    Conexionn conn;
    String cedula_usuario;
    int anio;
    //JTable auxP, auxN;

    public ReporteProveedorAño(Conexionn conn, String cedula_usuario, int anio) {
        initComponents();
        //setIconImage(new ImageIcon(getClass().getResource("/Imagenes/ico_21-1.png")).getImage());
        //Aceptar.setVisible(false);
        this.conn = conn;
        this.cedula_usuario = cedula_usuario;
        this.anio = anio;
        this.tablaProv.setVisible(false);
        this.comboProv1.setEnabled(false);
        cargar_Provee();
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component north = ui.getNorthPane();
        MouseMotionListener[] actions
                = (MouseMotionListener[]) north.getListeners(MouseMotionListener.class);
        for (MouseMotionListener action : actions) {
            north.removeMouseMotionListener(action);
        }
                       
        /*comboProv.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                if (e.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        System.out.println("Holas");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });*/
    }

    public void cargar_Provee() {
        comboProv.removeAllItems();
        comboProv.addItem("Seleccione un proveedor...");
        ArrayList proov = conn.cargarEstablecimiento();
        for (Object obj : proov) {
            comboProv.addItem(obj.toString());
            //System.out.println(obj.toString());
        }
    }
    
    public void cargar_Cliente() {
        comboProv1.removeAllItems();
        comboProv1.addItem("Seleccione un cliente...");
        ArrayList proov = conn.cargarCliente((String) comboProv.getSelectedItem());
        for (Object obj : proov) {
            comboProv1.addItem(obj.toString());
            System.out.println(obj.toString());
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

        lbl_Reporte = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboProv = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProv = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        comboProv1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(880, 650));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lbl_Reporte.setFont(new java.awt.Font("Open Sans", 1, 48)); // NOI18N
        lbl_Reporte.setText("Reporte Facturas por Proveedor ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Proveedor:");

        comboProv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboProv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un proveedor..." }));
        comboProv.setToolTipText("");
        comboProv.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProvItemStateChanged(evt);
            }
        });
        comboProv.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboProvPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProvActionPerformed(evt);
            }
        });

        tablaProv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Factura", "CI CLiente", "RUC Prov", "Tipo", "Fecha Emision", "Estado Fact", "Ambiente", "Total sin IVA", "IVA", "Total con IVA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaProv);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Cliente");

        comboProv1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        comboProv1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un  cliente..." }));
        comboProv1.setToolTipText("");
        comboProv1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProv1ItemStateChanged(evt);
            }
        });
        comboProv1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                comboProv1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        comboProv1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProv1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(comboProv1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbl_Reporte)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(lbl_Reporte)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboProv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(comboProv1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        String[] datoi;
        

    }//GEN-LAST:event_formComponentShown

    private void comboProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProvActionPerformed

    private void comboProvItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProvItemStateChanged
        // TODO add your handling code here:
        tablaProv.setVisible(true);
    }//GEN-LAST:event_comboProvItemStateChanged

    private void comboProvPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboProvPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        cargar_Cliente();
        comboProv1.setEnabled(true);
    }//GEN-LAST:event_comboProvPopupMenuWillBecomeInvisible

    private void comboProv1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProv1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProv1ItemStateChanged

    private void comboProv1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_comboProv1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        ArrayList historial_p = conn.ddl(String.format("select * from factura"));
        ArrayList idEstab = conn.ddl(String.format("select id_establecimiento from establecimiento where nombre_establecimiento='%s'", comboProv.getSelectedItem().toString()));
        int sel;
                
        System.out.println(idEstab.get(0));
        if (!historial_p.isEmpty()) {
            
            Statement st;
            try {
                st = conn.getConn().createStatement();
                ResultSet rs = st.executeQuery(String.format("select * from factura where id_establecimiento=%s and id_cliente=%s", idEstab.get(0), comboProv1.getSelectedItem().toString()));
                ResultSetMetaData rsMd = rs.getMetaData();
                int numeroColumnas = rsMd.getColumnCount();
                //System.out.println("estoy en dfdfg" + rs.getString(0));
                
                int i=0;
                while(rs.next()){
                    System.out.println("estoy en el while");                    
                    for(int j=0;j<numeroColumnas;j++){
                        System.out.println(rs.getObject(j+1));
                        tablaProv.setValueAt(rs.getObject(j+1), i, j);
                        System.out.println(rs.getObject(j+1));
                    }
                    i++;
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ReporteProveedorAño.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            //txtPersonal.setText((String) historial_p.get(8));
            //JTable tabH = new JTable
            /*JTable tablaHistorialP = new JTable(datosTabla, nombreCabeceras) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            auxP = tablaHistorialP;

            DefaultTableCellRenderer alinearDerecha = new DefaultTableCellRenderer();
            alinearDerecha.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
            tablaHistorialP.getColumnModel().getColumn(1).setCellRenderer(alinearDerecha);
            tablaHistorialP.getColumnModel().getColumn(2).setCellRenderer(alinearDerecha);
            

            //txtPersonal.setText((String) historial_p.get(8));
            //JTable tabH = new JTable
            /*JTable tablaHistorialP = new JTable(datosTabla, nombreCabeceras) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            auxP = tablaHistorialP;

            DefaultTableCellRenderer alinearDerecha = new DefaultTableCellRenderer();
            alinearDerecha.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
            tablaHistorialP.getColumnModel().getColumn(1).setCellRenderer(alinearDerecha);
            tablaHistorialP.getColumnModel().getColumn(2).setCellRenderer(alinearDerecha);
            tablaHistorialP.getColumnModel().getColumn(3).setCellRenderer(alinearDerecha);*/

        }
    }//GEN-LAST:event_comboProv1PopupMenuWillBecomeInvisible

    private void comboProv1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProv1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboProv1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    public void toExcel(JTable table, File file) {
        try {
            TableModel model = table.getModel();
            FileWriter excel = new FileWriter(file);

            for (int i = 0; i < model.getColumnCount(); i++) {
                excel.write(model.getColumnName(i) + "\t");
            }

            excel.write("\n");

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    excel.write(model.getValueAt(i, j).toString() + "\t");
                }
                excel.write("\n");
            }

            excel.close();

        } catch (IOException e) {
            System.out.println(e);
        }
    }

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
            java.util.logging.Logger.getLogger(ReporteProveedorAño.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteProveedorAño.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteProveedorAño.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteProveedorAño.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboProv;
    private javax.swing.JComboBox<String> comboProv1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_Reporte;
    private javax.swing.JTable tablaProv;
    // End of variables declaration//GEN-END:variables
}
