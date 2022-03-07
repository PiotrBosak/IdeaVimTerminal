import org.jetbrains.sbtidea.Keys._

lazy val myAwesomeFramework =
  project.in(file("."))
    .enablePlugins(SbtIdeaPlugin)
    .settings(
      version := "0.0.1-SNAPSHOT",
      scalaVersion := "2.13.6",
      ThisBuild / intellijPluginName := "IdeaVim-Terminal",
      ThisBuild / intellijBuild      := "213.6777.52",
      ThisBuild / intellijPlatform   := IntelliJPlatform.IdeaUltimate,
      Global    / intellijAttachSources := true,
      Compile / javacOptions ++= "--release" :: "11" :: Nil,
      intellijPlugins += "com.intellij.properties".toPlugin,
      intellijPlugins += "IdeaVim".toPlugin,
        dependencyOverrides ++= {
            Seq(
                "net.java.dev.jna" % "jna" % "5.8.0"
            )
        },
      libraryDependencies += "org.typelevel" %% "cats-effect" % "3.3.5",
      unmanagedResourceDirectories in Compile += baseDirectory.value / "resources",
      unmanagedResourceDirectories in Test    += baseDirectory.value / "testResources",
    )
