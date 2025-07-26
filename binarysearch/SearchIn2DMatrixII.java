/*
 Given a 2D array matrix where each row is sorted in ascending order from left to right and each column is sorted in ascending order from top to bottom, write an efficient algorithm to search for a specific integer target in the matrix.
 */
package binarysearch;

public class SearchIn2DMatrixII {

  // Optimal Approach (Using Binary Search)
  // Time Complexity: O(N*log(M))
  // Space Complexity: O(1)
  public static boolean searchMatrix(int[][] matrix, int target) {
      int rows = matrix.length; 
      for (int i = 0; i < rows; i++) {
        boolean found = binarySearch(matrix[i], target);
        if (found) return true;
      }

      return false;
    }

  private static boolean binarySearch(int[] matrixRow, int target) {
        
    int low = 0, high = matrixRow.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;

      if (matrixRow[mid] == target) return true;
      else if (matrixRow[mid] < target) low = mid + 1;
      else high = mid - 1;
    }

    return false;
  }
  public static void main(String[] args) {
    int[][] matrix = {{1, 4, 7, 11, 15}, 
                          {2, 5, 8, 12, 19},
                          {3, 6, 9, 16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}};
    int target = 8;

    boolean result = searchMatrix(matrix, target);
    System.out.println(result);
  }
}
