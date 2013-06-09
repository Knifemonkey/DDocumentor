package org.ddocumentor.project;

public interface ProjectRepository {

    Project findOneById(String id);

    void save(Project project);
}
