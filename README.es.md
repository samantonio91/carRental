# Car Rental — ejercicio de programación orientada a objetos

Este repositorio implementa los métodos y las relaciones del [diagrama UML original](images/uml-car-rental.png), usando **Java 17**, nombres de clases y métodos en **inglés** y pruebas con **JUnit 5**.

**No es una API REST de reservas ni una aplicación terminada:** el diagrama se enfoca en relaciones de POO y no describe controladores para alquiler de vehículos.

## Relación entre clases

- **Composición:** `Human` contiene `Head` y `Body`; expone `setHead()`, `setBody()`, `display()`.
- **Herencia:** `Driver extends Human`, `BusDriver extends Driver`, `Bus/Taxi extends Car`.
- **Agregación:** `BusDriver` usa objetos `Clothes` y `Hat` mediante `wearClothes()` y `wearHat()`.
- **Interfaz:** `Vehicle.run()` es implementado por `Car` y `Boat`.
- **Asociación:** `Driver.addCar()` y `Car.addDriver()` mantienen ambos lados sincronizados.
- **Dependencia:** `Car.runWith(Petroleum)` utiliza un objeto `Petroleum` sin guardarlo como atributo.
- **Presentación:** `Human.display()` y `BusDriver.show()` devuelven mensajes de texto.

Los 10 métodos expresamente indicados en el UML están presentes, además de métodos de consulta necesarios para probarlos. El diagrama contiene ciertas ambigüedades (como la cardinalidad 1:1 frente a las listas de coches/conductores), que se documentan en el README en inglés.

## Ejecutar pruebas

Java 17 y Gradle Wrapper. No necesitas MySQL ni variables de entorno.

```bash
./gradlew test
```

En Windows: `gradlew.bat test`.

## Siguiente etapa

Diseñar un dominio de alquiler real antes de implementar API REST, base de datos y reservaciones. No se deben confundir los métodos de este UML con funcionalidades de un sistema comercial.
