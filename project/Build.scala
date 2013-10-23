import sbt._
import Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin.EclipseKeys

object Build extends sbt.Build {
	import Dependencies._

	lazy val myProject = Project("akka-quartz", file("."))
		.settings(
		organization  := "us.theatr",
		version       := "0.3.0-SNAPSHOT",
		scalaVersion  := "2.10.3",
		crossScalaVersions := Seq("2.10.3"),
		scalacOptions := Seq("-deprecation", "-encoding", "utf8"),
		resolvers     ++= Dependencies.resolutionRepos,
		publishTo := Some(Resolver.file("file", new File("../../ivy-repo"))),
		libraryDependencies ++=
		  provided(akkaActor, slf4j, logback) ++ compile(quartz) ++
		  test(specs2, akkaTestkit)

	)
}

