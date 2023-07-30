package com.babii.shipmonk.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjectsTypeTest {

    @Test
    void testConvertFromInteger() {
        Integer n = 3;
        assertEquals(ObjectsType.INTEGER, ObjectsType.objectsTypeFrom(n));
    }

    @Test
    void testConvertFromString() {
        String n = "3";
        assertEquals(ObjectsType.STRING, ObjectsType.objectsTypeFrom(n));
    }

    @Test
    void testFailingConversion() {
        Long n = 3L;
        assertThrows(IllegalArgumentException.class, () -> ObjectsType.objectsTypeFrom(n));
    }
}
