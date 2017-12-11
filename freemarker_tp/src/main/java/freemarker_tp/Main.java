package freemarker_tp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.html2pdf.HtmlConverter;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Main {

	public static void main(String[] args) throws IOException, TemplateException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_27);
		cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Clement\\Documents\\Template"));
		cfg.setDefaultEncoding("UTF-8");

		
		List<String> listeFilms = new ArrayList<String>();
		listeFilms.add("Inception");
		listeFilms.add("Interstellar");
		listeFilms.add("Seven");
		listeFilms.add("Transformers 3");
		listeFilms.add("Le seigneur des anneaux");
		listeFilms.add("Inception");
		
		List<Object> listeFilms2 = new ArrayList<Object>();
//		
//		Film film1 = new Film("inception", "blabla", 2300);
//		Film film2 = new Film("interstellar", "blabla", 23400);
//		Film film3 = new Film("le seigneur des anneaux", "jean", 1990);
//		Film film4 = new Film("Transformers", "robert", 1992);
//		Film film5 = new Film("inception", "louis", 2001);
		
		listeFilms2.add(new Film("inception", "blabla", 2300));
		listeFilms2.add(new Film("interstellar", "blabla", 23400));
		listeFilms2.add(new Film("le seigneur des anneaux", "jean", 1990));
		listeFilms2.add(new Film("Transformers", "robert", 1992));
		listeFilms2.add(new Film("inception", "louis", 2001));

		
		
		Map root = new HashMap();
//		for (int i=0; i<listeFilms.size(); i++) {
//			root.put("film" + i, listeFilms.get(i));
//		}
		
		
		/* Create a data-model */
		
		root.put("listeFilms", listeFilms2);
		
		
		/* Get the template (uses cache internally) */
		Template temp = cfg.getTemplate("myTemplate.tpl");

		/* Merge data-model with template */
		Writer out = new StringWriter();
		temp.process(root, out);
		
		
		HtmlConverter.convertToPdf(((StringWriter)out).getBuffer().toString(), new FileOutputStream("C:\\Users\\Clement\\Documents\\Template\\test.pdf"));

	}

}
