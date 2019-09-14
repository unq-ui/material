package twitter

class Tweet(val username: String, val content: String)

class Twitter {
    fun addTweet(username: String, content: String) {
        tweets.add(Tweet(username, content))
    }
    val tweets = mutableListOf<Tweet>()
}