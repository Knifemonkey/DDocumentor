import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName = "ddocumentor"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    javaCore,
    javaJdbc,
    javaEbean,
    "info.bliki.wiki" % "bliki-core" % "3.0.19",
    "com.google.code.morphia" % "morphia" % "0.99",
    "com.google.inject" % "guice" % "3.0",
    "javax.inject" % "javax.inject" % "1",
    "org.hamcrest" % "hamcrest-library" % "1.3" % "test",
    "jdepend" % "jdepend" % "2.9.1" % "test",
    "org.mockito" % "mockito-core" % "1.9.5" % "test",
    // These deps below are needed to make tests work without ClassDefNotFound exceptions, they are not actually needed in the code
    "org.apache.httpcomponents" % "httpclient" % "4.2.3",
    "org.apache.httpcomponents" % "httpcore" % "4.2.3",
    "org.seleniumhq.selenium" % "selenium-firefox-driver" % "2.32.0" % "test",
    "org.seleniumhq.selenium" % "selenium-android-driver" % "2.32.0" % "test",
    "org.seleniumhq.selenium" % "selenium-chrome-driver" % "2.32.0" % "test",
    "org.seleniumhq.selenium" % "selenium-ie-driver" % "2.32.0" % "test",
    "org.seleniumhq.selenium" % "selenium-iphone-driver" % "2.32.0" % "test",
    "org.seleniumhq.selenium" % "selenium-java" % "2.32.0" % "test",
    "org.seleniumhq.selenium" % "selenium-support" % "2.32.0" % "test",
    "org.seleniumhq.selenium" % "selenium-safari-driver" % "2.32.0" % "test",
    "org.seleniumhq.selenium" % "selenium-htmlunit-driver" % "2.32.0" % "test"

  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    resolvers += "info-bliki-repository" at "http://gwtwiki.googlecode.com/svn/maven-repository/",
    resolvers += "Morphia repository" at "http://morphia.googlecode.com/svn/mavenrepo/"
  )

}
