package com.github.henrikerola.scaladocumentmanager

import java.io.File
import vaadin.scala._

object DocumentManagerApplication {
  val FilesDir = "/Users/henri/Desktop/docs"
}

class DocumentManagerApplication extends Application("Scala Document Manager") {
  
  val selector = new Table {
    sizeFull()
    immediate = true
    selectionMode = SelectionMode.Single
    container = new FilesystemContainer(new File(DocumentManagerApplication.FilesDir))
    valueChangeListeners += {
      viewer.property = new TextFileProperty(value.getOrElse(null).asInstanceOf[File])
    }
  }
  
  val viewer = new HtmlLabel {
    sizeFull()
  }

  override def main = new VerticalSplitPanel {
    addComponent(selector)
    addComponent(new VerticalLayout {
      sizeFull()
      add(viewer, ratio = 1)
      add(Button("Edit", editButtonClicked()))
    })
  }

  def editButtonClicked() {
    mainWindow.childWindows += new Window { editWindow =>
      width = 500 px;
      height = 400 px

      caption = "Edit document"
      modal = true

      content = new VerticalLayout {
        sizeFull()
        val editor = add(new RichTextArea {
          sizeFull()
          writeThrough = false
          property = viewer.property
        }, ratio = 1)
        addComponent(Button("Save", {
          mainWindow.childWindows -= editWindow
          editor.commit()
        }))
      }
    }
  }
}