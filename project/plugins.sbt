// resolvers += "Web plugin repo" at "http://siasia.github.com/maven2"
// libraryDependencies <+= sbtVersion(v => "com.github.siasia" %% "xsbt-web-plugin" % (v+"-0.2.10"))

resolvers += Classpaths.typesafeResolver

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse" % "2.0.0-M1")


resolvers += "GWT plugin repo" at "http://thunderklaus.github.com/maven"

addSbtPlugin("net.thunderklaus" % "sbt-gwt-plugin" % "1.1-SNAPSHOT")
