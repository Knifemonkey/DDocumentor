package org.ddocumentor.project;

import com.google.code.morphia.annotations.Entity;

import java.util.Collections;
import java.util.SortedSet;

@Entity
public class Project {

    private final Long id;
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
        this.documentEntries = Collections.unmodifiableSortedSet(documentEntries);
    }

    public Long getId() {
        return this.id;
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
