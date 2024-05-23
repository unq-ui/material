# UIs » TP3 » 1°C 2024

# TikTok » React Native

Se debe realizar una pagina web con react native.
Se brinda el siguiente ejemplo de la aplicacion: [Figma](https://www.figma.com/file/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?type=design&node-id=23%3A1127&mode=design&t=yV9X91d9AUuFO9pW-1)

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```

## Comportamiento comun

Toda accion que requiera tener un usuario logueado y no se tenga uno, tiene que ir al login.

## Tabs

### [Home](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2307-1335&t=oSLoTczi7ppDJGjY-4)

En esta pagina se espera poder ver:
  - los ultimos posteos
    - en cada post se tiene que poder dar like (si estoy logueado) e ir al perfil del autor.

### [Explore](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2309-1911&t=oSLoTczi7ppDJGjY-4)

En esta pagina se tiene que mostrar los 10 tags mas usados. Al precionar alguno me tiene que mostrar los post de ese tag (trend).

### [Crear post](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2309-2203&t=oSLoTczi7ppDJGjY-4)

En esta pagina se tiene que poder crear un post, solo tienen que funcionar para usuarios logueados.

### [Search](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2309-2268&t=oSLoTczi7ppDJGjY-4)

En esta pagina se tiene que mostrar lo que busco el usuario pero **solo los posts que dieron como resultado**.

### [Profile](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2309-2353&t=oSLoTczi7ppDJGjY-4)

En esta pagina se tiene que mostrar el usuario logueado.

## Paginas adicionales

### [Login](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2309-2589&t=oSLoTczi7ppDJGjY-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Register](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2309-2661&t=oSLoTczi7ppDJGjY-4)

En esta pagina se espera que un nuevo usuario se pueda registrar, si el registro es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Post](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2309-2406&t=oSLoTczi7ppDJGjY-4)

En esta pagina se tiene que mostrar la informacion del post.

- Se muestra el video,
- El usuario (tiene que llevarte al perfil de ese usuario)
- comentarios (tenes que poder dejar un comentario, si estas logueado).
- likes (poder dar likes, si estas logueado).

### [Pagina del usuario](https://www.figma.com/design/IJQ6YJ2CvkWqs7eag0deyW/Tiktok?node-id=2309-2536&t=oSLoTczi7ppDJGjY-4)

En esta pagina podemos ver las post de ese usuario y agregar/quitar amigos.
