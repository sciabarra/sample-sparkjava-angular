name := "rugby"

organization := "com.sciabarra"

version := "0.1-SNAPSHOT"

//jetty()

libraryDependencies ++= 
  Seq("org.projectlombok" % "lombok" % "1.16.4"
     , "com.sparkjava" % "spark-core" % "2.2"
     , "org.webjars" % "bootstrap" % "3.3.4"
     , "org.webjars" % "angularjs" % "1.4.0"
     , "com.google.code.gson" % "gson" % "2.3.1"
     , "org.webjars" % "angular-ui-bootstrap" % "0.13.0"
     )

enablePlugins(SbtWeb)

Revolver.settings
