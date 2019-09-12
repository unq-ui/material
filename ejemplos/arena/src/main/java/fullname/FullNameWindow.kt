package fullname

import org.uqbar.arena.kotlin.extensions.*
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable


fun main() = FullNameWindow(FullNameViewModel()).startApplication()

@Observable
class FullNameViewModel() {
    var firstName: String = ""
    var lastName: String = ""

    @Dependencies("firstName", "lastName")
    fun getFullName() = "Hola $firstName $lastName"
}

class FullNameWindow(model: FullNameViewModel) : MainWindow<FullNameViewModel>(model) {
    override fun createContents(mainPanel: Panel) {
        title = "Ejemplo en clase"

        Label(mainPanel) with {
            text = "Nombre"
        }

        TextBox(mainPanel) with {
            width = 200
            bindTo("firstName")
        }

        Label(mainPanel) with {
            text = "Apellido"
        }

        TextBox(mainPanel) with {
            width = 200
            bindTo("lastName")
        }

        Label(mainPanel) with {
            bindTo("fullName")
        }
    }
}
