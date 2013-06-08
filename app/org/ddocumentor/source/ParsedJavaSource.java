package org.ddocumentor.source;

import com.google.common.collect.Lists;

import java.util.List;

public class ParsedJavaSource {

    private final String title;
    private final List<String> parts;

    public ParsedJavaSource(String title, List<String> parts) {
        this.title = title;
        this.parts = Lists.newArrayList(parts);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getDocumentParts() {
        return parts;
    }
}
