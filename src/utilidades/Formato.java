/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

/**
 *
 * @author COCO
 */
public class Formato {
    
    public static String darFormatoFactura(String s){
    
        String[] a = s.split("-");
            
        while(a[0].length() < 4)
            a[0] = "0" + a[0];
        
        while(a[1].length() < 8)
            a[1] = "0" + a[1];
            
        return a[0] + "-" + a[1];
        
    }
    
}
