package org.ddocumentor.project;

public interface ProjectRepository {

    Project findOneById(String id);

    Project save(Project project);
}
