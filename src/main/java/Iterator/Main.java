package Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Example 1: Generate a finite sequence of 10 Fibonacci numbers
        System.out.println("First 10 Fibonacci numbers:");
        FibonacciSequence limitedSequence = new FibonacciSequence(10);
        Iterator<Integer> limitedIterator = limitedSequence.iterator();
        while (limitedIterator.hasNext()) {
            System.out.println(limitedIterator.next());
        }

        // Example 2: Generate the first 5 numbers from an infinite sequence
        System.out.println("\nFirst 5 numbers from an infinite sequence:");
        FibonacciSequence infiniteSequence = new FibonacciSequence(); // Infinite sequence
        Iterator<Integer> infiniteIterator = infiniteSequence.iterator();

        int count = 0;
        while (infiniteIterator.hasNext() && count < 5) {
            System.out.println(infiniteIterator.next());
            count++;
        }
    }
}
