package patterns;

import java.util.Scanner;

public class Pattern16 {

  /*
    A 
    B B 
    C C C 
    D D D D 
    E E E E E
  */
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of Rows : ");
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        char ch = (char) ('A' + i);
        for (int j = 0; j <= i; j++) {
          System.out.print(ch + " ");
        }
        System.out.println();
      }
    }
  }
}
