package org.ddocumentor.system.project;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.ProjectRepository;
import org.ddocumentor.project.SysProjectBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@Singleton
class MongoDbProjectRepository implements ProjectRepository {

    @Inject
    private DB db;


    private Gson gson = new Gson();

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
        SortedSet<DocumentEntry> documentEntries = new TreeSet<>(project.getAvailableDocuments());
        BasicDBObjectBuilder projectBuilder = BasicDBObjectBuilder.start()
                .add("name", project.getName())
                .add("documentEntries", gson.toJson(documentEntries));

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
        String documentEntriesJson = map.get("documentEntries").toString();
        Type type = new TypeToken<SortedSet<DocumentEntry>>() {}.getType();
        SortedSet<DocumentEntry> documentEntries = gson.fromJson(documentEntriesJson, type);

        return new ProjectBuilder()
                .setName(name)
                .setDocumentEntries(documentEntries)
                .setId(idString)
                .build();
    }

    public class ProjectBuilder extends SysProjectBuilder {
    }
}
