import io.javalin.Javalin
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import com.github.kittinunf.fuel.*
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.extensions.jsonBody
import com.github.kittinunf.fuel.jackson.responseObject
import controllers.FullUserAdapter
import controllers.BasicUserAdapter
import controllers.StoreUserAdapter
import com.fasterxml.jackson.databind.ObjectMapper

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class TwitterAPISpec {
    private lateinit var api: Javalin

    @BeforeAll fun setUp() {
        api = TwitterAPI(8000).init()
        // Inject the base path to no have repeat the whole URL
        FuelManager.instance.basePath = "http://localhost:${api.port()}/"
    }

    @AfterAll fun tearDown() {
        api.stop()
    }

    @Test @Order(1)
    fun `1 GET users retrieves an empty list by default`() {
        val (_, response, result) = Fuel.get("users").responseObject<List<BasicUserAdapter>>()
        assertEquals(200, response.statusCode)
        assertEquals(0, result.get().size)
        assertTrue(result.get().isEmpty())
    }

    @Test @Order(2)
    fun `2 POST users store a new user`() {
        val userJson = """
            {
                "username": "@hodor",
                "fullname": "Hodor",
                "password": "12345"
            }
        """
        val (_, response, _) = Fuel.post("users").jsonBody(userJson).responseObject<String>()
        assertEquals(201, response.statusCode)
        assertTrue(response.body().isEmpty())
    }

    @Test @Order(3)
    fun `3 GET users includes previous user storing`() {
        val userJson = """{"username": "@hodor", "fullname": "Hodor"}""".replace(" ", "")
        val (_, response, result) = Fuel.get("users").responseString()
        assertEquals(200, response.statusCode)
        assertEquals("[$userJson]", result.get())
    }

    @Test @Order(4)
    fun `4 POST users and retrieves by GET users (with mapper)`() {
        val mapper = ObjectMapper()
        val userPost = StoreUserAdapter(
                password = "nobody",
                fullname = "Arya Stark",
                username = "@arya"
        )
        val user = BasicUserAdapter(userPost.username, userPost.fullname)
        val (_, responsePost , _) = Fuel.post("users").jsonBody(mapper.writeValueAsString(userPost)).response()
        assertEquals(201, responsePost.statusCode)

        val (_, response, result) = Fuel.get("users").responseObject<List<BasicUserAdapter>>()
        assertEquals(200, response.statusCode)
        assertEquals(2, result.get().size)
        assertEquals(user, result.get().first { it.username == "@arya" })
    }

    @Test @Order(5)
    fun `5 GET users (alternative)`() {
        val (_, response, result) = Fuel.get("users").responseObject<List<BasicUserAdapter>>()

        val user = result.get().first { it.username == "@arya" }
        assertEquals(200, response.statusCode)
        assertEquals(2, result.get().size)
        assertEquals("@arya", user.username)
        assertEquals("Arya Stark", user.fullname)
    }

    @Test @Order(6)
    fun `6 GET users by username`() {
        val (_, response, result) = Fuel.get("users/@hodor").responseObject<FullUserAdapter>()
        val userResult = result.get()
        assertEquals(200, response.statusCode)
        assertEquals("@hodor", userResult.username)
        assertEquals("Hodor", userResult.fullname)
        assertTrue(userResult.tweets.isEmpty())
    }

    @Test @Order(7)
    fun `7 PUT users-tweet`() {
        val (_, response, result) = Fuel.put("users/@hodor/tweet")
                .jsonBody("Hodor hodor hodor hodor ...")
                .responseObject<FullUserAdapter>()

        val userResult = result.get()
        assertEquals(200, response.statusCode)
        assertEquals("@hodor", userResult.username)
        assertEquals("Hodor", userResult.fullname)
        assertEquals(1, userResult.tweets.size)
        assertEquals("Hodor hodor hodor hodor ...", userResult.tweets.first())
    }

    @Test @Order(8)
    fun `8 DELETE users`() {
        val (_, response, _) = Fuel.delete("users/@arya").responseString()
        assertEquals(204, response.statusCode)
    }

    @Test @Order(9)
    fun `9 DELETE users verification`() {
        val (_, response, result) = Fuel.get("users").responseObject<List<BasicUserAdapter>>()
        assertEquals(200, response.statusCode)
        assertEquals(1, result.get().size)
        assertEquals("@hodor", result.get().first().username)
    }
}
