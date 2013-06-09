package org.ddocumentor.system.project;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.Mongo;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.project.ProjectRepository;
import org.ddocumentor.source.ParsedJavaSource;

import javax.inject.Singleton;
import java.net.UnknownHostException;

public class SysProjectModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DocumentRepository.class).to(MongoDbDocumentRepository.class);
        bind(ProjectRepository.class).to(MongoDbProjectRepository.class);
    }


    @Provides
    @Singleton
    Datastore datastore() {
        Mongo m = mongo();
        Datastore db = morphia().map(ParsedJavaSource.class).createDatastore(
                m, "mydb");
        return db;
    }

    @Provides
    @Singleton
    private Morphia morphia() {
        return new Morphia();
    }

    @Provides
    @Singleton
    private DbNameProvider dbNameProvider() {
        return new DbNameProvider();
    }

    @Provides
    @Singleton
    private Mongo mongo() {
        try {
            return new Mongo("localhost", 27017);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public static class DbNameProvider {
        public String getName() {
            return "ddocumentor";
        }
    }
}
