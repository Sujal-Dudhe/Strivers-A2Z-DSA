/*
 Given a 2D array matrix that is row-wise sorted. The task is to find the median of the given matrix
 */
package binarysearch;

public class MatrixMedian {

  /* 
  // Brute Approach 
  // Time Complexity: O(n*m) + O(n*m log(n*m))
  // Space Complexity: O(n*m), As a temporary list is used to store the elements of the flattened matrix.
  public static int findMedian(int[][] matrix) {
    ArrayList<Integer> flatMat = new ArrayList<>();
    int n = matrix.length;
    int m = matrix[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        flatMat.add(matrix[i][j]);
      }
    }
    Collections.sort(flatMat);
    int result = flatMat.get((m * n) / 2);
    return result;
  }
  */

  // Optimal Approach
  // Time Complexity: O(log(max)) * O(N(logM))
  // Space Complexity: O(1)
  public static int findMedian(int[][] matrix) {
    int n = matrix.length; 
    int m = matrix[0].length;

    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      low = Math.min(low, matrix[i][0]);
      high = Math.max(high, matrix[i][m - 1]);
    }

    int req = (n * m) / 2;
    while (low <= high) {
      int mid = low + (high - low) / 2;

      int smallOrEqual = countSmallEqual(matrix, n, m, mid);
      if (smallOrEqual <= req) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return low;
  }

  private static int countSmallEqual(int[][] matrix, int n, int m, int mid) {
    int count = 0;
    for (int i = 0; i < n; i++) {
      count += upperBound(matrix[i], mid, m);
    }

    return count;
  }

  private static int upperBound(int[] arr, int x, int m) {
    int low = 0, high = m - 1;
    int ans = m;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] > x) {
        ans = mid;
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 4, 5},
                          {8, 9, 11, 12, 13},
                          {21, 23, 25, 27, 29}};

    int result = findMedian(matrix);
    System.out.println("The Median Element is: " + result);
  }
}
