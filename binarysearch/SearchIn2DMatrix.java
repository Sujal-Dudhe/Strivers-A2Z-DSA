/*
  Given a 2-D array mat where the elements of each row are sorted in non-decreasing order, and the first element of a row is greater than the last element of the previous row (if it exists), and an integer target, determine if the target exists in the given mat or not.
*/
package binarysearch;

public class SearchIn2DMatrix {

  /* 
  // Brute Approach (Using Linear Search)
  // Time Complexity: O(N*M)
  // Space Complexity: O(1)
  public static boolean searchMatrix(int[][] mat, int target) {
    if (mat.length == 0 || mat[0].length == 0) return false;
    
    int n = mat.length;
    int m = mat[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (mat[i][j] == target) return true;
      }
    }
    return false;
  }
  */
        
  // Optimal Approach (Using Binary Search)
  // Time Complexity: O(N + log(M))
  // Space Complexity: O(1)
  public static boolean searchMatrix(int[][] mat, int target) {
    int n = mat.length;
    int m = mat[0].length;
    
    for (int i = 0; i < n; i++) {
      if (mat[i][0] <= target && target <= mat[i][m - 1]) {
        return binarySearch(mat[i], target);
      }
    }
    return false;
  }
  
  private static boolean binarySearch(int[] row, int target) {
    int n = row.length; 
    int low = 0, high = n - 1;
    
    while (low <= high) {
      int mid = (low + high) / 2;
      
      if (row[mid] == target) return true;
      else if (target > row[mid]) low = mid + 1;
      else high = mid - 1;
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
    int target = 8;

    boolean result = searchMatrix(matrix, target);
    System.out.println(result);
  }
}
