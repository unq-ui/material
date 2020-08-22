# UIs » TP1 » 1°C 2020

## UNQFlix » Desktop Arena

UNQFlix es una plataforma de streaming de películas y series. Para el TP1 se requiere
la construcción de una aplicación de escritorio (desktop) para poder administrar
el contenido de la aplicación. La aplicación deberá conocer el listado de películas,
series y usuarios registrados.

### Información de Modelo

#### Película

- Estado (habilitada /deshabilitada)
- Descripción
- Poster (URL a la imágen)
- Título
- Video (URL al video)
- Tiempo de duración
- Lista de actores
- Lista de directores
- Lista de categorías (una categoría es un string)
- Contenido relacionado

#### Serie

- Estado (habilitada / deshabilitada)
- Descripción
- Poster (URL a la imágen)
- Título
- Temporadas
- Lista de categorías (una categoría es un string)
- Contenido relacionado

#### Temporada

- Descripción
- Nombre de la temporada (o número)
- Capítulos
- Poster (URL de la imágen)

#### Capítulo

- Descripción
- Nombre del capítulo
- Tiempo de duración
- Video (URL)
- Miniatura del capítulo (url de la imágen)

#### Usuario

- Nombre
- Correo electrónico (único, no editable)
- Contraseña

### ENUNCIADO - Interfaz Desktop con Arena

Se solicita la construcción de las siguiente funcionalidades:

1. ABM de Series. Para dar de alta una Serie, luego al entrar en dicha Serie,
   se puede crear Temporadas y al entrar a cada Temporadas se puede crear un Capítulo).
2. Buscador de series: se debe poder realizar búsquedas por nombres de series y mostrar los resultados.

**Para ayudar la comprensión del enunciados y darse una idea de como serían las pantallas adjuntamos los siguientes mockups:**

[https://www.figma.com/proto/HJg1GqKGTTSlTwmFN3qANK/unqflix-arena?node-id=1%3A40&scaling=min-zoom]
