name := "tipa-password-storage"

version := "1.0-snapshot"

scalaVersion := "2.9.2"

fork in run := true

libraryDependencies ++= Seq("com.lambdaworks" % "scrypt" % "1.3.3",
	"com.typesafe" % "config" % "1.0.0",
	"org.scalatest" %% "scalatest" % "1.8" % "test",
	"org.scalacheck" %% "scalacheck" % "1.10.0" % "test")
