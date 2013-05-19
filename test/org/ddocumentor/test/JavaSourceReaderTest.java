package org.ddocumentor.test;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.ddocumentor.FileJavaSourceAdapter;
import org.ddocumentor.docs.ParsedDocument;
import org.ddocumentor.source.ParsedDocumentManager;
import org.junit.Test;

public class JavaSourceReaderTest {

	@Test
	public void javaSourceReaderShouldReturnDocumentInDifferentParts() 
			throws IOException {
		
		BufferedReader javaSourceReader = prepareTestingFile();
		
		ParsedDocumentManager parsedDocumentManager = new FileJavaSourceAdapter();
		ParsedDocument parsedDocument = 
				parsedDocumentManager.parseJavaSource(javaSourceReader);
		
		assertThat(parsedDocument.getDocumentParts(), hasSize(3));
		assertThat(parsedDocument.getDocumentParts().get(2), is("Hello Doc Start3!"));		
		assertThat(parsedDocument.getTitle(), is(" This is document"));
	}

	private BufferedReader prepareTestingFile() throws IOException {
		//\DDocumentor\test\resources\SourceFile.java
		Path sourceFilePath = FileSystems.getDefault()
				.getPath("test", "resources", "SourceFile.java");
		
		return (BufferedReader)Files
				.newBufferedReader(sourceFilePath.toAbsolutePath(), StandardCharsets.UTF_8);
	}
}
