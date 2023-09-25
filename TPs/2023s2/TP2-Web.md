# UIs » TP2 » 2°C 2023

# Steam » React

Se debe realizar una pagina web con react.
Se brinda el siguiente ejemplo de la aplicacion: [Figma](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=10%3A29&mode=design&t=esnpQ3OxnLTvqfaS-1)

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

## Paginas

### [Home](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=10-32&mode=design&t=esnpQ3OxnLTvqfaS-4)

En esta pagina se espera poder ver:
  - los juegos que Steam recomienda
  - ver los primeros 10 tags (con un link a ver todos los tags) [Ejemplo](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=48-229&mode=design&t=esnpQ3OxnLTvqfaS-4)
  - ver un listado de juegos (dado que el endpoint los devuelve paginados, tenemos que agregarle las paginas).

### [Login](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=20-601&mode=design&t=esnpQ3OxnLTvqfaS-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Register](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=20-623&mode=design&t=esnpQ3OxnLTvqfaS-4)

En esta pagina se espera que un nuevo usuario se pueda registrar, si el registro es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Pagina de un juego](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=20-654&mode=design&t=esnpQ3OxnLTvqfaS-4)

En esta pagina se tiene que mostrar la informacion del juego en cuestion.

- se muestran los primeros 5 tags y despues un mostrar mas, que se espera que abra una modal con todos los tags que dispone el juego, si tiene menos de 5 tags no mostrar esta opcion.
- Un boton de comprar el juego
  - si el usuario **no** esta logueado llevarlo al login.
  - si el usuario esta logueado seguir el flujo de compra (ver ventana purchase).
  - si el usuario ya compro este juego no tener el boton de compra. 
    - [Ejemplo con juego comprado sin review](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=26-2267&mode=design&t=7tKRjzo8kDxZLQ8a-4)
    - [Ejemplo con juego comprado con review](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=54-2&mode=design&t=8kLiI1wFXBVpCjWz-4)
- tener seccion de juegos relacionados, al hacer click en ellos, redirigir a la pagina del juego clickeado.
- reviews
  - ver reviews de los usuarios.
  - si estoy logueado y no tengo review poder hacer una review se puede ocultar esta review si:
    - no tengo el juego en cuestion.
  - resaltar la review del usuario logueado.

### [Purchase](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=26-1736&mode=design&t=esnpQ3OxnLTvqfaS-4)

**Esta pagina no se puede acceder si no estas logueado**

En esta pagina se tiene que mostrar que juego vas a comprar y un formulario con los datos requeridos para hacer una compra.
Al terminar la compra redireccionar a la libreria del usuario.

### [Search](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=23-417&mode=design&t=esnpQ3OxnLTvqfaS-4)

En esta pagina se tiene que mostrar lo que busco el usuario junto a los juegos que dieron como resultado.


### [Library](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=25-1330&mode=design&t=esnpQ3OxnLTvqfaS-4)

**Esta pagina no se puede acceder si no estas logueado**

En esta pagina se listan todos los juegos que el usuario compro.

### [Pagina del usuario](https://www.figma.com/file/turhiDcSIBRmkzF3nzdI7E/Steam?type=design&node-id=25-768&mode=design&t=esnpQ3OxnLTvqfaS-4)

En esta pagina podemos ver las reviews de ese usuario y agregar/quitar amigos.

