package com.godel.ds.interfaces;

public interface CustomList <T> {
    int size();
    boolean isEmpty();
    void add(T value);
    void add(int index, T value);
    void remove(int index);
    T get(int index);
}
