package org.ddocumentor.test;

import static org.ddocumentor.testing.Asserts.partsHaveHtml;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.ddocumentor.html.HtmlConverter;
import org.ddocumentor.html.HtmlParsedDocument;
import org.ddocumentor.project.Project;
import org.ddocumentor.source.FileJavaSourceAdapter;
import org.ddocumentor.source.JavaSource;
import org.ddocumentor.source.JavaSourceParser;
import org.ddocumentor.source.ParsedJavaSource;
import org.hamcrest.Matcher;
import org.junit.Test;

public class GeneralAcceptanceTest {

    @Test
    public void convertSourceCodeToHTML() throws IOException {

        InputStream sourceFile = getSourceFileContents();


        JavaSource javaSource = new FileJavaSourceAdapter(sourceFile);
        ParsedJavaSource parsedJavaSource = new JavaSourceParser().parseJavaSource(javaSource);

        HtmlParsedDocument htmlParsedDocument = new HtmlConverter().convert(parsedJavaSource);
        assertThat(htmlParsedDocument.getTitle(), is("My title"));
        assertThat(htmlParsedDocument.getDocumentParts(), partsHaveHtml());
    }

    private InputStream getSourceFileContents() throws IOException {
        String fileName = "/public/examples/SourceFile.java";
        InputStream resourceAsStream = GeneralAcceptanceTest.class.getResourceAsStream(fileName);
        return resourceAsStream;
    }
}
