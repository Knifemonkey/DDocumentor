package org.ddocumentor.test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.ddocumentor.source.*;
import org.ddocumentor.testing.StubObjects;
import org.junit.Test;
import org.junit.Before;

import static org.ddocumentor.testing.StubObjects.asList;
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
        javaSources.add(StubObjects.createHelloDocStartJavaSource());
        javaSources.add(StubObjects.createHelloDocStartJavaSource());
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

    @Test
    public void javaSourceReaderShouldReturnDocumentInDifferentParts()
            throws IOException {

        InputStream sourceInputStream = prepareTestingFile();

        JavaSource javaSource = JavaSourceFactory.createJavaSource(sourceInputStream);

        List<ParsedJavaSource> parsedJavaSources =
                new JavaSourceParserImpl().parse(asList(javaSource));


        ParsedJavaSource parsedJavaSource = parsedJavaSources.get(0);
        assertThat(parsedJavaSource.getParts(), hasSize(3));
        assertThat(parsedJavaSource.getParts().get(2), is("Hello Doc Start3!"));
        assertThat(parsedJavaSource.getTitle(), is(" This is document"));
    }

    private InputStream prepareTestingFile() throws IOException {
        //\DDocumentor\test\resources\SourceFile.java
        Path sourceFilePath = FileSystems.getDefault()
                .getPath("test", "resources", "SourceFile.java");
        InputStream inputStream = Files.newInputStream(sourceFilePath.toAbsolutePath());
        return inputStream;
    }
}
