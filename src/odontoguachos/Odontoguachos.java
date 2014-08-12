/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package odontoguachos;

import GUI.FormularioPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Viic
 */
public class Odontoguachos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        setLookAndFeel();
        FormularioPrincipal mf = new FormularioPrincipal();
        mf.requestFocus();
        mf.setVisible(true);
        mf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        mf.setLocationRelativeTo(null);
        mf.setResizable(true);
        mf.setTitle("COSoft");
        
    }
    
    public static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Odontoguachos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
