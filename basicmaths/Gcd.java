package basicmaths;

import java.lang.Math;
import java.util.Scanner;

// Greatest common divisor e.g., GCD(11, 13) = 1, GCD(10, 5) = 5
@SuppressWarnings("unused")
public class Gcd {

   // Optimal/Efficient approach i.e., using eucledian algorithm (O(log(min(a,b))))
  // GCD(a, b) = GCD (a-b, b) where, a > b
  // GCD(a, b) = GCD (a%b, b) where, a > b
  public static int getGCD(int a, int b) {
    while (a > 0 && b > 0) {
      if (a > b) a = a % b;
      else b = b % a;
    }
    if (a == 0) return b;
    return a;
  }

  //  Time Complexity: O(min(n1,n2))
  // public static int getGCD(int n1, int n2) {
  //   int n = Math.min(n1, n2);
  //   int gcd = 1;
  //   for (int i = 1; i <= n; i++) {
  //     if (n1%i == 0 && n2 %i == 0) gcd = i;
  //   }
  //   return gcd;
  // }

  // Better approach
  // public static int getGCD(int m, int n) {
  //   int gcd = 1;
  //   for (int i = Math.min(m, n); i >= 1; i--) {
  //     if (m%i == 0 && n%i == 0) {
  //       gcd = i;
  //       break; // breaks the outer loop i.e., for loop here
  //     }
  //   }
  //   return gcd;
  // }

  public static void main(String[] args) {
    System.out.print("Enter numbers to find GCD : ");
    try(Scanner sc = new Scanner(System.in)) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      System.out.println("GCD of " + m + " and " + "n : " +getGCD(m, n));
    }
  }
}
