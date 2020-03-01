> [Volver al índice](README.md#guias-practicas)

# Práctica 1 » Modelado de Dominios

Realizar los ejercicios utilizando Kotlin.
En todos los casos se espera que la resolución del ejercicio sea
realizada mediante el uso de TDD.

## Ejercio 1: Conversor

Escribir un programa que permita convertir distintas unidades de medidas.

1. Programar un objeto que permita convertir de millas a kilómetros.
2. Programar un objeto que permita convertir de kilómetros a millas.
3. Programar un objeto que permita convertir bidireccionalmente millas <-> kilómetros.
4. Programar un objeto que permita convertir de una unidad cualquiera a otra. Para ello
se deberá programar un conversor genérico que sea capaz de recibir el tipo de conversión deseada.

## Ejercio 2: Manejo de Strings

Programar el objeto `Str` que tenga la capacidad de realizar las siguientes acciones:

1. Dado un string, retornarlo al revés.
  _Ej:_ `revert("interfaces") == "secafretni"`
2. Dada una palabra, determinar si es capicúa. _Ej:_ `isPalindrome("interfaces") == false; isPalindrome("neuquen") == true`
3. Dado un string, retornar la cantidad de vocales que contiene. _Ej:_ `vowels("Ácido clorhídrico") == 7`
4. Dada una oración, retornar la cantidad de palabras que contiene. _Ej:_ `words("construcción de interfaces de usuario") == 5`
5. Dado un texto, retornar la cantidad de párrafos que contiene. Un párrafo comienza luego de un salto de línea.

## Ejercio 3: Usuario de Red Social

Escribir un programa que permita obtener información de un Usuario de una red social.
Características de los usuarios:

- Nombre y apellido
- Nombre de usuario
- E-Mail
- Fecha de nacimiento
- Seguidores
- Seguidos

A partir del diseño se debe poder:

1. Obtener la información básica (nombre, usuario, etc).
2. Calcular la edad.
3. Determinar si el e-mail registrado es de gmail.
4. Obtener los seguidores que a la vez son seguidos por ese usuario.

## Ejercio 4: Manejo de Colecciones

Programar el objeto `UIList` que tenga la capacidad de realizar las siguientes acciones:

1. Dada una lista de números, determinar si está ordenada.
   _Ej:_ `isSorted([1, 3, 2]) == false; isSorted([1, 2, 3]) == true; isSorted([3, 2, 1]) == true`
2. Dada una lista de números y un booleano `asc`, retornar una copia que esté ordenada.
   Si `asc == true`, la lista debe ser retornada de menor a mayor. Si `asc == false`, de mayor a menor.
3. Dada una lista de números, retornar una nueva lista que contenga solo aquellos números que son primos. _Ej:_ `filterPrimes([1, 2, 3, 4, 5]) == [2, 3, 5]`
4. Dada una lista de números, retornar una nueva lista que contenga las potencias de 2.
   _Ej:_ `powMap([1, 2, 3, 4, 5]) == [1, 4, 9, 16, 25]`
5. Dada una lista de números, retornar el resultado de sumar cada número previamente multiplicado por su posición en la lista. _Ej:_ `sumProdPos([1, 1, 2, 3, 5, 8]) == (1*1 + 1*2 + 2*3 + 3*4 + 5*5 + 8*6) == 94`
