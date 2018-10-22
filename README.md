This is minimized example for a weird/buggy sbt behavior. 
Here is the settings: 3 modules, a, b, and root, module b is depending on a, but set to have one less crossScalaVersion, when you run sbt +test , this results in sbt trying to resolve b’s dependency a from repositories, which of course isn’t available.

```scala
lazy val root = project.in(file("."))
                 .aggregate(a, b)
                 .settings(crossScalaVersions := Seq("2.11.12", scalaVersion.value))

lazy val a = project.settings(crossScalaVersions := Seq("2.11.12", scalaVersion.value))

lazy val b = project.dependsOn(a).settings(crossScalaVersions := Seq(scalaVersion.value))
```

run `sbt +test` to see error

```
[warn] ==== local-preloaded: tried
[warn]   file:////Users/kailuowang/.sbt/preloaded/a/a_2.12/0.1.0-SNAPSHOT/a_2.12-0.1.0-SNAPSHOT.pom
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 	::          UNRESOLVED DEPENDENCIES         ::
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 	:: a#a_2.12;0.1.0-SNAPSHOT: not found
[warn] 	::::::::::::::::::::::::::::::::::::::::::::::
[warn] 
[warn] 	Note: Unresolved dependencies path:
[warn] 		a:a_2.12:0.1.0-SNAPSHOT
[warn] 		  +- b:b_2.12:0.1.0-SNAPSHOT
[error] sbt.librarymanagement.ResolveException: unresolved dependency: a#a_2.12;0.1.0-SNAPSHOT: not found
```

It runs fine if you run `+test` on module b alone. 
