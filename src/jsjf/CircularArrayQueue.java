package jsjf;

import jsjf.exceptions.EmptyCollectionException;

public class CircularArrayQueue<T> implements QueueADT<T> {

    private final static int DEFAULT_CAPACITY = 100;
    private int front, rear, count;
    private T[] queue;

    @SuppressWarnings("unchecked")
    public CircularArrayQueue(int initialCapacity){
        front = rear = count = 0;
        queue = (T[])(new Object[initialCapacity]);
    }

    public CircularArrayQueue(){
        this(DEFAULT_CAPACITY);
    }

    public void enqueue(T element) {
        if (size() == count){
            expandCapacity();
        }

        queue[rear] = element;
        rear = (rear+1) & queue.length;
        count++;
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);
        for(int i = 0; i < count; i++){
            larger[i] = queue[i];
            front = (front + 1) % queue.length;
        }
        front = 0;
        rear = count;
        queue = larger;
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (isEmpty()){
            throw new EmptyCollectionException("queue");
        }

        T result = queue[front];
        queue[front] = null;
        front = (front + 1) % queue.length;
        count--;

        return result;
    }

    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("queue");
        }
        return queue[front];
    }


    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }
}
