package com.babii.shipmonk.api;

import java.util.Collection;

public interface SortedLinkedList<T> {

    SortedLinkedList<T> sortedLinkedListFrom(Collection<T> collection);

    void addAll(T ...values);

    SortedLinkedList<T> reverse();

    T get(int index);

    int getSize();

    ObjectsType getSupportedType();

    Collection<T> toCollection();

}
