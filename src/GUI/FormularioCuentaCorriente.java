/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import controlador.ControladorCuentaCorriente;
import controlador.ControladorMaterial;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import modelo.ConceptoCuentaCorriente;
import modelo.Condonacion;
import modelo.Material;
import modelo.RenglonCuentaCorriente;
import utilidades.Fecha;
import utilidades.Mensaje;

/**
 *
 * @author COCO
 */
public class FormularioCuentaCorriente extends javax.swing.JDialog implements WindowFocusListener {

    int id;
    String filtro;
      
    Boolean deboRefrescar;
    
    ArrayList<RenglonCuentaCorriente> renglones;
    
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableColumnModel modeloColumnas = new DefaultTableColumnModel();
    
    ArrayList<ConceptoCuentaCorriente> conceptos;
    ArrayList<Condonacion> condonaciones;
    
    /**
     * Creates new form FormularioCuentaCorriente
     */
    public FormularioCuentaCorriente() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        setResizable(false);
        
        modelo = (DefaultTableModel) jTable1.getModel();
        modeloColumnas = (DefaultTableColumnModel) jTable1.getColumnModel();
        
        conceptos = new ArrayList<>();
        condonaciones = new ArrayList<>();
        renglones = new ArrayList<>();
        
        deboRefrescar = false;
        
        jTable1.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    
                    RenglonCuentaCorriente renglon = renglones.get(row);
                    switch (renglon.getTipo()){
                    
                        case RenglonCuentaCorriente.FACTURA: {
                        
                            if(renglon.getIdFactura() != null){
                                FormularioFactura form = new FormularioFactura(renglon.getIdFactura());
                                form.setVisible(true);
                            }
                            break;
                        
                        }
                        
                        case RenglonCuentaCorriente.RECIBO: {
                        
                            if(renglon.getIdRecibo() != null){
                                FormularioRecibo form = new FormularioRecibo(renglon.getIdRecibo());
                                form.setVisible(true);
                            }
                            break;
                        
                        }
                        
                        case RenglonCuentaCorriente.LIQUIDACION: {
                        
                            break;
                        
                        }
                    
                    }
                    
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
                
