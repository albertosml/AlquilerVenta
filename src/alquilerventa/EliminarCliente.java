/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerventa;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.mxrck.autocompleter.TextAutoCompleter;

/**
 *
 * @author alber
 */
public class EliminarCliente extends javax.swing.JFrame {

    private TextAutoCompleter autocomplete;
    
    /**
     * Creates new form AlquilerVenta
     */
    public EliminarCliente() throws ClassNotFoundException {
        initComponents();
        
        // Centrar pantalla
        this.setLocationRelativeTo(null);
        
        // Poner título
        this.setTitle("Eliminar Cliente - AlquilerVenta");
        
        // Obtener clientes
        OperacionesBD o = new OperacionesBD();
        ArrayList<Object> a = o.obtainClientsList();
        
        autocomplete = new TextAutoCompleter(client, a, 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_eliminar = new javax.swing.JButton();
        tit_cliente = new javax.swing.JLabel();
        client = new javax.swing.JTextField();
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

        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        tit_cliente.setText("Cliente:");

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
                .addGap(211, 211, 211)
                .addComponent(btn_eliminar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 37, Short.MAX_VALUE)
                .addComponent(tit_cliente)
                .addGap(64, 64, 64)
                .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tit_cliente)
                    .addComponent(client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(btn_eliminar)
                .addGap(74, 74, 74))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        String cli = (String) autocomplete.getItemSelected();
        
        OperacionesBD o = new OperacionesBD();
        try {
            // Validar expresión
            if (cli == null) 
                JOptionPane.showMessageDialog(rootPane,"No se puede eliminar a "
                    + "un cliente que no se haya elegido en el autocompletado");
            else {
                String s = o.deleteClient(cli.split("-->")[1].trim()); // nombre (id)
                if("error".equals(s)) JOptionPane.showMessageDialog(rootPane,"No está conectado a la base de datos");
                else if("alq".equals(s)) JOptionPane.showMessageDialog(rootPane,"No se puede eliminar a un cliente que tenga alquileres registrados");
                else if("ven".equals(s)) JOptionPane.showMessageDialog(rootPane,"No se puede eliminar a un cliente que tenga ventas registrados");
                else if("piso".equals(s)) JOptionPane.showMessageDialog(rootPane,"No se puede eliminar a un cliente que es inquilino de un piso");
                else {
                    JOptionPane.showMessageDialog(rootPane,"El cliente se ha eliminado con éxito");

                    // Me voy a inicio
                    AlquilerVenta av = new AlquilerVenta();
                    av.setVisible(true);
                    this.dispose();
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EliminarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EliminarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                try {
                    new EliminarCliente().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(EliminarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu alquiler;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JTextField client;
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
    private javax.swing.JMenuItem nuevo_cliente;
    private javax.swing.JMenuItem nuevo_elemento;
    private javax.swing.JMenuItem nuevo_piso;
    private javax.swing.JMenuItem registrar_venta;
    private javax.swing.JMenuItem registro_consulta_alquiler;
    private javax.swing.JMenuItem salir;
    private javax.swing.JLabel tit_cliente;
    private javax.swing.JMenu venta;
    // End of variables declaration//GEN-END:variables
}
