package jsjf;

import jsjf.exceptions.EmptyCollectionException;

/*
    ModifiedLinkedStack.java is a modification of the LinkedStack
    provided in the Java Foundations textbook based on Assignment 2
    Question 2 (PP 13.8 Pg 546). The modification is to turn it into a
    drop-out stack. The class is initialized with a maxSize value, if
    an element is pushed into the stack that exceeds the max size then
    the bottom element will drop out. This ensures that the stack is
    always at most maxSize.
 */


public class ModifiedLinkedStack<T> implements StackADT<T> {

    private int count;
    private int maxSize;
    private LinearNode<T> top;

    // Initialize with maxSize value.
    public ModifiedLinkedStack(int maxSize) {
        count = 0;
        this.maxSize = maxSize;
        top = null;
    }

    // This method is the only difference between the original LinkedStack.
    // It checks to see if the count has reached the max size or more. It
    // gets a reference to the top of the stack and loops down the stack until
    // it reaches the second to last element. Once that element is found it tells
    // that node to point to a null element. Thus dropping out the bottom node
    // which will then be collected by the garbage collector. It then decreases
    // the total count, which then gets increased again to maintain the correct
    // number.
    @SuppressWarnings("unchecked")
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<>(element);

        if (count >= maxSize) {
            LinearNode currentNode = top;
            for(int i = 1; i < count-1; i++){
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            count--;
        }

        temp.setNext(top);
        top = temp;
        count++;
    }

    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        T result = top.getElement();
        top = top.getNext();
        count--;

        return result;
    }

    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return top.getElement();
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public int size() {
        return count;
    }

    // Slight modification to the toString method to console out
    // 'top' to show which element is at the top of the stack.
    public String toString() {
        StringBuilder result = new StringBuilder();
        LinearNode currentNode = top;

        System.out.println("top");
        while (currentNode != null) {
            result.append(currentNode.getElement()).append("\n");
            currentNode = currentNode.getNext();
        }
        return result.toString();
    }
}
