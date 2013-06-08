package org.ddocumentor.system;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.google.common.io.Closeables;
import org.ddocumentor.source.JavaSource;
import org.ddocumentor.source.JavaSourceRepository;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FileJavaSourceRepositoryTest {

    private static final String MAGICAL_TEST_CONST
            = "My magical testing constanct that I use to check if this file was parsed";

    @Test
    public void shouldReadProjectDirectory() {
        JavaSourceRepository sourceRepository = prepareJavaSourceRepository();

        List<JavaSource> javaSources = sourceRepository.getJavaSources();

        assertThat(javaSources, hasSize(greaterThan(0)));
        assertThat(javaSources, hasItemWithText("MAGICAL_TEST_CONST"));
    }

    private Matcher<? super List<JavaSource>> hasItemWithText(final String magicalTestConst) {
        return new TypeSafeMatcher<List<JavaSource>>() {
            @Override
            protected boolean matchesSafely(List<JavaSource> javaSources) {

                for (JavaSource javaSource : javaSources) {
                    Reader content = javaSource.getContent();
                    String text = "";
                    try {
                        text = CharStreams.toString(content);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } finally {
                        Closeables.closeQuietly(content);
                    }

                    if (text.contains(magicalTestConst)) {
                        return true;
                    }

                }

                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Sources have expected magical constant token");
            }
        };
    }

    private JavaSourceRepository prepareJavaSourceRepository() {


        FileJavaSourceRepository javaSourceRepository
                = new FileJavaSourceRepository(FileSystems.getDefault().getPath(".", "tests"));

        return javaSourceRepository;
    }
}

