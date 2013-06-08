package org.ddocumentor.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.ddocumentor.FileJavaSourceAdapter;
import org.ddocumentor.docs.HtmlParsedDocument;
import org.ddocumentor.docs.JavaSource;
import org.ddocumentor.docs.JavaSourceParser;
import org.ddocumentor.source.ParsedJavaSource;
import org.junit.Test;

public class GeneralAcceptanceTest {

    @Test
    public void convertSourceCodeToHTML() throws IOException {

        InputStream sourceFile = getSourceFileContents();
        BufferedReader bufferedReader = 
	    		 new BufferedReader(new InputStreamReader(sourceFile, "UTF-8"));    


        JavaSource javaSource = new FileJavaSourceAdapter();
        ParsedJavaSource parsedJavaSource = new JavaSourceParser().parseJavaSource(javaSource);



//        String part1 = .getDocumentParts().get(0);

        //ParsedDocument convert = new Convert().convert(new FileJavaSourceAdapter(sourceFile));
        //String convertedSourceFile = convert.getMarkup();

        //System.out.println(convertedSourceFile);

        //TODO update to new output
//        assertThat(part1, is(getResultFile().toString()));


    }

    private InputStream getResultFile() throws IOException {
        String fileName = "/outputHTML.html";

        InputStream resourceAsStream = GeneralAcceptanceTest.class.getResourceAsStream(fileName);
        return resourceAsStream;

    }

    private InputStream getSourceFileContents() throws IOException {
        String fileName = "/public/examples/SourceFile.java";
        InputStream resourceAsStream = GeneralAcceptanceTest.class.getResourceAsStream(fileName);
        return resourceAsStream;
    }
}
