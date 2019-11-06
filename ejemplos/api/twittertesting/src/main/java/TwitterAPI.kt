import controllers.TwController
import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.core.util.RouteOverviewPlugin

fun main() {
    TwitterAPI(7000).init()
}

class TwitterAPI(private val port: Int) {

    fun init(): Javalin {
        val app = Javalin.create {
            it.enableCorsForAllOrigins()
            it.registerPlugin(RouteOverviewPlugin("/routes"))
        }.exception(Exception::class.java) { e, ctx ->
                e.printStackTrace()
                ctx.status(500)
                ctx.json("Error fatal")
        }.start(port)

        val twController = TwController()

        app.routes {
            path("users") {
                get(twController::getUsersList)             // GET users/
                post(twController::storeUser)               // POST users/
                path(":username") {
                    get(twController::getUserByUsername)    // GET users/:username
                    delete(twController::deleteUser)        // DELETE users/:username
                    path("tweet") {
                        put(twController::newTweet)         // PUT /users/:username/tweet
                    }
                }
            }
            path("tweets") {
                get(twController::getTweets)                // GET /tweets
                path(":username") {
                    post(twController::createTweet)         // POST /tweets/:username
                }
            }
        }

        return app
    }
}
