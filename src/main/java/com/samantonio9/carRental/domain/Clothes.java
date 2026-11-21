package com.samantonio9.carRental.domain;

/** Ropa in the original UML. */
public class Clothes {
    private final String name;

    public Clothes(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Clothes name must not be blank");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
