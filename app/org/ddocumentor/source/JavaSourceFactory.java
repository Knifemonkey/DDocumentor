package org.ddocumentor.source;

import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;

import java.io.*;

public class JavaSourceFactory {


    public static JavaSource createJavaSource(InputStream inputStream) {


        try {
            BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            Reader content = bufferedReader;

            String text = "";
            try {
                text = CharStreams.toString(content);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                Closeables.closeQuietly(content);
            }


            return new JavaSource(text);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
