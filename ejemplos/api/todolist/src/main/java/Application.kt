import io.javalin.Javalin
import io.javalin.apibuilder.ApiBuilder.*
import io.javalin.core.util.Header

class MainApp {

    lateinit var todoController: TodoController;

    init {
        todoController = TodoController(Bootstrap().getUsers())
    }

    fun start() {
        val app = Javalin
            .create()
            .enableCorsForAllOrigins()
            .start(7000)

        app.routes {
            path("/:userid/todos") {
                get(todoController::getAll)
                post(todoController::addNewTodo)
                path(":id") {
                    put(todoController::updateTodo)
                    delete(todoController::deleteTodo)
                }
            }
        }
        app.post("login", todoController::login)
        app.post("register", todoController::register)
        app.get("all", todoController::all)
    }
}

fun main(args: Array<String>) {
    MainApp().start()

}