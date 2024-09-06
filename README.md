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

Para este caso de uso se trabaja desde la rama feature/addBook:

![image](https://github.com/user-attachments/assets/b553e4a8-012e-4472-aaf7-4bdcabe62de2)


Ahora, se consideran tres pruebas unitarias validando que se añada un libro nuevo, un libro existente y uno nulo.
Se usa el siguiente comando para compilar el proyecto.

```xml
mvn clean package
``` 

Se visualiza que efectivamente las pruebas fallaron:


![image](https://github.com/user-attachments/assets/36df37e8-83ff-4c8b-92f7-b77e95e56738)

Fallaron dos pruebas.

***Aclaración:***

La prueba correspondiente a añadir un libro nulo pasó porque el método addBook actualmente retorna siempre false. 



- ***Método loanABook***





- ***Método returnLoad***



