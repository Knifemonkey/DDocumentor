package org.ddocumentor.source;

import java.util.List;

public class ParsedJavaSource {

    private String title;
    private List<String> parts;
    private String id;


    public ParsedJavaSource(String title, List<String> parts) {
        this.title = title;
        this.parts = parts;
    }

    ParsedJavaSource(SysSourceBuilder b) {
        this.id = b.id;
        this.parts = b.parts;
        this.title = b.title;
    }

    public String getId() {
        return id;
    }

    public List<String> getParts() {
        return this.parts;
    }

    public String getTitle() {
        return this.title;
    }


}
