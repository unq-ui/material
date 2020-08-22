# UIs » Parcial » 2°C 2019

> **26/11/2019**

![UNQ](../img/unq.png)

## Ejercicio 1

1. Defina con sus palabras el concepto de Interfaz de Usuario.
2. ¿Qué significa UX y por qué es tan importante en la construcción de UIs?
   Puede complementar con ejemplos concreto.

## Ejercicio 2

Dado el siguiente código Arena (puede asumir todos los imports
necesarios)

1. Dibujar la ventana resultante luego de clickear 3 veces en el botón "Siguiente"
2. ¿Qué sucede al clickear el botón "Voy a Tener Suerte"?

```kotlin
fun main() = StarWarsWindow(StarWars()).startApplication()

data class SW(val episode: String, val title: String)

@Observable class StarWars {
  var counter = 3
  var movies = mutableListOf(
    SW("I", "La Amenaza Fantasma"),
    SW("II", "El Ataque de los Clones"),
    SW("III", "La Venganza de los Sith"),
    SW("IV", "Una Nueva Esperanza"),
    SW("V", "El Imperio Contraataca"),
    SW("VI", "El Retorno del Jedi"),
    SW("VII", "El Despertar de la Fuerza"),
    SW("VII", "Los Últimos Jedi"),
    SW("IX", "El Ascenso de Skywalker")
  )
  
  @Dependencies("counter") fun getEpisode() = "Episodio ${movies[counter].episode}"
  
  @Dependencies("counter") fun getTitle() = movies[counter].title
  
  fun next() { counter = (counter + 1) % 9 }
  
  fun lucky() { counter = (0..8).random() }
}

class StarWarsWindow(model: StarWars) : MainWindow<StarWars>(model) {
  override fun createContents(mainPanel: Panel) {
    title = "Star Wars Universe"; mainPanel.asColumns(2);
    Panel(mainPanel) with { asVertical(); Label(it) bindTo "episode"; Label(it) bindTo "title" }
    Panel(mainPanel) with { asVertical(); 
      Button(it) with { caption = "Siguiente"; onClick { next() } }
      Button(it) with { caption = "Voy a Tener Suerte"; onClick { lucky() } }
    }
  }
  private fun next() = modelObject.next()
  private fun lucky() = modelObject.lucky()
}
```

## Ejercicio 3

1. Describa con sus palabras las arquitecturas Stateful y Stateless.
2. Defina CRUD y describa el protocolo básico para un CRUD REST de películas.
3. Enumere por lo menos 2 códigos HTTP usados para respuestas exitosas
   y 2 para indicar errores de aplicación.
   Explique en qué casos se debería utilizar cada uno.

## Ejercicio 4

Dado el siguiente código React (puede asumir todos los imports necesarios)

1. Dibuje el renderizado resultante de ingresar a la ruta <http://localhost:3000/>.
   Justifique su decisión.

```jsx
function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/"><Redirect to="/choice" /></Route>
        <Route path="/home" component={Home} />
        <Route path="/content" component={Content} />
        <Route path="/login" component={Login} />
        <Route path="/:info" render={Choice} />
        <Route path="*" component={NotFound} />
      </Switch>
    </BrowserRouter>
  );
}

const Choice = ({ match }) => {
  return match.params.info === 'logged' ? <Redirect to="/home" /> : <Redirect to="/login" />;
}

const Login = () => <Redirect to="/logged" />

const Content = () => <h1>Soy el contenido</h1>

const NotFound = () => <h1>Ups! Pasaron cosas...</h1>

class Home extends React.Component {
  componentDidMount() {
    this.props.history.push("/content");
  }
  render() {
    return <h1>Bienvenidos a Interfaces de Usuario</h1>;
  }
}
```

## Ejercicio 5

Dada la siguiente imagen, escriba un componente React con el código necesario
de HTML y CSS que permita generar ese mismo renderizado.

![Tarantino](img/2019s2-parcial-ej5.png)
