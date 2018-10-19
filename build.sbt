
lazy val root = project.in(file("."))
                 .aggregate(a, b)
                 .settings(crossScalaVersions := Seq("2.11.12", scalaVersion.value))

lazy val a = project.settings(crossScalaVersions := Seq("2.11.12", scalaVersion.value))

lazy val b = project.dependsOn(a).settings(crossScalaVersions := Seq(scalaVersion.value))
