package org.ddocumentor.test;

import org.ddocumentor.docs.Document;
import org.ddocumentor.docs.Project;
import org.ddocumentor.docs.DocumentRepository;
import org.ddocumentor.docs.ParsedDocument;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ParsedDocumentReadingTest {
    @Test
    public void shouldBeAbleToGetDocs() {
        Project project = StubObjects.prepareProject();
        DocumentRepository documentRepository = StubObjects.prepareDocumentRepository();

        List<ParsedDocument> parsedDocuments = documentRepository.findAllByProject(project);

        assertThat(parsedDocuments, not(hasSize(0)));
    }


    @Test
    public void shouldBeAbleToGetSingleDocByProjectsDocument() {
        Project project = StubObjects.prepareProject();
        Document firstDocument = project.getFirstDocument();
        DocumentRepository documentRepository = StubObjects.prepareDocumentRepository();

        ParsedDocument parsedDocument = documentRepository.findOneByProjectDocument(firstDocument);

        assertThat(parsedDocument.getTitle(), not(isEmptyOrNullString()));
        assertThat(parsedDocument.getMarkup(), not(isEmptyOrNullString()));
    }


}
