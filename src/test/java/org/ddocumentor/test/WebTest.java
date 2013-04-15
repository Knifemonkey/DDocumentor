package org.ddocumentor.test;

import org.junit.Before;
import org.junit.Test;
import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class WebTest {
	private static final String OUTPUT_DOCUMENTATION = "System.out.println(\"Hello Doc Start!\");";
	private static final String elementID = "documentation";

	@Before
	public void prepare() {
		setBaseUrl("http://localhost:8080/ddocumentor");
	}

	@Test
	public void test1() {
		beginAt("HelloWorld.jsp"); // Open the browser on
								// http://localhost:8080/test/home.xhtml
		assertTextInElement(elementID, OUTPUT_DOCUMENTATION);

	}

}
