package jsjf;

public class PalindromeTester {

    private String word;
    private LinkedQueue queue;
    private LinkedStack stack;

    public PalindromeTester(String word) {
        this.word = word;
        queue = new LinkedQueue();
        stack = new LinkedStack();

        addWordToDataStructures();

        System.out.println(queue.toString());
        System.out.println(stack.toString());

    }

    public void updateWord(String newWord) {
        this.word = newWord;
        queue = new LinkedQueue();
        stack = new LinkedStack();
        addWordToDataStructures();
    }

    public void testPalindromeStack() {
        StringBuilder lettersFromStack = new StringBuilder();
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            lettersFromStack.append(stack.pop());
        }
        if (lettersFromStack.toString().equalsIgnoreCase(word)) {
            System.out.println("Stack Test: " + word + " is a palindrome");
        } else {
            System.out.println("Stack Test: " + word + " is not a palindrome");
        }
    }

    public void testPalindromeQueue() {
        StringBuilder lettersFromQueue = new StringBuilder();
        int queueSize = queue.size();
        for (int i = 1; i <= word.length(); i++) {
            String l = queue.dequeue().toString();
            String l1 = String.valueOf(word.charAt(word.length() - i));

            if (!l.equalsIgnoreCase(l1)) {
                System.out.println("Queue Test: " + word + " is not a palindrome");
                return;
            }
        }
        //System.out.println("q: " + lettersFromQueue);
        System.out.println("Queue Test: " + word + " is a palindrome");

    }

    @SuppressWarnings("unchecked")
    private void addWordToDataStructures() {
        for (int i = 0; i < word.length(); i++) {
            queue.enqueue(word.charAt(i));
            stack.push(word.charAt(i));
        }
    }


    private void printWord() {
        System.out.println(word);
    }


}
