resolvers += Resolver.sonatypeRepo("releases")

libraryDependencies += "org.slf4j" % "slf4j-nop" % "1.7.0"

addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.2.0")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.7.2")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.7.5")
