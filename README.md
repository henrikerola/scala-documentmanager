This is a simple web application create with [Vaadin](http://vaadin.com/), [scala-wrappers](http://vaadin.com/addon/scala-wrappers) and [sbt](https://github.com/harrah/xsbt/wiki). 

It also contains an initial support for compiling a Vaadin widgetset with the [sbt-gwt-plugin](https://github.com/thunderklaus/sbt-gwt-plugin).


## Widgetset compilation

Necessary configuration related to widgetset is in [build.sbt](https://github.com/henrikerola/scala-documentmanager/blob/master/build.sbt). Currently Vaadin widgets to be included into the widgetset must be defined by hand into the [.gwt.xml](https://github.com/henrikerola/scala-documentmanager/blob/master/src/main/scala/com/github/henrikerola/scaladocumentmanager/DocumentManagerWidgetset.gwt.xml) file.

Widgetset can be compiled by saying:

    $ sbt gwt-compile
