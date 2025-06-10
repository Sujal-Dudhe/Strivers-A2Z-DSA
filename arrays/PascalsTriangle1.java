package arrays;

public class PascalsTriangle1 {

  // Time Complexity: O(C), Where C is the column number.
  // Space Complexity: O(1), as no extra space is used.
  private static int pascalTri(int row, int col) {
    return nCr(row-1, col-1);
  }

  private static int nCr(int n, int r) {
    if (r > n-r) r = n-r;
    
    if (r == 1) return n;

    long result = 1; 
    for (int i = 0; i < r; i++) {
      result *= (n - i);
      result /= (i + 1);
    }

    return (int) result;
  }
  public static void main(String[] args) {
    // Row number
    int r = 5;

    // Column number
    int c = 3;

    int ans = pascalTri(r, c);

    System.out.println("The element in the row " + r + " and column " + c + " is : " + ans);
  }
}