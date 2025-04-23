# UIs » TP2 » 1°C 2025

# Gog » React

Se debe realizar una pagina web con react.
Se brinda el siguiente ejemplo de la aplicacion: [Figma](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=6014-1475&t=1I8FiI5QIG7qB6cw-0)

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```


## Comportamiento comun

## Navbar

- Icono de la aplicacion (con redireccion a la pagina Home).
- Store (link a la pagina de Home).
- Library
  - Si tenemos un usuario logueado llevarlo a su libreria.
  - Si **NO** tenemos usuario logueado llevarlo al login.
- Search (solo busca juegos).
- Boton de login redirecciona al login 
  - si tenemos un usuario logueado este **NO** aparece.
- Boton de register redirecciona al registro.
  - si tenemos un usuario logueado este **NO** aparece.
- Boton de carrito **SOLO** si tengo usuario logueado.

## Paginas

### [Home](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=6008-626&t=1I8FiI5QIG7qB6cw-4)

En esta pagina se espera poder ver:
  - los juegos que Gog recomienda
  - ver los primeros 10 tags (con un link a ver todos los tags) [Ejemplo](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=48-2&t=1I8FiI5QIG7qB6cw-4)
  - ver un listado de juegos (dado que el endpoint los devuelve paginados, tenemos que agregarle las paginas).

### [Login](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=20-601&t=1I8FiI5QIG7qB6cw-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Register](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=20-623&t=1I8FiI5QIG7qB6cw-4)

En esta pagina se espera que un nuevo usuario se pueda registrar, si el registro es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Pagina de un juego](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=20-654&t=1I8FiI5QIG7qB6cw-4)

En esta pagina se tiene que mostrar la informacion del juego en cuestion.

- se muestran los primeros 5 tags y despues un mostrar mas, que se espera que abra una modal con todos los tags que dispone el juego, si tiene menos de 5 tags no mostrar esta opcion. **Los tags tienen que ser clickeables y redireccionar a la pagina que muestra los juegos de ese tag**
- Un boton de comprar el juego
  - si el usuario **no** esta logueado llevarlo al login.
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

### [Cart](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=6018-6&t=1I8FiI5QIG7qB6cw-4)

**Esta pagina no se puede acceder si no estas logueado**

En esta pagina se muestran los juegos en el carrito y un resumen de cuanto tendrias que pagar
[Ejemplo con juegos](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=6018-491&t=1I8FiI5QIG7qB6cw-4)

### [Purchase](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=26-1736&t=1I8FiI5QIG7qB6cw-4)

**Esta pagina no se puede acceder si no estas logueado**

En esta pagina se tiene que mostrar que juego vas a comprar y un formulario con los datos requeridos para hacer una compra.
Al terminar la compra redireccionar a la libreria del usuario.

### [Search](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=23-417&t=1I8FiI5QIG7qB6cw-4)

En esta pagina se tiene que mostrar lo que busco el usuario junto a los juegos que dieron como resultado.

### [Library](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=25-1330&t=1I8FiI5QIG7qB6cw-4)

**Esta pagina no se puede acceder si no estas logueado**

En esta pagina se listan todos los juegos que el usuario compro.
Y la opcion para desloguear al usuario.

### [Pagina del usuario](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=25-768&t=1I8FiI5QIG7qB6cw-4)

En esta pagina podemos ver las reviews de ese usuario y agregar/quitar amigos.

### [Pagina de un Tag](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=6014-1475&t=1I8FiI5QIG7qB6cw-4)

En esta pagina se listan los juegos del tag en cuestion.
