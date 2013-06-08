package org.ddocumentor.source;

import java.util.List;

public interface JavaSourceParser {
	
    public List<ParsedJavaSource> parse(List<JavaSource> javaSources);	

}
