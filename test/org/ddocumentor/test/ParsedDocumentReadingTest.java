package org.ddocumentor.test;

import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.source.ParsedJavaSource;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ParsedDocumentReadingTest {
    @Test
    public void shouldBeAbleToGetDocs() {
        Project project = StubObjects.prepareProject();
        DocumentRepository documentRepository = StubObjects.prepareDocumentRepository();

        List<DocumentEntry> htmlParsedDocuments = documentRepository.findAllByProject(project);

        assertThat(htmlParsedDocuments, not(hasSize(0)));
    }


    @Test
    public void shouldBeAbleToGetSingleDocByProjectsDocument() {
        Project project = StubObjects.prepareProject();
        DocumentEntry firstDocumentEntry = project.getFirstDocument();
        DocumentRepository documentRepository = StubObjects.prepareDocumentRepository();

        ParsedJavaSource parsedJavaSource = documentRepository.findOneByProjectDocument(firstDocumentEntry);

        assertThat(parsedJavaSource.getTitle(), not(isEmptyOrNullString()));
        assertThat(parsedJavaSource.getDocumentParts().get(0), not(isEmptyOrNullString()));
    }


}
