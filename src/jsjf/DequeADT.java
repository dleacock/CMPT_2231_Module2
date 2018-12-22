package jsjf;

/*  Deque ADT - David Leacock
   Abstract Data Type that will be used to implement an array based Deque.
   I chose these method names based off the already existing java util Deque
*/

public interface DequeADT<T> {


    // This is the equivalent to enqueue() from QueueADT
    public void addLast(T element);
    // Similar to enqueue but adds to the front of the queue
    public void addFirst(T element);

    // Equivalent to first()
    public T getFirst();
    // Similar to first() but from the end
    public T getLast();


    public boolean isEmpty();
    public int size();
    public String toString();
}
