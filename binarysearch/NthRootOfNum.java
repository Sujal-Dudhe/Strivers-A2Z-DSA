/*
 Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, return -1.
 */
package binarysearch;

public class NthRootOfNum {

  // Time Complexity: O(N*logN)
  // Space Complexity: O(1)
  public static int NthRoot(int N, int M) {
    int low = 1, high = M;
    
    while (low <= high) {
        int mid = (low + high) / 2;
        int midN = helperFunc(mid, N, M);
        
        if (midN == 1) return mid; // Found exact root
        else if (midN == 0) low = mid + 1; // Move right
        else high = mid - 1; // Move left
    }
    return -1;
  }

  private static int helperFunc(int mid, int n, int m) {
    long ans = 1, base = mid;
    
    while (n > 0) {
        if (n % 2 == 1) {
            ans *= base;
            if (ans > m) return 2;  // Early exit
            n--;
        } else {
            n /= 2;
            base *= base;
            if (base > m) return 2;
        }
    }
    if (ans == m) return 1;
    return 0;
  }

  public static void main(String[] args) {
    int n = 3, m = 27;
    int result = NthRoot(n, m);

    System.out.println("The answer is: " + result);
  }
}
