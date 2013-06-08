package org.ddocumentor.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.ddocumentor.source.FileJavaSourceAdapter;
import org.ddocumentor.html.HtmlParsedDocument;
import org.ddocumentor.source.JavaSource;
import org.ddocumentor.source.JavaSourceParser;
import org.ddocumentor.source.ParsedJavaSource;
import org.junit.Test;

public class JavaSourceReaderTest {

    @Test
    public void javaSourceReaderShouldReturnDocumentInDifferentParts()
            throws IOException {

        InputStream sourceInputStream = prepareTestingFile();

        JavaSource javaSource = new FileJavaSourceAdapter(sourceInputStream);
        ParsedJavaSource parsedJavaSource =
                new JavaSourceParser().parseJavaSource(javaSource);

        assertThat(parsedJavaSource.getDocumentParts(), hasSize(3));
        assertThat(parsedJavaSource.getDocumentParts().get(2), is("Hello Doc Start3!"));
        assertThat(parsedJavaSource.getTitle(), is(" This is document"));
    }

    private InputStream prepareTestingFile() throws IOException {
        //\DDocumentor\test\resources\SourceFile.java
        Path sourceFilePath = FileSystems.getDefault()
                .getPath("test", "resources", "SourceFile.java");
        InputStream inputStream = Files.newInputStream(sourceFilePath.toAbsolutePath());
        return inputStream;
    }
}
