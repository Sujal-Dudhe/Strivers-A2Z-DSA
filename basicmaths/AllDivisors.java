package basicmaths;

import java.util.*;

public class AllDivisors {

    // Efficient method (O(sqrt(n)) time complexity)
    public static List<Integer> getDivisorsOptimized(int num) {
        List<Integer> divisors = new ArrayList<>();
        if (num <= 0) return divisors; // Handle non-positive numbers
        
        for (int i = 1; i*i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
                if (i != num / i) { // Avoid duplicate for perfect squares
                    divisors.add(num / i);
                }
            }
        }
        Collections.sort(divisors); // O(n log n) where 'n' is the number of factors.
        return divisors;
    }

    // Basic method (O(n) time complexity) - for comparison
    public static List<Integer> getDivisorsBasic(int num) {
        List<Integer> divisors = new ArrayList<>();
        if (num <= 0) return divisors;
        
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                divisors.add(i);
            }
        }
        return divisors;
    }

    public static void main(String[] args) {
        System.out.print("Enter a positive integer: ");
        
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            
            if (n <= 0) {
                System.out.println("Please enter a positive integer.");
                return;
            }
            
            System.out.println("Divisors (optimized): " + getDivisorsOptimized(n));
            System.out.println("Divisors (basic): " + getDivisorsBasic(n));
        }
    }
}