package com.samantonio9.carRental.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/** Coche in the UML. A Car implements Vehicle and associates with Drivers. */
public class Car implements Vehicle {
    private final List<Driver> drivers = new ArrayList<>();

    public void addDriver(Driver driver) {
        Objects.requireNonNull(driver, "driver must not be null");
        if (!drivers.contains(driver)) {
            drivers.add(driver);
        }
        // Keep both ends of the UML association consistent.
        if (!driver.getCars().contains(this)) {
            driver.addCar(this);
        }
    }

    public List<Driver> getDrivers() {
        return Collections.unmodifiableList(drivers);
    }

    @Override
    public String run() {
        return "Car is running";
    }

    /** Demonstrates dependency on Petroleum without owning it as a field. */
    public String runWith(Petroleum petroleum) {
        Objects.requireNonNull(petroleum, "petroleum must not be null");
        return run() + " using " + petroleum.getType();
    }
}
