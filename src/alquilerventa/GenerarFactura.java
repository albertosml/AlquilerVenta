/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerventa;

import com.itextpdf.text.DocumentException;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;

/**
 *
 * @author alber
 */
public class GenerarFactura extends javax.swing.JFrame {

    /**
     * Creates new form GenerarFactura
     */
    public GenerarFactura() throws ClassNotFoundException {
        initComponents();
        
        // Centrar pantalla
        this.setLocationRelativeTo(null);
        
        // Poner título
        this.setTitle("Generar Factura - AlquilerVenta");
        
        // Obtener pisos
        OperacionesBD o = new OperacionesBD();
        ArrayList<String> a = o.obtainPisosList();
        if(a.get(0) != "error") {
            SpinnerListModel listModel = new SpinnerListModel(a);
        
            piso.setModel(listModel);
            piso.setValue(a.get(0));
        }
        else {
            SpinnerListModel listModel = new SpinnerListModel(new String[]{""});
            piso.setModel(listModel);
        }
        
        ((JSpinner.DefaultEditor) piso.getEditor()).getTextField().setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        piso = new javax.swing.JSpinner();
        txt_piso = new javax.swing.JLabel();
        txt_mes = new javax.swing.JLabel();
        mes = new com.toedter.calendar.JMonthChooser();
        txt_anio = new javax.swing.JLabel();
        anio = new com.toedter.calendar.JYearChooser();
        btn_generar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        titulo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titulo.setText("Introduzca los datos de la factura:");

        piso.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pisoStateChanged(evt);
            }
        });

        txt_piso.setText("Piso:");

        txt_mes.setText("Mes:");

        txt_anio.setText("Año:");

        btn_generar.setText("Generar Factura");
        btn_generar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_mes)
                                .addGap(18, 18, 18)
                                .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_piso)
                                .addGap(18, 18, 18)
                                .addComponent(piso, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_anio)
                                .addGap(18, 18, 18)
                                .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(btn_generar)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(titulo)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(titulo)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_piso)
                    .addComponent(piso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_mes)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_anio)
                    .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btn_generar)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pisoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pisoStateChanged
       
    }//GEN-LAST:event_pisoStateChanged

    private void btn_generarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generarActionPerformed
        JFileChooser elector = new JFileChooser();
        elector.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int r = elector.showOpenDialog(null);
        if(r == JFileChooser.APPROVE_OPTION) { // Si le da a aceptar
            File f = elector.getSelectedFile();
            
            OperacionesPDF o = new OperacionesPDF();
            try {
                String msg = o.generatePDF(((String) piso.getValue()).split(":")[0], mes.getMonth(), anio.getYear(), f.getAbsolutePath());
                if(msg == "error") JOptionPane.showMessageDialog(rootPane, "No está conectado a la base de datos");
                else if(msg == "") JOptionPane.showMessageDialog(rootPane, "Factura generada con éxito");
                else JOptionPane.showMessageDialog(rootPane, msg);
            } catch (FileNotFoundException | DocumentException | ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_generarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(GenerarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GenerarFactura().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(GenerarFactura.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JYearChooser anio;
    private javax.swing.JButton btn_generar;
    private com.toedter.calendar.JMonthChooser mes;
    private javax.swing.JSpinner piso;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel txt_anio;
    private javax.swing.JLabel txt_mes;
    private javax.swing.JLabel txt_piso;
    // End of variables declaration//GEN-END:variables
}
