# UIs » TP2 » 2°C 2023

# TikTok » React

Se debe realizar una pagina web con react.
Se brinda el siguiente ejemplo de la aplicacion: [Figma](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=23%3A1127&mode=design&t=yV9X91d9AUuFO9pW-1)

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```

## Comportamiento comun

### Navbar

- Icono de la aplicacion (con redireccion a la pagina Home).
- Search (al realizar la busqueda y dar enter tiene que redireccionar a Search).
- Si **no** estas logueado
  - Boton de login redirecciona al login 
  - Boton de register redirecciona al registro.
- Si esta logueado
  - Boton de crear post nuevo
  - Boton para ir al perfil del usuario logueado

### Sidebar

- For you: tiene que redireccionar a /home
- Following: Si tenemos usuario logueado tiene que ir a /following, si no tenemos usuario logueado tiene que pedir que te loguees.
- Friends: Si tenemos usuario logueado tiene que ir a /friends, si no tenemos usuario logueado tiene que pedir que te loguees.
- Explore: Tiene que mostrar los tags y seleccionar uno y mostrar los post de ese tag (por default el primero viene seleccionado)
- Profile: Si tenemos usuario logueado tiene que ir a /user/:id, si no tenemos usuario logueado tiene que pedir que te loguees.

## Paginas

### [Home](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=23-1304&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se espera poder ver:
  - los ultimos posteos
    - en cada post se tiene que poder dar like (si estoy logueado), ir al perfil del autor e ir al post en cuestion.
  
### [Login](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=72-1186&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Register](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=72-1323&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se espera que un nuevo usuario se pueda registrar, si el registro es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Post](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=36-414&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se tiene que mostrar la informacion del post.

- Se muestra el video,
- El usuario (tiene que llevarte al perfil de ese usuario)
- comentarios (tenes que poder dejar un comentario, si estas logueado).
- likes (poder dar likes, si estas logueado).

### [Search](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=56-2400&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se tiene que mostrar lo que busco el usuario junto a los usuarios y posts que dieron como resultado.

### [Following](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=24-1646&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se tiene que mostrar el timeline del usuario logueado. (si no se tiene un usuario logueado te tiene que mostrar el login)

### [Friends](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=54-1431&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se tiene que mostrar los amigos del usuario logueado. (si no se tiene un usuario logueado te tiene que mostrar el login)

### [Explore](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=54-573&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se tiene que mostrar los 10 tags mas usados y poder mostrar los post de ese tag seleccionado (por default, se selecciona el primer tag)

### [Crear post](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=72-1391&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina se tiene que poder crear un post, solo tienen que funcionar para usuarios logueados.

### [Pagina del usuario](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=54-1727&mode=design&t=yV9X91d9AUuFO9pW-4)

En esta pagina podemos ver las post de ese usuario y agregar/quitar amigos. (o desloguearte si estas viendo tu perfil)
