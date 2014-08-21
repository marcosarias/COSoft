package utilidades;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;




public class Xml {
	
	public static void almacenar(String path, Config a ){
		XStream xs = new XStream();
		
		try{
			FileOutputStream fs = new FileOutputStream(path);
			xs.toXML(a,fs);
			
		}catch (FileNotFoundException e){
			
		}
		
	}
       

	public static Config cargar(String path) throws FileNotFoundException{
	
            XStream xs = new XStream(new DomDriver());

            FileInputStream fi = new FileInputStream(path);
            Config a = new Config();
            xs.fromXML(fi,a);
            
            return a;
        
	}
}