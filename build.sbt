import sbt.Keys._

sbtPlugin := true

organization := "org.loven"

name := "test-loven-plugin"

version := "1.0.0.27.1-SNAPSHOT"//  sys.env("BUILD_VERSION") //

scalaVersion := "2.11.7"

libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"

// lazy val root = Project(id = "test", base = file("."))

publishArtifact in (Compile, packageDoc) := false

publishArtifact in (Compile, packageSrc) := false



credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishTo <<= (version) { version =>
  val releaseUrl = "releases" at "http://172.25.30.71:8081/content/repositories/releases/"

  val snapshotUrl = "snapshots" at "http://172.25.30.71:8081/content/repositories/snapshots/"
  if (version endsWith "-SNAPSHOT") Some(snapshotUrl) else Some(releaseUrl)
}

/*publishTo := {
  if (isSnapshot.value) Some(snapshotUrl) else Some(releaseUrl)
}*/
