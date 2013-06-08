package org.ddocumentor.test;

import static org.ddocumentor.testing.Asserts.partsHaveHtml;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.google.common.collect.Lists;
import org.ddocumentor.html.HtmlConverter;
import org.ddocumentor.html.HtmlParsedDocument;
import org.ddocumentor.source.*;
import org.junit.Test;

public class GeneralAcceptanceTest {

    @Test
    public void convertSourceCodeToHTML() throws IOException {

        InputStream sourceFile = getSourceFileContents();

        List<JavaSource> javaSources = Lists.newArrayList();
        JavaSource javaSource = JavaSourceFactory.createJavaSource(sourceFile);
        javaSources.add(javaSource);

        List<ParsedJavaSource> parsedJavaSource = new JavaSourceParserImpl().parse(javaSources);

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
