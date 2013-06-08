import org.ddocumentor.html.HtmlParsingModule;
import org.ddocumentor.project.ProjectModule;
import org.ddocumentor.system.SystemModule;
import play.GlobalSettings;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Global extends GlobalSettings {

    private static final Injector INJECTOR = createInjector();

    @Override
    public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
        return INJECTOR.getInstance(controllerClass);
    }

    private static Injector createInjector() {
        return Guice.createInjector(new HtmlParsingModule(), new SystemModule(), new ProjectModule());
    }

}