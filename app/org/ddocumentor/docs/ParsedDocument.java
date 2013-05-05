package org.ddocumentor.docs;

public class ParsedDocument {

    private final String title;
    private final String markup;

    public ParsedDocument(String title, String markup) {
        this.title = title;
        this.markup = markup;
    }

    public String getTitle() {
        return title;
    }

    public String getMarkup() {
        return markup;
    }
}
