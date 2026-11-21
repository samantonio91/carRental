package com.samantonio9.carRental.domain;

/** A component owned by a Human (Cuerpo in the original UML). */
public class Body {
    private final String name;

    public Body(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Body name must not be blank");
        }
        this.name = name.trim();
    }

    public String getName() {
        return name;
    }
}
