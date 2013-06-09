package org.ddocumentor.system.project;

import com.google.code.morphia.Key;
import com.google.code.morphia.Morphia;
import com.google.code.morphia.dao.BasicDAO;
import com.mongodb.Mongo;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.ProjectRepository;
import org.ddocumentor.project.SysProjectBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class MongoDbProjectRepository implements ProjectRepository {

    final ProjectEntryDAO projectEntryDAO;

    @Inject
    public MongoDbProjectRepository(Morphia morphia, Mongo mongo, SysProjectModule.DbNameProvider nameProvider) {
        this.projectEntryDAO = new ProjectEntryDAO(morphia, mongo, nameProvider.getName());
    }

    @Override
    public Project findOneById(Long id) {
        return projectEntryDAO.get(id);
    }

    @Override
    public Project save(Project project) {
        Key<Project> save = projectEntryDAO.save(project);
        Long id = (Long) save.getId();

        Project build = new ProjectBuilder()
                .from(project)
                .setId(id)
                .build();

        return build;
    }

    public class ProjectEntryDAO extends BasicDAO<Project, Long> {
        public ProjectEntryDAO(Morphia morphia, Mongo mongo, String name) {
            super(mongo, morphia, name);
        }
    }

    public class ProjectBuilder extends SysProjectBuilder {
    }
}
