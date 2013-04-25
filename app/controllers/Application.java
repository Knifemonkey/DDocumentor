package controllers;

import org.ddocumentor.Convert;
import org.ddocumentor.FileJavaSourceAdapter;
import org.ddocumentor.ParsedDocumentation;
import play.*;
import play.mvc.*;

import views.html.*;

import java.io.InputStream;

public class Application extends Controller {


    public static Result index() {

        InputStream inputStream = Play.application().resourceAsStream("/public/examples/SourceFile.java");

        FileJavaSourceAdapter javaSource = new FileJavaSourceAdapter(inputStream);
        ParsedDocumentation convert = new Convert().convert(javaSource);

        return ok(index.render(convert.getMarkup()));

    }
}
