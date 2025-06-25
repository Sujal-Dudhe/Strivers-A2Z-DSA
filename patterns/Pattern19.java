package patterns;

import java.util.Scanner;

public class Pattern19 {

  /*

    **********
    ****  ****
    ***    ***
    **      **
    *        *
    *        *
    **      **
    ***    ***
    ****  ****
    **********

  */
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of Rows : ");
      int n = sc.nextInt();

      // First Half
      int initialSpace = 0;
      for (int i = 0; i < n; i++) {

        // Stars
        for (int j = 1; j <= n - i; j++) {
            System.out.print("*");
        }

        // Spaces
        for (int j = 0; j < initialSpace; j++) {
          System.out.print(" ");
        }

        // Stars
        for (int j = 1; j <= n - i; j++) {
            System.out.print("*");
        }

        initialSpace += 2;
        System.out.println();
      }
      
      // Second Half
      initialSpace = 8;
      for (int i = 1; i <= n; i++) {
        // Stars
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }

        // Spaces
        for (int j = 0; j < initialSpace; j++) {
          System.out.print(" ");
        }

        // Stars
        for (int j = 1; j <= i; j++) {
            System.out.print("*");
        }

        initialSpace -= 2;
        System.out.println();

      }

    }
  }
}
