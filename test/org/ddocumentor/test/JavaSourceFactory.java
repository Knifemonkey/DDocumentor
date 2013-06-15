package org.ddocumentor.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import org.apache.commons.io.IOUtils;
import org.ddocumentor.source.JavaSource;

// JavaSource javaSource = JavaSourceFactory.createJavaSource(sourceInputStream);
public class JavaSourceFactory {
	
	public static JavaSource createJavaSource(InputStream sourceInputStream) 
			throws IOException {
		
		StringWriter writer = new StringWriter();
		IOUtils.copy(sourceInputStream, writer);
		return new JavaSource(writer.toString());
	}

}
