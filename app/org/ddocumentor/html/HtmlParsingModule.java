package org.ddocumentor.html;

import com.google.inject.AbstractModule;

public class HtmlParsingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(HtmlConverter.class);
    }
}
