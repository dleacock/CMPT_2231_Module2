package jsjf;

/*
    ModifiedArrayStack.java is a modification of the ArrayStack
    provided in the Java Foundations textbook based on Assignment 2
    Question 1 (PP 12.4 Pg 515). The modification is such that stack[top]
    points to the actual top of the stack and not the next array position.
    All other code is the same.
 */

import jsjf.exceptions.EmptyCollectionException;
import java.util.Arrays;

public class ModifiedArrayStack<T> implements StackADT<T> {

    private final static int DEFAULT_CAPACITY = 100;
    // This represents the index of the top value. An empty
    // stack has a top value of -1. Instead of the previous ArrayStack
    // class which used top to store the *next* index position. Since
    // an empty array has no top position, this will be initialized to -1.
    private int top;
    private T[] stack;

    public ModifiedArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    // The initial stack is empty, therefor it has no top
    // so we treat -1 as an empty size. I could have also
    // made top an Integer type which allows for null and
    // consider that to be empty.
    @SuppressWarnings("unchecked")
    public ModifiedArrayStack(int initialCapacity) {
        top = -1;
        stack = (T[]) (new Object[initialCapacity]);
    }

    // When pushing an element onto the stack we increase
    // the top variable first. We assume that the element
    // is acceptable. In the first case where the stack is
    // empty the value of top is -1 so we increase that to 0
    // and store the first value there. This allows top to
    // represent the index of the actual top stack value.
    public void push(T element) {
        if (size() == stack.length) {
            expandCapacity();
        }

        top++;
        stack[top] = element;

    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    // This is roughly inverse of the ArrayStack class. Since
    // top represents the actual index of the top stack value
    // we grab the element in that index, set that element to null/empty
    // and then we decrease the top index position.
    public T pop() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }

        T result = stack[top];
        stack[top] = null;
        top--;
        return result;
    }

    // When peaking we don't need to offset the top index since
    // top is now the index of the top of the stack. This method
    // also helps prove the question that stack[top] is the actual
    // top of the stack.
    public T peek() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("stack");
        }
        return stack[top];
    }

    // An empty stack is one in which the top value is -1
    public boolean isEmpty() {
        return (top == -1);
    }

    // An array is a 0-based index and top represents the index
    // of the top position. Therefor when returning the actual size of
    // the elements in the array we need to add 1 to the top index position
    // and if it's -1 that means the array is empty.
    public int size() {
        if (top == -1){
            return 0;
        }
        return top+1;
    }

    // Return a string with each element separated by a newline character.
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            result.append(stack[i]).append("\n");
        }
        return result.toString();
    }

}
