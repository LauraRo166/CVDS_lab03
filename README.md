# CVDS_lab03


## CREACIÓN - PROYECTO CON MAVEN

```yml
Grupo: edu.eci.cvds 
Artefacto: Library 
Paquete: edu.eci.cvds.tdd 
archetypeArtifactId: maven-archetype-quickstart 
```

![image](https://github.com/user-attachments/assets/06919335-39cd-4bb2-a16d-899baa5ac917)


### DEPENDENCIA JUNIT5

Se agregan las siguientes secciones de código al ```pom.xml```:

```xml
<properties>
  <maven.compiler.target>21</maven.compiler.target>
  <maven.compiler.source>21</maven.compiler.source>
</properties>
```

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter-api</artifactId>
  <version>5.11.0</version>
  <scope>test</scope>
</dependency>
```


## PRUEBAS UNITARIAS Y TDD

Se crea la clase de pruebas ```LibraryTest```.


- ***Método addBook***

Para este caso, se consideran dos pruebas unitarias validando que se añada un libro nuevo y un libro existente.
Se usa el siguiente comando para compilar el proyecto.

```xml
mvn clean package
``` 

Se visualiza que efectivamente las pruebas fallaron:

![image](https://github.com/user-attachments/assets/7022222b-0623-4251-84fe-6771af432076)



- ***Método loanABook***





- ***Método returnLoad***



