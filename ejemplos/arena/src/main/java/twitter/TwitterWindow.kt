package twitter

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.windows.MainWindow

class TwitterWindow(model: TwitterModel) : MainWindow<TwitterModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Mi twitter"

        table<TweetModel>(mainPanel) {
            visibleRows = 10
            bindItemsTo("tweets")
            column {
                title = "User"
                fixedSize = 80
                bindContentsTo("username")
            }
            column {
                title = "Tweet"
                fixedSize = 150
                bindContentsTo("tweet")
            }
        }

        Button(mainPanel) with {
            caption = "Agregar Tweet"
            onClick {
                TweetDialog(thisWindow, TweetModel()) with {
                    onAccept {
                        addTweet(modelObject)
                    }
                    open()
                }
            }
        }
    }

    fun addTweet(tweet: TweetModel) = modelObject.addNewTweet(tweet)

}