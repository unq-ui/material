package ar.edu.unq.api

import io.javalin.http.Context
import ar.edu.unq.model.Twitter
import ar.edu.unq.model.User
import ar.edu.unq.model.UsernameExist

class UserController {

    val twitter = Twitter(mutableListOf<User>())

    fun getAll(ctx: Context) {
        ctx.json(twitter.users)
    }

    fun createUser(ctx: Context) {
        val newUser = ctx.bodyAsClass(UserRegister::class.java)
        try {
            twitter.register(newUser.username, newUser.password, newUser.displayName)
            ctx.json("ok")
        } catch (exception: UsernameExist) {
            ctx.status(400)
            ctx.json(Handler(400, "Bad request", "Username is token"))
        }
    }

    fun getUser(ctx: Context) {
        val userId = ctx.pathParam("id")
        ctx.json(twitter.getUser(userId))
    }

    fun updateUser(ctx: Context) {
        val userId = ctx.pathParam("id")
        val updateUser = ctx.bodyAsClass(UserUpdate::class.java)
        twitter.getUser(userId).displayName = updateUser.displayName
        ctx.json("updated")
    }
}