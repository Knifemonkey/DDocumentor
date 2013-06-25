package org.ddocumentor.system.project;

import com.google.gson.Gson;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.project.Project;
import org.ddocumentor.source.ParsedJavaSource;
import org.ddocumentor.source.SysSourceBuilder;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Map;

@Singleton
class MongoDbDocumentRepository implements DocumentRepository {


    @Inject
    private DB db;


    @Override
    public ParsedJavaSource findOneByProjectDocument(DocumentEntry firstDocumentEntry) {
        String id = firstDocumentEntry.getId();
        DBCollection collection = db.getCollection("projects");
        BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));
        DBObject dbObject = collection.findOne(query);

        ParsedJavaSource build = buildParsedJavaSource(dbObject);

        return build;
    }

    @Override
    public ParsedJavaSource save(ParsedJavaSource parsedJavaSource) {
        DBCollection collection = db.getCollection("projects");
        BasicDBObjectBuilder projectBuilder = BasicDBObjectBuilder.start()
                .add("title", parsedJavaSource.getTitle())
                .add("parts", parsedJavaSource.getParts());

        if (parsedJavaSource.getId() != null) {
            projectBuilder.add("_id", new ObjectId(parsedJavaSource.getId()));
        }

        DBObject dbObject = projectBuilder.get();

        if (parsedJavaSource.getId() != null) {
            collection.save(dbObject);
        } else {
            collection.insert(dbObject);
        }

        ParsedJavaSource build = buildParsedJavaSource(dbObject);

        return build;
    }

    class SourceBuilder extends SysSourceBuilder {

    }

    ParsedJavaSource buildParsedJavaSource(DBObject one) {
        Map<String, Object> map = one.toMap();
        String idString = map.get("_id").toString();
        String title = map.get("title").toString();
        List<String> parts = (List<String>) map.get("parts");

        return new SourceBuilder()
                .setTitle(title)
                .setId(idString)
                .setParts(parts)
                .build();
    }
}
