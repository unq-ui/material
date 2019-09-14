package twitter

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.*
import org.uqbar.arena.windows.Dialog
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.WindowOwner
import java.awt.Color

class TweetDialog(owner: WindowOwner, model: TweetModel) : Dialog<TweetModel>(owner, model) {
    override fun createFormPanel(mainPanel: Panel) {
        ErrorsPanel(mainPanel, "")
        Panel(mainPanel) with {
            asColumns(2)
            Label(it) withText "User:"
            TextBox(it) bindTo("username")
        }

        KeyWordTextArea(mainPanel) with {
            height = 200
            color = Color.BLUE
            bindTo("tweet")
        }
        Label(mainPanel) bindTo "countDown"

        Panel(mainPanel) with {
            asHorizontal()
            Button(it) with {
                caption = "Twittear"
                bindEnabledTo("isOk")
                onClick { accept() }
            }
            Button(it) with {
                caption = "Cancelar"
                onClick { cancel() }
            }
        }
    }

    fun limit() = modelObject.limit

}