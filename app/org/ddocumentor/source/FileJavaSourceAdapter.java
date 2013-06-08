package org.ddocumentor.source;

import java.io.*;

public class FileJavaSourceAdapter implements JavaSource {

    private final BufferedReader content;

    public FileJavaSourceAdapter(InputStream inputStream) {


        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            this.content = bufferedReader;
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Reader getContent() {
        return content;
    }
}
