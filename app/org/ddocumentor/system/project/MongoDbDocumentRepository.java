package org.ddocumentor.system.project;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.google.inject.Singleton;
import com.mongodb.Mongo;
import org.bson.types.ObjectId;
import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.project.Project;
import org.ddocumentor.source.ParsedJavaSource;

import javax.inject.Inject;
import java.util.List;

@Singleton
class MongoDbDocumentRepository implements DocumentRepository {

    @Inject
    private Datastore datastore;

    @Override
    public List<DocumentEntry> findAllByProject(Project project) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ParsedJavaSource findOneByProjectDocument(DocumentEntry firstDocumentEntry) {
        throw new UnsupportedOperationException();
    }

}
