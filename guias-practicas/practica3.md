> [Volver al índice](README.md#guias-practicas)

# Práctica 3 » API REST - javalin

Realizar los ejercicios utilizando el framework Javalin y Kotlin.

> En todos los casos deben controlarse los problemas e informar
> con los códigos y mensajes de error correspondientes.

## Ejercicio 1: ToDo List

Escribir una interfaz que permita administrar tareas a través de una ToDo List.

Cada Tarea deberá contener:

* ID
* Título
* Descripción
* Fecha de Creación
* Estado

Estados: _Pendiente_, _Completa_

### Protocolo

* `GET /tasks`: Trae todas las tareas
* `GET /tasks/:id`: Trae la tarea con `:id`
* `POST /tasks/`: Agrega una nueva tarea
  - Body: `{"title": ..., "description": ...}
  - El ID, la fecha de creación y el estado se deben generar automáticamente al crear la tarea
  - Estado: _Pendiente_
* `PUT /tasks/:id`: Modifica una tarea
  - Body: `{"title": ..., "description": ...}
  - El ID y la fecha de creación no cambian
  - Si el estado es _Pendiente_ se puede modificar, si es _Completa_ debería devolver un error
* `DELETE /task/:id`: Elimina una tarea
  - No importa el estado para eliminar una tarea
* `PUT /task/:id/done`: Marca una tarea como _Completa_
* `PUT /task/:id/undone`: Marca una tarea como _Pendiente_


## Ejercicio 2: IMDB

Programar una API REST que permita buscar dentro un gran catálogo de películas.

Película:

* Título
* Descripción
* Fecha de estreno
* Directores
* Actores
* Rating

Protocolo

> No se pedirá un protocolo de CRUD, con lo cual puede crear el catálogo dentro de la aplicación.
> Los directores y actores pueden ser listas de _strings_, no es necesario modelarlo.

* `GET /searchBy?title={title}&description={description}&directors={director1,director2,...}&actors={actor1,actor2,...}`
    - Busca dentro del catálogo
    - Algunos ítems pueden tener contenido vacío
    - Internamente se deberían aplicar un criterio de "relevancia"
      * Primero los que matchean con todo
      * Luego los que matchean por título
      * Luego los que matchean por descripción
      * etc...
* `GET /ranking?min_rating={rating}&limit={limit}`
    - Trae las películas ordenadas por rating descendiente (de mayor a menor)
    - Opcionalmente se puede definir un valor mínimo de rating que deben cumplir las películas
    - Opcionalmente se puede definir un límite de películas a traer
