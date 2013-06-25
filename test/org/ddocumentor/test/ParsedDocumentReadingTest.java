package org.ddocumentor.test;

import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.source.ParsedJavaSource;
import org.ddocumentor.testing.StubObjects;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ParsedDocumentReadingTest {

    @Test
    public void shouldBeAbleToGetSingleDocByProjectsDocument() {
        Project project = StubObjects.prepareProject();
        DocumentEntry firstDocumentEntry = project.getFirstDocument();
        DocumentRepository documentRepository = StubObjects.prepareDocumentRepository();

        ParsedJavaSource parsedJavaSource = documentRepository.findOneByProjectDocument(firstDocumentEntry);

        assertThat(parsedJavaSource.getTitle(), not(isEmptyOrNullString()));
        assertThat(parsedJavaSource.getParts().get(0), not(isEmptyOrNullString()));
    }


}
