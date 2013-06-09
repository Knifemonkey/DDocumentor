package org.ddocumentor.system.project;

import org.ddocumentor.project.ProjectRepository;
import org.ddocumentor.testing.GuiceJUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules({SysProjectModule.class})
public class MongoDbProjectRepositoryTest {
    @Inject
    private ProjectRepository projectRepository;

    @Test
    public void shouldSaveAndLoadSameEntity() {

    }
}
