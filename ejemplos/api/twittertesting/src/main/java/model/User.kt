package model

class User(val username: String, var fullname: String, var password:String = "") {
    val tweets = mutableListOf<String>()
    fun addTweet(tweet: String) = if (tweet.isNotEmpty()) tweets.add(tweet) else ""
}
