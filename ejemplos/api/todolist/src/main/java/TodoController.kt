import io.javalin.BadRequestResponse
import io.javalin.Context
import io.javalin.NotFoundResponse
import java.time.LocalDateTime
import java.util.*

class TodoController(val users: MutableList<User>) {

    private fun getUser(userId: String): User {
        return users.firstOrNull { it.id == userId } ?: throw NotFoundResponse("Usuario no encontrado")
    }

    private fun getTodo(user: User, todoId: String): Todo {
        return user.todos.firstOrNull { it.id == todoId } ?: throw NotFoundResponse("TODO no encontrado")
    }

    fun getAll(ctx: Context) {
        val user = getUser(ctx.pathParam("userid"))
        ctx.json(UserJson(user.id, user.profile.username, user.profile.imageLink, user.todos.map { TodoJson(it.id, it.date.toString(), it.description)}))
    }

    fun addNewTodo(ctx: Context) {
        val user = getUser(ctx.pathParam("userid"))
        val newTodo = ctx.body<NewTodo>()
        user.todos.add(Todo(UUID.randomUUID().toString(), LocalDateTime.now(), newTodo.description))
        ctx.header("Access-Control-Allow-Origin", "*")
        ctx.json("Agregado")
    }

    fun updateTodo(ctx: Context) {
        val updateTodo = ctx.body<UpdateTodo>()
        val user = getUser(ctx.pathParam("userid"))
        val todo = getTodo(user, ctx.pathParam("id"))
        user.todos.remove(todo)
        user.todos.add(Todo(todo.id, todo.date, updateTodo.description))
        ctx.json("Actualizado")
    }

    fun deleteTodo(ctx: Context) {
        val user = getUser(ctx.pathParam("userid"))
        val todo = getTodo(user, ctx.pathParam("id"))
        user.todos.remove(todo)
        ctx.json("Borrado")
    }

    fun login(ctx: Context) {
        val login = ctx.body<Login>()
        val user = users.firstOrNull { it.profile.username == login.username && it.profile.password == login.password } ?: throw NotFoundResponse("Usuario no encontrado")
        ctx.json(user.id)
    }

    fun register(ctx: Context) {
        val register = ctx.body<Register>()
        val founded = users.any{ it.profile.username == register.username }
        if(!founded) {
            val newUser = User(UUID.randomUUID().toString(), Profile(register.username, register.password, register.imageLink), mutableListOf())
            users.add(newUser)
            ctx.json(newUser.id)
        } else {
            throw BadRequestResponse("Username ya utilizado")
        }
    }

    fun all(ctx: Context) {
        ctx.json(users)
    }
}