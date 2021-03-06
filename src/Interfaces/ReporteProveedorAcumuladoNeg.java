/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ReportExc.Exporter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexionBDD.Conexionn;
import groovy.sql.ResultSetMetaDataWrapper;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author vengatus
 */
public class ReporteProveedorAcumuladoNeg extends javax.swing.JInternalFrame {

    Conexionn conn;
    String cedula_usuario;
    int anio;
    //JTable auxP, auxN;

    public ReporteProveedorAcumuladoNeg(Conexionn conn, String cedula_usuario, int anio) {
        initComponents();
        //setIconImage(new ImageIcon(getClass().getResource("/Imagenes/ico_21-1.png")).getImage());
        //Aceptar.setVisible(false);
        this.conn = conn;
        this.cedula_usuario = cedula_usuario;
        this.anio = anio;
        this.tablaProv.setVisible(false);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        Component north = ui.getNorthPane();
        MouseMotionListener[] actions
                = (MouseMotionListener[]) north.getListeners(MouseMotionListener.class);
        for (MouseMotionListener action : actions) {
            north.removeMouseMotionListener(action);
        }    
        tablaProv.setEnabled(false);
        
        /*ArrayList tipoGastosNeg = conn.cargarTipoGasNegocio(cedula_usuario);
        DefaultTableModel dm = (DefaultTableModel) jTableTiposGasto.getModel();
            int i = 0;
            for (int l=0; l<tipoGastosNeg.size(); l++) {
                System.out.println("estoy en el while");
                dm.addRow(new Object [] {"",""});
                //for (int j = 0; j < 2; j++) {                                      
                    jTableTiposGasto.setValueAt(tipoGastosNeg.get(l).toString(),l ,0 );
                    jTableTiposGasto.setValueAt("0.0",l ,1 );
                    //System.out.println(rs.getObject(j + 1));
                //}
            }*/
    }
    
    public void cargarDato(String sfd) {
    
        nomCli.setText(sfd);
        CI.setText(cedula_usuario);
    }
    
    public void cargarTabla(String nombreProveedor) {
        labelAnio.setText(nombreProveedor);
        tablaProv.setVisible(true);
        Statement st;
        try {
            st = conn.getConn().createStatement();
            /*String co =" SELECT E.ID_ESTABLECIMIENTO, E.NOMBRE_ESTABLECIMIENTO, COUNT(ID_ESTABLECIMIENTO) FROM ESTABLECIMIENTO E JOIN"
                    + " FACTURA F ON F.ID_ESTABLECIMIENTO=E.ID_ESTABLECIMIENTO"
                    + " WHERE e.NOMBRE_ESTABLECIMIENTO ='"+nombreProveedor+"' ";*/
            String c = String.format("select id_establecimiento, nombre_establecimiento, count(id_establecimiento) "
                    + "from (select id_Factura, factura.id_establecimiento, nombre_establecimiento, total_sin_IVA, IVA,"
                    + " Total_con_iva \n" +"from factura join establecimiento on (factura.id_establecimiento = "
                    + "establecimiento.id_establecimiento) \n" +
                    "where (select substr(cast(fecha_emision as char),7) ='%s') and id_cliente = '%s' "
                    + "and establecimiento.nombre_establecimiento='%s' and tipo_factura = 'Negocio') \n" +
                    "group by id_establecimiento",anio, cedula_usuario, nombreProveedor);            
            System.out.println("Consulta q dudo");
            System.out.println(c);
            ResultSet rs = st.executeQuery(c);
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int numeroColumnas = rsMd.getColumnCount();
            //System.out.println("estoy en dfdfg" + rs.getString(0));
            
            DefaultTableModel dm = (DefaultTableModel) tablaProv.getModel();
            int i = 0;
            while (rs.next()) {
                //System.out.println("estoy en el while");
                dm.addRow(new Object[]{"", "", ""});
                for (int j = 0; j < numeroColumnas; j++) {                    
                    tablaProv.setValueAt(rs.getObject(j + 1),i ,j );                    
                    //System.out.println(rs.getObject(j + 1));
                }
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReporteProveedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        calcularTablaTipoNegocio(nombreProveedor);
    }
            
    public void calcularTablaTipoNegocio (String nombreProvedor){
                     
        labelAnio.setText(nombreProvedor);
        tablaProv.setVisible(true);
        Statement st;
        try {
            st = conn.getConn().createStatement();
            String c = String.format("select tipo, sum(total) from detalle \n" +
                    "join factura on (detalle.id_factura=factura.id_factura)  \n" +
                    "join establecimiento on (establecimiento.id_establecimiento=factura.id_establecimiento)\n" +
                    "where (select substr(cast(fecha_emision as char),7) ='%s') \n" +
                    "and id_cliente = '%s' and establecimiento.nombre_establecimiento='%s'\n" +                   
                    "and tipo_factura='Negocio' group by detalle.tipo",anio, cedula_usuario, nombreProvedor);            
            
            System.out.println(c);
            ResultSet rs = st.executeQuery(c);
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int numeroColumnas = rsMd.getColumnCount();
            //System.out.println("estoy en dfdfg" + rs.getString(0));
            
            DefaultTableModel dm = (DefaultTableModel) jTableTiposGasto.getModel();
            int i = 0;
            while (rs.next()) {
                //System.out.println("estoy en el while");
                dm.addRow(new Object[]{"", "", ""});
                for (int j = 0; j < numeroColumnas; j++) {                    
                    jTableTiposGasto.setValueAt(rs.getObject(j + 1),i ,j );                    
                    //System.out.println(rs.getObject(j + 1));
                }
                i++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ReporteProveedor.class.getName()).log(Level.SEVERE, null, ex);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProv = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CI = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        nomCli = new javax.swing.JTextField();
        botonExcel = new javax.swing.JButton();
        labelAnio = new javax.swing.JLabel();
        botonPdf = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTiposGasto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(1035, 410));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        lbl_Reporte.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        lbl_Reporte.setText("Acumulado Facturas del proveedor ");

        tablaProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RUC Prov", "Nomb Prov", "Num Fac"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaProv);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel.png"))); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Cliente:");

