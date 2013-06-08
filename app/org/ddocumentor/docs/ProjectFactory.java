package org.ddocumentor.docs;

import java.util.SortedSet;
import java.util.TreeSet;

public class ProjectFactory {
    public Project createNewProject(String name) {
        return new Project(name, new TreeSet<DocumentEntry>());
    }

    public Project createNewProject(String name, SortedSet<DocumentEntry> documentEntries) {
        return new Project(name, documentEntries);
    }
}
