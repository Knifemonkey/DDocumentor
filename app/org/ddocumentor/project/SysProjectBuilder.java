package org.ddocumentor.project;

import java.util.SortedSet;

public class SysProjectBuilder {
    Long id;
    String name;
    SortedSet<DocumentEntry> documentEntries;

    protected SysProjectBuilder() {
    }

    public SysProjectBuilder from(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.documentEntries = project.getAvailableDocuments();
        return this;
    }

    public SysProjectBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public SysProjectBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SysProjectBuilder setDocumentEntries(SortedSet<DocumentEntry> documentEntries) {
        this.documentEntries = documentEntries;
        return this;
    }

    public Project build() {
        return new Project(this);
    }

}
