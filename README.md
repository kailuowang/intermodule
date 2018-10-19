run `sbt +test` to see error

> [warn] ==== local-preloaded: tried
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
