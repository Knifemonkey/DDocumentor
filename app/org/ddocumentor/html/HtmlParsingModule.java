package org.ddocumentor.html;

import com.google.inject.AbstractModule;
import org.ddocumentor.html.Convert;

public class HtmlParsingModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Convert.class);
    }
}
