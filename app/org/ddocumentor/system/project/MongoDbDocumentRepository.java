package org.ddocumentor.system.project;

import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.project.Project;
import org.ddocumentor.source.ParsedJavaSource;

import javax.inject.Singleton;
import java.util.List;

@Singleton
class MongoDbDocumentRepository implements DocumentRepository {


    @Override
    public List<DocumentEntry> findAllByProject(Project project) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ParsedJavaSource findOneByProjectDocument(DocumentEntry firstDocumentEntry) {
        throw new UnsupportedOperationException();
    }

}
