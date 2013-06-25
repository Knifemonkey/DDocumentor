import org.ddocumentor.testing.TestMongoDb;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest {
    private static final String OUTPUT_DOCUMENTATION = "my long markup for project";
    private static TestMongoDb testMongoDb = new TestMongoDb();

    /**
     * add your integration test here
     * in this example we just check if the welcome page is being shown
     */
    @Test
    public void testShouldContainDocumentationOutput() {
        running(testServer(3333, fakeApplication(inMemoryDatabase())), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                browser.goTo("http://localhost:3333");
                assertThat(browser.findFirst("#documentation").getText()).contains(OUTPUT_DOCUMENTATION);
                assertThat(browser.findFirst("#sidebar-navigation").getText()).contains("mockName1");
                assertThat(browser.findFirst("#sidebar-navigation").getText()).contains("mockName2");
            }
        });
    }

    @BeforeClass
    public static void beforeAll() throws Exception {
        testMongoDb.start();
    }

    @AfterClass
    public static void afterAll() throws Exception {
        testMongoDb.stop();
    }
}
