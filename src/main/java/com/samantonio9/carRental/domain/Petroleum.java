package com.samantonio9.carRental.domain;

/** Petróleo in the UML: a method-level dependency of Car. */
public class Petroleum {
    private final String type;

    public Petroleum(String type) {
        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Petroleum type must not be blank");
        }
        this.type = type.trim();
    }

    public String getType() {
        return type;
    }
}
