# UIs » TP3 » 1°C 2025

# Gog » Mobile - React Native

Se debe realizar una pagina web con react.
Se brinda el siguiente ejemplo de la aplicacion: [Figma]([https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=6014-1475&t=1I8FiI5QIG7qB6cw-0](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=50-2))

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```

## Comportamiento comun

Si no estamos loguado, toda accion que requiera un usuario logueado tendra que redirigirme al login.

## Pantallas

### [Splash Screen](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2436-2&t=3izFqX8mwjXmofuc-4)

### [Login](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2436-4&t=3izFqX8mwjXmofuc-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Home](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2436-18&t=3izFqX8mwjXmofuc-4)

En esta pagina se espera poder ver:
  - ver un listado de juegos.

### [Pagina de un juego](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2436-209&t=3izFqX8mwjXmofuc-4)

En esta pagina se tiene que mostrar la informacion del juego en cuestion.

- se muestran los primeros 5 tags y despues un mostrar mas `more...`, que se espera que abra una modal con todos los tags que dispone el juego, si tiene menos de 5 tags no mostrar esta opcion.
- Un boton de comprar el juego
  - si el usuario esta logueado agregar el juego al carrito.
  - si el usuario ya compro este juego no tiene que tener el boton de compra. 
    - [Ejemplo con juego comprado sin review](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=26-2267&t=1I8FiI5QIG7qB6cw-4)
    - [Ejemplo con juego comprado con review](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=26-2123&t=1I8FiI5QIG7qB6cw-4)
- tener seccion de juegos relacionados, al hacer click en ellos, redirigir a la pagina del juego clickeado.
- reviews
  - ver reviews de los usuarios.
  - si estoy logueado y no tengo el juego no puedo dejar review, por lo que no tendria que ver la opcion de dejar review.
  - si estoy logueado, tengo el juego y **no** tengo review poder dejarla.
  - si estoy logueado, tengo el juego y tengo review verla como destacada.

### [Cart](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2451-40&t=3izFqX8mwjXmofuc-4)

En esta pagina se muestran los juegos en el carrito y un resumen de cuanto tendrias que pagar
[Ejemplo con juegos](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=6018-849&t=3izFqX8mwjXmofuc-4)

### [Purchase](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=6018-758&t=3izFqX8mwjXmofuc-4)

En esta pagina se tiene que mostrar que juego vas a comprar y un formulario con los datos requeridos para hacer una compra.
Al terminar la compra redireccionar a la libreria del usuario.

### [Search](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2473-249&t=3izFqX8mwjXmofuc-4)

En esta pagina se tiene que mostrar lo que busco el usuario junto a los juegos que dieron como resultado.

### [Library](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2451-169&t=3izFqX8mwjXmofuc-4)

En esta pagina se listan todos los juegos que el usuario compro.
Y la opcion para desloguear al usuario.

### [Pagina del usuario](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2452-408&t=OX8GdMOQZjx98Lez-4)

En esta pagina podemos ver las reviews de ese usuario y agregar/quitar amigos.
