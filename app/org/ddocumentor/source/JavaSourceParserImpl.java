package org.ddocumentor.source;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class JavaSourceParserImpl implements JavaSourceParser {
	
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
			
		List<String> documentParts = new ArrayList<>();
		
		String[] documentPartsArray = StringUtils.substringsBetween(javaSource.getContent(), 
        		JavaSource.TAG_DOC_EXAMPLE_START, JavaSource.TAG_DOC_EXAMPLE_END); 
		
		for (String currentPart : documentPartsArray) {						
			documentParts.add(stripJavaSourceCode(currentPart));			
		}
		
        return documentParts;      
	}

	private String stripJavaSourceCode(String currentPart) {
		String strippedCurrentPart = StringUtils.replaceChars(currentPart, "\r\n\t//", "");
		return strippedCurrentPart;
	}
	
	private String getTitle(JavaSource javaSource) {
		
		String title = StringUtils.substringBetween(javaSource.getContent(), 
				JavaSource.TAG_DOC_TITLE, "\n" );

        String titleResult = stripJavaSourceCode(title);
        titleResult = titleResult.trim();
        return titleResult;
	}	
	
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
	


}
