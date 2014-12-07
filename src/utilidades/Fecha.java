/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author COCO
 */
public class Fecha {
    
    public static String getFechaActual(){
    
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(calendar.getTime());
    
    }
    
    public static String getFechaActualInvertida(){
    
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    
    }
    
    public static String getFechaHaceMeses(int meses){
    
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, meses);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(calendar.getTime());
    
    }
    
    public static String invertirFecha(String fecha){
    
        String[] aux = fecha.split("-");
        return aux[2] + "-" + aux[1] + "-" + aux[0];
    
    }
    
    public static String[] getFechasInvertidas(String fecha, int cantidad){
    
        String[] fechas = new String[cantidad];
        Calendar calendar = Calendar.getInstance();
        String[] aux = fecha.split("-");
        calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(aux[2]));
        calendar.set(Calendar.MONTH, Integer.parseInt(aux[1]) - 1);
        calendar.set(Calendar.YEAR, Integer.parseInt(aux[0]));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
        for(int i = 0; i < cantidad; i++){
        
            fechas[i] = sdf.format(calendar.getTime());
            calendar.add(Calendar.MONTH, 1);
        
        }
        
        return fechas;
    
    }
    
    public static String getFechaFromJSpinner(Date date){
    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    
    }
    
    public static String getMes(String mes){
    
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        
        return meses[Integer.parseInt(mes) - 1];
    
    }
    
}
