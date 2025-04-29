package basicrecursion;

import java.util.Scanner;

public class SumNumbers {
  public static int sum(int n) {
    if (n == 0) return 0;
    else  return n + sum(n-1);
  }
  public static void main(String[] args) {
    System.out.print("Enter a Number: ");
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.print("Sum of first " + n + " numbers: " + sum(n));
    }
  }
}