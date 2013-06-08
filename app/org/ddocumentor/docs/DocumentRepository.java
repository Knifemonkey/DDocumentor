package org.ddocumentor.docs;

import java.util.List;

public interface DocumentRepository {
    List<HtmlParsedDocument> findAllByProject(Project project);

    HtmlParsedDocument findOneByProjectDocument(Document firstDocument);
}
