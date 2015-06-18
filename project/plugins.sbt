resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.0"

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.2.0")

// addSbtPlugin("com.earldouglas" % "xsbt-web-plugin" % "1.1.0")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

