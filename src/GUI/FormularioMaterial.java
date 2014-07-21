/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlador.ControladorMaterial;
import controlador.ControladorTipoMaterial;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Material;
import modelo.TipoMaterial;
import utilidades.Mensaje;

/**
 *
 * @author COCO
 */
public class FormularioMaterial extends javax.swing.JDialog {

    int tipo;
    Material material;
    int id;

    DefaultComboBoxModel modeloTipos = new DefaultComboBoxModel();
    private ArrayList<TipoMaterial> tipos;
    
    /**
     * Creates new form FormularioMaterial
     */
    public FormularioMaterial(int tipo) {
        initComponents();
        setModal(true);
        this.tipo = tipo;
        if(tipo == 0)
            FormularioMaterialTitulo.setText("Nuevo material");
        else FormularioMaterialTitulo.setText("Editando material");
        setLocationRelativeTo(null);
        setResizable(false);
        
        llenarTipos();
        
    }
    
    private void llenarTipos(){
    
        tipos = new ArrayList<>();
        ControladorTipoMaterial.getTipos(tipos);
        
        for(TipoMaterial tipo : tipos){
        
            modeloTipos.addElement(tipo.getDescripcion());
        
        }
    
    }
    
    public void setData(int id){
        
        this.id = id;
        material = new Material();
        material.setIdMaterial(id);
        ControladorMaterial.getDatos(material);
        
        Boolean encontro = false;
        int i = 0;
        while(!encontro){
        
            if(tipos.get(i).getIdtipomaterial() == material.getIdTipoMaterial()){
            
                encontro = true;
                FormularioMaterialCategoria.setSelectedIndex(i);
            
            }
            i++;
        
        }
        
        FormularioMaterialMarca.setText(material.getMarca());
        FormularioMaterialStock.setText(String.valueOf(material.getStock()));
        FormularioMaterialPrecio.setText(String.valueOf(material.getPrecio()));
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevoMaterialPanel = new javax.swing.JPanel();
        FormularioMaterialTitulo = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        FormularioMaterialCategoria = new javax.swing.JComboBox();
        FormularioMaterialMarca = new javax.swing.JTextField();
        FormularioMaterialStock = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        FormularioMaterialPrecio = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        cancelarButton = new javax.swing.JButton();
        cancelarButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nuevoMaterialPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        FormularioMaterialTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        FormularioMaterialTitulo.setText("Nuevo Material");

        jLabel9.setText("Categoría:");

        jLabel10.setText("Marca:");

        jLabel12.setText("Stock:");

        FormularioMaterialCategoria.setModel(modeloTipos);

        FormularioMaterialMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormularioMaterialMarcaActionPerformed(evt);
            }
        });

        FormularioMaterialStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FormularioMaterialStockActionPerformed(evt);
            }
        });

        jLabel13.setText("Precio de venta:");

        javax.swing.GroupLayout nuevoMaterialPanelLayout = new javax.swing.GroupLayout(nuevoMaterialPanel);
        nuevoMaterialPanel.setLayout(nuevoMaterialPanelLayout);
        nuevoMaterialPanelLayout.setHorizontalGroup(
            nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoMaterialPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addGroup(nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(FormularioMaterialPrecio)
                    .addComponent(FormularioMaterialStock)
                    .addComponent(FormularioMaterialMarca)
                    .addComponent(FormularioMaterialCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(nuevoMaterialPanelLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FormularioMaterialTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        nuevoMaterialPanelLayout.setVerticalGroup(
            nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoMaterialPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(FormularioMaterialTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(FormularioMaterialCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(FormularioMaterialMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(FormularioMaterialStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nuevoMaterialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(FormularioMaterialPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        cancelarButton.setText("Aceptar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        cancelarButton1.setText("Cancelar");
        cancelarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(cancelarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelarButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevoMaterialPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevoMaterialPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarButton)
                    .addComponent(cancelarButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButtonActionPerformed
        
        if(tipo == 0){ //Nuevo
            
            material = new Material();
            material.setIdTipoMaterial(tipos.get(FormularioMaterialCategoria.getSelectedIndex()).getIdtipomaterial());
            material.setMarca(FormularioMaterialMarca.getText());
            material.setStock(Integer.parseInt(FormularioMaterialStock.getText()));
            material.setPrecio(Float.parseFloat(FormularioMaterialPrecio.getText()));
            //Tomo valores de campos y se los asigno al objeto
            String resultado = ControladorMaterial.insertar(material);
            if(resultado.equals(""))  //No hubo error
                Mensaje.mostrarMensaje(rootPane, "Material agregado con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            else Mensaje.mostrarMensaje(rootPane, "Error al agregar material:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
            
            dispose();
            
        }
        else {
        
            material.setIdTipoMaterial(tipos.get(FormularioMaterialCategoria.getSelectedIndex()).getIdtipomaterial());
            material.setMarca(FormularioMaterialMarca.getText());
            material.setStock(Integer.parseInt(FormularioMaterialStock.getText()));
            material.setPrecio(Float.parseFloat(FormularioMaterialPrecio.getText()));
            String resultado = ControladorMaterial.editar(material);
            if(resultado.equals(""))  //No hubo error
                Mensaje.mostrarMensaje(rootPane, "Material editado con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            else Mensaje.mostrarMensaje(rootPane, "Error al editar material:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
            
            dispose();
            
        }
        
    }//GEN-LAST:event_cancelarButtonActionPerformed

    private void FormularioMaterialStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormularioMaterialStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FormularioMaterialStockActionPerformed

    private void FormularioMaterialMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FormularioMaterialMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FormularioMaterialMarcaActionPerformed

    private void cancelarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_cancelarButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox FormularioMaterialCategoria;
    private javax.swing.JTextField FormularioMaterialMarca;
    private javax.swing.JTextField FormularioMaterialPrecio;
    private javax.swing.JTextField FormularioMaterialStock;
    private javax.swing.JLabel FormularioMaterialTitulo;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JButton cancelarButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPanel nuevoMaterialPanel;
    // End of variables declaration//GEN-END:variables
}