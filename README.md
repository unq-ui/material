# Material de Cursada

> **Universidad Nacional de Quilmes » Construcción de Interfaces de Usuario**

## Info útil

* [Notas](https://docs.google.com/spreadsheets/d/e/2PACX-1vRN1aEH2bmXDQ6yC17ScQeNpbJF_Gsczk9DplZNG5wXb7NW9MHRDZFrYp8PBn2KZAzlWgTNh0fmU2eM/pubhtml?gid=1387586583&single=true)
* [Clases](Clases.md)
* [Calendario](Calendar.md)
* [Arena Framework](http://arena.uqbar-project.org/)
* [Kotlin by example](https://play.kotlinlang.org/byExample/overview)
* [Javalin](https://javalin.io/)
* [Node.js](https://nodejs.org)
* [React](https://reactjs.org)
* [Ejemplos de .gitignore](https://github.com/github/gitignore)

## Trabajos Prácticos

Dominio: PRÓXIMAMENTE

* [TP1 » Desktop](https://github.com/unq-ui/2021s1-twitter)
* TP2 » API
* TP3 » Web

## Trabajo Final Integrador

> PRÓXIMAMENTE

## Guías Prácticas

* [Práctica 1 » Modelado de Dominios](guias-practicas/practica1.md)
* [Práctica 2 » Interfaces Desktop](guias-practicas/practica2.md)
* [Práctica 3 » APIs REST](guias-practicas/practica3.md)

## Apuntes

* [Cookbook Arena » Guía de Inicio](apuntes/CookBook_Arena_Inicial.md)

## Ejemplos

### Dominios

* [Cajero Automático](https://github.com/unq-ui/ej-dominio-atm)
* [Geo Localización](https://github.com/unq-ui/ej-dominio-geo)
* [TV Shows](https://github.com/unq-ui/ej-dominio-tv-shows)

### Desktop

* [Cajero Automático](https://github.com/unq-ui/ej-desktop-atm)
* [Conversor](https://github.com/unq-ui/ej-desktop-converter)
* [Geo Localización](https://github.com/unq-ui/ej-desktop-geo)
* [Phone](https://github.com/unq-ui/ej-desktop-phone)
* [Time Counter](https://github.com/unq-ui/ej-desktop-time-counter)
* [TV Shows](https://github.com/unq-ui/ej-desktop-tv-shows)
* [Twitter](https://github.com/unq-ui/ej-desktop-twitter)
* [Unquify](https://github.com/unq-ui/ej-desktop-unquify)
* [ToDo List](https://github.com/unq-ui/ej-desktop-ToDoList)

### API REST

* [Anime](https://github.com/unq-ui/ej-api-anime)
* [CRUD User](https://github.com/unq-ui/ej-api-crud-user)
* [Geo Localización](https://github.com/unq-ui/ej-api-geo)
* [Mail Server](https://github.com/unq-ui/ej-api-mail-server)
* [ToDo List](https://github.com/unq-ui/ej-api-todo-list)
* [Twitter](https://github.com/unq-ui/ej-api-twitter)
* [Twitter con Testing](https://github.com/unq-ui/ej-api-twitter-testing)

### Javascript

* [DOM Manipulation](https://github.com/unq-ui/ej-javascript-dom)
* [Local Data](https://github.com/unq-ui/ej-javascript-local-data)
* [Remote Data](https://github.com/unq-ui/ej-javascript-remote-data)

### Web » ReactJS

* [Anime](https://github.com/unq-ui/ej-web-anime)
* [Contador](https://github.com/unq-ui/ej-web-counter)
* [Login & Beers](https://github.com/unq-ui/ej-web-login-and-beers)
* [Mail Client](https://github.com/unq-ui/ej-web-mail-client)
* [Routing](https://github.com/unq-ui/ej-web-routing)
* [ToDo List](https://github.com/unq-ui/ej-web-todo-list)
* [ToDo List Remote](https://github.com/unq-ui/ej-web-todo-list-remote)
* [Twitter](https://github.com/unq-ui/ej-web-twitter)

### Mobile » React Native

* [ToDo List](https://github.com/unq-ui/ej-mobile-todo-list)
* [UNQ IMDB](https://github.com/unq-ui/ej-mobile-unq-imdb)

## Ejemplos de pom.xml

* [Kotlin Domain](ejemplos/pom.kotlin.domain.xml)
* [Kotlin Arena](ejemplos/pom.kotlin.arena.xml)
* [Kotlin Javalin](ejemplos/pom.kotlin.javalin.xml)

## Desktop » Arena

### Vm arguments

```bash
-Djava.system.class.loader=org.uqbar.apo.APOClassLoader
```

## Aplicación Web » ReactJS

Primero es necesario instalar [Node.js](https://nodejs.org/en/download/) según su SO.

Una vez instalado ir al directorio donde va a estar el proyecto y ejecutar:

```bash
npx create-react-app mi-proyecto-web
cd mi-proyecto-web
npm start
```

Comandos _npm_ que vienen por default:

* `npm start`: Levanta la aplicación en (generalmente) localhost:3000
* `npm test`: Corre los tests (generalmente en modo _watcher_)
* `npm build`: Construye la aplicación en _modo production_ y guarda los archivos
               en el directorio `./dist`
* `npm eject`: Quita las configuraciones default de react. No se recomienda utilizarlo.

[notas-google-sheet]: <https://docs.google.com/spreadsheets/d/e/2PACX-1vTjUKlQyIgbbuerYqgFAshf_AHTnQAsetkX2QQKi6oyNm0lX8zIkbTl8uu3LHk14meGIYuRMGu5J8bO/pubhtml?gid=1387586583&single=true>
