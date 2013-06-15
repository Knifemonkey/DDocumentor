package org.ddocumentor.source;

public class JavaSource {
	
	public static final String TAG_DOC_TITLE = "#DocTitle"; 	
	public static final String TAG_DOC_EXAMPLE_START = "#DocStart"; 
	public static final String TAG_DOC_EXAMPLE_END = "#DocEnd"; 	

    private String content;

    public JavaSource(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

}
