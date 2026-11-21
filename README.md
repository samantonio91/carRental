# Car Rental UML — Java OOP Exercise

> **Status:** a Java 17 **object-oriented programming exercise**, not a production-ready car rental API. This branch implements the actual methods and relationships from [the provided UML diagram](images/uml-car-rental.png).

The diagram is labeled *Sistema de alquiler de coches online*, but its classes primarily demonstrate **composition, aggregation, inheritance, interfaces, association, and dependency**. Building booking REST endpoints is a separate future project, not part of this UML.

## Implemented UML methods

| Original UML | English code | Java class |
| --- | --- | --- |
| `Humano.setHead(Cabeza)` | `setHead(Head)` | `Human` |
| `Humano.setBody(Cuerpo)` | `setBody(Body)` | `Human` |
| `Humano.display()` | `display()` | `Human` |
| `Conductor.addCar(Coche)` | `addCar(Car)` | `Driver` |
| `Conductor de autobús.wearClothes(Ropa)` | `wearClothes(Clothes)` | `BusDriver` |
| `Conductor de autobús.wearHat(Sombrero)` | `wearHat(Hat)` | `BusDriver` |
| `Conductor de autobús.show()` | `show()` | `BusDriver` |
| `Vehículo.run()` | `run()` | `Vehicle` interface |
| `Barco.run()` | `run()` | `Boat` |
| `Coche.addDriver(Conductor)` | `addDriver(Driver)` | `Car` |

`Car.run()` implements the `Vehicle.run()` contract as well.

## Relationships

- **Composition:** `Human` owns references to `Head` and `Body` (assigned through the UML setters).
- **Inheritance:** `BusDriver extends Driver extends Human`; `Bus` and `Taxi` extend `Car`.
- **Aggregation:** `BusDriver` references externally created `Clothes` and `Hat`.
- **Interface implementation:** `Car` and `Boat` implement `Vehicle`.
- **Association:** `Driver.addCar()` and `Car.addDriver()` keep both sides synchronized and do not allow duplicate references.
- **Dependency:** `Car.runWith(Petroleum)` accepts a fuel type as a method argument without storing it.

### Design notes / Clarifications

The UML uses a dashed realization arrow for `Conductor` → `Humano` even though `Humano` is shown as a concrete class: Java uses **class inheritance** here. Some multiplicities say 1:1 while the driver/car properties are arrays: this implementation follows the **array/list** properties and permits multiple associations. Since the UML does not specify return types, `run()`, `display()` and `show()` return strings for observable, testable behavior.

This exercise deliberately does **not** expose HTTP endpoints or use JPA/MySQL yet. The original Spring Boot entry point is preserved, but the learning model is pure Java. The previous, incomplete entity classes were replaced by the UML domain classes. A later REST/database layer can be added separately.

## Run tests

Requires JDK 17. No database or credentials are needed.

```bash
./gradlew test
```

On Windows:

```powershell
gradlew.bat test
```

CI runs these tests on each pull request.

## What's next?

- Build an actual rental domain (customers, vehicles, reservations, availability) in a separate feature.
- Introduce REST controllers, validation, persistence and integration testing only when that domain is designed.
- If persisted data from the older JPA prototype exists, plan an explicit migration rather than assuming these pure-Java classes map to the old tables.

## Spanish reference

See [README.es.md](README.es.md). Original UML: [images/uml-car-rental.png](images/uml-car-rental.png).
