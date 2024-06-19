package fibonacci;

public class Main {
    public static void main(String[] args) {
        fibIterative();
        fibRecursive();
    }

    public static void fibIterative() {
        int n = 10; // Change this to the desired Fibonacci sequence length
        long[] fibonacciNumbers = new long[n];

        // The first two Fibonacci numbers
        fibonacciNumbers[0] = 0;
        fibonacciNumbers[1] = 1;

        // Calculate the Fibonacci sequence iteratively
        for (int i = 2; i < n; i++) {
            fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
        }

        // Print the Fibonacci sequence
        System.out.println("Fibonacci Sequence (Iterative):");
        for (int i = 0; i < n; i++) {
            System.out.println(fibonacciNumbers[i]);
        }
    }

    public static void fibRecursive() {
        int n = 10; // Change this to the desired Fibonacci sequence length

        System.out.println("Fibonacci Sequence (Recursive):");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
