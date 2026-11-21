package com.samantonio9.carRental.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Conductor: inherits Human and keeps an association to its cars. */
public class Driver extends Human {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) {
        Objects.requireNonNull(car, "car must not be null");
        if (!cars.contains(car)) {
            cars.add(car);
        }
        // Keep both ends of the UML association consistent.
        if (!car.getDrivers().contains(this)) {
            car.addDriver(this);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
