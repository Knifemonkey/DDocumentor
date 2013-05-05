package org.ddocumentor.test;

import org.ddocumentor.docs.Document;
import org.ddocumentor.docs.Project;
import org.junit.Test;

import java.util.SortedSet;

import static org.ddocumentor.test.StubObjects.prepareProject;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ProjectBundlingTest {

    @Test
    public void shouldBeAbleToGetDocumentListFromProject() {
        Project project = prepareProject();

        SortedSet<Document> documentList = project.getAvailableDocuments();

        assertThat(documentList, not(hasSize(0)));
    }


    @Test
    public void shouldBeAbleToGetFirstDocument() {
        Project project = StubObjects.prepareProject();
        Document firstDocument = project.getFirstDocument();

        assertThat(firstDocument.getTitle(), notNullValue());
    }

}
