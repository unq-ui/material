# UIs » TP2 » 1°C 2023

# Twitter » React

Se debe realizar una pagina web con react.
Se necesitan las siguientes funcionalidades:

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```

## Paginas

```
Todo error en la aplicación tiene que ser informado al usuario.
```

### Login

Se tiene que poder loguear un usuario.

### Registro

Se tiene que poder crear usuarios nuevos.

### Acciones para todas las paginas que acepte a un usuario logueado

- Poder ir a la home del usuario.
- Tener informacion del usuario logueado (foto y username).
- Poder desloguearse.
- Poder realizar una busqueda.
- Poder ir a ver los trending topics.

### Home - usuario

Se tiene que:

- Ver listado de tweets de `/followingTweets`. [Ver apartado de tweets](#apartado-de-tweet) para saber que informacion se tiene que mostrar.
- Poder agregar un tweet.
- Poder dar like a un tweet (tambien se tiene que saber de alguna forma si el usuario logueado ya le dio like a un tweet).
- Poder hacer un retweet (al hacer un retweet si todo sale correctamente me tiene que redirigir a la pagina del retweet creado).
- Poder hacer un reply (al hacer un reply si todo sale correctamente me tiene que redirigir a la pagina del tweet original).

### Tweet (tweet / retweet/ reply)

- ver informacion del usuario que realizo el tweet (foto, nombre de usuario).
- ver fecha del tweet.
- ver contenido.
- si el tweet contiene imagen verla.
- ver los replys.
- poder ir a ver el perfil del usuario que realizo el tweet.
- poder dar like (o sacarlo).
- poder hacer un reply (al hacer un reply si todo sale correctamente se tiene que ver el nuevo reply en esta misma pagina).
- poder hacer un retweet (al hacer un retweet si todo sale correctamente me tiene que redirigir a la pagina del retweet creado).
- Si estoy viendo un reply / retweet
  - Tengo que ver informacion del tweet original (info del usuario, fecha, contenido, imagen si es que tiene, ademas de poder ir al tweet original).
  - En el caso de que sea un **retweet** se tiene que informar de **ALGUNA MANERA** que este tweet es un retweet.

### User

- ver foto del usuario.
- ver background del usuario.
- ver nombre del usuario.
- ver cantidad de followers y de followings.
- ver los tweets del usuario ([Ver apartado de tweets](#apartado-de-tweet) para saber que informacion se tiene que mostrar).
- si el usuario que estoy viendo no es el usuario logueado poder seguir/dejar de seguir.

### Apartado de tweet

- ver informacion del usuario que realizo el tweet (foto, nombre de usuario)
- ver fecha del tweet.
- ver contenido.
- si el tweet contiene imagen verla.
- ver cantidad de likes
- ver cantidad de retweets
- ver cantidad de replys.
- poder acceder al perfil del usuario del tweet.
- poder ir a la pagina de ese tweet en particular.
- Si estoy viendo un reply / retweet
  - Tengo que ver informacion del tweet original (info del usuario, fecha, contenido, imagen si es que tiene, ademas de poder ir al tweet original)
  - En el caso de que sea un **retweet** se tiene que informar de **ALGUNA MANERA** que este tweet es un retweet.

