import org.junit.Test;

import jdepend.framework.JDepend;
import jdepend.framework.JavaClass;
import jdepend.framework.JavaPackage;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.logging.Logger;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Checks wether our projects has cycles in our packages - it shouldn't be so! So take care.
 */
public class CyclicDependenciesTest {

    private static final Logger LOGGER = Logger.getLogger(CyclicDependenciesTest.class.getName());

    @Test
    public void thereShouldBeNoCyclesBetweenPackagesInProject() throws IOException {
        JDepend jdepend = new JDepend();
        String directory = "./target/scala-2.10/classes/org/";
        File dir = new File(directory);
        System.out.println("" + dir.getAbsolutePath());
        jdepend.addDirectory(directory);

        Collection<JavaPackage> packages = jdepend.analyze();

        assertThat(packages, hasSize(greaterThan(0)));
        for (JavaPackage javaPackage : packages) {
            if (javaPackage.containsCycle()) {
                String classesString = "";
                Collection<JavaClass> classes = javaPackage.getClasses();

                for (JavaClass javaClass : classes) {
                    classesString += javaClass.getName() + ", ";
                }

                LOGGER.info("Package has cycle: " + javaPackage.getName() + ", with classes: " + classesString);
            }
        }
        assertThat("Cycles exist",
                jdepend.containsCycles(), is(false));
    }
}
