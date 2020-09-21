# UIs » TP2 » 2°C 2020

## Instagram » Desktop Arena

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
             "id": "p_1",
             "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "portrait": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
             "landscape": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
             "likes": [
                {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }, ...
             ],
             "date": "dd/MM/AAAA - hh:mm",
             "user": {
                "name": "Edward Elric",
                "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
             }
         }, ...
     ],
 }
 ```

### GET /user/{userId}

Retorna al usuario con el mismo id que es pasado como parametro y sus post

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
     "posts": [
         {
             "id": "p_1",
             "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "portrait": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
             "landscape": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
             "likes": [
                {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }, ...
             ],
             "date": "dd/MM/AAAA - hh:mm",
             "user": {
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

### GET /post/{postId}

Retorna el post con id `postId`

#### Respuestas

* 200:

Body:

```json
{
    "id": "p_1",
    "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
    "portrait": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
    "landscape": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
    "likes": [
    {
        "name": "Edward Elric",
        "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
    }, ...
    ],
    "date": "dd/MM/AAAA - hh:mm",
    "user": {
        "name": "Edward Elric",
        "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
    },
    "comments": [
        {
            "id": "c_1",
            "body": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
            "user": {
                "name": "Edward Elric",
                "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
            }
        }, ...
    ]
}
```

* 404:

Body:

```json
{
    "result": "Not found post with id {postId}"
}
```

### PUT /post/{postId}/like

Agrega/elimina al usuario como que le dio like a ese post

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
    "result": "Not found post with id {postId}"
}
```

### POST /post/{postId}/comment

#### Cuerpo del post

```json
{
    "body": "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
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
    "result": "Not found post with id {postId}"
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
             "id": "p_1",
             "description": "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
             "portrait": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
             "landscape": "https://a.wattpad.com/cover/83879595-352-k192548.jpg",
             "likes": [
                {
                    "name": "Edward Elric",
                    "image": "https://a.wattpad.com/cover/83879595-352-k192548.jpg"
                }, ...
             ],
             "date": "dd/MM/AAAA - hh:mm",
             "user": {
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

