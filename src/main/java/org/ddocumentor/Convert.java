package org.ddocumentor;


public class Convert {
	
	public String convert(String s){
		String startDelimiter = "#DocStart";
		int codeDocStart = s.indexOf(startDelimiter)+startDelimiter.length();
		int codeDocEnd = s.indexOf("#DocEnd")-2;
		CharSequence codeExample = s.subSequence(codeDocStart, codeDocEnd);
		return "<html><body>" + new Prettify().prettify(codeExample.toString()) + "</body></html>";
	}

}
