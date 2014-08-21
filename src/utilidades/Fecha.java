/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.util.Calendar;

/**
 *
 * @author COCO
 */
public class Fecha {
    
    public static String getFechaActual(){
    
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.YEAR);
    
    }
    
    public static String getFechaActualInvertida(){
    
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR) + "-" + calendar.get(Calendar.MONTH) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    
    }
    
    public static String getFechaHaceMeses(int meses){
    
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, meses);
        return calendar.get(Calendar.YEAR) + "-" + (calendar.get(Calendar.MONTH) + 1) + "-" + calendar.get(Calendar.DAY_OF_MONTH);
    
    }
    
    public static String invertirFecha(String fecha){
    
        String[] aux = fecha.split("-");
        return aux[2] + "-" + aux[1] + "-" + aux[0];
    
    }
    
}
