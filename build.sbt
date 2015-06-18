name := "rugby"

organization := "com.sciabarra"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

libraryDependencies ++= 
  Seq("org.projectlombok" % "lombok" % "1.16.4"
     , "com.sparkjava" % "spark-core" % "2.2"
     , "com.google.code.gson" % "gson" % "2.3.1"
     , "org.webjars" % "bootstrap" % "3.3.4"
     , "org.webjars" % "angularjs" % "1.4.0"
     , "org.webjars" % "angular-ui-bootstrap" % "0.13.0"
     , "junit" % "junit" % "4.11"
     , "org.specs2" %% "specs2-core" % "3.6.1" % "test"
     , "com.novocode" % "junit-interface" % "0.11" % "test"
     , "com.github.detro" % "phantomjsdriver" % "1.2.0" % "test"
     , "org.fluentlenium" % "fluentlenium-core" % "0.10.4-SNAPSHOT" % "test"
     , "org.fluentlenium" % "fluentlenium-assertj" % "0.10.4-SNAPSHOT" % "test"
     )

enablePlugins(SbtWeb)

Revolver.settings
