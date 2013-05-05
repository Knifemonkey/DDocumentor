package org.ddocumentor;


import org.ddocumentor.docs.ParsedDocument;
import org.ddocumentor.source.JavaSource;

public class Convert {

    public ParsedDocument convert(JavaSource javaSource) {
        String s = javaSource.getContent();

        String startDelimiter = "#DocStart";
        int codeDocStart = s.indexOf(startDelimiter) + startDelimiter.length();
        int codeDocEnd = s.indexOf("#DocEnd") - 2;
        CharSequence codeExample = s.subSequence(codeDocStart, codeDocEnd);

        String prettified = new Prettify().prettify(codeExample.toString());
        return new ParsedDocument("default", prettified);
    }

}
