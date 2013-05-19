package org.ddocumentor.test;

import org.ddocumentor.docs.ParsedDocument;
import org.junit.Test;

public class ConverterTest {
	@Test
	public void converterShouldHandleMultipleDocumentBlocks() {
		
		/* See JavaSourceReaderTest.converterShouldHandleMultipleDocumentBlocks
		JavaSource parsedDocument = prepareJavaSourceWithMultipleBlocks();

		//ParsedDocument parsedDocument = new Converter().convert(javaSource);
		
		List<DocumentPart> documentParts = parsedDocument.getParts();
		
		assertThat(documentParts, not(hasSize(0)));
		
		assertThat(documentParts.get(0).getMarkup(), not(isEmptyOrNullString()));
		*/
	}

	private ParsedDocument prepareJavaSourceWithMultipleBlocks() {
		// TODO Auto-generated method stub
		return null;
	}
}
