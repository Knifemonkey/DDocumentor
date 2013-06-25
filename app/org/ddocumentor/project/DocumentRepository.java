package org.ddocumentor.project;

import org.ddocumentor.source.ParsedJavaSource;

import java.util.List;

public interface DocumentRepository {

    ParsedJavaSource findOneByProjectDocument(DocumentEntry firstDocumentEntry);

    ParsedJavaSource save(ParsedJavaSource parsedJavaSource);
}
