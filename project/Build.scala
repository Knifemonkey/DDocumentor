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
    "net.sourceforge.jwebunit" % "jwebunit-htmlunit-plugin" % "3.1" % "test",
    "com.google.inject" % "guice" % "3.0",
    "javax.inject" % "javax.inject" % "1"
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    resolvers += "info-bliki-repository" at "http://gwtwiki.googlecode.com/svn/maven-repository/"
  )

}
