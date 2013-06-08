package org.ddocumentor.source.custom;

import org.ddocumentor.source.JavaSource;

public class HelloDocStartJavaSource extends JavaSource {

	
	public HelloDocStartJavaSource() {
		super();
		
		StringBuilder contentBuilder = new StringBuilder();
		
		contentBuilder.append("package resources;\n\n")
				.append("public class SourceFile{\n")
				.append("/*\n* #DocTitle This is document\n*/\n")
				.append("public void commentedMethod(){\n")
				.append("//#DocStart\n")
				.append("System.out.println(\"Hello Doc Start!\");\n")
				.append("//#DocEnd\n")
				.append("//#DocStart\n")
				.append("System.out.println(\"Hello Doc Start2!\");\n")
				.append("//#DocEnd\n")
				.append("//#DocStart\n")
				.append("System.out.println(\"Hello Doc Start3!\");\n")
				.append("//#DocEnd\n")
				.append("}\n}\n");				
		
		super.setContent(contentBuilder.toString());
	}
}
