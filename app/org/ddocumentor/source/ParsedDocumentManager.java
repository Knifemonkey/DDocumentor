package org.ddocumentor.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.ddocumentor.docs.ParsedDocument;

public interface ParsedDocumentManager {
	

	ParsedDocument parseJavaSource(BufferedReader javaSourceReader) 
			throws IOException;	

	List<String> getParts(ParsedDocument parsedDocument);

	
}
