package org.ddocumentor.html;


import com.google.common.collect.Lists;
import info.bliki.wiki.tags.code.JavaCodeFilter;
import info.bliki.wiki.tags.code.SourceCodeFormatter;
import org.ddocumentor.source.ParsedJavaSource;

import java.util.List;

public class HtmlConverter {
//
//    public HtmlParsedDocument convert(HtmlParsedDocument javaSource) {
//
//    	//TODO getParts and prettify them
//        /*List<String> javaSourceParts = javaSource.getContent();
//
//        String startDelimiter = "#DocStart";
//        int codeDocStart = s.indexOf(startDelimiter) + startDelimiter.length();
//        int codeDocEnd = s.indexOf("#DocEnd") - 2;
//        CharSequence codeExample = s.subSequence(codeDocStart, codeDocEnd);
//
//        String prettified = new Prettify().prettify(codeExample.toString());
//        return new ParsedDocument("default", prettified);
//        */
//    	return null;
//    }

    private HtmlParsedDocument convert(ParsedJavaSource parsedJavaSource) {

        HtmlParsedDocument htmlParsedDocument = new HtmlParsedDocument();
        htmlParsedDocument.setTitle(parsedJavaSource.getTitle());

        for (String code : parsedJavaSource.getDocumentParts()) {
            String result = prettify(code);
            result = wrapWithPre(result);
            htmlParsedDocument.addPart(result);
        }

        return htmlParsedDocument;
    }

    private String prettify(String javaCode) {
        String result;
        SourceCodeFormatter f = new JavaCodeFilter();
        result = f.filter(javaCode);
        return result;
    }

    private String wrapWithPre(String result) {
        String coding1 = "<pre class=\"java\" style=\"border: 1px solid #b4d0dc; background-color: #ecf8ff;\">";
        String coding3 = "</pre>";
        result = coding1 + result + coding3;
        return result;
    }

    public List<HtmlParsedDocument> convert(List<ParsedJavaSource> parsedJavaSource) {
        List<HtmlParsedDocument> parsedDocuments = Lists.newArrayList();

        for (ParsedJavaSource javaSource : parsedJavaSource) {
            HtmlParsedDocument htmlParsedDocument = convert(javaSource);
            parsedDocuments.add(htmlParsedDocument);
        }

        return parsedDocuments;
    }
}
