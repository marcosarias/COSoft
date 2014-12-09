package utilidades;

import java.io.File;
import java.io.RandomAccessFile;

public class Log {

    public static void write(String text){

        File myFile = new File("Log.txt");

        try
        {
            long fileLength = myFile.length();
            RandomAccessFile raf = new RandomAccessFile(myFile, "rw");
            raf.seek(fileLength);
            raf.writeBytes(text + " - " + Fecha.getFechaHoraActual() + "\n");
            raf.close();
        } catch(Exception e)
        {
            
        }

    }

}
