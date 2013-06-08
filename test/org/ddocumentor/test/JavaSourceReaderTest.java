package org.ddocumentor.test;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.ddocumentor.source.FileJavaSourceAdapter;
import org.ddocumentor.html.HtmlParsedDocument;
import org.ddocumentor.source.JavaSource;
import org.ddocumentor.source.JavaSourceParser;
import org.junit.Test;

public class JavaSourceReaderTest {

	@Test
	public void javaSourceReaderShouldReturnDocumentInDifferentParts() 
			throws IOException {
		
		BufferedReader javaSourceReader = prepareTestingFile();
		
		JavaSource parsedJavaSource = new FileJavaSourceAdapter();
		HtmlParsedDocument htmlParsedDocument =
				new JavaSourceParser().parseJavaSource(javaSourceReader);
		
		assertThat(htmlParsedDocument.getDocumentParts(), hasSize(3));
		assertThat(htmlParsedDocument.getDocumentParts().get(2), is("Hello Doc Start3!"));
		assertThat(htmlParsedDocument.getTitle(), is(" This is document"));
	}

	private BufferedReader prepareTestingFile() throws IOException {
		//\DDocumentor\test\resources\SourceFile.java
		Path sourceFilePath = FileSystems.getDefault()
				.getPath("test", "resources", "SourceFile.java");
		
		return (BufferedReader)Files
				.newBufferedReader(sourceFilePath.toAbsolutePath(), StandardCharsets.UTF_8);
	}
}
