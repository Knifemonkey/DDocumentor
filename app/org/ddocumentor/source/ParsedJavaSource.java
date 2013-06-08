package org.ddocumentor.source;

import java.util.List;

public class ParsedJavaSource {
	
	private String title;
	List<String> documentParts;
	

    public ParsedJavaSource(String title, List<String> documentParts) {
        this.title = title; 
    }

    public List<String> getParts() {
       return this.documentParts;
    }

    public String getTitle() {
        return this.title;
    }


    public List<String> getDocumentParts() {
        return this.documentParts;
    }
}
