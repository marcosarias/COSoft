/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlador.ControladorMaterial;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import modelo.Material;
import utilidades.Mensaje;

/**
 *
 * @author COCO
 */
public class ActualizarStock extends javax.swing.JDialog {

    ArrayList<Material> materiales;
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableColumnModel modeloColumnas = new DefaultTableColumnModel();
    
    /**
     * Creates new form DatosRemito
     */
    public ActualizarStock() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);

        modelo = (DefaultTableModel) jTable1.getModel();
        modeloColumnas = (DefaultTableColumnModel) jTable1.getColumnModel();
        
        llenarTodo();
        
    }
    
    private void llenarTodo() {
        
        materiales = new ArrayList<>();
        
        ControladorMaterial.getMateriales(materiales);
        
        for(Material material : materiales){
        
            Object[] data = { material.getTipo() + " " + material.getMarca(), 0 };
            modelo.addRow(data);
            
        
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

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Actualizar stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Material", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                        .addGap(131, 131, 131)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Boolean hayStock = true;
        for(int i = 0; i < jTable1.getRowCount(); i++){
        
            if( (materiales.get(i).getStock() + (int)jTable1.getValueAt(i, 1)) < 0 )
                hayStock = false;
        
        }
        
        ArrayList<Material> nuevos = new ArrayList<>();
        if(!hayStock)
            Mensaje.mostrarMensaje(rootPane, "No hay stock suficiente, revise las cantidades", "Error", JOptionPane.ERROR_MESSAGE);
        else{
        
            for(int i = 0; i < jTable1.getRowCount(); i++){
        
                int cant = (int)jTable1.getValueAt(i, 1);
                if(cant != 0){
                    Material m = materiales.get(i);
                    m.setStock(m.getStock() + cant);
                    nuevos.add(m);
                }
        
            }
            
            String resultado = ControladorMaterial.modificarStock(nuevos);
            if(resultado.equals("")){  //No hubo error
            Mensaje.mostrarMensaje(rootPane, "Stock actualizado con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            
        }
        else Mensaje.mostrarMensaje(rootPane, "Error al actualizar stock:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
            
            dispose();

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
