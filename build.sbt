name := "tipa-password-storage"

version := "0.1"

scalaVersion := "2.10.3"

fork in run := true

libraryDependencies ++= Seq(
"com.lambdaworks" % "scrypt" % "1.4.0",
	"com.typesafe" % "config" % "1.0.2",
	"org.scalatest" %% "scalatest" % "2.0" % "test",
	"org.scalacheck" %% "scalacheck" % "1.11.1" % "test")
