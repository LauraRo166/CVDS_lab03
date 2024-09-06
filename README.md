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




- ***Método loanABook***

Sobre la rama feature/loanABook se trabaja el caso de uso prestar libro:


![image](https://github.com/user-attachments/assets/ec62cbae-6ce3-4c7e-8f6f-e0e91c45437e)


Se tienen en cuenta 5 pruebas unitarias:
1. Prestar un libro
2. No debería volver a prestar un libro si el usuario ya lo tiene
3. No debería prestar libro si usuario no existe
4. No debería prestar libro a usuario si el libro no existe
5. No debería prestar libro si este no está registrado para prestar, por ejemplo que haya cero disponibles para prestar.

![image](https://github.com/user-attachments/assets/05bc7037-b48a-45a2-9c37-7a10fef86d96)

Hay dos pruebas con errores porque el método que se está probando retorna null, por lo tanto, al usar método getStatus se produce error por nulidades en objetos de tipo Loan.


- ***Método returnLoad***


