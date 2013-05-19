package org.ddocumentor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ddocumentor.docs.ParsedDocument;
import org.ddocumentor.source.ParsedDocumentManager;

public class FileJavaSourceAdapter implements ParsedDocumentManager {

	/*
    public FileJavaSourceAdapter(InputStream inputStream) {
        try {
            this.content = readFile(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String readFile(InputStream resourceAsStream) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
    */

	@Override
	public ParsedDocument parseJavaSource(BufferedReader javaSourceReader) 
			throws IOException {
		
		ParsedDocument parsedDocument = new ParsedDocument();				
					
		String javaSourceString = parseSimpleTags(javaSourceReader, parsedDocument);
						
		parseComplexTags(parsedDocument, javaSourceString);

		return parsedDocument;
	}

	private void parseComplexTags(ParsedDocument parsedDocument,
			String javaSourceString) {
		String[] documentParts = 
				StringUtils.substringsBetween(javaSourceString, "#DocStart", "#DocEnd");
		
		for (String markup : documentParts) {
			parsedDocument.getDocumentParts().add(markup);
		}
	}

	private String parseSimpleTags(BufferedReader javaSourceReader, ParsedDocument parsedDocument) 
			throws IOException {
		
		StringBuilder javaSourceSB = new StringBuilder(); 
		
		String line;
		do {
			
			line = javaSourceReader.readLine();
			
			parseTitle(line, parsedDocument);
			
			javaSourceSB.append(line);
			
		} while (line != null);		
		
		return javaSourceSB.toString();
	}

	private void parseTitle(String line, ParsedDocument parsedDocument) {
		if ((line != null) && line.contains("#DocTitle")) {
			parsedDocument.setTitle(StringUtils.substringAfter(line, "#DocTitle"));
		}
	}

	@Override
	public List<String> getParts(ParsedDocument parsedDocument) {		
		return parsedDocument.getDocumentParts();
	}

}
