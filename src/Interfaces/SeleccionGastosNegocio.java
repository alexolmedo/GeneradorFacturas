/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import conexionBDD.Conexionn;
import javax.swing.JOptionPane;

/**
 *
 * @author Gabriela
 */
public class SeleccionGastosNegocio extends javax.swing.JFrame {

    Conexionn cp;
    Object datosProducto[][];
    String numFact;
    int anio;
    String cedulaCli;
    String tipo;
    String nombreEst;
    
    String totalSinImp, impuesto, totalConIVA;
    
    /**
     * Creates new form SeleccionGastosNegocio
     */
    public SeleccionGastosNegocio() {
        initComponents();
    }
    public SeleccionGastosNegocio(Conexionn cp,Object datosProducto[][],String numFact,
            int anio,String cedulaCli,String tipo,String nombreEst,String totalSinImp, 
            String impuesto,String totalConIVA) {
        initComponents();
        this.cp = cp;
        this.datosProducto = datosProducto;
        this.numFact = numFact;
        this.anio = anio;
        this.cedulaCli = cedulaCli;
        this.tipo = tipo;
        this.nombreEst = nombreEst;
        this.totalConIVA = totalConIVA;
        this.totalSinImp = totalSinImp;
        this.impuesto = impuesto;
   
        
        lblnegocio.setText(nombreEst);       
        
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
        cbArriendo = new javax.swing.JCheckBox();
        cbServiciosBasicos = new javax.swing.JCheckBox();
        cbmercaderia = new javax.swing.JCheckBox();
        cbSueldos = new javax.swing.JCheckBox();
        cbMovilizacion = new javax.swing.JCheckBox();
        cbViaticos = new javax.swing.JCheckBox();
        cbCapacitacion = new javax.swing.JCheckBox();
        cbSuministrosOficina = new javax.swing.JCheckBox();
        cbHerramientasTrabajo = new javax.swing.JCheckBox();
        cbOtros = new javax.swing.JCheckBox();
        lblnegocio = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Selccione el tipo de Gastos para su Negocio", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cbArriendo.setText("Arriendo");

        cbServiciosBasicos.setText("Sevicios Básicos");
        cbServiciosBasicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbServiciosBasicosActionPerformed(evt);
            }
        });

        cbmercaderia.setText("Mercaderia");
        cbmercaderia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmercaderiaActionPerformed(evt);
            }
        });

        cbSueldos.setText("Sueldos");

        cbMovilizacion.setText("Movilizacion");

        cbViaticos.setText("Viaticos");

        cbCapacitacion.setText("Capacitacion");

        cbSuministrosOficina.setText("Suministros de Oficina");

        cbHerramientasTrabajo.setText("Herramientas de Trabajo");

        cbOtros.setText("Otros");

        lblnegocio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnegocio.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbServiciosBasicos)
                    .addComponent(cbMovilizacion)
                    .addComponent(cbmercaderia)
                    .addComponent(cbCapacitacion)
                    .addComponent(cbHerramientasTrabajo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbArriendo)
                    .addComponent(cbSueldos)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cbSuministrosOficina, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbOtros))
                    .addComponent(cbViaticos))
                .addGap(20, 20, 20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(lblnegocio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblnegocio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbmercaderia)
                        .addGap(18, 18, 18)
                        .addComponent(cbServiciosBasicos)
                        .addGap(18, 18, 18)
                        .addComponent(cbMovilizacion)
                        .addGap(18, 18, 18)
                        .addComponent(cbCapacitacion)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbHerramientasTrabajo)
                            .addComponent(cbOtros)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbArriendo)
                        .addGap(18, 18, 18)
                        .addComponent(cbSueldos)
                        .addGap(18, 18, 18)
                        .addComponent(cbViaticos)
                        .addGap(18, 18, 18)
                        .addComponent(cbSuministrosOficina)))
                .addGap(16, 16, 16))
        );

        jButton1.setText("ACEPTAR");
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
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbmercaderiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmercaderiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmercaderiaActionPerformed

    private void cbServiciosBasicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbServiciosBasicosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbServiciosBasicosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!cbCapacitacion.isSelected() && !cbHerramientasTrabajo.isSelected() &&
                !cbMovilizacion.isSelected() && !cbOtros.isSelected() && !cbServiciosBasicos.isSelected() &&
                !cbSueldos.isSelected() && !cbSuministrosOficina.isSelected() && !cbViaticos.isSelected() &&
                !cbmercaderia.isSelected()){
            JOptionPane.showMessageDialog(null, "Seleccione al menos un tipo de gasto para su Negocio");
        }else{
            boolean merca = cbmercaderia.isSelected();
            boolean arriendo = cbArriendo.isSelected();
            boolean serviciosBasicos = cbServiciosBasicos.isSelected();
            boolean sueldos = cbSueldos.isSelected();
            boolean movi = cbMovilizacion.isSelected();
            boolean viaticos = cbViaticos.isSelected();
            boolean capacitacion = cbCapacitacion.isSelected();
            boolean suministros = cbSuministrosOficina.isSelected();
            boolean herramientas = cbHerramientasTrabajo.isSelected();
            boolean otros = cbOtros.isSelected();

            if(!cp.verificar_usuario("SELECT NEGOCIO FROM TIPO_GASTO_NEGOCIO WHERE NEGOCIO='" + nombreEst+ "'")){
                String query = "INSERT INTO TIPO_GASTO_NEGOCIO VALUES ('" + nombreEst + "','" + merca + "','" 
                        + arriendo + "','" + serviciosBasicos + "','" + sueldos + "','" + movi + "','" + viaticos + "','" 
                        + capacitacion +"','"+ suministros+"','"+ herramientas+"','"+otros+ "')";                
                cp.ddl(query);
            }
            
            SeleccionarTipoGastoNegocios seleccionarH = new SeleccionarTipoGastoNegocios(cp, datosProducto, numFact, anio, cedulaCli, tipo,nombreEst,totalSinImp, 
            impuesto,totalConIVA);
            seleccionarH.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionGastosNegocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionGastosNegocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionGastosNegocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionGastosNegocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionGastosNegocio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbArriendo;
    private javax.swing.JCheckBox cbCapacitacion;
    private javax.swing.JCheckBox cbHerramientasTrabajo;
    private javax.swing.JCheckBox cbMovilizacion;
    private javax.swing.JCheckBox cbOtros;
    private javax.swing.JCheckBox cbServiciosBasicos;
    private javax.swing.JCheckBox cbSueldos;
    private javax.swing.JCheckBox cbSuministrosOficina;
    private javax.swing.JCheckBox cbViaticos;
    private javax.swing.JCheckBox cbmercaderia;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblnegocio;
    // End of variables declaration//GEN-END:variables
}
