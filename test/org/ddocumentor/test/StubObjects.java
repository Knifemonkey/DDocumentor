package org.ddocumentor.test;

import com.google.common.collect.Sets;
import org.ddocumentor.docs.Document;
import org.ddocumentor.docs.Project;
import org.ddocumentor.docs.ProjectFactory;
import org.ddocumentor.docs.DocumentRepository;
import org.ddocumentor.system.MockDocumentRepository;

import java.util.SortedSet;

public class StubObjects {
    public static Project prepareProject() {
        ProjectFactory projectFactory = new ProjectFactory();
        SortedSet<Document> documents = Sets.newTreeSet();

        Document document;
        document = new Document("titleFirst");
        documents.add(document);
        document = new Document("titleSecond");
        documents.add(document);

        return projectFactory.createNewProject("mockProject", documents);
    }

    public static DocumentRepository prepareDocumentRepository() {
        DocumentRepository documentRepository = new MockDocumentRepository();
        return documentRepository;
    }
}
