resolvers ++= Seq(Resolver.sonatypeRepo("releases")
                 , "Flyway" at "http://flywaydb.org/repo"
                 // , "sean8223 Releases" at "https://github.com/sean8223/repository/raw/master/releases"
                 )

libraryDependencies ++= Seq("ch.qos.logback" % "logback-classic" % "1.1.3")

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.2.0")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.5")

addSbtPlugin("org.flywaydb" % "flyway-sbt" % "3.2.1")

// addSbtPlugin("sean8223" %% "jooq-sbt-plugin" % "1.5")

val plugin = project.in(file(".")).dependsOn(file("plugin").toURI)
