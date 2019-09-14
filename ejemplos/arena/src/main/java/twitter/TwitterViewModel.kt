package twitter

import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable

@Observable
class TweetModel {
    val limit = 80
    var username: String = ""
    var tweet: String = ""

    @Dependencies("tweet")
    fun getCountDown() = limit - tweet.length

    @Dependencies("tweet")
    fun getIsOk() = tweet.length <= limit
}

@Observable
class TwitterModel(val twitter: Twitter) {

    var tweets = mutableListOf<TweetModel>()
    init {
        tweets = twitter.tweets.map {
            val t = TweetModel()
            t.username = it.username
            t.tweet = it.content
            t
        }.toMutableList()
    }
    fun addNewTweet(tweet: TweetModel) = tweets.add(tweet)
}