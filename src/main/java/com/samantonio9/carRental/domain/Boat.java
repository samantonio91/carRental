package com.samantonio9.carRental.domain;

/** Barco: a second implementation of Vehicle. */
public class Boat implements Vehicle {
    private final String name;

    public Boat(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Boat name must not be blank");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }

    @Override
    public String run() {
        return "Boat " + name + " is running";
    }
}
