package tp5;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class Freemarker {
	Configuration cfg;
	String toto = "World";

	public void createConfig() throws Exception {
		cfg = new Configuration(Configuration.VERSION_2_3_27);
		cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Clement\\eclipse-workspace\\tp5\\src\\main"));
		cfg.setDefaultEncoding("UTF-8");

		URLTemplateLoader urlt = new URLTemplateLoader() {
			@Override
			protected URL getURL(String name)// class abstraite
			{
				return Main.class.getResource("/" + name);
			}
		};
		cfg.setTemplateLoader(urlt);
	}

	public String remplir() throws Exception {
		Map<String, Object> root = new HashMap<String, Object>();
		root.put("aRemplir", toto);// liaison
		Template temp = cfg.getTemplate("myTemplate.tpl");// quel template
		Writer out = new StringWriter();// mise en mémoire ram (feuille blanche)
		temp.process(root, out);// print de la feuille blanche
		URL url = Main.class.getResource("/myTemplate.tpl");
		System.out.println(url.toString());
		System.out.println(out.toString());
		return(out.toString());
	}

	public void go() throws Exception {
		createConfig();
		remplir();
	}
}
