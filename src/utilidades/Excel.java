/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author COCO
 */
public class Excel {
    
    public static void writeFile(JTable tabla, File file, String titulo, String hoja){
    
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook(); 
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet(hoja);
          
        //This data needs to be written (Object[])
        ArrayList<String[]> data = new ArrayList<String[]>();
        data.add(new String[] {""});
        data.add(new String[] {""});
        String[] titulos = new String[tabla.getColumnCount()];
        for(int i = 0; i < tabla.getColumnCount(); i++)
            titulos[i] = tabla.getColumnModel().getColumn(i).getHeaderValue().toString();
        
        data.add(titulos);
        
        for(int i = 0; i < tabla.getRowCount(); i++){
        
            String[] datos = new String[tabla.getColumnCount()];
            for(int j = 0; j < tabla.getColumnCount(); j++){
            
                if(tabla.getValueAt(i, j) != null)
                    datos[j] = tabla.getValueAt(i, j).toString();
            
            }
            data.add(datos);
        
        }
        
        XSSFFont boldFont = workbook.createFont();
        boldFont.setBold(true);
        CellStyle style = sheet.getWorkbook().createCellStyle();
        style.setFont(boldFont);
        
        //Iterate over data and write to sheet
        int rownum = 0;
        for (int i = 0; i < data.size(); i++)
        {
            rownum = i;
            Row row = sheet.createRow(rownum);
            int cellnum = 0;
            for (String obj : data.get(i))
            {
               Cell cell = row.createCell(cellnum++);
               if(rownum == 2)
                    cell.setCellStyle(style);
               cell.setCellValue((String)obj);
               
            }
        }
        
        for(int colNum = 0; colNum < sheet.getRow(2).getLastCellNum(); colNum++)   
            workbook.getSheetAt(0).autoSizeColumn(colNum);
        sheet.getRow(0).createCell(1).setCellValue(titulo.toUpperCase());
        sheet.getRow(0).getCell(1).setCellStyle(style);
        
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(file);
            workbook.write(out);
            out.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    
    }
    
}
