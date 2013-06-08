package org.ddocumentor.system;

import com.google.inject.AbstractModule;
import org.ddocumentor.project.DocumentRepository;

/**
 * This module later will be later divided and distributed among other packages to promote encapsulation and cohesion.
 */
public class SystemModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(DocumentRepository.class).to(MockDocumentRepository.class);
    }
}
