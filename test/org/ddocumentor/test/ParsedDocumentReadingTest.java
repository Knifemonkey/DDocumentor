package org.ddocumentor.test;

import org.ddocumentor.docs.DocumentEntry;
import org.ddocumentor.docs.HtmlParsedDocument;
import org.ddocumentor.docs.Project;
import org.ddocumentor.docs.DocumentRepository;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ParsedDocumentReadingTest {
    @Test
    public void shouldBeAbleToGetDocs() {
        Project project = StubObjects.prepareProject();
        DocumentRepository documentRepository = StubObjects.prepareDocumentRepository();

        List<HtmlParsedDocument> htmlParsedDocuments = documentRepository.findAllByProject(project);

        assertThat(htmlParsedDocuments, not(hasSize(0)));
    }


    @Test
    public void shouldBeAbleToGetSingleDocByProjectsDocument() {
        Project project = StubObjects.prepareProject();
        DocumentEntry firstDocumentEntry = project.getFirstDocument();
        DocumentRepository documentRepository = StubObjects.prepareDocumentRepository();

        HtmlParsedDocument htmlParsedDocument = documentRepository.findOneByProjectDocument(firstDocumentEntry);

        assertThat(htmlParsedDocument.getTitle(), not(isEmptyOrNullString()));
        assertThat(htmlParsedDocument.getDocumentParts().get(0), not(isEmptyOrNullString()));
    }


}
