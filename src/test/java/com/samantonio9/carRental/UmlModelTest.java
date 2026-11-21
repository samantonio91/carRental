package com.samantonio9.carRental;

import com.samantonio9.carRental.domain.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UmlModelTest {

    @Test
    void humanComposesHeadAndBodyAndDisplaysThem() {
        Human human = new Human();
        Head head = new Head("head");
        Body body = new Body("body");
        human.setHead(head);
        human.setBody(body);
        assertSame(head, human.getHead());
        assertSame(body, human.getBody());
        assertTrue(human.display().contains("head"));
        assertTrue(human.display().contains("body"));
    }

    @Test
    void compositionRequiresNonNullComponents() {
        Human human = new Human();
        assertThrows(NullPointerException.class, () -> human.setHead(null));
        assertThrows(NullPointerException.class, () -> human.setBody(null));
    }

    @Test
    void driverAddsCarAndKeepsBidirectionalAssociation() {
        Driver driver = new Driver();
        Car car = new Car();
        driver.addCar(car);
        driver.addCar(car);
        assertEquals(1, driver.getCars().size());
        assertEquals(1, car.getDrivers().size());
        assertSame(driver, car.getDrivers().get(0));
        assertThrows(UnsupportedOperationException.class, () -> driver.getCars().clear());
    }

    @Test
    void carCanAddDriverFromEitherSideWithoutDuplicates() {
        Car car = new Car();
        Driver driver = new Driver();
        car.addDriver(driver);
        car.addDriver(driver);
        assertEquals(1, car.getDrivers().size());
        assertEquals(1, driver.getCars().size());
        assertSame(car, driver.getCars().get(0));
    }

    @Test
    void driverInheritsHumanAndBusDriverInheritsDriver() {
        BusDriver driver = new BusDriver();
        assertInstanceOf(Driver.class, driver);
        assertInstanceOf(Human.class, driver);
        driver.setHead(new Head("head"));
        assertNotNull(driver.getHead());
    }

    @Test
    void busDriverAggregatesClothesAndHatAndShowsState() {
        BusDriver driver = new BusDriver();
        Clothes clothes = new Clothes("uniform");
        Hat hat = new Hat("cap");
        driver.wearClothes(clothes);
        driver.wearHat(hat);
        assertSame(clothes, driver.getClothes());
        assertSame(hat, driver.getHat());
        assertTrue(driver.show().contains("uniform"));
        assertTrue(driver.show().contains("cap"));
    }

    @Test
    void busDriverCanBeAssociatedWithBus() {
        BusDriver driver = new BusDriver();
        Bus bus = new Bus();
        driver.addCar(bus);
        assertTrue(bus.getDrivers().contains(driver));
        assertTrue(driver.getCars().contains(bus));
    }

    @Test
    void vehiclesRunThroughTheirInterface() {
        Vehicle car = new Car();
        Vehicle boat = new Boat("Ocean");
        assertTrue(car.run().contains("Car"));
        assertTrue(boat.run().contains("Ocean"));
    }

    @Test
    void busAndTaxiInheritCarAndVehicleBehavior() {
        Vehicle bus = new Bus();
        Vehicle taxi = new Taxi();
        assertInstanceOf(Car.class, bus);
        assertInstanceOf(Car.class, taxi);
        assertEquals("Car is running", bus.run());
        assertEquals("Car is running", taxi.run());
    }

    @Test
    void petroleumIsOnlyAMethodDependencyOfCar() {
        Car car = new Car();
        assertTrue(car.runWith(new Petroleum("diesel")).contains("diesel"));
        assertThrows(NullPointerException.class, () -> car.runWith(null));
    }

    @Test
    void nullAssociationsAreRejected() {
        assertThrows(NullPointerException.class, () -> new Driver().addCar(null));
        assertThrows(NullPointerException.class, () -> new Car().addDriver(null));
    }

    @Test
    void namesCannotBeBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Head(" "));
        assertThrows(IllegalArgumentException.class, () -> new Body(null));
        assertThrows(IllegalArgumentException.class, () -> new Clothes(""));
        assertThrows(IllegalArgumentException.class, () -> new Hat(" "));
        assertThrows(IllegalArgumentException.class, () -> new Boat(""));
        assertThrows(IllegalArgumentException.class, () -> new Petroleum(""));
    }
}
