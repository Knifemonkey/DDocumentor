package org.ddocumentor.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.ddocumentor.Convert;
import org.ddocumentor.FileJavaSourceAdapter;
import org.ddocumentor.ParsedDocumentation;
import org.junit.Test;

public class GeneralAcceptanceTest {

    @Test
    public void convertSourceCodeToHTML() throws IOException {
        InputStream sourceFile = getSourceFileContents();
        String resultFile = new FileJavaSourceAdapter(getResultFile()).getContent();

        ParsedDocumentation convert = new Convert().convert(new FileJavaSourceAdapter(sourceFile));
        String convertedSourceFile = convert.getMarkup();

        System.out.println(convertedSourceFile);

        assertThat(convertedSourceFile, is(resultFile));


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
