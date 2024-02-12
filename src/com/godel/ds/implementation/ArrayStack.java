package com.godel.ds.implementation;

import com.godel.ds.exceptions.EmptyStructureException;
import com.godel.ds.interfaces.GenericStack;

@SuppressWarnings("unchecked")
public class ArrayStack<E> implements GenericStack<E> {
    int topIndex;
    E[] data;


    public ArrayStack() {
        data = (E[]) (new Object[1]);
        topIndex = -1;
    }
    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStructureException("CustomList is empty");
        }
        else
            return data[topIndex];
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStructureException("CustomList is empty");
        } else {
            E result = data[topIndex];
            topIndex--;
            return result;
        }
    }

    @Override
    public void push(E target) {
        if (isFull()) {
            this.stretch();
        }
        data[++topIndex] = target;
    }

    boolean isFull() {
        return data.length == topIndex + 1;
    }

    void stretch() {
        E[] newData = (E[]) (new Object[data.length * 2]);
        int i =0;
        System.arraycopy(data, i+1, newData, i, data.length-1-i);
        data = newData;
        System.out.println(data.length);
    }
}
