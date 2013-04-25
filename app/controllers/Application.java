package controllers;

import org.ddocumentor.Convert;
import org.ddocumentor.FileJavaSourceAdapter;
import org.ddocumentor.ParsedDocumentation;
import play.*;
import play.mvc.*;

import views.html.*;

import javax.inject.Inject;
import java.io.InputStream;

public class Application extends Controller {


    @Inject
    private Convert convert;

    public Result index() {

        InputStream inputStream = Play.application().resourceAsStream("/public/examples/SourceFile.java");

        FileJavaSourceAdapter javaSource = new FileJavaSourceAdapter(inputStream);
        ParsedDocumentation parsedDocumentation = convert.convert(javaSource);

        return ok(index.render(parsedDocumentation.getMarkup()));

    }
}
