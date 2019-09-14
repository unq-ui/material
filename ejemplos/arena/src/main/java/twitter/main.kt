package twitter

class SetUp {
    val twitter = Twitter()
    init {
        twitter.addTweet("@jon", "i know nothing")
        twitter.addTweet("@cersei", "i choose violence")
    }
    fun data() = twitter
}

fun main() {
    val s = SetUp()
    TwitterWindow(TwitterModel(s.data())).startApplication()
}
