package com.godel.ds.implementation;

import com.godel.ds.exceptions.EmptyStructureException;
import com.godel.ds.interfaces.GenericQueue;

public class ArrayQueue<E> implements GenericQueue<E> {
    private int front;
    private E[] data;
    private int size;

    public ArrayQueue() {
        data = (E[]) (new Object[1]);
        size = 0;
        front = 0;
    }
    @Override
    public void add(E target) {
        if (isFull()) {
            stretch();
        }
        int index = (front + size) % data.length;
        data[index] = target;
        System.out.println("Added "+  data[index]);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new EmptyStructureException("Stack is empty");
        }
        E result = data[front];
        System.out.println("removed "+data[front]);
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    boolean isFull() {
        return size == data.length;
    }

    void stretch() {
        E[] newData = (E[]) (new Object[data.length * 2]);
        for (int i = 0; i < data.length; i++) {
            int index = (front + i) % data.length;
            newData[i] = data[index];
        }
        data = newData;
        front = 0;
    }

}
