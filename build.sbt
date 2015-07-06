name := "rugby"

organization := "com.sciabarra"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.6"

crossPaths := false

resolvers ++= Seq("Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
		, Resolver.sonatypeRepo("public") 
		)

libraryDependencies ++= 
  Seq("org.projectlombok" % "lombok" % "1.16.4"
     , "com.sparkjava" % "spark-core" % "2.2"
     , "com.google.code.gson" % "gson" % "2.3.1"
     , "org.webjars" % "bootstrap" % "3.3.4"
     , "org.webjars" % "angularjs" % "1.4.0"
     , "org.webjars" % "angular-ui-bootstrap" % "0.13.0"
     , "junit" % "junit" % "4.11"
     , "com.novocode" % "junit-interface" % "0.11" % "test"
     , "org.fluentlenium" % "fluentlenium-core" % "0.10.3" % "test"
     , "org.fluentlenium" % "fluentlenium-assertj" % "0.10.3" % "test"
     , "com.codeborne" % "phantomjsdriver" % "1.2.1"
     , "com.jayway.restassured" % "rest-assured" % "2.4.1" % "test"
     , "com.jayway.restassured" % "json-path" % "2.4.1" % "test"
     , "com.jayway.restassured" % "json-schema-validator" % "2.4.1" % "test"
     , "com.h2database" % "h2" % "1.4.187" % "jooq"
     , "com.h2database" % "h2" % "1.4.187"
     , "org.jooq" % "jooq" % "3.6.2"
  )


enablePlugins(SbtWeb)

Revolver.settings

net.virtualvoid.sbt.graph.Plugin.graphSettings

parallelExecution in Test := false

javaOptions in Revolver.reStart += "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8000"

seq(flywaySettings: _*)

seq(jooqSettings:_*)

flywayUrl := s"jdbc:h2:file:${baseDirectory.value}/target/rugby"

flywayUser := "SA"

flywayPassword := ""

jooqOptions := Seq("jdbc.driver" -> "org.h2.Driver",
   "jdbc.url" -> flywayUrl.value,
   "jdbc.user" -> flywayUser.value,
   "jdbc.password" -> flywayPassword.value,
   "generator.database.name" -> "org.jooq.util.h2.H2Database",
   "generator.database.inputSchema" -> "PUBLIC",
   "generator.target.packageName" -> "rugby.jooq")

jooqOutputDirectory := file("src") / "main" / "java"

addCommandAlias("go", "; re-stop ; assets ; flywayMigrate ; jooq:codegen ;re-start")