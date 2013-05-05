package controllers;

import org.ddocumentor.Convert;
import org.ddocumentor.FileJavaSourceAdapter;
import org.ddocumentor.docs.*;
import play.*;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;
import java.io.InputStream;
import java.util.SortedSet;
import java.util.TreeSet;

public class Application extends Controller {

    @Inject
    private Convert convert;
    @Inject
    private ProjectFactory projectFactory;
    @Inject
    private DocumentRepository documentRepository;

    public Result index() {

        InputStream inputStream = Play.application().resourceAsStream("/public/examples/SourceFile.java");

        FileJavaSourceAdapter javaSource = new FileJavaSourceAdapter(inputStream);
        ParsedDocument parsedDocument = convert.convert(javaSource);

        Project project = prepareProject();
        ParsedDocument oneByProjectDocument = documentRepository.findOneByProjectDocument(project.getFirstDocument());


        return ok(index.render(project, oneByProjectDocument));

    }

    private Project prepareProject() {
        SortedSet<Document> documents = new TreeSet<>();

        documents.add(new Document("mockName1"));
        documents.add(new Document("mockName2"));

        return projectFactory.createNewProject("MyMockProject", documents);
    }


}
