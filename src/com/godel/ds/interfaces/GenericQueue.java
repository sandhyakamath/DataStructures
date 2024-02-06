package com.godel.ds.interfaces;

public interface GenericQueue<E> {
    public void add(E target);
    public boolean isEmpty();
    public E remove();
}
