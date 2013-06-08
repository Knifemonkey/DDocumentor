package org.ddocumentor.testing;

import com.google.common.base.Strings;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;

public class Asserts {


    public static Matcher<List<String>> partsHaveHtml() {
        return new TypeSafeMatcher<List<String>>() {
            @Override
            protected boolean matchesSafely(List<String> strings) {

                for (String string : strings) {
                    if (string.contains("<pre")) {
                        return true;
                    }
                }

                return false;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("List contains html");
            }
        };
    }

    public static Matcher<? super List<String>> partsDoHaveContent() {
        return new TypeSafeMatcher<List<String>>() {
            @Override
            protected boolean matchesSafely(List<String> strings) {
                for (String string : strings) {
                    if (Strings.isNullOrEmpty(string)) {
                        return false;
                    }
                }

                return true;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("All items have content");
            }
        };
    }

}
