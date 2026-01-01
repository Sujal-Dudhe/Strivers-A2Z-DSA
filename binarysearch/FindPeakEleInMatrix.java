/*
 Given a 0-indexed n x m matrix mat where no two adjacent cells are equal, find any peak element mat[i][j] and return the array [i, j].
 A peak element in a 2D grid is an element that is strictly greater than all of its adjacent neighbours to the left, right, top, and bottom.
Assume that the entire matrix is surrounded by an outer perimeter with the value -1 in each cell.

Note: As there can be many peak values, 1 is given as output if the returned index is a peak number, otherwise 0.
 */
package binarysearch;

public class FindPeakEleInMatrix {

  // Optimal Approach
  // Time Complexity: O(N*log(M))
  // Space Complexity: O(1)
  public static int[] peakGrid(int[][] mat) {
    int m = mat[0].length;

    int low = 0, high = m - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      int row = maxEleRow(mat, mid);

      int left = mid - 1 >= 0 ? mat[row][mid - 1] : Integer.MIN_VALUE;
      int right = mid + 1 < m ? mat[row][mid + 1] : Integer.MIN_VALUE;

      if (left < mat[row][mid] && mat[row][mid] > right) {
        return new int[] {row, mid};
      } else if (left > mat[row][mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return new int[] {-1, -1};
  }

  private static int maxEleRow(int[][] arr, int col) {
    int n = arr.length;
    int maxEle = Integer.MIN_VALUE;
    int rowIndex = -1;
    for (int i = 0; i < n; i++) {
      if (arr[i][col] > maxEle) {
        maxEle = arr[i][col];
        rowIndex = i;
      }
    }
    return rowIndex;
  }

  public static void main(String[] args) {
    int[][] mat = {
                  {10, 20, 15},
                  {21, 30, 14}, 
                  {7, 16, 31}
                };
    
    System.out.println("The row of Peak Element is " + peakGrid(mat)[0] + " and column of Peak Element is " + peakGrid(mat)[1]);
  }
}