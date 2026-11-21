package com.samantonio9.carRental.domain;

import java.util.Objects;

/** A component owned by a Human (Cabeza in the original UML). */
public class Head {
    private final String name;

    public Head(String name) {
        this.name = requireName(name);
    }

    public String getName() {
        return name;
    }

    private static String requireName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Head name must not be blank");
        }
        return name.trim();
    }
}
