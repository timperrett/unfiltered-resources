
name := "unfiltered-resources"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "net.databinder"       %% "unfiltered-filter"       % "0.8.3",
  "net.databinder"       %% "unfiltered-netty-server" % "0.8.3"
)

assemblyJarName in assembly := "example.jar"

mainClass in assembly := Some("example.Main")
