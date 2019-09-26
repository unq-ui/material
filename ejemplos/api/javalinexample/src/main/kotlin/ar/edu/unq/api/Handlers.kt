package ar.edu.unq.api

import ar.edu.unq.model.Post
import ar.edu.unq.model.User

open class Handler(val code: Int, val type: String, open val message: String)

data class NotFoundHandler(override val message: String): Handler(404, "not found", message)

data class UserRegister(val username: String, val password: String, val displayName: String)

data class UserUpdate(val displayName: String)

data class UserView(val username: String, val displayName: String, val friend: List<UserView>, val posts: MutableList<Post>) {
    constructor(user: User) : this(user.username, user.displayName, user.friends.map {UserView(it)}, user.posts)
}