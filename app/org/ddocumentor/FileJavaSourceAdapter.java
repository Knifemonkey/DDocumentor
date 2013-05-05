package org.ddocumentor;

import org.ddocumentor.source.JavaSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileJavaSourceAdapter implements JavaSource {

    private final String content;

    public FileJavaSourceAdapter(InputStream inputStream) {
        try {
            this.content = readFile(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getContent() {
        return content;
    }


    private String readFile(InputStream resourceAsStream) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        char[] buf = new char[1024];
        int numRead = 0;
        while ((numRead = reader.read(buf)) != -1) {
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}
