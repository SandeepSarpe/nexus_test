import sbt.Keys._

name := """test"""

version := sys.env("BUILD_VERSION") //"1.0.0.27.1-SNAPSHOT"

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

lazy val root = Project(id = "test", base = file("."))


val releaseUrl = "releases" at "http://172.25.30.71:8081/content/repositories" + "/releases/"

val snapshotUrl = "snapshots" at "http://172.25.30.71:8081/content/repositories" + "/snapshots/"


credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo := {
  if (isSnapshot.value) Some(snapshotUrl) else Some(releaseUrl)
}