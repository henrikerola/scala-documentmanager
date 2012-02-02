package com.github.henrikerola.scaladocumentmanager

import java.io.File
import com.vaadin.Application
import com.vaadin.data.util.FilesystemContainer
import vaadin.scala._
import com.vaadin.data.util.TextFileProperty
import org.vaadin.teemu.ratingstars.RatingStars

object DocumentManagerApplication {
  val filesDir = "/Users/henri/Desktop/docs"
}

class DocumentManagerApplication extends Application {
  def init {
    val mainWindow = new Window("Scala Document Manager", content = new VerticalSplitPanel);
    setMainWindow(mainWindow)

    val selector = mainWindow.add(new Table(width = 100 percent, height = 100 percent, immediate = true, selectable = true))
    selector.setContainerDataSource(new FilesystemContainer(new File(DocumentManagerApplication.filesDir)))

    val viewer = new HtmlLabel(width = 100 percent, height = 100 percent)
    mainWindow addComponent (new VerticalLayout(width = 100 percent, height = 100 percent) {
      add(viewer, ratio = 1)
      add(new Button("Edit", _ => editButtonClicked))
      add(new RatingStars())
    })

    selector.addListener(_ => {
      viewer.setPropertyDataSource(new TextFileProperty(selector.getValue.asInstanceOf[File]));
    })

    def editButtonClicked {
      val editLayout = new VerticalLayout(100 percent, 100 percent)
      val editWindow = new Window("Edit document", 500 px, 400 px, content = editLayout, modal = true)
      editWindow.center()
      getMainWindow().addWindow(editWindow)

      val editor = editLayout.add(new RichTextArea(width = 100 percent, height = 100 percent), ratio = 1)
      editor.setWriteThrough(false)
      editor.setPropertyDataSource(viewer getPropertyDataSource)

      editLayout.add(new Button("Save", _ => {
        editor.commit()
        getMainWindow().removeWindow(editWindow)
      }))
    }
  }
}