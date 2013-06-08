package org.ddocumentor.test;

import com.google.common.collect.Sets;
import org.ddocumentor.docs.DocumentEntry;
import org.ddocumentor.docs.Project;
import org.ddocumentor.docs.ProjectFactory;
import org.ddocumentor.docs.DocumentRepository;
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
