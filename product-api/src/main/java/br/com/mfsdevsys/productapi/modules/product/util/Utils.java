package br.com.mfsdevsys.productapi.modules.product.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Utils {
	
	public String deAccent(String str) {
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	// E no momento de usar ficaria algo como:
	//System.out.print(deAccent("Olá, mundo!"));

}
