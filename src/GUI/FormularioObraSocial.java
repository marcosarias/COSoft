/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import controlador.ControladorObraSocial;
import javax.swing.JOptionPane;
import modelo.ObraSocial;
import utilidades.Mensaje;

/**
 *
 * @author COCO
 */
public class FormularioObraSocial extends javax.swing.JDialog {

    int tipo;
    
    ObraSocial obra;
    int id;
    
    /**
     * Creates new form FormularioObraSocial
     */
    public FormularioObraSocial(int tipo) {
        initComponents();
        this.tipo = tipo;
        if(tipo == 0)
            jLabelTitulo.setText("Nueva obra social");
        else jLabelTitulo.setText("Editando obra social");
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public void setData(int id){
        
        this.id = id;
        obra = new ObraSocial();
        obra.setIdObraSocial(id);
        ControladorObraSocial.getDatos(obra);
        
        jTextField1.setText(obra.getNombre());
        jTextField4.setText(obra.getTelefonos());
        jTextField5.setText(obra.getDireccion());
        jTextField2.setText(obra.getFechacontrato());
        jTextField3.setText(obra.getFirma());
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevaObraSocialPanel = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        nuevaObraSocialPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelTitulo.setText("Nueva Obra Social");

        jLabel2.setText("Nombre:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha de Contrato: ");

        jLabel4.setText("Responsable Contrato: ");

        jLabel5.setText("Telefonos:");

        jLabel6.setText("Dirección:");

        javax.swing.GroupLayout nuevaObraSocialPanelLayout = new javax.swing.GroupLayout(nuevaObraSocialPanel);
        nuevaObraSocialPanel.setLayout(nuevaObraSocialPanelLayout);
        nuevaObraSocialPanelLayout.setHorizontalGroup(
            nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevaObraSocialPanelLayout.createSequentialGroup()
                .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nuevaObraSocialPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3)
                            .addComponent(jTextField1)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5)
                            .addComponent(jTextField4)))
                    .addGroup(nuevaObraSocialPanelLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addGap(0, 205, Short.MAX_VALUE)))
                .addContainerGap())
        );
        nuevaObraSocialPanelLayout.setVerticalGroup(
            nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevaObraSocialPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nuevaObraSocialPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nuevaObraSocialPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(236, 236, 236))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nuevaObraSocialPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(tipo == 0){ //Nuevo
            
            obra = new ObraSocial();
            obra.setNombre(jTextField1.getText());
            obra.setTelefonos(jTextField4.getText());
            obra.setDireccion(jTextField5.getText());
            obra.setFechacontrato(jTextField2.getText());
            obra.setFirma(jTextField3.getText());
            //Tomo valores de campos y se los asigno al objeto
            String resultado = ControladorObraSocial.insertar(obra);
            if(resultado.equals(""))  //No hubo error
                Mensaje.mostrarMensaje(rootPane, "Obra social agregada con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            else Mensaje.mostrarMensaje(rootPane, "Error al agregar obra social:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
            
            dispose();
            
        }
        else {
        
            obra.setNombre(jTextField1.getText());
            obra.setTelefonos(jTextField4.getText());
            obra.setDireccion(jTextField5.getText());
            obra.setFechacontrato(jTextField2.getText());
            obra.setFirma(jTextField3.getText());
            String resultado = ControladorObraSocial.editar(obra);
            if(resultado.equals(""))  //No hubo error
                Mensaje.mostrarMensaje(rootPane, "Obra social editada con éxito", "Enhorabuena", JOptionPane.INFORMATION_MESSAGE);
            else Mensaje.mostrarMensaje(rootPane, "Error al editar obra social:\n" + resultado, "Error", JOptionPane.ERROR_MESSAGE);
            
            dispose();
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JPanel nuevaObraSocialPanel;
    // End of variables declaration//GEN-END:variables
}
