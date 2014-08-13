/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlador.ControladorProfesional;
import controlador.ControladorTipoCuota;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import modelo.TipoCuota;
import utilidades.Mensaje;

/**
 *
 * @author COCO
 */
public class ListadoCuotasProfesional extends javax.swing.JDialog {

    int matricula;
    ArrayList<Integer> ids;
    ArrayList<TipoCuota> tipoCuotas;
    
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableColumnModel modeloColumnas = new DefaultTableColumnModel();
    
    /**
     * Creates new form ListadoCuotasProfesional
     */
    public ListadoCuotasProfesional(int matricula) {
        initComponents();
        this.matricula = matricula;
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
        modelo = (DefaultTableModel) jTable1.getModel();
        modeloColumnas = (DefaultTableColumnModel) jTable1.getColumnModel();
        
        llenarTodo();
        
    }

    private void llenarTodo() {
                
        ids = ControladorProfesional.getObrasProfesional(matricula);
        tipoCuotas = new ArrayList<>();
        ControladorTipoCuota.getTipos(tipoCuotas);
        
        for(TipoCuota tipo : tipoCuotas){
        
            Boolean esta = false;
            if(ids.contains(tipo.getIdCuota()))
                esta = true;
            
            Object[] data = { tipo.getNombre(), tipo.getFrecuencia(), tipo.getImporte(), esta };
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuota", "Frecuencia", "Importe", "Adherido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setText("Suscripciones");

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelTitulo)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        ArrayList<Integer> idsNuevos = new ArrayList<>();
        for(int i = jTable1.getRowCount() - 1; i >= 0; i--){
        
            Boolean esta = (Boolean) modelo.getValueAt(i, 3);
            if(esta)
                idsNuevos.add(tipoCuotas.get(i).getIdCuota());
        
        }
        
        String resultado = ControladorProfesional.actualizarCuotas(idsNuevos, matricula);
        if (resultado.equals("")) //No hubo error
        {
            Mensaje.mostrarMensaje(rootPane, "Operación realizada con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Mensaje.mostrarMensaje(rootPane, "Error al realizar la operación:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
        }

        dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
