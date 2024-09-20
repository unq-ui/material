# UIs » TP2 » 2°C 2024

# Mercadolibre » React


Se debe realizar una pagina web con react.
Se brinda el siguiente ejemplo de la aplicacion: [Figma](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=2-165&t=NsCL3HIugv7d3Xsf-1)

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```

## Importante

* No se puede hacer uso de **Contextos**.
* No se pueden definir hooks propios (aka custom hooks).

Si se utilizan lo antes mencionado, el tp estara desaprobado y **no** se realizara la correccion.

## Comportamiento comun

### Navbar

- Icono de la aplicacion (con redireccion a la pagina Home).
- Search (al realizar la busqueda y dar enter tiene que redireccionar a Search).
- Categorías redirecciona a la pagina de categorias
- Si **no** estas logueado
  - Boton de `Creá tu cuenta` redirecciona al registro. 
  - Boton de `Ingreá redirecciona al login.
- Si esta logueado
  - Boton de [Nombre de usuario] redirecciona a tu usuario.
  - Boton de carrito redirecciona a tu carrito. (extra, agregar la cantidad de elementos que tiene en el carrito).

## Paginas

### [Home](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=2-246&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se espera poder ver:
  - los productos
    - en cada producto se tiene que poder dar like (si estoy logueado), ir al perfil del vendedor e ir al producto en cuestion.
    - las precio de las cuotas es el precio dividido en 12.
  
### [Login](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=24-1196&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Register](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=24-1239&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se espera que un nuevo usuario se pueda registrar, si el registro es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Producto](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=12-1272&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se tiene que mostrar la informacion del producto.

- Se muestan todas las imagenes, haciendo click en una imagen tiene que cargarla en la seccion de imagen mas grande.
- El vendedor (tiene que redireccionar a la pagina del vendedor)
- preguntas (tenes que poder dejar una pregunta, si estas logueado).
- likes (poder dar likes, si estas logueado).
- Si sos el vendedor de este producto, tenes que poder dejar las respuestas a las preguntas.

### [Search](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=9-584&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se tiene que mostrar lo que busco el usuario.

### [Categories](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=4-218&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se tiene que mostrar todas las categorias del sistema. [Iconos de las categorias](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=4-467&t=NsCL3HIugv7d3Xsf-4)

### [Categoria](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=9-341&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se tiene que mostrar los productos de esa categoria.
  - en cada producto se tiene que poder dar like (si estoy logueado), ir al perfil del vendedor e ir al producto en cuestion.
  - las precio de las cuotas es el precio dividido en 12.

### [Vendedor](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=9-717&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se tiene que mostrar los productos del vendedor.
  - en cada producto se tiene que poder dar like (si estoy logueado), ir al perfil del vendedor e ir al producto en cuestion.
  - las precio de las cuotas es el precio dividido en 12.

### [User logueado](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=9-912&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se tiene que mostrar los productos likeados, los vendidos, los comprados, y sus productos que tienen en venta.
  - en cada producto se tiene que poder dar like (si estoy logueado), ir al perfil del vendedor e ir al producto en cuestion.
  - las precio de las cuotas es el precio dividido en 12.

### [Carrito](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=11-1020&t=NsCL3HIugv7d3Xsf-4)

En esta pagina se tiene que mostrar los productos que tienen en el carrito, modificar y eliminar los productos.

### [Agregar producto](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=24-1295&t=NsCL3HIugv7d3Xsf-4)

En esta pagina tenemos que poder agregar un producto, al crear el producto me tiene que llevar a la pagina de este producto.

### [Editar producto](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=24-1483&t=NsCL3HIugv7d3Xsf-4)

En esta pagina tenemos que poder editar un producto, al terminar la edicion del producto me tiene que llevar a la pagina de este producto.

### [Compra](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=178-1437&t=7ksUB0zfmF7F6AHf-4)

En esta pagina se tendra que ver el monto de la compra y los inputs para realizar una compra. Al terminar la operación te tendra que llevar a la home.

