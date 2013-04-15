package org.ddocumentor.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.ddocumentor.Convert;
import org.junit.Test;

public class GeneralAceptenceTest {
	
	@Test
	public void convertSourceCodeToHTML() throws IOException{
		String sourceFile = getSourceFileContents();
		String resultFile = getResultFile();
		
		String[] javaSources = new String[] {"../\\DDocumentor\\src\\test\\resources\\targetFiles"};
		String convertedSourceFile = new Convert().convert(sourceFile );
		System.out.println(convertedSourceFile);
		
		assertThat(convertedSourceFile, is(resultFile));
		
		
	}

	private String getResultFile() throws IOException {
		String fileName = "/outputHTML.html";
		return readFile(fileName);
		
	}

	private String getSourceFileContents() throws IOException {
		String fileName = "/SourceFile.java";
		return readFile(fileName);
		
	}

	private String readFile(String fileName) throws IOException {
		InputStream resourceAsStream = GeneralAceptenceTest.class.getResourceAsStream(fileName);
		StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
	}
	
	private List<File> getFileListFromDirectory(String paramString,
			List<File> paramVector) {
		File localFile = new File(paramString);
		String[] arrayOfString = localFile.list();
		if (arrayOfString == null)
			return paramVector;
		int i = 0;
		while (i < arrayOfString.length) {
			String str = paramString + File.separatorChar + arrayOfString[i];
			File file = new File(str);
			if (file.isFile())
				if (str.endsWith(".java"))
					paramVector.add(file);
				else
					paramVector = getFileListFromDirectory(str, paramVector);
			++i;
		}
		return paramVector;
	}

}
