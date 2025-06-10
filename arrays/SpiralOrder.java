package arrays;
import java.util.List;
import java.util.ArrayList;

public class SpiralOrder {

  // Time Complexity: O(N*M), where m and n are no. of rows and columns respectively.
  // Space Complexity: O(1), as extra space to store the ans is not considered.
  private static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> ans = new ArrayList<>();
    int m = matrix.length;  // Number of Rows
    int n = matrix[0].length;  // Number of Columns 

    int top= 0, left = 0, right = n - 1, bottom = m - 1;

    while (top <= bottom && left <= right) {
      //  Left to Right
      for (int i = left; i <= right; i++) {
        ans.add(matrix[top][i]);
      }
      top++;
      
      //  Top to Bottom
      for (int i = top; i<= bottom; i++) {
        ans.add(matrix[i][right]);
      }
      right--;

      //  Right to Left
      if (top <= bottom) {
        for (int i = right; i >= left; i--) {
          ans.add(matrix[bottom][i]);
        }
        bottom--;
      }

      //  Bottom to Top
      if (left <= right) {
        for (int i = bottom; i >= top; i--) {
          ans.add(matrix[i][left]);
        }
        left++;
      }
    }
    return  ans;
  }

  public static void main(String[] args) {
    int matrix[][] = {{1, 2, 3,}, {4, 5, 6}, {7, 8, 9}};

    List<Integer> result = new ArrayList<>();
    result = spiralOrder(matrix);

    for (int i = 0; i < result.size(); i++)  {
      System.out.print(result.get(i) + " ");
    }
  }
}