/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerventa;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alber
 */
public class ModificarElemento extends javax.swing.JFrame {

    private TextAutoCompleter autocomplete;
    
    /**
     * Creates new form AlquilerVenta
     */
    public ModificarElemento() throws ClassNotFoundException {
        initComponents();
        
        // Centrar pantalla
        this.setLocationRelativeTo(null);
        
        // Poner título
        this.setTitle("Modificar Elemento - AlquilerVenta");
        
        // Obtener elementos
        OperacionesBD o = new OperacionesBD();
        ArrayList<Object> a = o.obtainElementosList();
        JTextField client = new JTextField("");
        
        autocomplete = new TextAutoCompleter(client, a, 0);
        
        int result = JOptionPane.showConfirmDialog(null, client, 
                "Elegir elemento a modificar", JOptionPane.OK_OPTION);
        
        String s = (String) autocomplete.getItemSelected();
        if (s == null || result != JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(rootPane,"No se ha elegido ningún cliente a modificar");

            // Ocultar zonas de cambio de nombre
            tit_precio.setVisible(false);
            precio.setVisible(false);
            tit_nombre.setVisible(false);
            nombre.setVisible(false);
            tit_nuevo_nombre.setVisible(false);
            nuevo_nombre.setVisible(false);
            btn_modificar.setVisible(false);
        } else {
            nombre.setText(s);
            
            ArrayList<Object> e = o.obtainElemento(s.split("-->")[1].trim());
            nuevo_nombre.setText((String) e.get(0));
            precio.setText((String) e.get(1).toString());
            
            // Ocultar botón de volver a inicio
            btn_inicio.setVisible(false);
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

        tit_nombre = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        tit_precio = new javax.swing.JLabel();
        precio = new javax.swing.JTextField();
        btn_inicio = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        tit_nuevo_nombre = new javax.swing.JLabel();
        nuevo_nombre = new javax.swing.JTextField();
        menubar = new javax.swing.JMenuBar();
        ini = new javax.swing.JMenu();
        inicio = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        alquiler = new javax.swing.JMenu();
        registro_consulta_alquiler = new javax.swing.JMenuItem();
        cons_alq = new javax.swing.JMenuItem();
        nuevo_piso = new javax.swing.JMenuItem();
        modificar_piso = new javax.swing.JMenuItem();
        elim_piso = new javax.swing.JMenuItem();
        venta = new javax.swing.JMenu();
        registrar_venta = new javax.swing.JMenuItem();
        consultar_ventas = new javax.swing.JMenuItem();
        nuevo_elemento = new javax.swing.JMenuItem();
        modificar_elemento = new javax.swing.JMenuItem();
        elim_elem = new javax.swing.JMenuItem();
        cliente = new javax.swing.JMenu();
        nuevo_cliente = new javax.swing.JMenuItem();
        modificar_cliente = new javax.swing.JMenuItem();
        elim_cli = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tit_nombre.setText("Nombre Actual:");

        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        tit_precio.setText("Precio por Kg o L o Garrafa:");

        btn_inicio.setText("Volver a inicio");
        btn_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inicioActionPerformed(evt);
            }
        });

        nombre.setEditable(false);

        tit_nuevo_nombre.setText("Nuevo Nombre:");

        ini.setText("Inicio");

        inicio.setText("Ir a Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });
        ini.add(inicio);

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        ini.add(salir);

        menubar.add(ini);

        alquiler.setText("Alquiler");
        alquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alquilerActionPerformed(evt);
            }
        });

        registro_consulta_alquiler.setText("Registrar/Consultar/Eliminar Alquiler");
        registro_consulta_alquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registro_consulta_alquilerActionPerformed(evt);
            }
        });
        alquiler.add(registro_consulta_alquiler);

        cons_alq.setText("Consultar Alquileres");
        cons_alq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cons_alqActionPerformed(evt);
            }
        });
        alquiler.add(cons_alq);

        nuevo_piso.setText("Añadir Piso");
        nuevo_piso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_pisoActionPerformed(evt);
            }
        });
        alquiler.add(nuevo_piso);

        modificar_piso.setText("Modificar Piso");
        modificar_piso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_pisoActionPerformed(evt);
            }
        });
        alquiler.add(modificar_piso);

        elim_piso.setText("Eliminar Piso");
        elim_piso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elim_pisoActionPerformed(evt);
            }
        });
        alquiler.add(elim_piso);

        menubar.add(alquiler);

        venta.setText("Venta");

        registrar_venta.setText("Registrar/Eliminar Venta");
        registrar_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar_ventaActionPerformed(evt);
            }
        });
        venta.add(registrar_venta);

        consultar_ventas.setText("Consultar Ventas");
        consultar_ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar_ventasActionPerformed(evt);
            }
        });
        venta.add(consultar_ventas);

        nuevo_elemento.setText("Añadir Elemento");
        nuevo_elemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_elementoActionPerformed(evt);
            }
        });
        venta.add(nuevo_elemento);

        modificar_elemento.setText("Modificar Elemento");
        modificar_elemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_elementoActionPerformed(evt);
            }
        });
        venta.add(modificar_elemento);

        elim_elem.setText("Eliminar Elemento");
        elim_elem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elim_elemActionPerformed(evt);
            }
        });
        venta.add(elim_elem);

        menubar.add(venta);

        cliente.setText("Cliente");

        nuevo_cliente.setText("Registrar Cliente");
        nuevo_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_clienteActionPerformed(evt);
            }
        });
        cliente.add(nuevo_cliente);

        modificar_cliente.setText("Modificar Cliente");
        modificar_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar_clienteActionPerformed(evt);
            }
        });
        cliente.add(modificar_cliente);

        elim_cli.setText("Eliminar Cliente");
        elim_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elim_cliActionPerformed(evt);
            }
        });
        cliente.add(elim_cli);

        menubar.add(cliente);

        setJMenuBar(menubar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(btn_modificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tit_nuevo_nombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nuevo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tit_nombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(8, 8, 8))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tit_precio)
                                    .addGap(18, 18, 18)
                                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btn_inicio)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_inicio)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tit_nombre))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tit_nuevo_nombre)
                    .addComponent(nuevo_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tit_precio)
                    .addComponent(precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btn_modificar)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inicioActionPerformed
        AlquilerVenta a = new AlquilerVenta();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_inicioActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        String name = nuevo_nombre.getText();
        if(!name.isEmpty()) {
            String prec = precio.getText();
            if(prec.matches("[0-9]+[.][0-9]+") || prec.matches("[0-9]+[,][0-9]+") || prec.matches("[0-9]+")) {
                OperacionesBD o = new OperacionesBD();
                try {
                    if("error".equals(o.updateElemento(nombre.getText().split("-->")[1].trim(), name, prec.replace(",", ".")))) JOptionPane.showMessageDialog(rootPane,"No está conectado a la base de datos");
                    else {
                        JOptionPane.showMessageDialog(rootPane,"El elemento se ha modificado con éxito");

                        // Me voy a inicio
                        AlquilerVenta av = new AlquilerVenta();
                        av.setVisible(true);
                        this.dispose();
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NuevoPiso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else JOptionPane.showMessageDialog(rootPane, "No se ha introducido el precio por unidad del elemento que se debe "
                + "escribir de la siguiente manera: por ejemplo, 135 ó 135.46");
        }
        else JOptionPane.showMessageDialog(rootPane, "El nombre del elemento no está introducido");
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
        AlquilerVenta a = new AlquilerVenta();
        a.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_inicioActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void registro_consulta_alquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registro_consulta_alquilerActionPerformed
        ResConAlquiler r = null;
        try {
            r = new ResConAlquiler();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registro_consulta_alquilerActionPerformed

    private void cons_alqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cons_alqActionPerformed
        ConsultarAlquileres ca = null;
        try {
            ca = new ConsultarAlquileres();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        ca.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cons_alqActionPerformed

    private void nuevo_pisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_pisoActionPerformed
        NuevoPiso n = null;
        try {
            n = new NuevoPiso();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nuevo_pisoActionPerformed

    private void modificar_pisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_pisoActionPerformed
        ModificarPiso m = null;
        try {
            m = new ModificarPiso();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modificar_pisoActionPerformed

    private void elim_pisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elim_pisoActionPerformed
        EliminarPiso e = null;
        try {
            e = new EliminarPiso();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_elim_pisoActionPerformed

    private void alquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alquilerActionPerformed

    private void registrar_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar_ventaActionPerformed
        RegistrarVenta r = null;
        try {
            r = new RegistrarVenta();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registrar_ventaActionPerformed

    private void consultar_ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar_ventasActionPerformed
        ConsultarVentas c = null;
        try {
            c = new ConsultarVentas();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_consultar_ventasActionPerformed

    private void nuevo_elementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_elementoActionPerformed
        NuevoElemento n = new NuevoElemento();
        n.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nuevo_elementoActionPerformed

    private void modificar_elementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_elementoActionPerformed
        ModificarElemento m = null;
        try {
            m = new ModificarElemento();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modificar_elementoActionPerformed

    private void elim_elemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elim_elemActionPerformed
        EliminarElemento e = null;
        try {
            e = new EliminarElemento();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_elim_elemActionPerformed

    private void nuevo_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_clienteActionPerformed
        RegistrarCliente r = new RegistrarCliente();
        r.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_nuevo_clienteActionPerformed

    private void modificar_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar_clienteActionPerformed
        ModificarCliente m = null;
        try {
            m = new ModificarCliente();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modificar_clienteActionPerformed

    private void elim_cliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elim_cliActionPerformed
        EliminarCliente e = null;
        try {
            e = new EliminarCliente();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlquilerVenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_elim_cliActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarElemento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarElemento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarElemento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarElemento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ModificarElemento().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ModificarElemento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu alquiler;
    private javax.swing.JButton btn_inicio;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JMenu cliente;
    private javax.swing.JMenuItem cons_alq;
    private javax.swing.JMenuItem consultar_ventas;
    private javax.swing.JMenuItem elim_cli;
    private javax.swing.JMenuItem elim_elem;
    private javax.swing.JMenuItem elim_piso;
    private javax.swing.JMenu ini;
    private javax.swing.JMenuItem inicio;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem modificar_cliente;
    private javax.swing.JMenuItem modificar_elemento;
    private javax.swing.JMenuItem modificar_piso;
    private javax.swing.JTextField nombre;
    private javax.swing.JMenuItem nuevo_cliente;
    private javax.swing.JMenuItem nuevo_elemento;
    private javax.swing.JTextField nuevo_nombre;
    private javax.swing.JMenuItem nuevo_piso;
    private javax.swing.JTextField precio;
    private javax.swing.JMenuItem registrar_venta;
    private javax.swing.JMenuItem registro_consulta_alquiler;
    private javax.swing.JMenuItem salir;
    private javax.swing.JLabel tit_nombre;
    private javax.swing.JLabel tit_nuevo_nombre;
    private javax.swing.JLabel tit_precio;
    private javax.swing.JMenu venta;
    // End of variables declaration//GEN-END:variables
}
