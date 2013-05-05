package org.ddocumentor.docs;

import com.google.inject.AbstractModule;

public class DocModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ProjectFactory.class);
    }
}
