name := "hackerrank-challenges"

val scalaV = "2.12.3"
scalaVersion in ThisBuild := scalaV

lazy val hackerrankChallenges = project.in(file(".")) settings(
  libraryDependencies ++= Seq(
    "org.scala-lang" % "scala-reflect" % scalaV,
    "org.scalatest" %% "scalatest" % "3.0.4" % "test",
    "org.mockito" % "mockito-all" % "1.10.19" % "test"
  ))
