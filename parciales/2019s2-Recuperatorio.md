# UIs » Recuperatorio » 2°C 2020

> **17/12/2019**

![UNQ](../img/unq.png)

## Ejercicio 1 (Teoría)

Defina y explique los patrones de diseño MVC y MVVM, comentando sus
diferencias e indicando en qué escenarios es conveniente aplicar cada
uno y por qué.

## Ejercicio 2 (Desktop)

Dado el siguiente código Arena (puede asumir `imports` y `main()`)

1. Dibujar la ventana resultante si se completa el input
   con "Materias" y se presiona el botón "Buscar"
2. Explique qué sucede si se presiona el botón "Buscar"
   si en el input contiene el texto "No".

```kotlin
@Observable class LuckySearch {
  var searchInput = "";
  var errorMsg = "";
  var results = ""
  
  fun clear() {
    searchInput = "";
    errorMsg = "";
    results = ""
  }
  
  fun search() {
    errorMsg = ""; results = ""
    if (searchInput.trim().length < 3) {
      errorMsg = "Se requieren más de 2 caracteres"; return;
    }
    results += "- Introducción de la Programación\n"
    results += "- Bases de Datos\n"
    results += "- Construcción de Interfaces de Usuario\n"
  }
}

class LuckySearchWindow(model: LuckySearch) : MainWindow<LuckySearch>(model) {
  override fun createContents(mainPanel: Panel) {
    title = "Buscador de la Suerte";

    Label(mainPanel) with { fontSize = 18; text = "Lucky Search" }

    TextBox(mainPanel) bindTo "searchInput"

    Label(mainPanel) with { color = Color.RED; bindTo("errorMsg") }

    Panel(mainPanel) with {
      asHorizontal()
      Button(it) with { caption = "Buscar"; onClick { search() }}
      Button(it) with { caption = "Limpiar"; onClick { clear() }}
    }

    Label(mainPanel) with { alignLeft(); bindTo("results") }
  }

  fun clear() { modelObject.clear() }

  fun search() { modelObject.search() }
}
```

## Ejercicio 3 (API)

Se cuenta con un CRUD de personajes de Game of Thrones.
**Armar un Request para actualizar** la información de Jaime Lannister.
La nueva profesión debe ser "Guardia Real" y la nueva cantidad de manos
debe ser 1 (el resto de los datos no deben sufrir modificaciones).
El request de actualización debe contente el método HTTP,
el path que identifique el recurso a actualizar y el body con los datos.
Puede utilizar este `GET /personajes/4242` como referencia.

```json
{
  "id": 4242,
  "nombre": "Jaime Lannister",
  "profesion": "Matareyes",
  "frase": "Un Lannister siempre paga sus deudas",
  "manos": 2
}
```

## Ejercicio 4 (Web)

Dado el siguiente código React (puede asumir imports y bootstrap)

1. Dibuje el renderizado resultante del componente Home
2. Explique cómo es el funcionamiento del formulario: binding, manejo del state,
   funciones callback, envío del formulario, etc…
3. Explique qué sucede si se presiona el botón "Voy a tener suerte" con
   el input de búsqueda vacía. ¿Qué componente se renderiza y por qué?

```jsx
function Recu() {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/" component={Home} />
        <Route path="/search/:search" component={Search} />
        <Route path="/lucky/:search" component={Lucky} />
        <Route path="*" component={NotFound} />
      </Switch>
    </BrowserRouter>
  );
}

const NotFound = () => <h1>Ups! Pasaron cosas...</h1>

const Search = props => <h1>Buscaste: "{props.match.params.search}"</h1>

const Lucky = props => {
  props.match.params.search.trim() === ""
    ? props.history.push("/error")
    : props.history.push(`/search/${props.match.params.search}`);
  return null;
}

class Home extends React.Component {
  constructor(props) {
    super(props);
    this.state = { search: "" };
  }
  
  updateSearch = (event) => this.setState({ search: event.target.value })
  
  goSearch = () => this.props.history.push(`/search/${this.state.search}`)
  
  goLucky = () => this.props.history.push(`/lucky/${this.state.search}`)

  render() {
    return (
     <div className="container" style={{ textAlign: 'center', alignContent: 'center' }}>
     <h1>UnQui Search</h1>
        <form>
        <div>
          <input style={{ width: '500px' }}
            value={this.state.search}
            onChange={this.updateSearch}
            type="text" placeholder="Buscar..." />
            <div style={{ margin: '5px', align: 'center' }}>
              <SearchButton name="Buscar" typeStyle="info" fn={this.goSearch} />
              <SearchButton name="Voy a tener suerte" typeStyle="success" fn={this.goLucky} />
            </div>
          </div>
        </form>
      </div>
    )
  }
}

const SearchButton = ({name, typeStyle, fn}) =>
  <button
   style={{ margin: '5px' }}
   type="button"
   className={`btn btn-${typeStyle}`}
   onClick={fn}>{name}
  </button>
```
