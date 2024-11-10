import java.util.Scanner;

public class Fibonacci {

    // Recursive Fibonacci method
    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n; // Base cases: F(0) = 0, F(1) = 1
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci method
    public static int fibonacciIterative(int n) {
        if (n <= 1) {
            return n; // Base cases: F(0) = 0, F(1) = 1
        }

        int a = 0, b = 1; // Initial values for F(0) and F(1)
        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b; // F(n) is the last computed value
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter fib num");
        int n = sc.nextInt();

        // Recursive approach
        System.out.println("Recursive Approach:");
        long startTimeRecursive = System.nanoTime();
        System.out.println("Fibonacci(" + n + ") = " + fibonacciRecursive(n));
        long endTimeRecursive = System.nanoTime();
        long timeTakenRecursiveMillis = (endTimeRecursive - startTimeRecursive) / 1000000; // Convert to milliseconds
        System.out.println("Time taken: " + timeTakenRecursiveMillis + " milliseconds");

        // Iterative approach
        System.out.println("\nIterative Approach:");
        long startTimeIterative = System.nanoTime();
        System.out.println("Fibonacci(" + n + ") = " + fibonacciIterative(n));
        long endTimeIterative = System.nanoTime();
        long timeTakenIterativeMillis = (endTimeIterative - startTimeIterative) / 1000000; // Convert to milliseconds
        System.out.println("Time taken: " + timeTakenIterativeMillis + " milliseconds");

        // Complexity Summary:
        System.out.println("\nComplexity Summary:");
        System.out.println("1. Recursive Approach:");
        System.out.println("   - Time Complexity: O(2^n) (Exponential time due to repeated subproblems)");
        System.out.println("   - Space Complexity: O(n) (Due to recursive call stack)");

        System.out.println("\n2. Iterative Approach:");
        System.out.println("   - Time Complexity: O(n) (Linear time with one loop)");
        System.out.println("   - Space Complexity: O(1) (Constant space, only storing two previous numbers)");
    }
}
