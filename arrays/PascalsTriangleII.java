package arrays;

public class PascalsTriangleII {
  // Time Complexity: O(R), because no. of elements in a row is same as row number.
  // Space Complexity: O(1)
  private static int[] pascalsTri2(int r) {

    int[] ans = new int[r];

    ans[0] = 1;
    for (int i = 1; i < r; i++) {
      ans[i] = (ans[i-1] * (r - i)) / i;
    }

    return ans;
  }
  public static void main(String[] args) {
    int r = 5; 

    int[] result = pascalsTri2(r);

    System.out.print("Row " + r + " : ");

    for(int nums : result) {
      System.out.print(nums + " ");
    }
  }
}