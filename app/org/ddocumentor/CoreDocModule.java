package org.ddocumentor;

import com.google.inject.AbstractModule;

public class CoreDocModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Convert.class);
    }
}
