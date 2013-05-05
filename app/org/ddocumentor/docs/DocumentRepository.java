package org.ddocumentor.docs;

import java.util.List;

public interface DocumentRepository {
    List<ParsedDocument> findAllByProject(Project project);

    ParsedDocument findOneByProjectDocument(Document firstDocument);
}
