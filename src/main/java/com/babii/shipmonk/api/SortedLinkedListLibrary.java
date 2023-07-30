package com.babii.shipmonk.api;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;

import static com.babii.shipmonk.api.ObjectsType.objectsTypeFrom;

public final class SortedLinkedListLibrary<T> implements SortedLinkedList<T> {

    private final Comparator<T> comparator = new SortedLinkedListComparator<T>().getSortedLinkedListComparator();

    private final LinkedList<T> linkedList = new LinkedList<>();
    private ObjectsType supportedType;
    private int size = 0;

    public ObjectsType getSupportedType() {
        return supportedType;
    }

    @Override
    public int getSize() {
        return size;
    }

    public SortedLinkedListLibrary() {
        // Creates an empty sorted linked list
    }

    public SortedLinkedListLibrary(Collection<T> collection) {
        this();
        this.sortedLinkedListFrom(collection);
    }

    @SafeVarargs
    @Override
    public final void addAll(T... values) {
        size = size + values.length;
        if (size < 1) {
            return;
        }

        supportedType = Optional.ofNullable(supportedType).orElse(objectsTypeFrom(values[0]));
        Arrays.stream(values).forEach(this::add);
    }

    @Override
    public SortedLinkedList<T> reverse() {
        Collections.reverse(this.linkedList);
        return this;
    }

    @Override
    public T get(int index) {
        return this.linkedList.get(index);
    }

    public void printValues() {
        linkedList.forEach(System.out::println);
    }

    public SortedLinkedList<T> sortedLinkedListFrom(Collection<T> collection) {
        final var arrayList = collection.toArray();
        addAll((T[]) arrayList);
        return this;
    }

    public Collection<T> toCollection() {
        return new LinkedList<>(this.linkedList);
    }

    private void add(T value) {
        if (supportedType != objectsTypeFrom(value)) {
            throwIllegalArgumentException();
        }

        int pointer = 0;
        if (linkedList.isEmpty()) {
            linkedList.add(value);
            return;
        }
        while(pointer < linkedList.size()) {
            if (comparator.compare(linkedList.get(pointer), value) > 0) {
                linkedList.add(pointer, value);
                return;
            }
            pointer++;
        }
        if (pointer == linkedList.size()) {
            linkedList.add(value);
        }
    }

    private void throwIllegalArgumentException() {
        throw new IllegalArgumentException("Can't mix values of different types");
    }


    private static class SortedLinkedListComparator<T> {
        private Comparator<T> comparator;

        private Comparator<T> getSortedLinkedListComparator() {
            return (o1, o2) -> {
                if (o1 instanceof String stringValue) {
                    return stringValue.compareTo((String) o2);
                }
                if (o1 instanceof Integer integerValue) {
                    return integerValue.compareTo((Integer) o2);
                }
                throw new IllegalArgumentException();
            };
        }
    }
}
