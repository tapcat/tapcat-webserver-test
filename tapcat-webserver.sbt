name := "tapcat-webserver-test"

version := "1.0"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.10" % "2.0.RC2" % "test",
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"
)