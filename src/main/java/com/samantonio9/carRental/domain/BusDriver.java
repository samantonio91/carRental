package com.samantonio9.carRental.domain;

import java.util.Objects;

/** Conductor de autobús: specializes Driver and aggregates Clothes and Hat. */
public class BusDriver extends Driver {
    private Clothes clothes;
    private Hat hat;

    public void wearClothes(Clothes clothes) {
        this.clothes = Objects.requireNonNull(clothes, "clothes must not be null");
    }

    public void wearHat(Hat hat) {
        this.hat = Objects.requireNonNull(hat, "hat must not be null");
    }

    public Clothes getClothes() {
        return clothes;
    }

    public Hat getHat() {
        return hat;
    }

    public String show() {
        return "Bus driver [clothes=" + (clothes == null ? "unset" : clothes.getName())
                + ", hat=" + (hat == null ? "unset" : hat.getName())
                + ", cars=" + getCars().size() + "]";
    }
}
