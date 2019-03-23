# Construcción de Interfaces de Usuario :: Material de Cursada

## Links útiles

* [Página de la materia](http://interfaces.web.unq.edu.ar/)
* [Página de la materia en cuatrimestres anteriores](https://algo3.uqbar-project.org/)
* [Kotlin by example](https://play.kotlinlang.org/byExample/overview)
* [Ejemplos de .gitignore](https://github.com/github/gitignore)

## Vm arguments para Arena

```
-Djava.system.class.loader=org.uqbar.apo.APOClassLoader
```

## Ejemplos de pom.xml para tener a mano

### Sólo Dominio

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>ar.edu.unq.ui</groupId>
    <artifactId>proyecto</artifactId>
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

### Proyecto de Arena

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
    <artifactId>proyecto-desktop</artifactId>
    <version>1.0</version>

    <parent>
        <groupId>org.uqbar-project</groupId>
        <artifactId>arena-xtend-parent</artifactId>
        <version>3.6.3</version>
    </parent>

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