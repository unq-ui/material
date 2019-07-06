# Consigna

* **Levantar el ambiente**.
* **Agregar ventana para agregar ToDo's**.
* *(opcional) Eliminar un ToDo.*
* *(opcional) Agregar signUp.*
* *(opcional) Agregar editar un ToDo.*

Hacer los puntos obligatorios y **al menos un opcional**.

# Levantar ambiente

* Descargar react native cli
  > npm install -g react-native-cli
* Descargar java JDK 8 (tiene que ser JDK!)
* Descargar AndroidStudio
* Linux
  * Agregar variables de entorno 
  ```bash
    export ANDROID_HOME=$HOME/Android/Sdk
    export PATH=$PATH:$ANDROID_HOME/emulator
    export PATH=$PATH:$ANDROID_HOME/tools
    export PATH=$PATH:$ANDROID_HOME/tools/bin
    export PATH=$PATH:$ANDROID_HOME/platform-tools
  ```
  * Instalar watchman (consola)
  ```bash
    $ git clone https://github.com/facebook/watchman.git
    $ cd watchman
    $ git checkout v4.9.0  # the latest stable release
    $ ./autogen.sh
    $ ./configure
    $ make
    $ sudo make install
  ```
* Crear un dispositivo en AndroidStudio
* Crear en la carpeta **android** del proyecto un archivo '.env'
  ```
    HOST=192.168.1.6 <- Su ip local
  ```
* Correr proyecto
  > react-native run-android

# Herramienta opcional para ver logs *Reactotron*

## Instalacion

* https://github.com/infinitered/reactotron/releases
