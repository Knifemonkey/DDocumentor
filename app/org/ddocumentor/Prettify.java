package org.ddocumentor;

import info.bliki.wiki.tags.code.JavaCodeFilter;
import info.bliki.wiki.tags.code.SourceCodeFormatter;

public class Prettify {

	public String prettify(String javaCode) {
		SourceCodeFormatter f = new JavaCodeFilter();
        String result;
        String coding1 = "<pre class=\"java\" style=\"border: 1px solid #b4d0dc; background-color: #ecf8ff;\">";
        String coding3 = "</pre>";
        result = f.filter(javaCode);
        result = coding1 + result + coding3;
        return result;
	}
}
