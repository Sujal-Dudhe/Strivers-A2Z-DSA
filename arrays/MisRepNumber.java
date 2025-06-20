package arrays;

// Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing

public class MisRepNumber {

  /* 
  // Better Approach
  // Time Complexity: O(2*N)
  // Space Complexity: O(N), for using hash array.
  private static int[] findMisRepNum(int[] nums) {
    int n = nums.length;

    int[] hash = new int[n + 1];

    for (int i = 0; i < n; i++) hash[nums[i]]++;

    int repeating = -1, missing = -1;
    for (int i = 1; i <= n; i++) {
      if (hash[i] == 2) {
        repeating = i;
      } else if (hash[i] == 0) {
        missing = i;
      }
    }
    return new int[] {repeating, missing};
  }
  */

  // Optimal approach
  // Time Complexity: O(N)
  // Space Complexity: O(1)
  private static int[] findMisRepNum(int[] nums) {
    long n = nums.length;

    // Sum of first n natural numbers
    long sumN = (n * (n + 1)) / 2; 
    // Sum of squares of first n natural numbers
    long sumSquareN = (n * (n + 1) * (2*n + 1)) / 6;

    // sum (sum) and sum of square (sumSquare) of array elements
    long sum = 0, sumSquare = 0;
    for (int i = 0; i < n; i++) {
      sum += (long)nums[i];
      sumSquare += (long)nums[i] * (long)nums[i];
    }

    // x - y
    long val1 = sum - sumN;
    // x^2 - y^2
    long val2 = sumSquare - sumSquareN;

    // Calculate X + Y using X + Y = (X^2 - Y^2) / (X - Y)
    val2 = val2 / val1;

    /* Calculate X and Y from X + Y and X - Y 
           X = ((X + Y) + (X - Y)) / 2
           Y = X - (X - Y) */
    long x = (val1 + val2) / 2;
    long y = x - val1;

    return new int[] {(int) x, (int) y};
  }

  public static void main(String[] args) {
    int[] arr = {6, 5, 7, 1, 8, 6, 4, 3, 2};

    int[] result = findMisRepNum(arr);

    System.out.println("Repeating and Missing numbers are: {" + result[0] + ", " + result[1] + "}");
  }
}