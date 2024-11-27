package Iterator;

import java.util.Iterator;

// Fibonacci sequence as a "pseudo-collection"
public class FibonacciSequence implements Sequence {
    private final Integer maxCount; // Maximum number of elements (null for infinite)

    // Constructor for a finite sequence
    public FibonacciSequence(int maxCount) {
        this.maxCount = maxCount;
    }

    // Default constructor for an infinite sequence
    public FibonacciSequence() {
        this.maxCount = null; // Null indicates no limit
    }

    @Override
    public Iterator<Integer> iterator() {
        // Create an iterator with or without a limit
        if (maxCount == null) {
            return new FibonacciIterator(); // Infinite sequence
        }
        return new FibonacciIterator(maxCount); // Finite sequence
    }
}
