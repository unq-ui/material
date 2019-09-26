package ar.edu.unq.api

import ar.edu.unq.model.NotFound
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.core.util.RouteOverviewPlugin

fun main(args: Array<String>) {
    val app = Javalin.create {
        it.defaultContentType = "application/json"
        it.registerPlugin(RouteOverviewPlugin("/routes"))
        it.enableCorsForAllOrigins()
    }
        .start(7000)

    val userController = UserController()
    app.routes {
        path("users") {
            get(userController::getAll)
            post(userController::createUser)
            path(":id") {
                get(userController::getUser)
                put(userController::updateUser)
            }
        }
    }

    app.exception(NotFound::class.java) { e, ctx ->
        ctx.status(404)
        ctx.json(NotFoundHandler(e.message!!))
    }
}
