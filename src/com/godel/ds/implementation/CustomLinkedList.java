package com.godel.ds.implementation;

import com.godel.ds.interfaces.CustomList;
@SuppressWarnings("unchecked")
public class CustomLinkedList<T> implements CustomList<T> {
    Node<T> head;
    int size;

   public CustomLinkedList () {
        this.head = null;
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
        Node<T> newNode = new Node<>(value);
        if (size == 0)
            this.head = newNode;
       else {
           Node<T> currentNode = this.head;
           while (currentNode.nextNode != null)
                currentNode = currentNode.nextNode;
           currentNode.nextNode = newNode;
       }
       size++;
    }

    @Override
    public void add(int index, T value) {
        Node<T> newNode = new Node<>(value);
        Node<T> currentNode = this.head;
        for (int i = 0 ; i < index - 1; i++)
            currentNode = currentNode.nextNode;
        newNode.nextNode = currentNode.nextNode;
        currentNode.nextNode = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        Node<T> currentNode = head;
        for(int i = 0; i < index - 2; i++) {
            currentNode = currentNode.nextNode;
        }

        currentNode.nextNode = currentNode.nextNode.nextNode;
    }

    @Override
    public T get(int index) {
        Node<T> currentNode = head;
        for(int i = 0; i < index - 1; i++) {
            currentNode = currentNode.nextNode;
        }
        return currentNode.data;
    }

    private static class Node<T> {
        T data;
        Node<T> nextNode;

        Node(T data) {
            this.data = data;
            this.nextNode = null;
        }
    }
}
