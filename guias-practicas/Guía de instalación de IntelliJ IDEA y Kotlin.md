# Guía de instalación de IntelliJ IDEA y primer proyecto en Kotlin

## Instalación de IntelliJ IDEA

Para instalar IntelliJ IDEA, lo primero que debemos hacer es descargar el instalador desde la página oficial de JetBrains. Para ello, accedemos a la página de descargas de IntelliJ IDEA y seleccionamos la versión Community, que es gratuita.

[Link de descarga de InstelliJ IDEA](https://www.jetbrains.com/idea/download/)

También contamos con la opción de descargar la version Ultimate, con el email institucional de la universidad, para ello debemos acceder a la pagina de JetBrains y crear una cuenta con el email institucional de la universidad, una vez creada la cuenta, debemos acceder a la pagina de descargas de IntelliJ IDEA y seleccionar la version Ultimate.

[Podemos registrarnos con email institucional acá.](https://www.jetbrains.com/community/education/#students)

Una vez descargado el instalador, lo ejecutamos y seguimos los pasos del asistente de instalación.

Si estamos usando un sistema operativo basado en GNU/Linux, al descargar IntelliJ vamos a ver que nos descarga un archivo con extension `.tar.gz`. Debemos descomprimirlo en la carpeta que queramos. Entramos a la carpeta donde descomprimimos el archivo y buscamos la carpeta llamada `bin` y ejecutamos el archivo `idea.sh`. Con esto ya podemos empezar a usar IntelliJ IDEA.

## Creación de un proyecto en Kotlin

Una vez instalado IntelliJ IDEA, lo ejecutamos y nos aparecerá la siguiente pantalla de bienvenida. En ella, seleccionamos la opción `New Project`.

![Pantalla de bienvenida](./_img_intellij/Screenshot%202023-08-17%20at%2017.21.55.png)

En la siguiente pantalla, verificamos que este seleccionada la opción `Maven Archetype` de la columna izquierda llamada `Generators`.

![Generadores](./_img_intellij/Screenshot%202023-08-17%20at%2017.23.31.png)

Maven es una herramienta de gestión de paquetes y dependencias. Un arquetipo es una plantilla de proyecto, que nos permite crear un proyecto con una estructura y dependencias predefinidas.

---

Si no tenemos una JDK instalada en nuestro equipo, debemos instalarla. IntelliJ nos brinda la opcion de instalarla desde la misma pantalla, para ello debemos seleccionar la opcion `Download JDK`.

![Instalacion JDK](./_img_intellij/Screenshot%202023-08-17%20at%2017.24.15.png)

Recomendamos instalar la JDK 1.8, ya que es la version mas estable y usada. Tambien recomendamos utilizar la implementacion de Amazon, llamada Corretto.

Verificar que sea la version 1.8 y no la version 18.

![Instalacion JDK](./_img_intellij/Screenshot%202023-08-17%20at%2017.24.49.png)

![Instalacion JDK 2](./_img_intellij/Screenshot%202023-08-17%20at%2017.25.12.png)

Continuamos con el apartado Catalog, en el cual debemos seleccionar la opcion `Maven Central` para que nos muestre todos los arquetipos disponibles.

![Catalog](./_img_intellij/Screenshot%202023-08-17%20at%2017.26.13.png)

En el campo `Archetype` debemos escribir `kotlin-archetype-jvm` y seleccionar el arquetipo `kotlin-archetype-jvm`, como vemos en la imagen.

![Arquetipo](./_img_intellij/Screenshot%202023-08-17%20at%2017.26.55.png)

![Pantalla final](./_img_intellij/Screenshot%202023-08-17%20at%2017.27.07.png)

Le damos al boton Create y se nos abre una ventana con el proyecto. Lo primero que vemos es el `pom.xml` que es el archivo de configuracion de Maven. En el podemos ver las dependencias del proyecto, en este caso, por ejemplo, vemos la dependencia de Kotlin.

![pom.xml](./_img_intellij/Screenshot%202023-08-17%20at%2017.27.26.png)

Esperamos a que se instalen todas las dependencias y ya podemos empezar a programar.

![Descargas de dependencias](./_img_intellij/Screenshot%202023-08-17%20at%2017.27.43.png)

Nos dirigimos a la carpeta `src/main/kotlin` y vemos que hay un archivo llamado `Hello.kt`.

![Hello.kt](./_img_intellij/Screenshot%202023-08-17%20at%2017.29.40.png)

En la parte superior derecha, vamos a ver un boton verde de Play, que nos permite ejecutar el proyecto. Le damos al boton y si todo esta bien, vemos que se ejecuta el proyecto y nos muestra por consola el mensaje `Hello, World`.

![Correr proyecto](./_img_intellij/Screenshot%202023-08-17%20at%2017.30.00.png)

![Hello World](./_img_intellij/Screenshot%202023-08-17%20at%2017.30.21.png)

Con esto ya verificamos que podemos ejecutar el proyecto y comenzar a programar.