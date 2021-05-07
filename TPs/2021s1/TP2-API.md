# UIs » TP2 » 1°C 2021

## Twitter » API

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

Retorna al usuario logueado con su timeline

#### Respuestas

* 200:

Body:

```json
{
    "name": "Edward Elric",
    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
    "followers": [
         {
            "name": "Edward Elric",
            "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
         }, ...
     ],
     "timeline": [
         {
             "id": "t_2",
             "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "images": ["https://a.wattpad.com/cover/83879595-352-k192548.jpg", "https://a.wattpad.com/cover/83879595-352-k192548.jpg"],
             "reply": {
                "id": "t_1",
                "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                "images": ["https://a.wattpad.com/cover/83879595-352-k192548.jpg", "https://a.wattpad.com/cover/83879595-352-k192548.jpg"],
                "author": {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }
             },
             "likes": [
                {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }, ...
             ],
             "date": "dd/MM/AAAA - hh:mm",
             "author": {
                "name": "Edward Elric",
                "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
             }
         }, ...
     ],
 }
 ```

### GET /user/{userId}

Retorna al usuario con el mismo id que es pasado como parametro y sus tweets

#### Respuestas

* 200:

Body:

```json
{
    "name": "Edward Elric",
    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
    "followers": [
         {
            "name": "Edward Elric",
            "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
         }, ...
     ],
     "tweets": [
         {
            "id": "t_1",
            "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            "images": ["https://a.wattpad.com/cover/83879595-352-k192548.jpg", "https://a.wattpad.com/cover/83879595-352-k192548.jpg"],
            "reply": {
                "id": "t_1",
                "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                "images": ["https://a.wattpad.com/cover/83879595-352-k192548.jpg", "https://a.wattpad.com/cover/83879595-352-k192548.jpg"],
                "author": {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }
             },
             "likes": [
                {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }, ...
             ],
             "date": "dd/MM/AAAA - hh:mm",
             "author": {
                "name": "Edward Elric",
                "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
             }
         }, ...
     ],
 }
 ```

 * 404:

```json
{
    "result": "Not found user with id {userId}"
}
```

### PUT /user/{userId}/follow

Agrega/elimina al usuario como follower del userId

#### Respuestas

* 200:

Body:

```json
 {
     "result": "ok"
 }
```

* 404:

```json
{
    "result": "Not found user with id {userId}"
}
```

### GET /tweet/{tweetId}

Retorna el tweet con id `tweetId`

#### Respuestas

* 200:

Body:

```json
{
    "id": "t_1",
    "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    "images": ["https://a.wattpad.com/cover/83879595-352-k192548.jpg", "https://a.wattpad.com/cover/83879595-352-k192548.jpg"],
    "reply": {
        "id": "t_1",
        "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
        "images": ["https://a.wattpad.com/cover/83879595-352-k192548.jpg", "https://a.wattpad.com/cover/83879595-352-k192548.jpg"],
        "author": {
            "name": "Edward Elric",
            "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
        }
    },
    "likes": [
        {
            "name": "Edward Elric",
            "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
        }, ...
    ],
    "date": "dd/MM/AAAA - hh:mm",
    "author": {
        "name": "Edward Elric",
        "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
    },
    "comments": [
        {
            "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            "images": [],
            "author": {
                "name": "Edward Elric",
                "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
            },
            "reply": null
            "likes": [],
        }, ...
    ]
}
```

* 404:

Body:

```json
{
    "result": "Not found tweet with id {tweetId}"
}
```

### PUT /tweet/{tweetId}/like

Agrega/elimina al usuario como que le dio like a ese tweet

#### Respuestas

* 200:

Body:

```json
 {
     "result": "ok"
 }
```

* 404:

```json
{
    "result": "Not found tweet with id {tweetId}"
}
```

### POST /tweet/{tweetId}/comment

#### Cuerpo del post

```json
{
    "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    "images": ["img1.com", "img2.com"]
}
```

#### Respuestas

* 200:

```json
{
    "result": "ok"
}
```

* 404:

```json
{
    "result": "Not found tweet with id {tweetId}"
}
```

### GET /search?q={text}

Utiliza un *query parameter* para buscar o un tag o el nombre de un usuario (se toma que si no se pasa un # se busca un usuario y si tiene un # se busca en un tag).

#### Respuestas

* 200:

Body si se busco un tag:

```json
 {
     "content": [
         {
             "id": "t_1",
             "text": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "images": ["https://a.wattpad.com/cover/83879595-352-k192548.jpg"],
             "likes": [
                {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }, ...
             ],
             "date": "dd/MM/AAAA - hh:mm",
             "author": {
                "name": "Edward Elric",
                "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
             }
         }, ...
     ]
 }
 ```

Body si se busco un usuario:

```json
 {
     "content": [
         {
            "name": "Edward Elric",
            "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
            "followers": [
                {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }, ...
            ],
         }
     ]
 }
 ```

