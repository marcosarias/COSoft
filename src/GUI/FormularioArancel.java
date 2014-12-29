/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import controlador.ControladorArancel;
import controlador.ControladorMaterial;
import controlador.ControladorObraSocial;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Arancel;
import modelo.Material;
import modelo.ObraSocial;
import utilidades.Mensaje;

/**
 *
 * @author COCO
 */
public class FormularioArancel extends javax.swing.JDialog {

    Arancel arancel;
    int id;
    int tipo;

    DefaultComboBoxModel modelo = new DefaultComboBoxModel();
    private ArrayList<ObraSocial> obras;
    
    /**
     * Creates new form FormularioArancel
     * @param tipo
     */
    public FormularioArancel(int tipo) {
        initComponents();
        setModal(true);
        this.tipo = tipo;
        if(tipo == 0)
            FormularioArancelTitulo.setText("Nuevo arancel");
        else FormularioArancelTitulo.setText("Editando arancel");
        setLocationRelativeTo(null);
        setResizable(false);
        
        llenarObras();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FormularioArancelTitulo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        FormularioArancelObra = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        FormularioArancelValor = new javax.swing.JTextField();
        FormularioArancelDesc = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        FormularioArancelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        FormularioArancelTitulo.setText("Nuevo Arancel");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        FormularioArancelObra.setModel(modelo);

        jLabel9.setText("Obra social:");

        jLabel10.setText("Descripcion:");

        jLabel12.setText("Valor:");

        FormularioArancelValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormularioArancelValorActionPerformed(evt);
            }
        });

        FormularioArancelDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormularioArancelDescActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormularioArancelValor)
                    .addComponent(FormularioArancelDesc)
                    .addComponent(FormularioArancelObra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(FormularioArancelObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(FormularioArancelDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(FormularioArancelValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(FormularioArancelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 105, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jButton1)
                .addGap(72, 72, 72)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FormularioArancelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FormularioArancelValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormularioArancelValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FormularioArancelValorActionPerformed

    private void FormularioArancelDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormularioArancelDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FormularioArancelDescActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void setData(int id){
        
        this.id = id;
        arancel = new Arancel();
        arancel.setId(id);
        ControladorArancel.getDatos(arancel);
        
        Boolean encontro = false;
        int i = 0;
        while(!encontro){
        
            if(obras.get(i).getIdObraSocial() == arancel.getObra()){
            
                encontro = true;
                FormularioArancelObra.setSelectedIndex(i);
            
            }
            i++;
        
        }
        
        FormularioArancelDesc.setText(arancel.getDescripcion());
        FormularioArancelValor.setText(String.valueOf(arancel.getValor()));
                
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(tipo == 0){ //Nuevo
            
            arancel = new Arancel();
            arancel.setObra(obras.get(FormularioArancelObra.getSelectedIndex()).getIdObraSocial());
            arancel.setDescripcion(FormularioArancelDesc.getText());
            arancel.setValor(Float.parseFloat(FormularioArancelValor.getText()));
            //Tomo valores de campos y se los asigno al objeto
            String resultado = ControladorArancel.insertar(arancel);
            if(resultado.equals(""))  //No hubo error
                Mensaje.mostrarMensaje(rootPane, "Arancel agregado con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            else Mensaje.mostrarMensaje(rootPane, "Error al agregar arancel:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
            
            dispose();
            
        }
        else {
        
            arancel.setObra(obras.get(FormularioArancelObra.getSelectedIndex()).getIdObraSocial());
            arancel.setDescripcion(FormularioArancelDesc.getText());
            arancel.setValor(Float.parseFloat(FormularioArancelValor.getText()));
            String resultado = ControladorArancel.editar(arancel);
            if(resultado.equals(""))  //No hubo error
                Mensaje.mostrarMensaje(rootPane, "Arancel editado con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            else Mensaje.mostrarMensaje(rootPane, "Error al editar arancel:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
            
            dispose();
            
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField FormularioArancelDesc;
    private javax.swing.JComboBox FormularioArancelObra;
    private javax.swing.JLabel FormularioArancelTitulo;
    private javax.swing.JTextField FormularioArancelValor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables

    private void llenarObras() {
        
        obras = new ArrayList<>();
        ControladorObraSocial.getObrasSociales(obras);
        
        for(ObraSocial obra : obras){
        
            modelo.addElement(obra.getNombre());
        
        }
        
    }
}
