package jsjf;

import jsjf.exceptions.EmptyCollectionException;

public class LinkedQueue<T> implements QueueADT<T> {

    private int count;
    private LinearNode<T> head, tail;

    public LinkedQueue() {
        count = 0;
        head = tail = null;
    }


    @Override
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<>(element);
        if (isEmpty()) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        count++;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        T result = head.getElement();
        head = head.getNext();
        count--;

        if (isEmpty()) {
            tail = null;
        }

        return result;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return head.getElement();
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinearNode<T> currentNode = head;
        while (currentNode != null) {
            result.append(currentNode.getElement().toString());
            currentNode = currentNode.getNext();
        }
        return result.toString();
    }

}
