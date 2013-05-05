import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonNode;
import org.ddocumentor.docs.Document;
import org.ddocumentor.docs.DocumentRepository;
import org.ddocumentor.docs.ParsedDocument;
import org.ddocumentor.docs.Project;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;

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

        Document firstDocument = project.getFirstDocument();
        ParsedDocument oneByProjectDocument = documentRepository.findOneByProjectDocument(firstDocument);

        Content html = views.html.index.render(project, oneByProjectDocument);
        assertThat(contentType(html)).isEqualTo("text/html");
        assertThat(contentAsString(html)).contains("mockProject");
        assertThat(contentAsString(html)).contains("titleFirst");
        assertThat(contentAsString(html)).contains("titleSecond");
    }


}
