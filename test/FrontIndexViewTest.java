import org.ddocumentor.html.HtmlConverter;
import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.html.HtmlParsedDocument;
import org.ddocumentor.project.Project;
import org.ddocumentor.source.ParsedJavaSource;
import org.junit.*;

import play.mvc.*;

import static org.ddocumentor.test.StubObjects.*;
import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;


/**
 * Simple (JUnit) tests that can call all parts of a play app.
 * If you are interested in mocking a whole application, see the wiki for more details.
 */
public class FrontIndexViewTest {

    @Test
    public void shouldDisplayBasicInformation() {
        Project project = prepareProject();
        DocumentRepository documentRepository = prepareDocumentRepository();

        DocumentEntry firstDocumentEntry = project.getFirstDocument();
        ParsedJavaSource parsedJavaSource = documentRepository.findOneByProjectDocument(firstDocumentEntry);
        HtmlParsedDocument htmlParsedDocument = new HtmlConverter().convert(parsedJavaSource);

        Content html = views.html.index.render(project, htmlParsedDocument);
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("mockProject");
        assertThat(contentAsString(html)).contains("titleFirst");
        assertThat(contentAsString(html)).contains("titleSecond");
        

        assertThat(contentAsString(html)).contains("Hello Doc Start!");
        assertThat(contentAsString(html)).contains("Hello Doc Start2!");
        assertThat(contentAsString(html)).contains("Hello Doc Start3!");
    }


}
