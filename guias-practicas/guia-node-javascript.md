# Guía inicial Node.js + Entorno de desarrollo

Esta guía esta pensada para preparar el entorno para trabajar con JavaScript y Node.js, las tecnologias base que vamos a utilizar a lo largo de toda la materia.

---

## ¿Qué es Node.js?

Node.js es un entorno de ejecución que permite correr JavaScript fuera del navegador. Es ampliamente usado para:

- Crear APIs (backend)
- Automatizar tareas
- Desarrollar herramientas de línea de comandos
- Aplicaciones en tiempo real (chat, streaming, etc.)
- Aplicaciones Full Stack

Entre otras.

---

## Instalación de Node.js

### Opción simple (en Windows y Mac)

1. Ir a: https://nodejs.org/en/download
2. Descargar la versión **LTS (Long Term Support)**
3. Ejecutar el instalador .exe en Windows o el Package Installer .pkg en MacOS
4. Verificar instalación usando PowerShell o Linea de comando:

```bash
node -v
npm -v
````

### Opcion recomendada (MacOS y GNU/Linux)
1. Ir a: https://nodejs.org/en/download
2. Descargar la versión **LTS (Long Term Support)** utilizando **nvm** y una *terminal*
3. Ejecutar los comandos que muestra la pagina. En este caso por ejemplo:
```bash
# Download and install nvm:
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.4/install.sh | bash

# in lieu of restarting the shell
\. "$HOME/.nvm/nvm.sh"

# Download and install Node.js:
nvm install 24

# Verify the Node.js version:
node -v # Should print "v24.14.0".

# Verify npm version:
npm -v # Should print "11.9.0".
```

### Opcion recomendada (Windows)
1. Ir a: https://nodejs.org/en/download
2. Descargar la versión **LTS (Long Term Support)** utilizando **Chocolatey** y PowerShell o Linea de comando.
3. Ejecutar los comandos que muestra la pagina. En este caso por ejemplo:
```bash
# Download and install Chocolatey:
powershell -c "irm https://community.chocolatey.org/install.ps1|iex"

# Download and install Node.js:
choco install nodejs --version="24.14.0"

# Verify the Node.js version:
node -v # Should print "v24.14.0".

# Verify npm version:
npm -v # Should print "11.9.0".
```

---

## ¿Qué es NVM (Node Version Manager)?

NVM es un programita que nos permite manejar de versiones de Node.
Cuando avanzás, vas a necesitar cambiar de versión de Node según el proyecto.

### MacOS y GNU/Linux
* Repo: [https://github.com/nvm-sh/nvm](https://github.com/nvm-sh/nvm)

### Opciones para Windows

#### NVM para Windows (Node Version Manager)

Permite instalar y cambiar versiones fácilmente.

* Repo: [https://github.com/coreybutler/nvm-windows](https://github.com/coreybutler/nvm-windows)

**Ejemplo de uso:**

```bash
nvm install 24
nvm use 24
```

---

#### NVS (Node Version Switcher)

Alternativa más flexible, multiplataforma.

* Repo: [https://github.com/jasongin/nvs](https://github.com/jasongin/nvs)

```bash
nvs add 24
nvs use 24
```

---

#### NDM (Node Desktop Manager)

Interfaz gráfica para manejar versiones.

* Ideal para quienes prefieren evitar la terminal.

---

## ¿Qué es NPM?

NPM (Node Package Manager) es el gestor de paquetes de Node.js.

Sirve para:

* Instalar librerías
* Gestionar dependencias
* Ejecutar scripts

### Comandos básicos

```bash
npm init         # Inicializa un proyecto
npm install      # Instala dependencias
npm install <paquete>
npm run <script> # Ejecuta scripts
```

---

## Estructura básica de un proyecto

```bash
mi-proyecto/
│
├── node_modules/      # Dependencias instaladas
├── package.json      # Configuración del proyecto
├── package-lock.json # Versiones exactas
├── src/              # Código fuente
└── index.js          # Punto de entrada
```

---

## package.json explicado

Ejemplo:

```json
{
  "name": "mi-proyecto",
  "version": "1.0.0",
  "description": "Proyecto de ejemplo",
  "main": "index.js",
  "scripts": {
    "start": "node index.js",
    "dev": "node --watch index.js"
  },
  "dependencies": {},
  "devDependencies": {}
}
```

### Campos importantes

* `name`: nombre del proyecto
* `version`: versión actual
* `main`: archivo principal
* `scripts`: comandos ejecutables
* `dependencies`: librerías necesarias
* `devDependencies`: herramientas de desarrollo

---

## Sintaxis básica de JavaScript (repaso rápido)

### Variables

```js
let nombre = "Tomás";
const edad = 30;
```

### Funciones

```js
function saludar(nombre) {
  return `Hola ${nombre}`;
}

// Arrow function
const saludar = (nombre) => `Hola ${nombre}`;
```

### Condicionales

```js
if (edad > 18) {
  console.log("Mayor de edad");
} else {
  console.log("Menor de edad");
}
```

### Arrays y objetos

```js
const lista = [1, 2, 3];

const persona = {
  nombre: "Tomás",
  edad: 30
};
```

---

## Editores recomendados

### Visual Studio Code (Este es el que usamos nosotros)

* Gratis
* Muy popular
* Gran cantidad de extensiones

---

### ZED

* Editor moderno y muy rápido, de los creadores del editor Atom
* Ideal para workflows livianos
* Aún en crecimiento

---

### IntelliJ / WebStorm (JetBrains)

* Muy potente
* Excelente autocompletado y refactorización
* Licencia educativa gratuita disponible con el email de @alu.unq.edu.ar

---

## Buenas prácticas iniciales

* Usar siempre control de versiones (Git)
* Nombrar variables claramente
* Separar lógica en archivos/carpetas
* No mezclar lógica de negocio con infraestructura
* Leer y tratar de comprender errores (clave para aprender)

---

## Primer programa en Node.js

Crear un archivo `index.js`:

```js
console.log("Hola mundo desde Node.js");
```

Ejecutar:

```bash
node index.js
```
