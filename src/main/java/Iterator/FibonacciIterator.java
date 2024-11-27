package Iterator;

import java.util.Iterator;

// Iterator for generating Fibonacci numbers
public class FibonacciIterator implements Iterator<Integer> {
    private int previous = 0; // F(n-2)
    private int current = 1;  // F(n-1)
    private int count = 0;    // Current position in the sequence
    private final int maxCount; // Maximum number of elements (Integer.MAX_VALUE for infinite)

    // Constructor for a finite sequence
    public FibonacciIterator(int maxCount) {
        this.maxCount = maxCount;
    }

    // Default constructor for an infinite sequence
    public FibonacciIterator() {
        this.maxCount = Integer.MAX_VALUE; // Infinite sequence
    }

    @Override
    public boolean hasNext() {
        return count < maxCount; // Check if there are more elements to generate
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements in the sequence.");
        }
        int next = previous + current; // Compute the next Fibonacci number
        previous = current;           // Update F(n-2) -> F(n-1)
        current = next;               // Update F(n-1) -> F(n)
        count++;
        return previous;              // Return the current Fibonacci number
    }
}
