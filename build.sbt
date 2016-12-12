val scTest = "org.scalatest" % "scalatest_2.11" % "3.0.0" % "test"
val scJson = "org.json4s" %% "json4s-jackson" % "3.3.0"
lazy val root = (project in file(".")).
  settings(
    name := "Scandas",
    version := "1.0",
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq(scTest,scJson)
  )
