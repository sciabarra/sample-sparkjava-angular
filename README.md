# Starting

- download and install Java 8 (7 or earlier is not good enough)

- download and install SBT (http://www.scala-sbt.org)

No worries, no scala used here (only Java/Javascript) but we use the sbt tool.

- open the command prompt and type sbt (assuming you have installed sbt and put it in the path)

At the ">" prompt type: 

> assets

This will download the requirements

Now type

> run

It will start an embedded server.

You can start playing with http://localhost:4567/ 

Note it will redirect to a /page/index.html. Read below

# Layout

## Resources
Application code for the client should reside in src/app. 

Most notably, html in app/html, css in app/css, images in img/js

## Javascript

Javascript is a bit special since it run an automated concatenation.

You invoke /app/js. It will read the /app/js/index.txt where there is a list of all the javascript component 
and it will concatenate them in a single output.

So when you add a new file, add it also in the index.txt and you can immedately use it.

Note how the application is split. There is a top level module ("module.js") that is basically invoking all the submodules.

For each function there is a module folder with a module.js invoking the other modules.

The main module is called 'Module', each submodule is called 'Module.something'.


## Java

Java code for the server part should reside in src/java.

Check the example in src/java/rugby/todo for a sample of the backend code

