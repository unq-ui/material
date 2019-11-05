# Clase react 2

## Parte 1

Crear proyecto con create-react-app

```bash
npx create-react-app APP_NAME
```

## Parte 2

Agregar dependencias utiles

* bootstrap
* jquery (dependencia para bootstrap)
* popper.js (dependencia para bootstrap)
* react-router-dom (para hacer routeo) (Parte 4)
* axios (para realiar requests) (Parte 5)

## Parte 3

Creamos el componente Login con dos inputs (usuario y password) y un boton para loguearnos (Por ahora es todo local, y tenemos los datos harcodeados de usuarios).

*EJ:*
usuario: **juan**
contraseña: **juan**

## Parte 4

Creamos el componente Home para que despues de hacer click y que los datos sean correctos navegue a dicho componente.

## Parte 5

En el Home se realiza un pedido a una api publica *https://api.punkapi.com/v2/beers* y listamos el resultado.