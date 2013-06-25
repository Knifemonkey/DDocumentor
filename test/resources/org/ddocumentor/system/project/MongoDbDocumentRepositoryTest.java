package org.ddocumentor.system.project;

import org.ddocumentor.project.*;
import org.ddocumentor.source.ParsedJavaSource;
import org.ddocumentor.testing.GuiceJUnitRunner;
import org.ddocumentor.testing.TestMongoDb;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({SysProjectModule.class})
public class MongoDbDocumentRepositoryTest {
    @Inject
    private DocumentRepository documentRepository;
    @Inject
    private ProjectRepository projectRepository;
    @Inject
    private ProjectFactory projectFactory;
    private static TestMongoDb testMongoDb = new TestMongoDb();

    @Test
    public void shouldBeAbleToSaveParsedJavaSources() {
        ParsedJavaSource parsedJavaSource = new ParsedJavaSource("some title", asList("code1", "code2"));
        parsedJavaSource = documentRepository.save(parsedJavaSource);

        assertThat(parsedJavaSource.getId(), not(isEmptyOrNullString()));
    }

    @Test
    public void savedDocumentShouldHaveItsPartsPresent() {

        ParsedJavaSource parsedJavaSource = new ParsedJavaSource("some title", asList("code1", "code2"));
        parsedJavaSource = documentRepository.save(parsedJavaSource);

        ParsedJavaSource foundParsedSource = findParsedJavaSourceById(parsedJavaSource.getId());

        assertThat(foundParsedSource.getParts(), hasItem("code1"));
        assertThat(foundParsedSource.getParts(), hasItem("code2"));
    }

    private ParsedJavaSource findParsedJavaSourceById(String id) {
        return documentRepository.findOneByProjectDocument(new DocumentEntry(id, "something"));
    }

    @BeforeClass
    public static  void beforeAll() throws Exception {
        testMongoDb.start();
    }

    @AfterClass
    public static void afterAll() throws Exception {
        testMongoDb.stop();
    }
}
