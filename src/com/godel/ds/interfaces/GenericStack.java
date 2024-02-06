package com.godel.ds.interfaces;

public interface GenericStack<E> {
    boolean isEmpty();
    E peek();
    E pop();
    void push(E target);
}
