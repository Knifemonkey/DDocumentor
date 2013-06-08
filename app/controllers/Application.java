package controllers;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.inject.Inject;

import org.ddocumentor.html.HtmlConverter;
import org.ddocumentor.html.HtmlParsedDocument;
import org.ddocumentor.project.*;
import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.source.ParsedJavaSource;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    @Inject
    private HtmlConverter htmlConverter;
    @Inject
    private ProjectFactory projectFactory;
    @Inject
    private DocumentRepository documentRepository;

    public Result index() {

//        InputStream inputStream =
//                Play.application().resourceAsStream("/public/examples/SourceFile.java");
//
//        JavaSource javaSource = new FileJavaSourceAdapter(inputStream);
//        ParsedJavaSource parsedJavaSource = new JavaSourceParser().parseJavaSource(javaSource);

        Project project = prepareProject();

        //TODO Pick documents from project
        ParsedJavaSource parsedJavaSource = documentRepository.findOneByProjectDocument(project.getFirstDocument());
        HtmlParsedDocument htmlParsedDocument = new HtmlConverter().convert(parsedJavaSource);
        return ok(index.render(project, htmlParsedDocument));
    }

    private Project prepareProject() {
        SortedSet<DocumentEntry> documentEntries = new TreeSet<>();

        documentEntries.add(new DocumentEntry("mockName1"));
        documentEntries.add(new DocumentEntry("mockName2"));

        return projectFactory.createNewProject("MyMockProject", documentEntries);
    }


}
