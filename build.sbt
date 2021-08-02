name := "sbt-demo"

version := "0.1"

scalaVersion := "2.12.12"

//idePackagePrefix := Some("com.demo")

val com = (project in file("Common"))
  .settings(
    name := "Common-sbt",
    // https://mvnrepository.com/artifact/io.github.embeddedkafka/embedded-kafka
    libraryDependencies ++= Seq("io.github.embeddedkafka" %% "embedded-kafka" % "2.8.0" % Test,
      "org.json4s" %% "json4s-native" % "4.0.3",
      "org.json4s" %% "json4s-ext" % "4.0.3")


)

val act =(project in file("Actor"))
  .settings(
    name := "Acotr-jar"
  )
  .dependsOn(com)

val rootmod = (project in file(".")).aggregate(com,act)

