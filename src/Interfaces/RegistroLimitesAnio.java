/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import conexionBDD.Conexionn;
import javax.swing.ImageIcon;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowFocusListener;
//import java.awt.event.WindowListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import sun.awt.WindowClosingSupport;

/**
 *
 * @author vengatus
 */
public class RegistroLimitesAnio extends javax.swing.JFrame {

    Login login;

    public RegistroLimitesAnio(Login login) {
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/Imagenes/ico_21-1.png")).getImage());
        this.login = login;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_vestimenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_anio = new javax.swing.JTextField();
        txt_vivienda = new javax.swing.JTextField();
        txt_salud = new javax.swing.JTextField();
        txt_educacion = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_alimentacion = new javax.swing.JTextField();
        btn_Registrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(350, 450));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(java.awt.Color.black);
        jLabel7.setFont(new java.awt.Font("Open Sans Extrabold", 1, 24)); // NOI18N
        jLabel7.setText("REGISTRO DE LIMITES");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel4.setBackground(java.awt.Color.black);
        jLabel4.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel4.setText("Alimentacion:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel5.setBackground(java.awt.Color.black);
        jLabel5.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel5.setText("Salud:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        txt_vestimenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_vestimentaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_vestimenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 120, 30));

        jLabel6.setBackground(java.awt.Color.black);
        jLabel6.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel6.setText("VIvienda:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel10.setBackground(java.awt.Color.black);
        jLabel10.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel10.setText("Vestimenta:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        txt_anio.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        txt_anio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_anioKeyTyped(evt);
            }
        });
        getContentPane().add(txt_anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 90, 30));

        txt_vivienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_viviendaKeyTyped(evt);
            }
        });
        getContentPane().add(txt_vivienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 120, 30));

        txt_salud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_saludKeyTyped(evt);
            }
        });
        getContentPane().add(txt_salud, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 120, 30));

        txt_educacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_educacionKeyTyped(evt);
            }
        });
        getContentPane().add(txt_educacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 120, 30));

        jLabel11.setBackground(java.awt.Color.black);
        jLabel11.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        jLabel11.setText("Educacion:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel8.setBackground(java.awt.Color.black);
        jLabel8.setFont(new java.awt.Font("Open Sans Extrabold", 1, 14)); // NOI18N
        jLabel8.setText("AÑO:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        jLabel9.setBackground(java.awt.Color.black);
        jLabel9.setFont(new java.awt.Font("Open Sans Extrabold", 1, 18)); // NOI18N
        jLabel9.setText("LIMITES");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txt_alimentacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_alimentacionKeyTyped(evt);
            }
        });
        getContentPane().add(txt_alimentacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 120, 30));

        btn_Registrar.setText("Registrar");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 150, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_saludKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_saludKeyTyped
        filtrar(evt, txt_salud);
    }//GEN-LAST:event_txt_saludKeyTyped

    private void txt_alimentacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_alimentacionKeyTyped
        filtrar(evt, txt_alimentacion);
    }//GEN-LAST:event_txt_alimentacionKeyTyped

    private void txt_viviendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_viviendaKeyTyped
        filtrar(evt, txt_vivienda);
    }//GEN-LAST:event_txt_viviendaKeyTyped

    private void txt_educacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_educacionKeyTyped
        filtrar(evt, txt_educacion);
    }//GEN-LAST:event_txt_educacionKeyTyped

    private void txt_vestimentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_vestimentaKeyTyped
        filtrar(evt, txt_vestimenta);
    }//GEN-LAST:event_txt_vestimentaKeyTyped

    private void txt_anioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_anioKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) || txt_anio.getText().length() > 3) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_anioKeyTyped

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        String anio = txt_anio.getText(),
                alim = txt_alimentacion.getText(),
                edu = txt_educacion.getText(),
                salud = txt_salud.getText(),
                vest = txt_vestimenta.getText(),
                viv = txt_vivienda.getText();
        if (anio.equals("") || alim.equals("") || edu.equals("")
                || salud.equals("") || vest.equals("") || viv.equals("")) {
            JOptionPane.showMessageDialog(null, "Es necesario llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (anio.length() == 4) {
                conexionBDD.Conexionn conn = new Conexionn();
                if (!conn.verificar_usuario(String.format("select * from gastosanualespersonales where anio_gastos=%s", anio))) {
                    conn.insertar(String.format("insert into gastosanualespersonales values(%s,%s,%s,%s,%s,%s)", anio, alim, salud, viv, edu, vest));
                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                    this.dispose();
                    //this.login.cargar_anios();
                    this.login.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Los limites de ese año ya estan registrados", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Año incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        login.setVisible(true);

    }//GEN-LAST:event_formWindowClosed

    private void filtrar(java.awt.event.KeyEvent evt, JTextField txt) {
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && !(c == '.')) {
            getToolkit();
            evt.consume();
        }
        if ((c == '.') && (txt.getText().contains("."))) {
            getToolkit();
            evt.consume();
        }
    }

    /*
    @Override
    public void setDefaultCloseOperation(int operation) {        
        this.login.setVisible(true);
JOptionPane.showMessageDialog(null, "se cerrara");
        super.setDefaultCloseOperation(operation); //To change body of generated methods, choose Tools | Templates.
        
    }
     */

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
            java.util.logging.Logger.getLogger(RegistroLimitesAnio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroLimitesAnio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroLimitesAnio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroLimitesAnio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new RegistroLimitesAnio(login).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txt_alimentacion;
    private javax.swing.JTextField txt_anio;
    private javax.swing.JTextField txt_educacion;
    private javax.swing.JTextField txt_salud;
    private javax.swing.JTextField txt_vestimenta;
    private javax.swing.JTextField txt_vivienda;
    // End of variables declaration//GEN-END:variables
}
