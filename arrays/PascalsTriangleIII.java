package arrays;
import java.util.List;

import java.util.ArrayList;

// Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.
public class PascalsTriangleIII {

  private static List<Integer> generateRow(int row) {
    List<Integer> ansRow = new ArrayList<>();
    ansRow.add(1);

    long currEle = 1; 
    for (int col = 1; col < row; col++) {
      currEle *= (row - col);
      currEle /= col;
      
      ansRow.add((int)currEle);
    }

    return ansRow;
  }

  // Time Complexity : O(N^2), generating each row takes linear time and there are N rows.
  // Space Complexity : O(N^2), for storing entire Pascal's triangle
  public static List<List<Integer>> pascalTriIII(int n) {
    List<List<Integer>> ans = new ArrayList<>();

    for (int row = 1; row <= n; row++) {
      ans.add(generateRow(row));
    }

    return ans;
  }

  public static void main(String[] args) {
    int n = 6;

    List<List<Integer>> pascalTri = pascalTriIII(n);

    for (List<Integer> row : pascalTri) {
      for (int ele : row) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }
}