import jsjf.ArrayDeque;
import jsjf.ModifiedArrayStack;
import jsjf.ModifiedLinkedStack;
import jsjf.PalindromeTester;

import java.util.Deque;
import java.util.LinkedList;

/*
    Assignment 2 - COMP 2231 - David Leacock
    This is the main class to test the 4 questions.


 */


public class Main {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        /*System.out.println("*************** START OF QUESTION 1 ***************");

        // Question 1 PP 12.4 Pg 515
        // ModifiedStackArray Tests.
        ModifiedArrayStack modifiedArrayStack = new ModifiedArrayStack();
        modifiedArrayStack.push("A");
        modifiedArrayStack.push("B");
        modifiedArrayStack.push("C");
        modifiedArrayStack.push("D");
        modifiedArrayStack.push("E");
        // The top of the stack contains element E, therefor when we peek at the top
        // this is what we should see.
        System.out.println("Top element should be E");
        System.out.println("Top of stack: " + modifiedArrayStack.peek());
        modifiedArrayStack.pop();
        // The top of the stack contains element D, when we peek at the top that's what
        // we should see.
        System.out.println("After pop() top element should be D");
        System.out.println("Top of stack: " + modifiedArrayStack.peek());
        // Let's push E back onto the stack and print the whole array of A,B,C,D,E
        modifiedArrayStack.push("E");
        System.out.println("After push() top element should be E again");
        System.out.println("Top of stack: " + modifiedArrayStack.peek());
        System.out.println("Entire Array - should be A,B,C,D,E");
        System.out.println(modifiedArrayStack.toString());

        System.out.println("*************** END OF QUESTION 1 *************** \n\n\n");


        // Question 2 Pp 13.8 pg 546
        // Create a Drop-Stack (modifiedLinkedStack) and
        System.out.println("*************** START OF QUESTION 2 ***************");
        ModifiedLinkedStack modifiedLinkedStack = new ModifiedLinkedStack(5);
        modifiedLinkedStack.push("A");
        modifiedLinkedStack.push("B");
        modifiedLinkedStack.push("C");
        modifiedLinkedStack.push("D");
        modifiedLinkedStack.push("E");
        System.out.println("Entire Array - should be A,B,C,D,E (top)");
        System.out.println(modifiedLinkedStack.toString());

        // Add a new element to stack which contains 5 elements (a full stack).
        // This will force the stack to drop the bottom element which is 'A'
        modifiedLinkedStack.push("F");
        System.out.println("Pushing element F onto full stack. Element A should drop");
        System.out.println("Entire Array - should be B,C,D,E,F (top)");
        System.out.println(modifiedLinkedStack.toString());

        // Add a new element to stack which contains 5 elements (a full stack).
        // This will force the stack to drop the bottom element which is 'B'
        modifiedLinkedStack.push("G");
        System.out.println("Pushing element G onto full stack. Element B should drop");
        System.out.println("Entire Array - should be C,D,E,F,G (top)");
        System.out.println(modifiedLinkedStack.toString());

        // Add a new element to stack which contains 5 elements (a full stack).
        // This will force the stack to drop the bottom element which is 'C'
        modifiedLinkedStack.push("H");
        System.out.println("Pushing element H onto full stack. Element C should drop");
        System.out.println("Entire Array - should be D,E,F,G,H (top)");
        System.out.println(modifiedLinkedStack.toString());

        System.out.println("*************** END OF QUESTION 2 *************** \n\n\n");*/

        System.out.println("*************** START OF QUESTION 3 *************** \n\n\n");
        ArrayDeque deque = new ArrayDeque(5);
        deque.addLast("A");
        System.out.println(deque.toString());
        deque.addLast("B");
        System.out.println(deque.toString());
        deque.addLast("C");
        System.out.println(deque.toString());
        deque.addLast("D");
        System.out.println(deque.toString());
        deque.addLast("E");
        System.out.println(deque.toString());
        System.out.println("Front: " + deque.peakFront() + " Rear: " + deque.peakRear());
        deque.addLast("F");
        System.out.println(deque.toString());
        deque.addLast("G");
        System.out.println(deque.toString());
        deque.addFirst("H");
        System.out.println(deque.toString());
        System.out.println(deque.toString());
        System.out.println("Front: " + deque.peakFront() + " Rear: " + deque.peakRear());
        deque.getLast();
        //deque.addLast("F");
        System.out.println("Front: " + deque.peakFront() + " Rear: " + deque.peakRear());
        //deque.getFirst();
        System.out.println(deque.toString());
        System.out.println("*************** END OF QUESTION 3 *************** \n\n\n");
        System.out.println("*************** START OF QUESTION 4 *************** \n\n\n");

       /* PalindromeTester palindromeTester = new PalindromeTester("Hannah");
        palindromeTester.testPalindromeQueue();
        palindromeTester.testPalindromeStack();
        palindromeTester.updateWord("David");
        palindromeTester.testPalindromeQueue();
        palindromeTester.testPalindromeStack();
        palindromeTester.updateWord("aBcDEFfeDcbA");
        palindromeTester.testPalindromeQueue();
        palindromeTester.testPalindromeStack();
        palindromeTester.updateWord("Sarah");
        palindromeTester.testPalindromeQueue();
        palindromeTester.testPalindromeStack();*/


    }
}
