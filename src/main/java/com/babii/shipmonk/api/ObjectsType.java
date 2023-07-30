package com.babii.shipmonk.api;

import java.util.Arrays;

public enum ObjectsType {

    INTEGER,
    STRING;

    public static <T> ObjectsType objectsTypeFrom(T object) {
        if (object instanceof Integer) {
            return INTEGER;
        }
        if (object instanceof String) {
            return STRING;
        }
        throw new IllegalArgumentException("Don't accept types other than " + Arrays.asList(values()));
    }

}