DDocumentor
===========

Application that will help to generate documentation automatically from the sources. Main goal/benefit would be to have live, up-to-date documentation that is edited by modifying your source code example file.

License:
This software is distributed according to the MIT license. Read more about it here: http://opensource.org/licenses/MIT


To start the app, use the [App Engine Maven Plugin](http://code.google.com/p/appengine-maven-plugin/) that is already included in this demo.
Just run the command.

    mvn appengine:devserver

For further information, consult the [Java App Engine](https://developers.google.com/appengine/docs/java/overview) documentation.

To see all the available goals for the App Engine plugin, run

    mvn help:describe -Dplugin=appengine