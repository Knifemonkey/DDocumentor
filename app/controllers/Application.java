package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.inject.Inject;

import org.ddocumentor.Convert;
import org.ddocumentor.FileJavaSourceAdapter;
import org.ddocumentor.docs.*;
import org.ddocumentor.docs.DocumentEntry;
import org.ddocumentor.source.ParsedJavaSource;

import play.Play;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.defaultpages.error;

public class Application extends Controller {

    @Inject
    private Convert convert;
    @Inject
    private ProjectFactory projectFactory;
    @Inject
    private DocumentRepository documentRepository;

    public Result index() {
    	
    	try (
    			InputStream inputStream = 
    				Play.application().resourceAsStream("/public/examples/SourceFile.java");
    	     
    			BufferedReader bufferedReader = 
    	    		 new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));) {
    		
            ParsedJavaSource parsedJavaSource = new FileJavaSourceAdapter();
            HtmlParsedDocument htmlParsedDocument = parsedJavaSource.parseJavaSource(bufferedReader);

            Project project = prepareProject();
            
            //TODO Pick documents from project
            //ParsedDocument oneByProjectDocument = documentRepository.findOneByProjectDocument(project.getFirstDocument());


            return ok(index.render(project, htmlParsedDocument));
    		
    	} catch (IOException ioe) {
    		
    		return ok(error.render(null));   
    	}


    }

    private Project prepareProject() {
        SortedSet<DocumentEntry> documentEntries = new TreeSet<>();

        documentEntries.add(new DocumentEntry("mockName1"));
        documentEntries.add(new DocumentEntry("mockName2"));

        return projectFactory.createNewProject("MyMockProject", documentEntries);
    }


}
