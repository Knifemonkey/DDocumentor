package org.ddocumentor;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ddocumentor.docs.HtmlParsedDocument;
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
	public HtmlParsedDocument parseJavaSource(BufferedReader javaSourceReader)
			throws IOException {
		
		HtmlParsedDocument htmlParsedDocument = new HtmlParsedDocument();
					
		String javaSourceString = parseSimpleTags(javaSourceReader, htmlParsedDocument);
						
		parseComplexTags(htmlParsedDocument, javaSourceString);

		return htmlParsedDocument;
	}

	private void parseComplexTags(HtmlParsedDocument htmlParsedDocument,
			String javaSourceString) {
		String[] documentParts = 
				StringUtils.substringsBetween(javaSourceString, "#DocStart", "#DocEnd");
		
		for (String markup : documentParts) {
			htmlParsedDocument.getDocumentParts().add(markup);
		}
	}

	private String parseSimpleTags(BufferedReader javaSourceReader, HtmlParsedDocument htmlParsedDocument)
			throws IOException {
		
		StringBuilder javaSourceSB = new StringBuilder(); 
		
		String line;
		do {
			
			line = javaSourceReader.readLine();
			
			parseTitle(line, htmlParsedDocument);
			
			javaSourceSB.append(line);
			
		} while (line != null);		
		
		return javaSourceSB.toString();
	}

	private void parseTitle(String line, HtmlParsedDocument htmlParsedDocument) {
		if ((line != null) && line.contains("#DocTitle")) {
			htmlParsedDocument.setTitle(StringUtils.substringAfter(line, "#DocTitle"));
		}
	}

	@Override
	public List<String> getParts(HtmlParsedDocument htmlParsedDocument) {
		return htmlParsedDocument.getDocumentParts();
	}

}
