package org.ddocumentor.source;

import org.apache.commons.lang3.StringUtils;
import org.ddocumentor.html.HtmlParsedDocument;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaSourceParserImpl implements JavaSourceParser {
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


    public ParsedJavaSource parseJavaSource(JavaSource javaSource) {

        ParsedJavaSource htmlParsedDocument = new ParsedJavaSource(null, null);

//        String javaSourceString = parseSimpleTags(javaSourceReader, htmlParsedDocument);

//        parseComplexTags(htmlParsedDocument, javaSourceString);

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


	
    */	
	
	@Override
	public List<ParsedJavaSource> parse(List<JavaSource> javaSources) {
		
		List<ParsedJavaSource> parsedJavaSources = new ArrayList<>(); 
		for (JavaSource javaSource : javaSources) {
			
			ParsedJavaSource parsedJavaSource = new ParsedJavaSource(getTitle(javaSource), getDocumentParts(javaSource));
			parsedJavaSources.add(parsedJavaSource);
		
		}
		
		return parsedJavaSources;
		
	}

	private List<String> getDocumentParts(JavaSource javaSource) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getTitle(JavaSource javaSource) {
		// TODO Auto-generated method stub
		return null;
	}	

}
