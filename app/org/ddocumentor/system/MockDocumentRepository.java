package org.ddocumentor.system;

import com.google.common.collect.Lists;
import org.ddocumentor.project.DocumentEntry;
import org.ddocumentor.project.Project;
import org.ddocumentor.project.DocumentRepository;
import org.ddocumentor.source.ParsedJavaSource;

import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MockDocumentRepository implements DocumentRepository {

    @Override
    public ParsedJavaSource findOneByProjectDocument(DocumentEntry firstDocumentEntry) {
    	
        List<String> doc1Parts = new ArrayList<>();
        doc1Parts.add("<b>Hello Doc Start!</b>");
        doc1Parts.add("<b>Hello Doc Start2!</b>");

        return new ParsedJavaSource("parsedByProjectDocument", doc1Parts);
    }

    @Override
    public ParsedJavaSource save(ParsedJavaSource parsedJavaSource) {
        throw new UnsupportedOperationException();
    }

}
