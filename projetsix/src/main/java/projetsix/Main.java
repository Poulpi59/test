package projetsix;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {
		Date date = new Date();
		date.getTime();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar .MONTH, 3); // on ajoute 3 mois par rapport à aujourd'hui
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(date.toString());
		System.out.println(sdf.format(date));
		System.out.println(sdf.parse("01/02/2001"));
		
		Properties prop = new Properties();
		Reader r = new FileReader(new File("C:\\Users\\Clement\\Documents\\Template\\config.properties"));
		prop.load(r);
		r.close();
		
		if (prop.containsKey("serveur")) {
			System.out.println(prop.getProperty("serveur"));
			
		}
		prop.put("clétoto", "33");
		
		Writer w = new FileWriter(new File("C:\\Users\\Clement\\Documents\\Template\\config.properties"));
		prop.store(w,  "Mon fichier de config");
		w.close();
	}

}
