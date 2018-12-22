package jsjf;

import com.sun.jmx.remote.internal.ArrayQueue;
import jsjf.exceptions.EmptyCollectionException;

public class ArrayDeque<T> implements DequeADT<T> {

    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] deque;

    @SuppressWarnings("unchecked")
    public ArrayDeque(int initialCapacity) {
        front = rear = count = 0;
        deque = (T[]) (new Object[initialCapacity]);
    }

    public ArrayDeque() {
        this(DEFAULT_CAPACITY);
    }


    public void addFirst(T element) {
        if (size() == deque.length) {
            expandCapacity();
        }
        deque[front] = element;
        front = Math.floorMod(front - 1, deque.length);
        count++;

    }

    public T getFirst() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        T result = deque[front];
        deque[front] = null;
        front = Math.floorMod(front + 1, deque.length);
        count--;
        return result;
    }


    public void addLast(T element) {
        if (size() == deque.length) {
            expandCapacity();
        }

        deque[rear] = element;
        rear = (rear + 1) % deque.length;
        count++;
    }


    public T getLast() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        T result = deque[rear];
        deque[rear] = null;
        rear = Math.floorMod(rear - 1, deque.length);
        count--;

        return result;
    }

    public T peakFront() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        return deque[front];
    }

    public T peakRear() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }

        return deque[rear];
        // return deque[(rear - 1) * deque.length];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T element : deque) {
            if (element != null) {
                result.append(element);
            } else {
                result.append("*");
            }
        }
        return result.toString();
    }


    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[deque.length * 2]);
        for (int i = 0; i < count; i++) {
            larger[i] = deque[front];
            front = (front + 1) % deque.length;
        }
        front = 0;
        rear = count;
        deque = larger;
    }
}
