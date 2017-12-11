package tp5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexp {

	public static void main(String[] args) {
		String toto = "Il fait beau 123 4567";
		Pattern pat = Pattern.compile("[a-zA-Z ]+ [0-9]{3} [0-9]{4}");
		Matcher mat = pat.matcher(toto);
		System.out.println(mat.matches());

	}

}
