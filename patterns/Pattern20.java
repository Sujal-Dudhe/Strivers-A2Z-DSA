package patterns;

import java.util.Scanner;

public class Pattern20 {

  /*

*        *
**      **
***    ***
****  ****
**********
****  ****
***    ***
**      **
*        *

  */
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of Rows : ");
      int n = sc.nextInt();

      int spaces = 2*n - 2;
      for(int i = 1; i <= 2*n - 1; i++) {
        int stars = i;
        if (i > n) stars = 2*n - i;
        // Stars
        for(int j = 1; j <= stars; j++) {
          System.out.print("*");
        }
        
        // Spaces
        for (int j = 1; j <= spaces; j++) {
          System.out.print(" ");
        }

        // Stars 
        for(int j = 1; j <= stars; j++) {
          System.out.print("*");
        }

        System.out.println();
        if (i < n) spaces -= 2;
        else spaces += 2;
      }
    }
  }
}
