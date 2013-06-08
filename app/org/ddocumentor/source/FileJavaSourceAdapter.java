package org.ddocumentor.source;

import java.io.Reader;

import org.ddocumentor.source.JavaSource;

public class FileJavaSourceAdapter implements JavaSource {


    @Override
    public Reader getContent() {
        throw new UnsupportedOperationException();
    }
}
