package org.ddocumentor.source;

import java.util.List;

public class ParsedJavaSource {

    private String title;
    private List<String> parts;


    public ParsedJavaSource(String title, List<String> parts) {
        this.title = title;
        this.parts = parts;
    }

    public List<String> getParts() {
        return this.parts;
    }

    public String getTitle() {
        return this.title;
    }
}
