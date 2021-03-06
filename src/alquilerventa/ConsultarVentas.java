/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilerventa;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alber
 */
public class ConsultarVentas extends javax.swing.JFrame {

    private TextAutoCompleter autocomplete_cliente, autocomplete_elemento;
    
    /**
     * Creates new form AlquilerVenta
     */
    public ConsultarVentas() throws ClassNotFoundException {
        initComponents();
        
        // Centrar pantalla
        this.setLocationRelativeTo(null);
        
        // Poner título
        this.setTitle("Consultar Ventas - AlquilerVenta");
        
        OperacionesBD o = new OperacionesBD();
        
        // Obtener elementos
        ArrayList<Object> a = o.obtainElementosList();
        autocomplete_elemento = new TextAutoCompleter(elemento, a, 0);
        
        // Obtener clientes (compradores)        
        a = o.obtainClientsList();
        autocomplete_cliente = new TextAutoCompleter(comprador, a, 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_consultar = new javax.swing.JButton();
        check_elemento = new javax.swing.JCheckBox();
        check_comprador = new javax.swing.JCheckBox();
        scroll = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        total = new javax.swing.JLabel();
        check_anio = new javax.swing.JCheckBox();
        anio = new com.toedter.calendar.JYearChooser();
        check_campania = new javax.swing.JCheckBox();
        aniocampaniainicio = new com.toedter.calendar.JYearChooser();
        guion = new javax.swing.JLabel();
        aniocampaniafin = new com.toedter.calendar.JYearChooser();
        elemento = new javax.swing.JTextField();
        comprador = new javax.swing.JTextField();
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

        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        check_elemento.setText(" Elemento:");
        check_elemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_elementoActionPerformed(evt);
            }
        });

        check_comprador.setText(" Comprador:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Elemento", "Cantidad", "Precio por Kg o L o Garrafa", "Total", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scroll.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(15);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(80);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(15);
            tabla.getColumnModel().getColumn(5).setResizable(false);
        }

        total.setText("Total Ventas:");

        check_anio.setText("Año:");

        check_campania.setText("Campaña:");

        guion.setText("-");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(check_elemento)
                                .addGap(18, 18, 18)
                                .addComponent(elemento, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(check_comprador)
                                .addGap(18, 18, 18)
                                .addComponent(comprador, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166))
                            .addComponent(scroll))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(395, 395, 395))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(check_anio)
                        .addGap(46, 46, 46)
                        .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(156, 156, 156)
                        .addComponent(check_campania)
                        .addGap(18, 18, 18)
                        .addComponent(aniocampaniainicio, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guion, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(aniocampaniafin, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_consultar)
                .addGap(70, 70, 70))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check_elemento)
                    .addComponent(check_comprador)
                    .addComponent(elemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comprador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_consultar)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(check_anio)
                        .addComponent(anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(check_campania)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(guion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(aniocampaniainicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(aniocampaniafin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(39, 39, 39)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(total)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Calendar cal = Calendar.getInstance();
        aniocampaniainicio.setValue(cal.get(Calendar.YEAR)-1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void check_elementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_elementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_elementoActionPerformed

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        String elem = (String) autocomplete_elemento.getItemSelected();
        if(check_elemento.isSelected() && elem == null) {
            JOptionPane.showMessageDialog(rootPane,"Se tiene que escoger un elemento elegido del autocompletado");
            return ;
        }
        
        String com = (String) autocomplete_cliente.getItemSelected();
        if(check_comprador.isSelected() && com == null) {
            JOptionPane.showMessageDialog(rootPane,"Se tiene que escoger un comprador elegido del autocompletado");
            return ;
        }
        
        String year = Integer.toString(anio.getYear());
        
        if(!check_elemento.isSelected() && !check_comprador.isSelected() && !check_anio.isSelected() && !check_campania.isSelected()) JOptionPane.showMessageDialog(rootPane, "No se puede hacer esa consulta, compruebe los datos");
        else {
            OperacionesBD o = new OperacionesBD();
            ArrayList<Vector<String>> a = null;
            try {
                if(check_campania.isSelected()) {
                    if(aniocampaniafin.getYear() - aniocampaniainicio.getYear() == 1) {
                        a = o.obtainVentas(check_elemento.isSelected() && !elem.isEmpty() ? elem.split("-->")[1].trim() : null, 
                                   check_comprador.isSelected() && !com.isEmpty() ? com.split("-->")[1].trim() : null,
                                   Integer.toString(aniocampaniainicio.getYear()), Integer.toString(aniocampaniafin.getYear()));
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "La diferencia entre el año de inicio y el año de fin debe ser igual a 1");
                        return ;
                    }
                }
                else {
                    a = o.obtainVentas(check_elemento.isSelected() && !elem.isEmpty() ? elem.split("-->")[1].trim() : null, 
                                   check_comprador.isSelected() && !com.isEmpty() ? com.split("-->")[1].trim() : null,
                                   check_anio.isSelected() ? year : null, null);
                }
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConsultarVentas.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(a.size() == 1 && "error".equals(a.get(0).get(0))) JOptionPane.showMessageDialog(rootPane, "No está conectado a la base de datos");
            else {
                DefaultTableModel table = (DefaultTableModel) tabla.getModel();

                int nfils = table.getRowCount();
                for(int i=0;i<nfils;i++) table.removeRow(0);

                Float tot_t = 0f;
                for(int i=0;i<a.size();i++) {
                    Float tot = Float.parseFloat(a.get(i).get(3)) * Float.parseFloat(a.get(i).get(4));
                    table.addRow(new Object[]{a.get(i).get(5), a.get(i).get(6), a.get(i).get(3), String.format("%.2f", Float.parseFloat(a.get(i).get(4))), String.format("%.2f", tot), a.get(i).get(0) + "/" + a.get(i).get(1) + "/" + a.get(i).get(2)});
                    tot_t += tot;
                }

                tabla.setModel(table);
                total.setText("Total Ventas: " + String.format("%.2f", tot_t) + " €");
            }
        }
    }//GEN-LAST:event_btn_consultarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                    new ConsultarVentas().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConsultarVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu alquiler;
    private com.toedter.calendar.JYearChooser anio;
    private com.toedter.calendar.JYearChooser aniocampaniafin;
    private com.toedter.calendar.JYearChooser aniocampaniainicio;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JCheckBox check_anio;
    private javax.swing.JCheckBox check_campania;
    private javax.swing.JCheckBox check_comprador;
    private javax.swing.JCheckBox check_elemento;
    private javax.swing.JMenu cliente;
    private javax.swing.JTextField comprador;
    private javax.swing.JMenuItem cons_alq;
    private javax.swing.JMenuItem consultar_ventas;
    private javax.swing.JTextField elemento;
    private javax.swing.JMenuItem elim_cli;
    private javax.swing.JMenuItem elim_elem;
    private javax.swing.JMenuItem elim_piso;
    private javax.swing.JLabel guion;
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
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel total;
    private javax.swing.JMenu venta;
    // End of variables declaration//GEN-END:variables
}
