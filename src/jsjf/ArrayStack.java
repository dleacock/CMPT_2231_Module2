package jsjf;

import jsjf.exceptions.EmptyCollectionException;

import java.util.Arrays;

public class ArrayStack<T> implements StackADT<T> {

    private final static int DEFAULT_CAPACITY = 100;

    private int top;
    private T[] stack;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        top = 0;
        stack = (T[]) (new Object[initialCapacity]);
    }


    @Override
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }

        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    @Override
    public T pop() throws EmptyCollectionException {

        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }

        top--;
        T result = stack[top];
        stack[top] = null;
        return result;
    }

    @Override
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return stack[top-1];
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
