package org.ddocumentor.project;

public interface ProjectRepository {

    Project findOneById(Long id);

    Project save(Project project);
}
