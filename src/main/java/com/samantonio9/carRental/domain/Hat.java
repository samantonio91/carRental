package com.samantonio9.carRental.domain;

/** Sombrero in the original UML. */
public class Hat {
    private final String name;

    public Hat(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Hat name must not be blank");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
