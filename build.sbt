dependsOn(any, boolean, double, array2D, hlist, coproduct)

DslEntries.autoImport.aggregate(deeplearning, any, boolean, double, array2D, hlist, coproduct)

lazy val deeplearning = project.disablePlugins(SparkPackagePlugin)

lazy val boolean = project.disablePlugins(SparkPackagePlugin).dependsOn(deeplearning, `buffered-layer`, any)

lazy val double = project.disablePlugins(SparkPackagePlugin).dependsOn(any, boolean, `buffered-layer`)

lazy val any = project.disablePlugins(SparkPackagePlugin).dependsOn(deeplearning)

lazy val array2D = project.disablePlugins(SparkPackagePlugin).dependsOn(double)

lazy val hlist = project.disablePlugins(SparkPackagePlugin).dependsOn(any)

lazy val coproduct = project.disablePlugins(SparkPackagePlugin).dependsOn(boolean)

lazy val `buffered-layer` = project.disablePlugins(SparkPackagePlugin).dependsOn(deeplearning)

lazy val `sbt-nd4j` = project

SbtNd4J.addNd4jRuntime(Test)

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % Test
