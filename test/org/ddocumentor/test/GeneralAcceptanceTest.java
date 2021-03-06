package org.ddocumentor.test;

import static org.ddocumentor.testing.Asserts.partsHaveHtml;
import static org.ddocumentor.testing.StubObjects.prepareTestingFile;
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

        InputStream sourceFile = prepareTestingFile();

        List<JavaSource> javaSources = Lists.newArrayList();
        JavaSource javaSource = JavaSourceFactory.createJavaSource(sourceFile);
        javaSources.add(javaSource);

        List<ParsedJavaSource> parsedJavaSources = new JavaSourceParserImpl().parse(javaSources);

        ParsedJavaSource parsedJavaSource = parsedJavaSources.get(0);
        HtmlParsedDocument htmlParsedDocument = new HtmlConverter().convert(parsedJavaSource);


        assertThat(htmlParsedDocument.getTitle(), is("This is document"));
        assertThat(htmlParsedDocument.getDocumentParts(), partsHaveHtml());
    }


}
