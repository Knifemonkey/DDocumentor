package org.ddocumentor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.ddocumentor.docs.HtmlParsedDocument;
import org.ddocumentor.docs.JavaSource;
import org.ddocumentor.source.ParsedJavaSource;

public class FileJavaSourceAdapter implements JavaSource {


    @Override
    public Reader getContent() {
        throw new UnsupportedOperationException();
    }
}
