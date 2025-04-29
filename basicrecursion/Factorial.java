package basicrecursion;

import java.util.Scanner;

public class Factorial {
  public static int fact(int n) {
    if (n == 1) return 1;
    else return n * fact(n-1);
  }
  public static void main(String[] args) {
    System.out.print("Enter a Number: ");
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.print("Factorial of " + n + " is: " + fact(n));
    }
  }
}