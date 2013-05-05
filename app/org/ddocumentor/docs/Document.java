package org.ddocumentor.docs;

/**
 * Meta entry for project about available documents
 * Used to query parsed documents. IMO we need this to avoid fat ParsedDocument list in memory
 */
public class Document implements Comparable<Document> {
    private final String title;

    public Document(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(Document o) {
        return o.title.compareTo(this.title);
    }
}
