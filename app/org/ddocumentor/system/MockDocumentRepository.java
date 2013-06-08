package org.ddocumentor.system;

import com.google.common.collect.Lists;
import org.ddocumentor.docs.DocumentEntry;
import org.ddocumentor.docs.HtmlParsedDocument;
import org.ddocumentor.docs.Project;
import org.ddocumentor.docs.DocumentRepository;

import javax.inject.Singleton;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class MockDocumentRepository implements DocumentRepository {

    @Override
    public List<HtmlParsedDocument> findAllByProject(Project project) {
        List<HtmlParsedDocument> lists = Lists.newArrayList();

        String doc1Part1 = "<b>my markup</b>";
        String doc2Part1 = "<b>my second markup</b>";
        
        List<String> doc1Parts = new ArrayList<>();        
        doc1Parts.add(doc1Part1);
        
        List<String> doc2Parts = new ArrayList<>();
        doc2Parts.add(doc2Part1);
        
        lists.add(new HtmlParsedDocument("doc1", doc1Parts));
        lists.add(new HtmlParsedDocument("doc2", doc2Parts));

        return lists;
    }

    @Override
    public HtmlParsedDocument findOneByProjectDocument(DocumentEntry firstDocumentEntry) {
    	
        List<String> doc1Parts = new ArrayList<>();        
        doc1Parts.add("<b>my long markup for project</b>");
        
        return new HtmlParsedDocument("parsedByProjectDocument", doc1Parts);
    }

}
