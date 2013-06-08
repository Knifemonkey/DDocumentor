package org.ddocumentor.test;

import org.ddocumentor.html.HtmlConverter;
import org.ddocumentor.html.HtmlParsedDocument;
import org.ddocumentor.source.ParsedJavaSource;
import org.junit.Test;


import static org.ddocumentor.testing.Asserts.*;
import static org.ddocumentor.testing.StubObjects.parsedJavaSource;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CodeHtmlSyntaxHighlightingSpecTest {
    @Test
    public void converterShouldHandleMultipleDocumentBlocks() {

        ParsedJavaSource javaSource = parsedJavaSource();

        HtmlConverter converter = new HtmlConverter();
        HtmlParsedDocument htmlParsedDocument = converter.convert(javaSource);


        assertThat(htmlParsedDocument.getDocumentParts(), hasSize(greaterThan(0)));
        assertThat(htmlParsedDocument.getDocumentParts(), partsDoHaveContent());
        assertThat(htmlParsedDocument.getDocumentParts(), partsHaveHtml());
    }


}
