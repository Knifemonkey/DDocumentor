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

import static java.util.Arrays.asList;

public class Application extends Controller {

    @Inject
    private HtmlConverter htmlConverter;
    @Inject
    private ProjectFactory projectFactory;
    @Inject
    private ProjectRepository projectRepository;
    @Inject
    private DocumentRepository documentRepository;

    public Result index() {

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

        Project myMockProject = projectFactory.createNewProject("MyMockProject");
        ParsedJavaSource source;

        source = new ParsedJavaSource("mockName1", asList("my long markup for project", "part2"));
        source = documentRepository.save(source);
        myMockProject.addParsedJavaSource(source);

        source = new ParsedJavaSource("mockName2", asList("part3", "java code"));
        source = documentRepository.save(source);
        myMockProject.addParsedJavaSource(source);

        myMockProject = projectRepository.save(myMockProject);

        return myMockProject;
    }


}
