//import net.thunderklaus.GwtPlugin._

name := "scaladocumentmanager"
 
scalaVersion := "2.9.1"
 
seq(webSettings: _*)

//seq(gwtSettings: _*)

resolvers += "Vaadin add-ons repository" at "http://maven.vaadin.com/vaadin-addons"

libraryDependencies ++= Seq(
  "com.vaadin" % "vaadin" % "6.8.0",
  //"org.vaadin.addons" % "scala-wrappers" % "0.2.0",
  //"org.vaadin.addons" % "ratingstars" % "1.4",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "container"
)

// hack: sbt-gwt-plugin assumes that sources are in src/main/java
//javaSource in Compile <<= (scalaSource in Compile)

//gwtModules := List("com.github.henrikerola.scaladocumentmanager.DocumentManagerWidgetset")

// more correct place would be to compile widgetset under the target dir and configure jetty to find it from there 
//gwtTemporaryPath := file(".") / "src" / "main" / "webapp" / "VAADIN" / "widgetsets"
