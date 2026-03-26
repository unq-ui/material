# UIs » TP2 » 1°C 2026

# Instagram » React

Se debe realizar una pagina web con react.
Se brinda el siguiente ejemplo de la aplicacion: [Figma](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=15-315&t=I2wTC2WpyzYiAhZJ-1)

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```

## Importante

* No se puede hacer uso de **Contextos**.
* No se pueden definir hooks propios (aka custom hooks).

Si se utilizan lo antes mencionado, el tp estara desaprobado y **no** se realizara la correccion.

### Comportamiento comun

Toda url que quiera entrar el usuario y no se encuentre logueado me tendra que llevar a la pantalla de login.

### Paginas

#### [Login](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=1-2&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

#### [Registro](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=5-24&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se espera que un nuevo usuario se pueda registrar, si el registro es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

#### [Home](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=10-12&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se tiene que ver:
  - Navbar
  - Timeline del usuario logueado.
  - Al hacer click sobre una imagen o sobre los comentarios me tiene que llevar a la pagina del post.
  - Al hacer click en el `Me gusta` tiene que agregar/quitar el me gusta e indicar de alguna forma que es lo que esta sucediendo. (Una forma podria ser pintar el corazon de color)
  - Al hacer click sobre la imagen o el nombre del dueño del post tengo que ir a su perfil.

#### [Post](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=15-206&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se tiene que ver:
  - La imagen en grande del post.
  - Quien lo realizo.
    - Si soy el owner del post tengo que poder eliminarlo o editarlo ([Ejemplo](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=15-315&t=I2wTC2WpyzYiAhZJ-4))
    - Si lo quiero eliminar se necesita modal de confirmación ([Ejempplo](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=18-99&t=I2wTC2WpyzYiAhZJ-4))
  - Tengo que ver los comentarios del post
    - Al hacer click sobre la imagen o el nombre del dueño del comentario tengo que ir a su perfil.
  - Tengo que poder dejar un comentario.
  - Tengo que poder dejar/quitar un `Me gusta`

#### [Agregar Post](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=19-176&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se tiene que poder agregar un post, al cargar la url de la imagen se tiene que poder hacer un preview de dicha imagen.

#### [Editar Post](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=19-262&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se tiene que poder ver el post cargado originalmente y poder modificarlo.

#### [Search](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=19-310&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se tiene que mostrar el texto buscado y sus resultados, en el caso de que el resultado no tenga usuario o post directamente no aparecera esa seccion, si el resultado de la busqueda da que las dos listas son vacias, tendra que aparecer un mensaje diciendo que no se encontraron resultados.

#### [Perfil de un usuario](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=15-33&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se muestra informacion del usuario en cuestion y sus posts, ademas de la opcion de seguir/dejar de seguir.

#### [Perfil del usuario logueado](https://www.figma.com/design/e3Uldm1LAgEVJMa2Ccrfr9/Instagram?node-id=15-159&t=I2wTC2WpyzYiAhZJ-4)

En esta pagina se muestra infromacion del usuario logueado mostrando sus posts.



