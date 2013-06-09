package org.ddocumentor.system.project;

import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.ProjectRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MongoDbProjectRepository implements ProjectRepository {

    final ProjectEntryDAO projectEntryDAO;

    @Inject
    public MongoDbProjectRepository(Morphia morphia, Mongo mongo) {
        this.projectEntryDAO = new ProjectEntryDAO(morphia, mongo);
    }

    @Override
    public Project findOneById(String id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void save(Project project) {
        throw new UnsupportedOperationException();
    }


    public class ProjectEntryDAO extends BasicDAO<Project, Long> {
        public ProjectEntryDAO(Morphia morphia, Mongo mongo) {
            super(mongo, morphia, "mytestdb");
        }
    }
}
