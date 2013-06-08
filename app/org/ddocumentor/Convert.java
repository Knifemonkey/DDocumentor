package org.ddocumentor;


import org.ddocumentor.docs.HtmlParsedDocument;

public class Convert {

    public HtmlParsedDocument convert(HtmlParsedDocument javaSource) {
    	
    	//TODO getParts and prettify them
        /*List<String> javaSourceParts = javaSource.getContent();

        String startDelimiter = "#DocStart";
        int codeDocStart = s.indexOf(startDelimiter) + startDelimiter.length();
        int codeDocEnd = s.indexOf("#DocEnd") - 2;
        CharSequence codeExample = s.subSequence(codeDocStart, codeDocEnd);

        String prettified = new Prettify().prettify(codeExample.toString());
        return new ParsedDocument("default", prettified);
        */
    	return null;
    }

}
