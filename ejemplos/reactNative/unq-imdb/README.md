# UNQ-Imdb

## Instalación y Ejecutar

* Node (version 12 o más)
* npm install expo-cli --global (solo para crear un proyecto desde cero)
* npm install
* npm start
* Abre un navegador en localhost:3000
* Descargar la app de expo (https://play.google.com/store/apps/details?id=host.exp.exponent&hl=es_AR)
* Escanear con la app el QR de la pagina.

## Ejercicio

* Poder mostrar los detalles de la pelicula y sus comentarios. (Tanto en la home como en el search)
* Agregar el ver mas de una categoria (al final de los carruseles se tiene un ver mas)
* Agregar un comentario a la pelicula
* (Opcional) modificar el home para traer los resultados paginados

## API

Existe un archivo en `src/resourse/Api.js` en donde se encuentran las rutas, en este archivo existe un `GROUP_ID` el cual tienen que cambiar al numero que les corresponde como grupo.

```javascript
const GROUP_ID = '20'; // Cambiar por el numero correspondiente
```

### Endpoins

https://app.swaggerhub.com/apis-docs/unq-ui/unq-imdb/1.0.0