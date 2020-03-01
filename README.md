# Construcción de Interfaces de Usuario

**_Material de Cursada_**

## Links útiles

* [Página de la materia](http://interfaces.web.unq.edu.ar/)
* [Página de la materia en cuatrimestres anteriores](https://algo3.uqbar-project.org/)
* [Kotlin by example](https://play.kotlinlang.org/byExample/overview)
* [Javalin](https://javalin.io/)
* [NodeJS](https://nodejs.org)
* [ReactJS](https://reactjs.org)
* [Ejemplos de .gitignore](https://github.com/github/gitignore)

## Guías Prácticas

* [Práctica 1 » Modelado de Dominios](guias-practicas/practica1.md)
* [Práctica 2 » Interfaces Desktop](guias-practicas/practica2.md)
* [Práctica 3 » APIs REST](guias-practicas/practica3.md)
* Práctica 4 » Interfaces Web

## Ejemplos

### Dominios » Kotlin

* [Cajero Automático](https://github.com/unq-ui/ej-dominio-atm)
* [Geo Localización](https://github.com/unq-ui/ej-dominio-geo)
* [TV Shows](https://github.com/unq-ui/ej-dominio-tv-shows)

### Desktop » Arena

* [Cajero Automático](https://github.com/unq-ui/ej-desktop-atm)
* [Conversor](https://github.com/unq-ui/ej-desktop-converter)
* [Geo Localización](https://github.com/unq-ui/ej-desktop-geo)
* [Phone](https://github.com/unq-ui/ej-desktop-phone)
* [Time Counter](https://github.com/unq-ui/ej-desktop-time-counter)
* [TV Shows](https://github.com/unq-ui/ej-desktop-tv-shows)
* [Twitter](https://github.com/unq-ui/ej-desktop-twitter)
* [Unquify](https://github.com/unq-ui/ej-desktop-unquify)

### API REST » Javalin

* [Geo Localización](https://github.com/unq-ui/ej-api-geo)

### Web » HTML

TODO

### Web » Javascript

TODO

### Web » React

TODO

### Mobile » React Native

TODO

## Domain » Kotlin

### Ejemplo de pom.xml básico

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>ar.edu.unq.ui</groupId>
    <artifactId>mi-proyecto</artifactId>
    <version>1.0</version>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

## Desktop » Arena

### Vm arguments

```bash
-Djava.system.class.loader=org.uqbar.apo.APOClassLoader
```

### Ejemplos de pom.xml básico

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <repositories>
        <repository>
            <id>uqbar</id>
            <name>Uqbar</name>
            <url>http://maven.uqbar.org/releases/</url>
        </repository>
    </repositories>

    <modelVersion>4.0.0</modelVersion>

    <groupId>ar.edu.unq.ui</groupId>
    <artifactId>mi-proyecto-desktop</artifactId>
    <version>1.0</version>

    <parent>
        <groupId>org.uqbar-project</groupId>
        <artifactId>arena-xtend-parent</artifactId>
        <version>3.6.3</version>
    </parent>

    <dependencies>
        <!-- Si necesita su proyecto de dominio lo agregan acá como dependencia -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
            <scope>test</scope>
        </dependency>
    </dependencies>

</project>
```

## Api REST » Javalin

### Ejemplo de pom.xml básico

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>ar.edu.unq.ui</groupId>
    <artifactId>mi-proyecto-api</artifactId>
    <version>1.0</version>

    <dependencies>
        <!-- Si necesita su proyecto de dominio lo agregan acá como dependencia -->
        <dependency>
            <groupId>io.javalin</groupId>
            <artifactId>javalin</artifactId>
            <version>2.8.0</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>1.7.26</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.9.8</version>
        </dependency>
    </dependencies>

</project>
```

## Aplicación Web » ReactJS

Primero es necesario instalar node según su SO: https://nodejs.org/en/download/

Una vez instalado node, ir al directorio donde va a estar el proyecto y ejecutar:

```bash
npx create-react-app mi-proyecto-web
cd mi-proyecto-web
npm start
```

Comandos _npm_ que vienen por default:

* `npm start`: Levanta la aplicación en (generalmente) localhost:3000
* `npm test`: Corre los tests (generalmente en modo _watcher_)
* `npm build`: Construye la aplicación en _modo production_ y guarda los archivos en el directorio `./dist`
* `npm eject`: Quita las configuraciones default de react. No se recomienda utilizarlo.
