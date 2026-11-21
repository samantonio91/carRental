package com.samantonio9.carRental.domain;

import java.util.Objects;

/** Composition of Head and Body, matching the Humano class in the UML. */
public class Human {
    private Head head;
    private Body body;

    public void setHead(Head head) {
        this.head = Objects.requireNonNull(head, "head must not be null");
    }

    public void setBody(Body body) {
        this.body = Objects.requireNonNull(body, "body must not be null");
    }

    public Head getHead() {
        return head;
    }

    public Body getBody() {
        return body;
    }

    /** Returns displayable text rather than writing to the console. */
    public String display() {
        return "Human [head=" + (head == null ? "unset" : head.getName())
                + ", body=" + (body == null ? "unset" : body.getName()) + "]";
    }
}
