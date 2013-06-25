package org.ddocumentor.project;

import java.io.Serializable;

/**
 * Meta entry for project about available documents
 * Used to query parsed documents. IMO we need this to avoid fat ParsedDocument list in memory
 */
public class DocumentEntry implements Comparable<DocumentEntry>, Serializable {
    private final String title;
    private final String id;

    public DocumentEntry(String title) {
        this.title = title;
        id = null;
    }

    public DocumentEntry(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int compareTo(DocumentEntry o) {
        return o.title.compareTo(this.title);
    }
}