                    if(renglones.get(row).getTipo() == RenglonCuentaCorriente.FACTURA && renglones.get(row).getIdFactura() == null)
                        jPopupMenu1.show(me.getComponent(), me.getX(), me.getY());
                    
                }
                
            }
            
        });
        
        addWindowFocusListener(this);
        
        filtro = " AND fecha <= '" + Fecha.getFechaFromJSpinner((Date)jSpinner4.getModel().getValue()) + "'";

    }
    
    public void setData(int id, String nombre){
    
        this.id = id;
        jLabel1.setText(nombre);
        
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
        jMenuItemCondonar = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.DAY_OF_MONTH);
        jSpinner3 = new javax.swing.JSpinner(sm);
        SpinnerDateModel sm2 = new SpinnerDateModel(date, null, null, Calendar.DAY_OF_MONTH);
        jSpinner4 = new javax.swing.JSpinner(sm2);
        jButton4 = new javax.swing.JButton();

        jMenuItemCondonar.setText("Condonar débito");
        jMenuItemCondonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCondonarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItemCondonar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Nombre");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Detalle", "Debe", "Haber", "Factura"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(250);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(15);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
        }

        jTextField1.setEditable(false);

        jLabel2.setText("Saldo adeudado");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Desde");

        jLabel6.setText("Hasta");

        jButton3.setText("Filtrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Reestablecer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner3, "dd-MM-yyyy");
        jSpinner3.setEditor(de);

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(jSpinner4, "dd-MM-yyyy");
        jSpinner4.setEditor(de2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jButton3)
                    .addComponent(jButton1)
                    .addComponent(jSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton4.setText("Cobrar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton4)
                        .addGap(0, 694, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(290, 290, 290)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        filtro = " and fecha >= '" + Fecha.getFechaFromJSpinner((Date)jSpinner3.getModel().getValue()) + "' AND fecha <= '" + Fecha.getFechaFromJSpinner((Date)jSpinner4.getModel().getValue()) + "'";
        llenarTodo();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        deboRefrescar = true;
        CobrarDebitos form = new CobrarDebitos(id);
        form.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        filtro = " where fecha <= '" + Fecha.getFechaFromJSpinner((Date)jSpinner4.getModel().getValue()) + "'";
        llenarTodo();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItemCondonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCondonarActionPerformed
        
        deboRefrescar = true;
        CondonarDebito form = new CondonarDebito(renglones.get(jTable1.getSelectedRow()).getIdDebito());
        form.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemCondonarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuItem jMenuItemCondonar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void llenarTodo() {
        
        for(int i = jTable1.getRowCount() - 1; i >= 0; i--){
        
            modelo.removeRow(i);
        
        }
        
        conceptos.clear();
        condonaciones.clear();
        renglones.clear();
        
        ControladorCuentaCorriente.obtenerCuotas(conceptos, id, filtro);
        ControladorCuentaCorriente.obtenerCondonaciones(condonaciones, id);
        
        float saldo = 0;
        
        for(ConceptoCuentaCorriente concepto : conceptos){
        
            if(concepto.getIdliquidacion() == 0){
            
                if(concepto.getIdrecibo() == null){
                    
                    Object[] data = { Fecha.invertirFecha(concepto.getFecha()), concepto.getDetalle(), concepto.getImporte(), 0 , concepto.getIdfactura() };  //DEBE
                    modelo.addRow(data);
                    saldo += concepto.getImporte();
                    
                    renglones.add(new RenglonCuentaCorriente(concepto.getId(), RenglonCuentaCorriente.FACTURA, concepto.getIdfactura()));
                    for(Condonacion c : condonaciones){
                    
                        if(c.getIdCuota() == concepto.getId()){
                         
                            Object[] data2 = { "", "Condonada el " + Fecha.invertirFecha(c.getFecha()), 0, concepto.getImporte(), "" };  //HABER
                            modelo.addRow(data2);
                            renglones.add(new RenglonCuentaCorriente(concepto.getId(), RenglonCuentaCorriente.CONDONACION, concepto.getIdfactura()));
                            saldo -= concepto.getImporte();
                            
                        }
                    
                    }
                    
                }
                else{       //PAGO EFECTIVO, solo al comprar materiales
                
                    Object[] data = { Fecha.invertirFecha(concepto.getFecha()), concepto.getDetalle(), concepto.getImporte(), 0 , concepto.getIdfactura() };  //DEBE
                    modelo.addRow(data);
                    
                    Object[] data2 = { "", "Recibo: " + concepto.getIdrecibo(), 0, concepto.getImporte(), "" };  //HABER
                    modelo.addRow(data2);
                    
                    renglones.add(new RenglonCuentaCorriente(concepto.getId(), RenglonCuentaCorriente.FACTURA, concepto.getIdfactura()));
                    renglones.add(new RenglonCuentaCorriente(concepto.getId(), RenglonCuentaCorriente.RECIBO, concepto.getIdrecibo()));
                
                }
            
            }
            else{
            
                Object[] data = { Fecha.invertirFecha(concepto.getFecha()), concepto.getDetalle(), concepto.getImporte(), 0 , concepto.getIdfactura() };  //DEBE
                modelo.addRow(data);
                
                Object[] data2 = { "", "Liquidación: " + concepto.getNombreliquidacion(), 0, concepto.getImporte() , "" };  //HABER
                modelo.addRow(data2);
                
                renglones.add(new RenglonCuentaCorriente(concepto.getId(), RenglonCuentaCorriente.FACTURA, concepto.getIdfactura()));
                renglones.add(new RenglonCuentaCorriente(concepto.getId(), RenglonCuentaCorriente.LIQUIDACION, concepto.getIdliquidacion()));
            
            }
            
            jTextField1.setText(String.valueOf(saldo));
            
        }
        
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {
        
        if(deboRefrescar)
            llenarTodo();
        deboRefrescar = false;
        
    }

    @Override
    public void windowLostFocus(WindowEvent e) {
        
    }
    
}
