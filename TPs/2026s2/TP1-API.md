# UIs » TP1 » 2°C 2026

# Mercadolibre » React

Se debe realizar una API utilizando [ExpressJS](https://expressjs.com/). Se debe armar los siguientes requests especificados en https://swaggers-virid.vercel.app/mercadolibre

## Modelo

https://github.com/unq-ui/mercadolibre-model-js

## Enunciado

* Se tienen que implementar el [swagger](https://swaggers-virid.vercel.app/mercadolibre)

### Formatos de datos:

* Cuando aparezca una fecha se tiene que enviar y recibir con el siguiente formato: `YYYY/MM/DD`. La unica fecha distinta es el `expirationDate` que tiene que ser `YYYY/MM`.

### Requisitos minimos
- Respetar el contrato (nombre de los endpoints, propiedades de los objetos, status codes)
- Status Code 4xx en todo caso que se reciba un error por parte del sistema
- Implementar esquemas de validacion para los endpoints que necesitan de informacion mediante un `body`
- Separar responsabilidades en controladores
- El token de sesión tiene vencimiento configurable
- La configuración del proyecto tiene que estar definida en un `.env`
- Si el proyecto no tiene el archivo `.env` este **NO** tendria que levantar
