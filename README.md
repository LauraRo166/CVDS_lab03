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

Sobre la rama feature/addBook se trabaja el caso de uso añadir libro:

![Captura de pantalla 2024-09-05 204833](https://github.com/user-attachments/assets/6b125890-0ec9-4d15-adb8-27a1efe1c438)


Se tiene en cuenta tres pruebas unitarias:
1. Debería añadir un libro
2. Debería añadir libro existente (aumenta la cantidad del mismo)
3. No debería añadir libro nulo

![image](https://github.com/user-attachments/assets/8ae61032-faad-4abb-9dd2-b1adba537fc5)

La prueba correspondiente a libro nulo pasa porque el método como tal tiene como retorno false por defecto. 


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


- ***Método returnLoan***

Sobre la rama feature/returnLoan se trabaja el caso de uso retornar préstamo.

Se tienen en cuenta tres pruebas unitarias:
1. Debería retornar préstamo correctamente.
2. Debería retornar nulo si el préstamo no existe.
3. Debería retornar préstamo si ya está de vuelta (no debe cambiar su estado).


![image](https://github.com/user-attachments/assets/a12fe77c-99ba-4161-8192-b3f6abb83ff6)
  
De 2: esta prueba está pasando porque el método returnLoan retorna nulo por defecto, sin implementación.

De 3: esta prueba está con error porque se referencia a un objeto nulo. Se soluciona con la implementación.


***Todas las pruebas pasan:***

Luego de implementar todos los métodos necesarios, ya no hay errores ni fallas:

![image](https://github.com/user-attachments/assets/062e924a-2d2d-4839-95f4-6ba0938a6d34)


## JACOCO

Al verificar la cobertura, se evidencia que es superior al 80%:


![Captura de pantalla 2024-09-06 002436](https://github.com/user-attachments/assets/44b82813-5954-4570-91c1-072652691cfe)


## SONARQUBE

La integración con Sonar se generó con el siguiente comando:

```xml
mvn verify sonar:sonar -D sonar.token=sqa_b0e25416af7abaf088f0a8218c17a438b12fcf53
```

![image](https://github.com/user-attachments/assets/5b7f614f-db98-49ab-8b01-fd1f17e57b3d)


![image](https://github.com/user-attachments/assets/256aa29b-48a0-4cb1-b6a7-614e7fdfcfc8)

Así se ve el reporte:

![image](https://github.com/user-attachments/assets/15a081f2-0d38-4212-b16a-5dafd54880f4)

Y desde Docker:

![image](https://github.com/user-attachments/assets/4fafa345-4ecb-4b5e-b3f4-6255a8aa6e11)



