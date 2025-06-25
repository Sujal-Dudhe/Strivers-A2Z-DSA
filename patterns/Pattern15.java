package patterns;

import java.util.Scanner;

public class Pattern15 {
  /*
    A B C D E 
    A B C D 
    A B C 
    A B 
    A
  */
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of Rows : ");
      int n = sc.nextInt();

      for (int i = 0; i < n; i++) {
        for (char ch = 'A'; ch <= 'A' + (n - i - 1); ch++) {
          System.out.print(ch + " ");
        }
        System.out.println();
      }
    }
  }
}
