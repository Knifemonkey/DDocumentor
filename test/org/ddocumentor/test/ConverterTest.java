package org.ddocumentor.test;

import org.ddocumentor.html.HtmlConverter;
import org.ddocumentor.html.HtmlParsedDocument;
import org.ddocumentor.source.ParsedJavaSource;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ConverterTest {
    @Test
    public void converterShouldHandleMultipleDocumentBlocks() {

        ParsedJavaSource javaSource = prepareParsedJavaSource();

        HtmlConverter converter = new HtmlConverter();
        HtmlParsedDocument htmlParsedDocument = converter.convert(javaSource);


        assertThat(htmlParsedDocument.getDocumentParts(), hasSize(greaterThan(0)));
        assertThat(htmlParsedDocument.getDocumentParts().get(0), not(isEmptyOrNullString()));

    }

    private ParsedJavaSource prepareParsedJavaSource() {
        throw new UnsupportedOperationException();
    }
}
