/*
 Given a non-empty grid mat consisting of only 0s and 1s, where all the rows are sorted in ascending order, find the index of the row with the maximum number of ones.
If two rows have the same number of ones, consider the one with a smaller index. If no 1 exists in the matrix, return -1.
 */
package binarysearch;

public class RowWithMaxOnes {

  // Brute Approach (Using Linear Search)
  // Time Complexity: O(N*M)
  // Space Complexity:  O(1)
  /*
  public static int maxOnesRow(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;
    int countMaxOnes = 0;
    int index = -1;

    for (int i = 0; i < n; i++) {
      int countOnes = 0;
      for (int j = 0; j < m; j++) {
        countOnes += mat[i][j];
      }
      if (countOnes > countMaxOnes) {
        countMaxOnes = countOnes;
        index = i;
      }
    }
    return index;
  }
  */

  // Optimal Approach (Using Binary Search)
  // Time  Complexity: O(N*log(M))
  // Space Complexity: O(1)
  public static int maxOnesRow(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    int countMaxOnes = 0;
    int index = -1;
    for (int i = 0; i < n; i++) {
      int countOnes = m - lowerBound(mat[i], m, 1);

      if (countOnes > countMaxOnes) {
        countMaxOnes = countOnes;
        index = i;
      }
    }
    return index;
  }

  private static int lowerBound(int[] row, int n, int x) {
    int ans = n;
    int low = 0, high = n - 1;
    while (low <= high) {
      int mid = (low + high) / 2;

      if (row[mid] >= x) {
        ans = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 1, 1}, {0, 0, 1}, {0, 0, 0}};

    System.out.println("The row with maximum number of 1's is: " +  maxOnesRow(matrix));
  }
}