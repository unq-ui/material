# UIs » TP2 » 2°C 2019

## DigitalWallet » API

Continuando con la construcción de la plataforma financiera
DigitalWallet, el inversor solicita comenzar con la construcción de la
plataforma WEB, para esto es necesario la construcción de una API
RESTFull que de soporte y brinde la funcionalidad necesaria para la
aplicación WEB.

Se requiere la construcción de la siguientes APIs:

Validar que un usuario es válido.

#### POST /login

Body

```json
{
 "email": "a@gmail.com",
 "password": "asa"
}
```

IMPORTANTE: Si bien no vamos a preocuparnos por la seguridad, tengan
siempre presente que es una pésima práctica enviar el password como
texto plano. Debería viajar cifrado (si quieren hacerlo son libres,
pero no vamos a requerirlo).

Registrar un nuevo usuario en el sistema.

#### POST /register

```json
{
 "email":"polo@gmail.com",
 "firstName":"facundo",
 "idCard":"12345667", 
 "lastName":"Polo", 
 "password":"polo",
 "isAdmin" : true
 }
```

Luego de que el usuario se loguee puede realizar la siguientes acciones:

#### POST /transfer

Request

```json
{
 "fromCVU":"060065243",
 "toCVU":"519264035",
 "amount":"6"
 }
```

#### POST /cashIn

Request

```json
{
 "fromCVU": "060065243" ,
 "amount" : 500.25,
 "cardNumber":"1234 1234 1234 1234",
 "fullName":"Facundo ",
 "endDate":"07/2019",
 "securityCode": "123"
}
```

Obtener todos los movimientos de una cuenta

#### GET /transaccions/:cvu

```json
[
{
        "amount": 500.25,
        "dateTime": {  },
        "description": "Carga con tarjeta",
        "fullDescription": "Carga con tarjeta xxxx xxxx xxxx por $500.25",
        "cashOut": false
    }, {
        "amount": -634,
        "dateTime": { },
        "description": "Transferencia de Egreso",
        "fullDescription": "Transferencia de Egreso hacía xxx  por -634.0",
        "cashOut": true
    }, {
        "amount": 1500,
        "dateTime": { },
        "description": "Transferencia de Ingreso",
        "fullDescription": "Transferencia de Ingreso desde xxx por $1500.0",
        "cashOut": false
    }
]
```

#### DELETE /users/:cvu

Se debe identificar el usuario que tenga la cuenta con cvu enviado por
parámetro y luego debe ser eliminado del sistema

[]{#t.aa3af46352442dca234dfcadc3b0bd5f9bc149af}[]{#t.4}

#### GET /account/:cvu

Recuperar el saldo de la cuenta con CVU enviado por parámetro

```json
{
    "amount": "520.20"
}
```

IMPORTANTE

Notar que todas las consultas anteriores pueden llegar a dar errores si
no se efectúan correctamente. Estos errores tienen que ser informados
correctamente con los códigos del protocolo HTTP correspondientes y
mensaje amigable que informe lo sucedido.

Cada grupo es libre de reestructurar los cuerpos de REQUEST y RESPONSE
siempre y cuando se cumpla con la información necesaria.

También pueden agregar más rutas en caso que sean necesarias.
