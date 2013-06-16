package org.ddocumentor.system.project;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.project.ProjectRepository;

import javax.inject.Singleton;

public class SysProjectModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DocumentRepository.class).to(MongoDbDocumentRepository.class);
        bind(ProjectRepository.class).to(MongoDbProjectRepository.class);
    }


    @Provides
    @Singleton
    DB datastore() {
        try {
            MongoClient mongoClient = new MongoClient();
            DB db = mongoClient.getDB("ddocumentor");
            return db;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
