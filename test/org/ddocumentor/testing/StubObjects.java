package org.ddocumentor.testing;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.ProjectFactory;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.source.ParsedJavaSource;
import org.ddocumentor.system.MockDocumentRepository;

import java.util.List;
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

    public static ParsedJavaSource parsedJavaSource() {
        String title = "Mock title";
        List<String> strings = Lists.newArrayList();

        strings.add("System.out.println(\"tadas\"");
        strings.add("callMethod();");

        ParsedJavaSource parsedJavaSource = new ParsedJavaSource(title, strings);


        return parsedJavaSource;
    }
}
