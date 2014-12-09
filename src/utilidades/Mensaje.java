/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author COCO
 */
public class Mensaje {
    
    public static void mostrarMensaje(Component rootPane, String mensaje, String titulo, int tipo){

        JOptionPane.showMessageDialog(rootPane, mensaje, titulo, tipo);
        
        if(tipo == JOptionPane.ERROR_MESSAGE)
            Log.write(mensaje);
    
    }
    
}
