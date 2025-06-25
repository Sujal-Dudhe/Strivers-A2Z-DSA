package patterns;

import java.util.Scanner;

public class Pattern12 {
  /*
    1      1
    12    21
    123  321
    12344321
  */
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of Rows : ");
      int n = sc.nextInt();
      
      int space = 2 * (n-1);
      for (int i = 1; i <= n; i++) {
        // Numbers
        for (int j = 1; j <= i; j++) {
          System.out.print(j);
        }
        // Space
        for (int j = 1; j <= space; j++) {
          System.out.print(" ");
        }
        // Numbers
        for (int j = i; j >= 1; j--) {
          System.out.print(j);
        }
        System.out.println();
        space -= 2;
      }
    }
  }
}