        CI.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CI.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("CI");

        nomCli.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nomCli.setEnabled(false);

        botonExcel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_application-xml_28904.png"))); // NOI18N
        botonExcel.setText("Exportar Excel");
        botonExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonExcelActionPerformed(evt);
            }
        });

        labelAnio.setFont(new java.awt.Font("Open Sans", 0, 24)); // NOI18N
        labelAnio.setText("xyz");

        botonPdf.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/if_19_1737236.png"))); // NOI18N
        botonPdf.setText("Exportar Pdf");
        botonPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPdfActionPerformed(evt);
            }
        });

        jTableTiposGasto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableTiposGasto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTableTiposGasto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Gasto", "Total Acumulado"
            }
        ));
        jScrollPane3.setViewportView(jTableTiposGasto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(botonPdf)
                                .addGap(18, 18, 18)
                                .addComponent(botonExcel))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(103, 103, 103))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(lbl_Reporte)
                            .addGap(18, 18, 18)
                            .addComponent(labelAnio))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(nomCli, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)
                            .addComponent(jLabel5)
                            .addGap(18, 18, 18)
                            .addComponent(CI, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Reporte)
                    .addComponent(labelAnio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nomCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(CI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonExcel)
                            .addComponent(botonPdf))
                        .addGap(11, 11, 11)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        String[] datoi;
        

    }//GEN-LAST:event_formComponentShown

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botonExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonExcelActionPerformed
        // TODO add your handling code here:
        if (tablaProv.getRowCount() > 0) {
            JFileChooser chooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
            chooser.setFileFilter(filter);
            chooser.setDialogTitle("Guardar archivo");
            chooser.setAcceptAllFileFilterUsed(false);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {                
                List<JTable> tb = new ArrayList<>();
                List<String> nom = new ArrayList<>();
                tb.add(tablaProv);
                nom.add("Compras por factura");
                String file = chooser.getSelectedFile().toString().concat(".xls");
                try {
                    Exporter e = new Exporter(new File(file), tb, nom);
                    if (e.export()) {
                        JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(this, "No hay datos para exportar","Mensaje de error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botonExcelActionPerformed

    private void botonPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPdfActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos pdf", "pdf");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo");
        chooser.setAcceptAllFileFilterUsed(false);
        
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {  
        
            String file = chooser.getSelectedFile().toString().concat(".pdf");
            
            try{
            Document doc = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(doc, new FileOutputStream(new File(file)));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(tablaProv.getColumnCount());
            for (int i = 0; i < tablaProv.getColumnCount(); i++) {
                    pdfTable.addCell(tablaProv.getColumnName(i));
                }
                //extracting data from the JTable and inserting it to PdfPTable
                for (int rows = 0; rows < tablaProv.getRowCount(); rows++) {
                    for (int cols = 0; cols < tablaProv.getColumnCount(); cols++) {
                        pdfTable.addCell(tablaProv.getModel().getValueAt(rows, cols).toString());

                    }
                }
                doc.add(pdfTable);
                doc.close();
                JOptionPane.showMessageDialog(null, "Los datos fueron exportados a pdf en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);

            } catch (DocumentException ex) {

            } catch (FileNotFoundException ex) {

            }
        }
    }//GEN-LAST:event_botonPdfActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteProveedorAcumuladoNeg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteProveedorAcumuladoNeg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteProveedorAcumuladoNeg.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteProveedorAcumuladoNeg.class
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
    private javax.swing.JTextField CI;
    private javax.swing.JButton botonExcel;
    private javax.swing.JButton botonPdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableTiposGasto;
    private javax.swing.JLabel labelAnio;
    private javax.swing.JLabel lbl_Reporte;
    private javax.swing.JTextField nomCli;
    private javax.swing.JTable tablaProv;
    // End of variables declaration//GEN-END:variables
}
