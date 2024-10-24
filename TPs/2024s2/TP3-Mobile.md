# UIs » TP3 » 2°C 2024

# Mercadolibre » ReactNative


Se debe realizar una pagina web con react native.
Se brinda el siguiente ejemplo de la aplicacion: [Figma](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3650-1472)

```
Se puede hacer cambios en la api, estos cambios TIENEN que estar aclarados y justificados en un README
```

## Comportamiento comun

Si no estamos loguado, toda accion que requiera un usuario logueado tendra que redirigirme al login.

## Secciones

### [Home](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3655-1580&t=o2RcS5ErkZIrl511-4)

En esta seccion se espera poder ver:
  - los productos
    - en cada producto se tiene que poder dar like (si estoy logueado) e ir al producto en cuestion.
    - las precio de las cuotas es el precio dividido en 12.
  
### [Categories](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3655-1762&t=o2RcS5ErkZIrl511-4)

En esta seccion se tiene que mostrar todas las categorias del sistema. [Iconos de las categorias](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=4-467&t=NsCL3HIugv7d3Xsf-4)

Al hacer click en alguna se tiene que navegar a la categoria.

**Importante, el navbar desaparece!!**

### [Search](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3655-2266&t=o2RcS5ErkZIrl511-4)

En esta seccion se ve el input (*plus: dejar fijo el input en la pantalla apesar del scroll*) y los resultados de dicha busqueda, esta se renderiza en la misma seccion.

### [Cart](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3656-631&t=o2RcS5ErkZIrl511-4)

En esta seccion se tiene que mostrar los productos que tienen en el carrito, modificar y eliminar los productos.
Si no estoy logueado me tiene que redireccionar al login.

### [User](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3656-2367&t=o2RcS5ErkZIrl511-4)

En esta pagina se tiene que mostrar un acceso para ver los productos likeados, los vendidos, los comprados, y sus productos que tienen en venta.

### [User - Sin sesion](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3656-2230&t=o2RcS5ErkZIrl511-4)

En esta pagina se espera que el usuario pueda loguearse a la aplicacion, si el logueo es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [User- Register](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3656-2324&t=o2RcS5ErkZIrl511-4)

En esta pagina se espera que un nuevo usuario se pueda registrar, si el registro es correcto redireccionar a la home, si se encuentra algun error, informar al usuario del error obtenido.

### [Producto](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3656-3047&t=o2RcS5ErkZIrl511-4)

En esta seccion se tiene que mostrar la informacion del producto.

- Se muestan todas las imagenes, haciendo press en una imagen tiene que cargarla en la seccion de imagen mas grande.
- El vendedor.
- preguntas (tenes que poder dejar una pregunta, si estas logueado).
- Si sos el vendedor de este producto, tenes que poder dejar las respuestas a las preguntas.


### [Categoria/id](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3655-2008&t=o2RcS5ErkZIrl511-4)

En esta pagina se tiene que mostrar los productos de esa categoria.
  - en cada producto se tiene que poder dar like (si estoy logueado) e ir al producto en cuestion.
  - las precio de las cuotas es el precio dividido en 12.
  - Tener en cuenta que el back me lleva a la lista de categorias.
  - el navbar desaparece.
/MercadoLibre?node-id=11-1020&t=NsCL3HIugv7d3Xsf-4)


### [Compra](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3656-2096&t=o2RcS5ErkZIrl511-4)

En esta seccion se tendra que ver el monto de la compra y los inputs para realizar una compra. Al terminar la operación te tendra que llevar a la home.
Tener en cuenta: 
  - el back me lleva al carrito.
  - el navbar desaparece.

### [Liked/Sales/Purchases/My Products](https://www.figma.com/design/oauLoRKzswvzectxA7Juhn/MercadoLibre?node-id=3656-2441&t=o2RcS5ErkZIrl511-4)

En esta seccion se ven los productos que tiene el usuario (segun corresponda, Liked/Sales/Purchases/My Products).
Tener en cuenta: 
  - el back me lleva al user.
  - el navbar desaparece.
