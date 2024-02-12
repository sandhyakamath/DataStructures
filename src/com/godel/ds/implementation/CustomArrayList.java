package com.godel.ds.implementation;

import com.godel.ds.interfaces.CustomList;
import java.util.Arrays;
@SuppressWarnings("unchecked")
public class CustomArrayList<T> implements CustomList<T> {
    final int defaultCapacity = 10;
    private T[] elements;
    private int size;

    public CustomArrayList() {
        this.elements = (T[]) new Object[defaultCapacity];
        this.size = 0;
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative value");
        }
        this.elements = (T[]) new Object[initialCapacity];
        this.size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(T value) {
        ensureCapacity();
        elements[size] = value;
        size++;
    }

    @Override
    public void add(int index, T value) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index+1, size-index);
        elements[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        T element = elements[index];
        System.arraycopy(elements, index+1, elements, index, (size-index)-1);
        System.out.println("Deleted: "+ element);
        size--;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Index out of bounds");
        }
        return elements[index];
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
