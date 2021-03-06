/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import controlador.ControladorArancel;
import controlador.ControladorMaterial;
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
import modelo.Arancel;
import modelo.Material;
import utilidades.Mensaje;

/**
 *
 * @author COCO
 */
public class ListadoArancelesObraSocial extends javax.swing.JDialog implements WindowFocusListener {

    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableColumnModel modeloColumnas = new DefaultTableColumnModel();
    
    Boolean deboRefrescar;
    
    ArrayList<Arancel> aranceles;
    int obra;
    
    /**
     * Creates new form ListadoArancelesObraSocial
     * @param obra
     */
    public ListadoArancelesObraSocial(int obra) {
        initComponents();
        this.obra=obra;
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
        modelo = (DefaultTableModel) jTable1.getModel();
        modeloColumnas = (DefaultTableColumnModel) jTable1.getColumnModel();
        
        aranceles = new ArrayList<>();
        deboRefrescar = false;
        
        jTable1.addMouseListener(new MouseAdapter() {
            
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
        jMenuItemEditar = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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
        jLabelTitulo.setText("Aranceles");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descripción", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        
        int ok = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea eliminar este arancel?", "Atención", JOptionPane.YES_NO_OPTION);
        
        if(ok == JOptionPane.YES_OPTION){
            int i = jTable1.getSelectedRow();
            String resultado = ControladorArancel.eliminar(aranceles.get(i).getId());
            if(resultado.equals("")){
                modelo.removeRow(i);
                aranceles.remove(i);
            }
            else Mensaje.mostrarMensaje(rootPane, "Error al eliminar arancel:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed

    private void jMenuItemEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEditarActionPerformed
        
        deboRefrescar = true;
        FormularioArancel form = new FormularioArancel(1);
        form.setData(aranceles.get(jTable1.getSelectedRow()).getId());
        form.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenuItem jMenuItemEditar;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
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
        
        aranceles.clear();
        
        ControladorArancel.getAranceles(aranceles, obra);
        
        for(Arancel arancel : aranceles){
        
            String[] data = { arancel.getDescripcion(), String.valueOf(arancel.getValor()) };
            modelo.addRow(data);
        
        }
        
    }
}
