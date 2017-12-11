package tp5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import freemarker.cache.URLTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class Main {
	public static void main(String[] args) throws Exception {
		Freemarker fm = new Freemarker();
		fm.go();
	}
}
