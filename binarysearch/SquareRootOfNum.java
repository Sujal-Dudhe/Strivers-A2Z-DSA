/*
 Given a positive integer n. Find and return its square root. If n is not a perfect square, then return the floor value of sqrt(n).
 */
package binarysearch;

public class SquareRootOfNum {

  /* 
  // Brute approach (Using Linear search)
  // Time Complexity: O(sqrt(N))
  // Space Complexity: O(1)
  public static long floorSqrt(long n) {
      long ans = 0;
      for (long i = 1; i <= n; i++) {

        long val = i * i;
        if (val <= (long) n) {
            ans = (int) i;
        } else {
            break;
        }
      }

      return ans;
    }
  */

  // Optimal approach (Using Binary search)
  // Time Complexity: O(logN)
  // Space Complexity: O(1) 
  public static long floorSqrt(long n) {

    long low = 1, high = n;
    while (low <= high) {
      long mid = (long) (low + high) / 2;
      long val = mid * mid;

      if (val <= (long) n) {
        low = (int) (mid + 1);
      } else {
        high = (int) (mid - 1);
      }
    }
    return high;
  }

  public static void main(String[] args) {
    int n = 50;

    int result = (int) floorSqrt(n);

    System.out.println("The floor of square root of " + n + " is: " + result);
  }
}