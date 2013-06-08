package org.ddocumentor.test;

import com.google.common.collect.Sets;
import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.ProjectFactory;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.system.MockDocumentRepository;

import java.util.SortedSet;

public class StubObjects {
    public static Project prepareProject() {
        ProjectFactory projectFactory = new ProjectFactory();
        SortedSet<DocumentEntry> documentEntries = Sets.newTreeSet();

        DocumentEntry documentEntry;
        documentEntry = new DocumentEntry("titleFirst");
        documentEntries.add(documentEntry);
        documentEntry = new DocumentEntry("titleSecond");
        documentEntries.add(documentEntry);

        return projectFactory.createNewProject("mockProject", documentEntries);
    }

    public static DocumentRepository prepareDocumentRepository() {
        DocumentRepository documentRepository = new MockDocumentRepository();
        return documentRepository;
    }
}
