package com.babii.shipmonk.api;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortedLinkedListLibraryTest {

    @Test
    void testEmptySortedLinkedListCreation() {
        final SortedLinkedList<String> sortedLinkedList = new SortedLinkedListLibrary<>();
        assertEquals(0, sortedLinkedList.getSize());
        assertNull(sortedLinkedList.getSupportedType());
    }

    @Test
    void testSortedLinkedListCreationFromIntegerCollection() {
        final List<Integer> list = new ArrayList<>(List.of(3, 5, 9, 1, 2, 0));

        final SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedListLibrary<>(list);

        assertEquals(list.size(), sortedLinkedList.getSize());
        assertEquals(ObjectsType.INTEGER, sortedLinkedList.getSupportedType());

        list.sort(Integer::compareTo);
        assertEquals(list, sortedLinkedList.toCollection());
    }


    @Test
    void testSortedLinkedListCreationFromStringCollection() {
        final List<String> list = new ArrayList<>(List.of("3", "a", "21", "ADS", "b1", "zda"));

        final SortedLinkedList<String> sortedLinkedList = new SortedLinkedListLibrary<>(list);

        assertEquals(list.size(), sortedLinkedList.getSize());
        assertEquals(ObjectsType.STRING, sortedLinkedList.getSupportedType());

        list.sort(String::compareTo);
        assertEquals(list, sortedLinkedList.toCollection());
    }

    @Test
    void testSortedLinkedListCreationFailure() {
        final List<Object> list = new ArrayList<>(List.of("3", 3, "21", "ADS", 2L, "zda"));

        assertThrows(IllegalArgumentException.class, () -> new SortedLinkedListLibrary<>(list));
    }
}
