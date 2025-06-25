package patterns;

import java.util.Scanner;
/*

A
AB
ABC 
ABCD
ABCDE
 
*/
public class Pattern14 {
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of Rows : ");
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        for (char ch = 'A'; ch <= 'A' + i; ch++) {
          System.out.print(ch);
        }
        System.out.println();
      }
    }
  }
}
