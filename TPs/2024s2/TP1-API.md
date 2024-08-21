# UIs » TP1 » 2°C 2024

# Mercadolibre » React

Se debe realizar una API utilizando Javalin. Se debe armar los siguientes requests especificados en https://swaggers-virid.vercel.app/mercadolibre

## Modelo

https://github.com/unq-ui/mercadolibre-model

## Enunciado

* Se tienen que implementar el [swagger](https://swaggers-virid.vercel.app/mercadolibre)

> El swagger hace referencia a un `ErrorDTO` pero **SE PUEDE** usar las exceptions de Javalin.

### Validaciones:

Tiene que devolver algun codigo de error si:
  * El body no esta completo.
  * Si algun dato es vacio.
  * Si la `query` del `/search` es vacia o no es enviado.
  * Si el query param `page` es un numero menor o igual a `0`.
  * Si al dar de alta/editar un producto su `stock` es menor o igual a `0`.
  * Si al dar de alta/editar un producto su `shipping` es negativo.

**OJO:** Existen mas posibles errores, mirar el swagger.

### Formatos de datos:

* Cuando aparezca una fecha se tiene que enviar y recibir con el siguiente formato: `YYYY/MM/DD`. La unica fecha distinta es el `expirationDate` que tiene que ser `YYYY/MM`.