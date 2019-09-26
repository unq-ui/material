package ar.edu.unq.model

import java.util.function.Predicate

class Twitter(val users: MutableList<User>) {

    private var userId = 0

    fun login(username: String, password: String): User {
        return this.lookUpUser({ it.username == username && it.password == password }, "Wrong user or password")
    }

    fun register(username: String, password: String, displayName: String) {
        if(this.existUsername(username)) {
            throw UsernameExist()
        }
        users.add(User(""+userId++, username, password, displayName, mutableListOf(), mutableListOf()))
    }

    fun getUser(id: String): User {
        return this.lookUpUser({ it.id == id }, "Not found userID")
    }

    private fun lookUpUser(function: (User) -> Boolean, notFoundText: String): User {
        return users.firstOrNull(function) ?: throw NotFound(notFoundText)
    }

    private fun existUsername(username: String): Boolean {
        return users.any { it.username == username }
    }

}