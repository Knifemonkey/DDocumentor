package org.ddocumentor.system.project;

import org.ddocumentor.project.Project;
import org.ddocumentor.project.ProjectFactory;
import org.ddocumentor.project.ProjectRepository;
import org.ddocumentor.testing.GuiceJUnitRunner;
import org.ddocumentor.testing.TestMongoDb;
import org.junit.*;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({SysProjectModule.class})
public class MongoDbProjectRepositoryTest {
    @Inject
    private ProjectRepository projectRepository;
    @Inject
    private ProjectFactory projectFactory;
    private static TestMongoDb testMongoDb = new TestMongoDb();

    @Test
    public void shouldSaveAndLoadSameEntity() {

        Project project = projectFactory.createNewProject("myproject");
        project = projectRepository.save(project);

        String id = project.getId();
        Project oneById = projectRepository.findOneById(id);

        assertThat(oneById.getName(), is("myproject"));
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
