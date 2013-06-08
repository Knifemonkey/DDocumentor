package org.ddocumentor.project;

import com.google.inject.AbstractModule;

public class ProjectModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ProjectFactory.class);
    }
}
