package org.ddocumentor.project;


import org.ddocumentor.source.ParsedJavaSource;

import java.util.Collections;
import java.util.SortedSet;

public class Project {

    private final String id;
    private final String name;
    private final SortedSet<DocumentEntry> documentEntries;

    Project(SysProjectBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.documentEntries = builder.documentEntries;
    }

    Project(String name, SortedSet<DocumentEntry> documentEntries) {
        this.id = null;
        this.name = name;
        this.documentEntries = documentEntries;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public SortedSet<DocumentEntry> getAvailableDocuments() {
        return Collections.unmodifiableSortedSet(documentEntries);
    }

    public DocumentEntry getFirstDocument() {
        return documentEntries.last();
    }

    public void addParsedJavaSource(ParsedJavaSource parsedJavaSource) {
        documentEntries.add(new DocumentEntry(parsedJavaSource.getId(), parsedJavaSource.getTitle()));
    }
}
