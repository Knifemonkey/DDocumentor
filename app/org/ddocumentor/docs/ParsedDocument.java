package org.ddocumentor.docs;

import java.util.ArrayList;
import java.util.List;

public class ParsedDocument {

	private String title;
    private List<String> documentParts = new ArrayList<>();
      
    public ParsedDocument() {    	
    }
    
    public ParsedDocument(String title) {
        this.title = title;
    }
    
    public ParsedDocument(String title, List<String> documentParts) {
        this.title = title;
        this.documentParts = documentParts;
    }    

	public String getTitle() {
        return title;
    }

	public List<String> getDocumentParts() {
		return documentParts;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
    public void setDocumentParts(List<String> documentParts) {
		this.documentParts = documentParts;
	}	

}
