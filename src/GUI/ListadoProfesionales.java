/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlador.ControladorMaterial;
import controlador.ControladorObraSocial;
import controlador.ControladorProfesional;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import modelo.ObraSocial;
import modelo.Profesional;
import utilidades.Mensaje;

/**
 *
 * @author COCO
 */
public class ListadoProfesionales extends javax.swing.JDialog implements WindowFocusListener {

    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableColumnModel modeloColumnas = new DefaultTableColumnModel();
    
    Boolean deboRefrescar;
    
    ArrayList<Profesional> profesionales;
    
    /**
     * Creates new form ListadoProfesionales
     */
    public ListadoProfesionales() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
        modelo = (DefaultTableModel) jTable1.getModel();
        modeloColumnas = (DefaultTableColumnModel) jTable1.getColumnModel();
        
        profesionales = new ArrayList<>();
        deboRefrescar = false;
        
        jTable1.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    
                    FormularioCuentaCorriente cc = new FormularioCuentaCorriente();
                    cc.setData(profesionales.get(row).getMatricula(), profesionales.get(row).getNombre());
                    cc.requestFocus();
                    cc.setVisible(true);
                    
                }
            }
            
            @Override
            public void mouseReleased(MouseEvent me) {
                
                if (me.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                
                    JTable table =(JTable) me.getSource();
                    Point p = me.getPoint();
                    int row = table.rowAtPoint(p);

                    if (row >= 0 && row < table.getRowCount()) {
                        table.setRowSelectionInterval(row, row);
                    } else {
                        table.clearSelection();
                    }
                
                    jPopupMenu1.show(me.getComponent(), me.getX(), me.getY());
                    
                }
                
            }
            
        });
        
        addWindowFocusListener(this);
        
        llenarTodo();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItemVerCuentaCorriente = new javax.swing.JMenuItem();
        jMenuItemVerObras = new javax.swing.JMenuItem();
        jMenuItemVerCuotas = new javax.swing.JMenuItem();
        jMenuItemVerLibrosEquip = new javax.swing.JMenuItem();
        jMenuItemAsignar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemEditar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        BuscarProfesionalTextField = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jMenuItemVerCuentaCorriente.setText("Ver cuenta corriente");
        jMenuItemVerCuentaCorriente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerCuentaCorrienteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemVerCuentaCorriente);

        jMenuItemVerObras.setText("Ver obras sociales");
        jMenuItemVerObras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerObrasActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemVerObras);

        jMenuItemVerCuotas.setText("Ver suscripciones");
        jMenuItemVerCuotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerCuotasActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemVerCuotas);

        jMenuItemVerLibrosEquip.setText("Ver cuotas pendientes");
        jMenuItemVerLibrosEquip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemVerLibrosEquipActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemVerLibrosEquip);

        jMenuItemAsignar.setText("Generar cuota");
        jMenuItemAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAsignarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemAsignar);
        jPopupMenu1.add(jSeparator1);

        jMenuItemEditar.setText("Editar");
        jMenuItemEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEditarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemEditar);

        jMenuItemEliminar.setText("Eliminar");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setText("Listado de Profesionales");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("Nuevo profesional");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nueva localidad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Generar cuotas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setText("Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BuscarProfesionalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscarProfesionalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nombre", "Dirección", "Teléfonos", "CBU", "Banco", "Localidad", "Activo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(6).setResizable(false);
            jTable1.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 226, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        NuevaLocalidad form = new NuevaLocalidad();
        form.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        deboRefrescar = true;
        FormularioProfesional form = new FormularioProfesional(0);
        form.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este profesional?", "Atención", JOptionPane.YES_NO_OPTION);
        
        if(ok == JOptionPane.YES_OPTION){
            int i = jTable1.getSelectedRow();
            String resultado = ControladorProfesional.eliminar(profesionales.get(i).getMatricula());
            if(resultado.equals("")){
                modelo.removeRow(i);
                profesionales.remove(i);
            }
            else Mensaje.mostrarMensaje(rootPane, "Error al eliminar profesional:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        // TODO add your handling code here:
        deboRefrescar = true;
        FormularioProfesional form = new FormularioProfesional(1);
        form.setData(profesionales.get(jTable1.getSelectedRow()).getMatricula());
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemEditarActionPerformed

    private void jMenuItemVerCuotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerCuotasActionPerformed
        // TODO add your handling code here:
        ListadoCuotasProfesional form = new ListadoCuotasProfesional(profesionales.get(jTable1.getSelectedRow()).getMatricula());
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemVerCuotasActionPerformed

    private void jMenuItemVerLibrosEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerLibrosEquipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemVerLibrosEquipActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String buscar = this.BuscarProfesionalTextField.getText();
        llenarTodo(buscar);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItemVerObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerObrasActionPerformed
        // TODO add your handling code here:
        ListadoObrasSocialesProfesional form = new ListadoObrasSocialesProfesional(profesionales.get(jTable1.getSelectedRow()).getMatricula());
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemVerObrasActionPerformed

    private void jMenuItemAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAsignarActionPerformed
        GenerarCuota form = new GenerarCuota(profesionales.get(jTable1.getSelectedRow()).getMatricula());
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemAsignarActionPerformed

    private void jMenuItemVerCuentaCorrienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemVerCuentaCorrienteActionPerformed
        FormularioCuentaCorriente cc = new FormularioCuentaCorriente();
        cc.setData(profesionales.get(jTable1.getSelectedRow()).getMatricula(), profesionales.get(jTable1.getSelectedRow()).getNombre());
        cc.setVisible(true);
    }//GEN-LAST:event_jMenuItemVerCuentaCorrienteActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        GenerarCuotas form = new GenerarCuotas();
        form.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscarProfesionalTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenuItem jMenuItemAsignar;
    private javax.swing.JMenuItem jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemVerCuentaCorriente;
    private javax.swing.JMenuItem jMenuItemVerCuotas;
    private javax.swing.JMenuItem jMenuItemVerLibrosEquip;
    private javax.swing.JMenuItem jMenuItemVerObras;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void windowGainedFocus(WindowEvent e) {
        
        if(deboRefrescar)
            llenarTodo();
        deboRefrescar = false;
        
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        
    }

    private void llenarTodo() {

        for(int i = jTable1.getRowCount() - 1; i >= 0; i--){
        
            modelo.removeRow(i);
        
        }
        
        profesionales.clear();
        
        ControladorProfesional.getProfesionales(profesionales);
        
        for(Profesional profesional : profesionales){
        
            String activo;
            if(profesional.getActivo() == 1)
                activo = "Si";
            else activo = "No";
            
            String[] data = { String.valueOf(profesional.getMatricula()), profesional.getNombre(), profesional.getDireccion(), profesional.getTelefonos(), profesional.getCbu(), profesional.getBanco(), profesional.getLocalidad(), activo };
            modelo.addRow(data);
        
        }
        
    }
    
    private void llenarTodo(String buscar) {

        for(int i = jTable1.getRowCount() - 1; i >= 0; i--){
        
            modelo.removeRow(i);
        
        }
        
        profesionales.clear();
        
        ControladorProfesional.getProfesionalesBusqueda(profesionales,buscar);
        
        for(Profesional profesional : profesionales){
        
            String activo;
            if(profesional.getActivo() == 1)
                activo = "Si";
            else activo = "No";
            String[] data = { String.valueOf(profesional.getMatricula()), profesional.getNombre(), profesional.getDireccion(), profesional.getTelefonos(), profesional.getCbu(), profesional.getBanco(), profesional.getLocalidad(), activo };
            modelo.addRow(data);
        
        }
        
    }
        
}
