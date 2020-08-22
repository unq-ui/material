# UIs » TP2 » 1°C 2020

## UNQFlix » API

Continuando con la construcción de la plataforma UNQFlix se solicita la construcción
de una API RESTFul que de soporte y brinde la funcionalidad necesaria para la aplicación
WEB que se realizará en el TP3.

### POST /register

#### Cuerpo del post

```json
{
    "name": "Edward Elric",
    "email": "edwardElric@gmail.com",
    "password": "philosopherStone",
    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
    "creditCard": "4444 3333 2222 1111"
}
```

#### Respuestas

* 201:

Se agrega un header Authentication con el token JWT.

Body:

```json
{
    "result": "ok"
}
```

### POST /login

#### Cuerpo del post

```json
{
    "email": "edwardElric@gmail.com",
    "password": "philosopherStone",
}
```

#### Respuestas

* 200:

Se agrega un header Authentication con el token JWT.

Body:

```json
{
    "result": "ok"
}
```

* 404:

Body:

```json
{
    "result": "error",
    "message": "User not found"
}
```

## NOTA

Para los siguientes request se tiene que agregar el header **Authentication** con el token JWT,
si este no se pasa o el usuario no existe la respuesta tienen que ser un **401**.

### GET /user

Retorna los favoritos y los últimos contenidos vistos

#### Respuestas

* 200:

Body:

```json
 {
    "name": "Edward Elric",
    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
    "favorites": [
         {
             "id": "ser_1",
             "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "title": "Lorem Ipsum",
             "state": true
         }, ...
     ],
     "lastSeen": [
         {
             "id": "ser_1",
             "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "title": "Lorem Ipsum",
             "state": true
         }, ...
     ],
 }
 ```

### GET /content

Retorna todos los contenidos **disponibles**, ademas tienen que estar **ordenados por titulo**

#### Respuestas

* 200:

Body:

```json
 {
     "content": [
         {
             "id": "ser_1",
             "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "title": "Lorem Ipsum",
             "state": true
         }, ...
     ]
 }
 ```

### GET /banners

Retorna los banners de la aplicacion

#### Respuestas

* 200:

Body:

```json
 {
     "banners": [
         {
             "id": "ser_1",
             "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "title": "Lorem Ipsum",
             "state": true
         }, ...
     ]
 }
 ```

### GET /search?text={text}

Utiliza un *query parameter* para pasar el texto a buscar

#### Respuestas

* 200:

Body:

```json
 {
     "content": [
         {
             "id": "ser_1",
             "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "title": "Lorem Ipsum",
             "state": true
         }, ...
     ]
 }
 ```

### GET /content/{:contentId}

Trae información de una serie o película, el parámetro tiene que ser el id de una
película o una serie.

#### Respuestas

* 200:

Body Serie:

```json
 {
    "id": "ser_...",
    "title": "I Am Not an Animal",
    "description": "I Am Not An Animal is an animated comedy series about the only six talking animals
     in the world, whose cosseted existence in a vivisection unit is turned upside down when they
     are liberated by animal rights activists.",
    "poster": "https://image.tmdb.org/t/p/w500/nMhv6jG5dtLdW7rgguYWvpbk0YN.jpg",
    "categories": [ "Animation", "Comedy" ],
    "relatedContent": [ ... ],
    "seasons": [
      {
        "id": "sea_...",
        "title": "Specials",
        "description": "It is a long established fact that a reader will be distracted by the readable
         content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a
         more-or-less normal distribution",
        "poster": "https://ih1.redbubble.net/image.349118470.6262/flat,750x,075,f-pad,750x1000,f8f8f8.u1.jpg",
        "chapters": [
          {
            "id": "cha_...",
            "title": "I am an Animation",
            "description": "DVD Making of Documentary",
            "duration": 50,
            "video": "https://www.youtube.com/watch?v=Kxms-OtUXS0",
            "thumbnail": "https://ih1.redbubble.net/image.349118470.6262/flat,750x,075,f-pad,750x1000,f8f8f8.u1.jpg"
          }, ...
        ]
      }, ...
    ]
  },
 }
 ```

Body Movie:

```json
{
    "id": "mov_...",
    "title": "Dilwale Dulhania Le Jayenge",
    "description": "Raj is a rich, carefree, happy-go-lucky second generation NRI. Simran is the
     daughter of Chaudhary Baldev Singh, who in spite of being an NRI is very strict about adherence to
     Indian values. Simran has left for India to be married to her childhood fiancé. Raj leaves for
     India with a mission at his hands, to claim his lady love under the noses of her whole family.
     Thus begins a saga.",
    "poster": "https://image.tmdb.org/t/p/w500/2CAL2433ZeIihfX1Hb2139CX0pW.jpg",
    "video": "https://www.youtube.com/watch?v=cmax1C1p660",
    "duration": 100,
    "actores": [ "Russ Deckard", "Jada Heng", "Elias Lemarr" ],
    "directors": [ "Phylicia Castile", "Cinderella Albertson", "Ailene Whitten" ],
    "categories": [ "Comedy", "Drama", "Romance" ],
    "relatedContent": [ ...]
}
```

### POST /user/fav/{:contentId}

Agrega o elimina un contenido de la lista de favoritos del usuario.

>La respuesta tambien puede ser la lista actualizada de los favoritos del usuario

#### Respuestas

* 200:

Body:

```json
{
    "result": "ok"
}
```

### POST /user/lastSeen

Agrega un contenido a la lista de lo ultimo visto del usuario

Body:

```json
{
    "id": "mov_1" // también puede ser una serie
}
```

>La respuesta también puede ser la lista actualizada de los favoritos del usuario

#### Respuestas

* 200:

Body:

```json
{
  "result": "ok"
}
```
