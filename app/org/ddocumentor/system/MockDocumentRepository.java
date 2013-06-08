package org.ddocumentor.system;

import com.google.common.collect.Lists;
import org.ddocumentor.docs.DocumentEntry;
import org.ddocumentor.docs.HtmlParsedDocument;
import org.ddocumentor.docs.Project;
import org.ddocumentor.docs.DocumentRepository;
import org.ddocumentor.source.ParsedJavaSource;

import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MockDocumentRepository implements DocumentRepository {

    @Override
    public List<DocumentEntry> findAllByProject(Project project) {
        List<DocumentEntry> lists = Lists.newArrayList();

        String doc1Part1 = "<b>my markup</b>";
        String doc2Part1 = "<b>my second markup</b>";
        
        List<String> doc1Parts = new ArrayList<>();        
        doc1Parts.add(doc1Part1);
        
        List<String> doc2Parts = new ArrayList<>();
        doc2Parts.add(doc2Part1);
        
        lists.add(new DocumentEntry("doc1"));
        lists.add(new DocumentEntry("doc2"));

        return lists;
    }

    @Override
    public ParsedJavaSource findOneByProjectDocument(DocumentEntry firstDocumentEntry) {
    	
        List<String> doc1Parts = new ArrayList<>();        
        doc1Parts.add("<b>my long markup for project</b>");
        
        return new ParsedJavaSource("parsedByProjectDocument", doc1Parts);
    }

}
