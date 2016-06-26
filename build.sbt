organization in ThisBuild := "com.github.lavenderx"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.11.8"


lazy val root = (project in file("."))
  .enablePlugins(JavaAppPackaging)
  .settings(commonSettings: _*)


lazy val commonSettings = Seq(
  homepage := Some(url("https://github.com/lavenderx/flink-examples")),

  developers := List(Developer(
    "lavenderx",
    "Zongzhi Bai",
    "dolphineor@gmail.com",
    url("https://github.com/lavenderx"))
  ),

  scmInfo := Some(ScmInfo(
    url("https://github.com/lavenderx/flink-examples"),
    "scm:git:git@github.com:lavenderx/flink-examples.git",
    Some("scm:git:git@github.com:lavenderx/flink-examples.git"))
  ),

  licenses := Seq(
    ("MIT", url("https://opensource.org/licenses/MIT"))
  ),

  name := "flink-examples",

  version := "1.0-SNAPSHOT",

  fork in run := true,

  scalacOptions ++= Seq(
    "-encoding", "UTF-8",
    "-unchecked",
    "-deprecation"
  ),

  javacOptions in compile ++= Seq(
    "-encoding", "UTF-8",
    "-source", "1.8",
    "-target", "1.8",
    "-Xlint:unchecked",
    "-Xlint:deprecation"
  ),

  ivyScala := ivyScala.value map {
    _.copy(overrideScalaVersion = true)
  },

  libraryDependencies ++= {
    val flinkVersion = "1.0.3"
    Seq(
      "org.apache.flink" %% "flink-streaming-scala" % flinkVersion,
      "org.apache.flink" %% "flink-scala" % flinkVersion,
      "org.apache.flink" %% "flink-clients" % flinkVersion
    )
  },

  unmanagedSourceDirectories in Compile := Seq((scalaSource in Compile).value),
  unmanagedSourceDirectories in Test := Seq((scalaSource in Test).value)
)
    