package org.ddocumentor.docs;

import org.ddocumentor.docs.Document;

import java.util.Collections;
import java.util.SortedSet;

public class Project {

    private final String name;
    private final SortedSet<Document> documents;

    public Project(String name, SortedSet<Document> documents) {
        this.name = name;
        this.documents = Collections.unmodifiableSortedSet(documents);
    }

    public Long getId() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public SortedSet<Document> getAvailableDocuments() {
        return documents;
    }

    public Document getFirstDocument() {
        return documents.first();
    }
}
