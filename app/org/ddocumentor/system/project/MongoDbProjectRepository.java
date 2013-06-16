package org.ddocumentor.system.project;

import com.google.inject.Inject;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.ProjectRepository;
import org.ddocumentor.project.SysProjectBuilder;

import javax.inject.Singleton;
import java.util.Map;

@Singleton
class MongoDbProjectRepository implements ProjectRepository {

    @Inject
    private DB db;


    @Override
    public Project findOneById(String id) {
        DBCollection collection = db.getCollection("projects");
        BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
        DBObject dbObject = collection.findOne(query);

        Project build = buildProject(dbObject);

        return build;
    }

    @Override
    public Project save(Project project) {

        DBCollection collection = db.getCollection("projects");
        BasicDBObjectBuilder projectBuilder = BasicDBObjectBuilder.start()
                .add("name", project.getName());

        if (project.getId() != null) {
            projectBuilder.add("_id", new ObjectId(project.getId()));
        }

        DBObject dbObject = projectBuilder.get();

        if (project.getId() != null) {
            collection.save(dbObject);
        } else {
            collection.insert(dbObject);
        }

        Project build = buildProject(dbObject);

        return build;
    }


    private Project buildProject(DBObject one) {
        Map<String, Object> map = one.toMap();
        String idString = map.get("_id").toString();
        String name = map.get("name").toString();

        return new ProjectBuilder()
                .setName(name)
                .setId(idString)
                .build();
    }

    public class ProjectBuilder extends SysProjectBuilder {
    }
}
