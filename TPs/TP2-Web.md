## TP2 >> Backend Desktop

Se requiere una aplicación web para que los clientes puedan realizar pedidos a los restaurantes que tienen cerca.

Para esto se requiere que los usuarios se puedan registrar y loguear.

#### `POST /login`
 
Body:
```json
{
  "username": "pepe@pepe.com",
  "password": "alsidjkfu1y2uia123*sdl"
}
```

#### `POST /register`

Body:
```json
{
  "username": "pepe",
  "email": "pepe@pepe.com",
  "password": "alsidjkfu1y2uia123*sdl",
  "address": "Calle falsa 123",
  "coord": {
    "latitude": 123,
    "longitude": -123
  }
}
```

> IMPORTANTE: Si bien no vamos a preocuparnos por la seguridad,
> tengan siempre presente que es una pésima práctica enviar el password
> como texto plano. Debería viajar encriptado (si quieren hacerlo
> son libres, pero no vamos a requerirlo).

---

Luego de que el usuario se loguee puede solicitar información.

### Información del Usuario

> Opcionalmente órdenes pendientes de entrega y el historial de pedidos.

#### `GET /users/:id`

Respuesta:

```json
{
  "username": "pepe",
  "email": "pepe@pepe.com",
  "address": "Calle falsa 123",
  "coord": {
    "latitude": 123,
    "longitude": -123
  }
}
```

#### `GET /users/:id?include=orders`


```json
{
  "username": "pepe",
  "email": "pepe@pepe.com",
  "address": "Calle falsa 123",
  "coord": {
    "latitude": 123,
    "longitude": -123
  },
  "finishedOrders": [
    {
      "id": 2,
      "restaurantId": 1,
      "menus": [
        {
          "menuId": 1,
          "amount": 4
        },
        ...
      ],
      "creditCard": {
        "name": "Homero Simpson",
        "number": "4444 3333 2222 1111",
        "securityCode": "123",
        "type": "visa",
        "vencimiento": "11/24"
      },
      "destination": { "lat": 123, "long": -123 }
    },
    ...
  ],
  "pendingOrders": [
    {
      "id": 1,
      "restaurantId": 1,
      "menus": [
        {
          "menuId": 1,
          "amount": 4,
        },
        ...
      ],
      "creditCard": {
        "name": "Homero Simpson",
        "number": "4444 3333 2222 1111",
        "securityCode": "123",
        "type": "visa",
        "vencimiento": "11/24"
      },
      "destination": { "lat": 123, "long": -123 }
    },
    ...
  ]
}
```

### Buscar un restaurant o un menu

#### `GET /search?q={data}&lat={lat}&long={long}`

Respuesta:
```json
{
  "restaurants":[
    {
      "id": 1,
      "name": "La cocina de miguel",
      "direction": "calle falsa 123",
      "position": { "lat": 123, "long": 123 },
      "description": "Lorem Ipsum est un texte d'espace réservé couramment utilisé."
    },
    ...
  ],
  "menus": [
   { 
    "id": 1,
    "name": "milanga oro",
    "price": 199.78,
    "products": [ 
      { "name": "milanesa al plato", "amount": 2 },
      { "name": "bebida cola 2.25L", "amount": 1 }
    ],
    "restaurantId": 1
   },
   ...
 ]
}
```

### Obtener todos los menus de un restaurant

#### `GET /restaurant/:id`

Respuesta:
```json
{
  "data": {
    "id": 1,
    "name": "La cocina de miguel",
    "direction": "calle falsa 123",
    "position": { "lat": 123, "long": 123 },
    "description": "Lorem Ipsum est un texte d'espace réservé couramment utilisé.",
    "menus": [
      { 
        "id": 1,
        "name": "milanga oro",
        "rawPrice": 199.78,
        "discountPrice": 179.80,
        "products": [ 
          {
            "name": "milanesa al plato",
            "amount": 2
          }, {
            "name": "bebida cola 2.25L",,
            "amount": 1
          }
        ],
        "discount": { 
          "type": "percentage",
          "amount": 10
        }
      },
      ...
    ]
  }
}
```

### Realizar un pedido

#### `POST /deliver`

Body:
```json
{
  "restaurantId": 1,
  "menus": [{
    "menuId": 1,
    "amount": 4,
  }],
  "creditCard": {
    "name": "Homero Simpson",
    "number": "4444 3333 2222 1111",
    "securityCode": "123",
    "type": "visa",
    "vencimiento": "11/24"
  },
  "destination": { "lat": 123, "long": 123 }
}
```

### Puntuar a un Pedido

#### `PUT /deliver/:id`

Body:
```json
{
  "rating": 2
}
```

---

Es importante notar que todas las consultas anteriores pueden llegar a dar errores si no se efectúan correctamente. Estos errores tienen que ser informados correctamente con los códigos HTTP correspondientes y mensaje amigable que informe lo sucedido.

Ej:

#### `GET /login`

Respuesta 404 (Not Found):

```json
{
  "status": 404,
  "message": "Usuario o contraseña incorrectos"
}
```

Cada es libre de reestructurar los cuerpos de REQUEST y RESPONSE siempre y cuando se cumpla con la información necesaria.

También pueden agregar más rutas en caso que necesiten.

---

## Diseño de la App

Pueden usar de guía el siguiente _prototype_ para darse una idea de cómo debería ser la aplicación web.

https://xd.adobe.com/view/6ea8af8b-4bed-4300-4011-aaa45b939263-1899/

assets y colores:

https://xd.adobe.com/spec/f21ccda5-6d5e-45ba-6faa-19ad19d5b93d-842d/
