// Implement the power function pow(x, n) , which calculates the x raised to n i.e. xn.

// Note : In output print 6 digits places after decimal point.
package recursion;

class Pow {
     
    /*
     // Brute Approach 
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    private static double myPow(double x, int n) {
        // Base case: any number to the power of 0 is 1
        if (n == 0 || x == 1.0) return 1;

        long temp = n;  // to avoid integer overflow

        // Handle negative exponents
        if (n < 0) {
            x = 1 / x;
            temp = -1L * n;
        }

        double ans = 1;
        for (long i = 0; i < temp; i++) {
            ans = ans * x;
        }
        return ans;
    }
    */

    // Optimal Approach
    // Time Complexity: O(log N), due to the halving of n in the even case and linear reduction in the odd case.
    // Space Complexity: O(log N), because of the recursive call stack depth.
    public static double myPow(double x, int n) {
        long num = n;

        if (num < 0) {
            return (1.0 / power(x, -num));
        }

        return power(x, num);
    }

    private static double power(double x, long n) {
        if (n == 0) return 1.0;

        if (n == 1) return x;

        if (n % 2 == 0) {
            return power(x*x, n / 2);
        }

        return x * power(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.printf("%.6f\n", myPow(2.0000, 10));

        System.out.printf("%.6f\n", myPow(2.0000, -2));
    }
}