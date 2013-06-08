package org.ddocumentor.html;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HtmlParsedDocument {

    private String title;
    private List<String> documentParts = new ArrayList<>();


    public HtmlParsedDocument(String title, List<String> documentParts) {
        this.title = title;
        this.documentParts = Lists.newArrayList(documentParts);
    }

    public String getTitle() {
        return title;
    }

    public List<String> getDocumentParts() {
        return Collections.unmodifiableList(documentParts);
    }

}
