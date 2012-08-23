name := "scaladocumentmanager"
 
scalaVersion := "2.9.1"
 
seq(webSettings: _*)

resolvers += "Vaadin add-ons repository" at "http://maven.vaadin.com/vaadin-addons"

libraryDependencies ++= Seq(
  "com.vaadin" % "vaadin" % "6.8.2",
  "org.vaadin.addons" % "scaladin" % "2.0.0",
  "org.eclipse.jetty" % "jetty-webapp" % "8.0.4.v20111024" % "container"
)