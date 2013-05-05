package org.ddocumentor.system;

import com.google.common.collect.Lists;
import org.ddocumentor.docs.Document;
import org.ddocumentor.docs.Project;
import org.ddocumentor.docs.DocumentRepository;
import org.ddocumentor.docs.ParsedDocument;

import javax.inject.Singleton;
import java.util.List;

@Singleton
public class MockDocumentRepository implements DocumentRepository {

    @Override
    public List<ParsedDocument> findAllByProject(Project project) {
        List<ParsedDocument> lists = Lists.newArrayList();

        lists.add(new ParsedDocument("doc1", "<b>my markup</b>"));
        lists.add(new ParsedDocument("doc2", "<b>my second markup</b>"));

        return lists;
    }

    @Override
    public ParsedDocument findOneByProjectDocument(Document firstDocument) {
        return new ParsedDocument("parsedByProjectDocument", "<b>my long markup for project</b>");
    }

}
