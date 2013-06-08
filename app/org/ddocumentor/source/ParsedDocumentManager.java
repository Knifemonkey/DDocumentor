package org.ddocumentor.source;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.ddocumentor.docs.HtmlParsedDocument;

public interface ParsedDocumentManager {
	

	HtmlParsedDocument parseJavaSource(BufferedReader javaSourceReader)
			throws IOException;	

	List<String> getParts(HtmlParsedDocument htmlParsedDocument);

	
}
