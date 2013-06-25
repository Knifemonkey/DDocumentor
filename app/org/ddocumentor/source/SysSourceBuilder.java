package org.ddocumentor.source;

import java.util.List;

public class SysSourceBuilder {
    String id;
    String title;
    List<String> parts;

    protected SysSourceBuilder() {
    }

    public SysSourceBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public SysSourceBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public SysSourceBuilder setParts(List<String> parts) {
        this.parts = parts;
        return this;
    }

    public ParsedJavaSource build() {
        return new ParsedJavaSource(this);
    }
}
