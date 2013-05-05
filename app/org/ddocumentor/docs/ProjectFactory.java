package org.ddocumentor.docs;

import org.ddocumentor.docs.Document;
import org.ddocumentor.docs.Project;

import java.util.SortedSet;
import java.util.TreeSet;

public class ProjectFactory {
    public Project createNewProject(String name) {
        return new Project(name, new TreeSet<Document>());
    }

    public Project createNewProject(String name, SortedSet<Document> documents) {
        return new Project(name, documents);
    }
}
