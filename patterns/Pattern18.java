package patterns;

import java.util.Scanner;

public class Pattern18 {
  /*
  
  E 
  D E 
  C D E 
  B C D E 
  A B C D E

  */
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of Rows : ");
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        for (char ch =(char) ('E'-i); ch <= 'E'; ch++) {
          System.out.print(ch + " ");
        }
        System.out.println();
      }
    }
  }
}
