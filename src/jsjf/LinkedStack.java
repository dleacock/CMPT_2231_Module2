package jsjf;

import jsjf.exceptions.EmptyCollectionException;

public class LinkedStack<T> implements StackADT<T> {

    private int count;
    private LinearNode<T> top;

    public LinkedStack() {
        count = 0;
        top = null;
    }

    @Override
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    @Override
    public T pop() throws EmptyCollectionException {
        if (isEmpty()){
            throw new EmptyCollectionException("stack");
        }
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    public T peek() throws EmptyCollectionException {
        if (isEmpty())
            throw new EmptyCollectionException("stack");

        return top.getElement();
    }

    public boolean isEmpty()
    {
        return (count == 0);
    }

    public int size() {
        return count;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        LinearNode current = top;

        while (current != null)
        {
            result.append(current.getElement());
            current = current.getNext();
        }

        return result.toString();
    }
}
