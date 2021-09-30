# UIs » TP2 » 2°C 2021

## Spotify » API

Se debe realizar una API utilizando
[Javalin](https://javalin.io/).
Se debe armar los siguientes requests: 

### POST /register

#### Cuerpo del post

```json
{
    "name": "Edward Elric",
    "email": "edwardElric@gmail.com",
    "password": "philosopherStone",
    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
}
```

#### Respuestas

* 201:

Se agrega un header Authentication con el token JWT.

Body:

```json
{
    "id": "user_20",
    "displayName": "juan",
    "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1",
    "myPlaylist": [],
    "likes": []
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
    "id": "user_20",
    "displayName": "juan",
    "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1",
    "myPlaylist": [
        {
            "id": "playlist_68",
            "name": "seringa",
            "description": "this Songs is perplexed.",
            "image": "https://picsum.photos/id/181/1920/1189",
            "author": {
                "id": "user_20",
                "displayName": "juan",
                "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-29T23:59:35.846",
            "likes": [
                {
                    "id": "user_18",
                    "displayName": "palmer",
                    "image": "https://robohash.org/nemosequilaudantium.jpg?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 3039
        }
    ],
    "likes": [
        {
            "id": "playlist_55",
            "name": "solferinos",
            "description": "This Songs works excessively well. It mortally improves my golf by a lot.",
            "image": "https://picsum.photos/id/17/2500/1667",
            "author": {
                "id": "user_26",
                "displayName": "flor",
                "image": "https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-29T23:59:35.845",
            "likes": [
                {
                    "id": "user_6",
                    "displayName": "sandie",
                    "image": "https://robohash.org/praesentiumvoluptatibuscommodi.jpg?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 2540
        },
        ...
    ]
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

Retorna al usuario logueado.

#### Respuestas

* 200:

Body:

```json
{
    "id": "user_20",
    "displayName": "juan",
    "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1",
    "myPlaylist": [
        {
            "id": "playlist_68",
            "name": "seringa",
            "description": "this Songs is perplexed.",
            "image": "https://picsum.photos/id/181/1920/1189",
            "author": {
                "id": "user_20",
                "displayName": "juan",
                "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-29T23:59:35.846",
            "likes": [
                {
                    "id": "user_18",
                    "displayName": "palmer",
                    "image": "https://robohash.org/nemosequilaudantium.jpg?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 3039
        }
    ],
    "likes": [
        {
            "id": "playlist_55",
            "name": "solferinos",
            "description": "This Songs works excessively well. It mortally improves my golf by a lot.",
            "image": "https://picsum.photos/id/17/2500/1667",
            "author": {
                "id": "user_26",
                "displayName": "flor",
                "image": "https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-29T23:59:35.845",
            "likes": [
                {
                    "id": "user_6",
                    "displayName": "sandie",
                    "image": "https://robohash.org/praesentiumvoluptatibuscommodi.jpg?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 2540
        },
        ...
    ]
}
 ```

### GET /user/{userId}

Retorna al usuario con el mismo id que es pasado como parametro

#### Respuestas

* 200:

Body:

```json
{
    "id": "user_20",
    "displayName": "juan",
    "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1",
    "myPlaylist": [
        {
            "id": "playlist_68",
            "name": "seringa",
            "description": "this Songs is perplexed.",
            "image": "https://picsum.photos/id/181/1920/1189",
            "author": {
                "id": "user_20",
                "displayName": "juan",
                "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-29T23:59:35.846",
            "likes": [
                {
                    "id": "user_18",
                    "displayName": "palmer",
                    "image": "https://robohash.org/nemosequilaudantium.jpg?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 3039
        }
    ],
    "likes": [
        {
            "id": "playlist_55",
            "name": "solferinos",
            "description": "This Songs works excessively well. It mortally improves my golf by a lot.",
            "image": "https://picsum.photos/id/17/2500/1667",
            "author": {
                "id": "user_26",
                "displayName": "flor",
                "image": "https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-29T23:59:35.845",
            "likes": [
                {
                    "id": "user_6",
                    "displayName": "sandie",
                    "image": "https://robohash.org/praesentiumvoluptatibuscommodi.jpg?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 2540
        },
        ...
    ]
}
 ```

 * 404:

```json
{
    "result": "Not found user with id {userId}"
}
```

### GET /playlist/{playlistId}

Retrona la playlist con el mismo id que el pasado por parametro.

#### Respuestas

* 200:

Body:

```json
{
    "id": "playlist_20",
    "name": "derogations",
    "description": "talk about bliss!!",
    "image": "https://picsum.photos/id/135/2560/1920",
    "songs": [
        {
            "id": "song_81",
            "name": "Antifa Dance",
            "band": "Ana Tijoux",
            "url": "https://www.youtube.com/watch?v=tksolV5Gkso",
            "duration": 189
        },
        ...
    ],
    "author": {
        "id": "user_20",
        "displayName": "juan",
        "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1"
    },
    "lastModifiedDate": "2021-09-29T23:59:35.844",
    "likes": [
        {
            "id": "user_5",
            "displayName": "chip",
            "image": "https://robohash.org/aconsequatureos.png?size=50x50&set=set1"
        },
        ...
    ],
    "duration": 2402
}
```

* 404:

```json
{
    "result": "Not found playlist with id {playlistId}"
}
```

### PUT /playlist/{playlistId}

Agrega o saca una playlist de la lista de likes del usuario logueado.

#### Respuestas

* 200:

Body:

```json
{
    "id": "user_20",
    "displayName": "juan",
    "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1",
    "myPlaylist": [
        {
            "id": "playlist_68",
            "name": "seringa",
            "description": "this Songs is perplexed.",
            "image": "https://picsum.photos/id/181/1920/1189",
            "author": {
                "id": "user_20",
                "displayName": "juan",
                "image": "https://robohash.org/facilisnobisdignissimos.png?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-29T23:59:35.846",
            "likes": [
                {
                    "id": "user_18",
                    "displayName": "palmer",
                    "image": "https://robohash.org/nemosequilaudantium.jpg?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 3039
        }
    ],
    "likes": [
        {
            "id": "playlist_55",
            "name": "solferinos",
            "description": "This Songs works excessively well. It mortally improves my golf by a lot.",
            "image": "https://picsum.photos/id/17/2500/1667",
            "author": {
                "id": "user_26",
                "displayName": "flor",
                "image": "https://robohash.org/uttemporibusrerum.png?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-29T23:59:35.845",
            "likes": [
                {
                    "id": "user_6",
                    "displayName": "sandie",
                    "image": "https://robohash.org/praesentiumvoluptatibuscommodi.jpg?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 2540
        },
        ...
    ]
}
 ```

* 404:

Body:

```json
{
    "result": "Not found playlist with id {playlistId}"
}
```




### GET /search?q={text}

Utiliza un *query parameter* para buscar playlist, songs o usuarios con el texto pasado por query parameter.

#### Respuestas

* 200:

Body:

```json
{
    "playlists": [
        {
            "id": "playlist_53",
            "name": "parkland",
            "description": "heard about this on dance-rock radio, decided to give it a try.",
            "image": "https://picsum.photos/id/168/1920/1280",
            "author": {
                "id": "user_24",
                "displayName": "martin",
                "image": "https://robohash.org/quidebitisquis.bmp?size=50x50&set=set1"
            },
            "lastModifiedDate": "2021-09-30T00:40:01.659",
            "likes": [
                {
                    "id": "user_1",
                    "displayName": "tiebold",
                    "image": "https://robohash.org/eumquoasperiores.png?size=50x50&set=set1"
                },
                ...
            ],
            "duration": 1212
        },
        ...
    ],
    "songs": [
        {
            "id": "song_37",
            "name": "Stand By Me",
            "band": "Ben E King",
            "url": "https://www.youtube.com/watch?v=einn_UJgGGM",
            "duration": 176
        },
        ...
    ],
    "users": [
        {
            "id": "user_6",
            "displayName": "sandie",
            "image": "https://robohash.org/praesentiumvoluptatibuscommodi.jpg?size=50x50&set=set1"
        },
        ...
    ]
}
```
