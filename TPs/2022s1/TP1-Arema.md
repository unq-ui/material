# Interfaz Desktop con Arena

Se debe realizar una aplicación de escritorio utilizando [Arena Framework](http://arena.uqbar-project.org/).

La aplicación requiere que el usuario pueda hacer las siguientes acciones:
* Ver la lista de categorías cargadas en el sistema.
* Crear/Editar una categoría.
* Poder ver sus listas de películas.
* Agregar/Editar una película.

_Algunas aclaraciones:_
- Una Película es valida si, tiene un titulo, una descripcion y un poster. Ademas el titula de la película no puede estar repetido.
- Una Categoría es valida si tiene un nombre y este no esta repetido

> Como utilizar el modelo
>
> ```kotlin
> val rottenTomatoesSystem = getRottenTomatoesSystem()
> ```


### Ejemplos de Ventanas

> Están ventanas son a modo de ejemplo para que se comprenda la funcionalidad.
> El alumno tiene total libertad de diseño siempre y cuando se mantenga la funcionalidad.

#### Vista del usuario

![User List](img/user.png)

#### Crear y editar categoría

> Cuando se edita una categoría se deben cargar los datos previos.

![Agregar o editar una categoría](img/CrearEditarcategoria.png)

#### Agregar y editar una película

> Cuando se edita una película se deben cargar los datos previos.

![Agregar o editar una Película](img/CrearEditarPelicula.png)