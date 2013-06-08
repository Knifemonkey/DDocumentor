package org.ddocumentor.project;

import java.util.Collections;
import java.util.SortedSet;

public class Project {

    private final String name;
    private final SortedSet<DocumentEntry> documentEntries;

    public Project(String name, SortedSet<DocumentEntry> documentEntries) {
        this.name = name;
        this.documentEntries = Collections.unmodifiableSortedSet(documentEntries);
    }

    public Long getId() {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public SortedSet<DocumentEntry> getAvailableDocuments() {
        return documentEntries;
    }

    public DocumentEntry getFirstDocument() {
        return documentEntries.first();
    }
}
