# UIs » Trabajo Final Integrador (TFI) » 1°C 2022

Este `TFI` tiene carácter de **exámen integrador** y debe realizarse
de **manera individual**.

## Enunciado

Tienen que programar un juego de _Piedra, Papel, Tijera, Lagarto o Spock_,
el cual se hizo conocido gracias a Sheldon Cooper pero en realidad fue
inventado por Sam Kass y Karen Bryla.

![sheldon]

### Reglas del Juego

Pueden ver las reglas en la [página de los creadores][creators] o
bien en la [wiki de The Big Bang Theory][wiki], pero es simplemente
como el _Piedra, Papel o Tijera_ con más casos:

* Tijera corta a Papel
* Papel tapa a Piedra
* Piedra aplasta a Lagarto
* Lagarto envenena a Spock
* Spock rompe a Tijera
* Tijera decapita a Lagarto
* Lagarto devora a Papel
* Papel desautoriza a Spock
* Spock vaporiza a Piedra
* y como siempre, Piedra aplasta a Tijera

### Requerimientos No Funcionales

* El trabajo **tiene** que estar programado en React
* Tienen que crear un repositorio en GitHub
  - Si es privado nos tienen que dar acceso a todos los docentes
  - El proyecto debe llamarse `unq-ui-<nombre-apellido>-trabajo-final`
  - Ejemplo: `unq-ui-leandro-dilorenzo-trabajo-final`
  - Ruta completa: `https://github.com/leandrojdl/unq-ui-leandro-dilorenzo-trabajo-final`
* Tiene que poder verse el progreso en los commits
* Tiene que existir un README.md que explique:
  - Cómo descargar e instalar el proyecto
  - Cómo ejecutarlo localmente
* La Interfaz del Juego tiene que ser lo suficientemente
  intuitiva para no necesitar explicación

### Requerimientos Funcionales Mínimos

Detallamos la funcionalidad **mínima** que se espera
que tenga el juego, pero ustedes tienen la libertad
de agregarle mejoras siempre y cuando se respete el espíritu del juego.

* Poder jugar una partida contra la computadora
* Poder elegir (de alguna forma) piedra, papel, tijera, lagarto o Spock
* Mostrar (de alguna forma) quién ganó la partida
* Mostrar (de alguna forma) qué eligió la computadora luego de terminada la partida
* La elección de la computadora tiene que estar _randomizada_
  - No vale dejar un valor fijo _hardcodeado_
  - Tampoco vale "mirar" la elección del jugador para elegir la jugada
* Que el código cumpla con los estándares mínimos que planteamos
  a lo largo de la materia

### Extras

> No hace falta que sean todos, cada _extra_ aporta.

* Interfaz Responsive
* Posibilidad de jugar más de una partida
* Mantener un contador de victorias de cada participante en la misma sesión
* Posibilidad de jugar entre 2 humanos (de forma local)
  - Manteniendo el anonimato de las elecciones de cada jugador

## Condiciones de Aprobación del TFI

Para aprobar el TFI (con 4) es necesario que:

* La aplicación levante
* Se pueda jugar por lo menos una partida
* El juego cumpla con los Requerimientos Funcionales Mínimos
* Exista la información necesaria para poder instalar y correr el project

## Condiciones de Aprobación de la Materia

* **Promocionan** si
  - Todos los `TPs >= 7` y `TFI >= 4`
  - En tal caso se promedian las notas
  - Pudiendo influir la nota de concepto
* **Pendiente de Aprobación** (PA) si
  - Todos los `TPs >= 7` y `TFI < 4`
  - O algún `TP` entre `[4, 7)` y `TFI >= 4`
* **Desaprobado** sino

## Entrega del Trabajo Final Integrador

* **Fecha Límite**: Miércoles 12/07/2023
* **Formato de Entrega**:
  - Generar un release en el proyecto en github
  - Enviar un mail a `tpi-doc-uis@listas.unq.edu.ar` con el link del tag
  - De no cumplirse con las pautas se considerá **Ausente**

[sheldon]: https://upload.wikimedia.org/wikipedia/commons/thumb/a/ad/Pierre_ciseaux_feuille_l%C3%A9zard_spock_aligned.svg/240px-Pierre_ciseaux_feuille_l%C3%A9zard_spock_aligned.svg.png
[wiki]: https://bigbangtheory.fandom.com/wiki/Rock,_Paper,_Scissors,_Lizard,_Spock
[creators]: (http://www.samkass.com/theories/RPSSL.html)
