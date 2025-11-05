# UIs » TP3 » 2°C 2025

# Instagram » Mobile - React Native

Se debe realizar una app android/ios con react native.
Se brinda el siguiente ejemplo de la aplicacion: [Figma](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2611-157&p=f&t=fdby7TzWnlT7tONt-0)

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```

## Comportamiento comun

Si no estamos loguado, toda accion que requiera un usuario logueado tendra que redirigirme al login.

## Pantallas

### [Splash Screen](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2679-278&t=fdby7TzWnlT7tONt-4)

### [Login](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2614-158&t=fdby7TzWnlT7tONt-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Registro](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2614-172&t=fdby7TzWnlT7tONt-4)

En esta pagina se espera que un nuevo usuario se pueda registrar, si el registro es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Home](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2614-205&t=fdby7TzWnlT7tONt-4)

En esta pagina se espera poder ver:
  - timeline del usuario.

### [Pagina de un post](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2620-273&t=fdby7TzWnlT7tONt-4)

En esta pagina se tiene que ver:
  - La imagen en grande del post.
  - Quien lo realizo.
    - Si soy el owner del post tengo que poder eliminarlo o editarlo
    - Si lo quiero eliminar se necesita modal de confirmación ([Ejempplo](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2620-835&t=fdby7TzWnlT7tONt-4))
  - Tengo que ver los comentarios del post
    - Al hacer click sobre la imagen o el nombre del dueño del comentario tengo que ir a su perfil.
  - Tengo que poder dejar un comentario.
  - Tengo que poder dejar/quitar un `Me gusta`

### [Search](https://www.figma.com/design/JtwYMUGxCtQfBjIxL31I8w/Gog?node-id=2473-249&t=3izFqX8mwjXmofuc-4)

En esta pagina se tiene que mostrar el texto buscado y sus resultados, en el caso de que el resultado no tenga usuario o post directamente no aparecera esa seccion, si el resultado de la busqueda da que las dos listas son vacias, tendra que aparecer un mensaje diciendo que no se encontraron resultados.

### [Pagina de Usuario no logueado](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2620-512&t=fdby7TzWnlT7tONt-4)

En esta pagina se muestra informacion del usuario en cuestion y sus posts, ademas de la opcion de seguir/dejar de seguir.

### [Pagina del usuario](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2620-397&t=fdby7TzWnlT7tONt-4)

En esta pagina se muestra infromacion del usuario logueado mostrando sus posts, ademas de la opcion para desloguearse.

### [Crear post](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2620-757&t=fdby7TzWnlT7tONt-4)

En esta pagina se tiene que poder agregar un post, al cargar la url de la imagen se tiene que poder hacer un preview de dicha imagen.
Al terminar de crear me tiene que llevar al post nuevo.

### [Editar post](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=2620-808&t=fdby7TzWnlT7tONt-4)

En esta pagina se tiene que poder ver el post cargado originalmente y poder modificarlo.
Al terminar de editar me tiene que llevar a ese mismo post.

