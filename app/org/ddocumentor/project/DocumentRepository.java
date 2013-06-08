package org.ddocumentor.project;

import org.ddocumentor.source.ParsedJavaSource;

import java.util.List;

public interface DocumentRepository {
    List<DocumentEntry> findAllByProject(Project project);

    ParsedJavaSource findOneByProjectDocument(DocumentEntry firstDocumentEntry);
}
