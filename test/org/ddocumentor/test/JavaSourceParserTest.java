package org.ddocumentor.test;

import java.util.ArrayList;
import java.util.List;

import org.ddocumentor.source.JavaSource;
import org.ddocumentor.source.JavaSourceParser;
import org.ddocumentor.source.JavaSourceParserImpl;
import org.ddocumentor.source.ParsedJavaSource;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

// GitRepository -> List<JavaSource> -> [SomeParser] -> ParsedJavaSources
// -> Converter (Applies HTML) -> ParsedDocument -> Controller and View -> User


// GitRepository -> [JavaSourceRepository] -> List<JavaSource> -> [JavaSourceParser] 
// -> List<ParsedJavaSources> -> [HtmlConverter] -> HtmlParsedDocument 

/* JavaSourceRepositoryTest.java:
 * - filesCanBeReadFromRepository 
 * 
 * JavaSourceParserTest.java:
 * - 
 * 
 * HtmlConverterTest.java:
 * - xdgffsdf
 * 
 */
/*
class JavaSource {
	Reader getContent();
}


class ParsedJavaSource { //ParsedDocument
	title
	parts
}

class HtmlParsedDocument {
	title // with html
	parts // with html 
}
*/





public class JavaSourceParserTest {
	
	List<JavaSource> javaSources;
	
	@Before
	public void prepare() {
		javaSources = new ArrayList<>();
		javaSources.add(new HelloDocStartJavaSource());
		javaSources.add(new HelloDocStartJavaSource());
	}
	
	@Test
	public void shouldConvertJavaSourceIntoParsedJavaSource() {
			
		JavaSourceParser javaSourceParser = new JavaSourceParserImpl();
					
		List<ParsedJavaSource> parsedJavaSources = 
				javaSourceParser.parse(javaSources);
		
		assertThat(parsedJavaSources, hasSize(equalTo(2)));
		
	}
	
	@Test 
	public void shouldParseIntoProperStructure() {
		
		ParsedJavaSource parsedSource = null;
		
		assertThat(parsedSource.getTitle(), is("This is document"));
		assertThat(parsedSource.getParts(), hasItem(containsString("Hello Doc Start2!")));
		assertThat(parsedSource.getParts(), hasSize(3));
	}
}
