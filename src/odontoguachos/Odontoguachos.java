/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package odontoguachos;

import GUI.MainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        MainFrame mf = new MainFrame();
        mf.requestFocus();
        mf.setVisible(true);
        mf.setLocationRelativeTo(null);
        mf.setResizable(false);
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
