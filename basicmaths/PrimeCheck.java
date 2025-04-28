package basicmaths;

import java.util.Scanner;

// Number that has 2 factors i.e., 1 and itself.
public class PrimeCheck {
  
  public static boolean isPrime(int n) {
    int count = 0;
    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        count++;
        if (n/i != i) {
          count++;
        }
      }
    }
    return count == 2;
  }

  public static void main(String[] args) {
    System.out.print("Enter a number : ");
    try(Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(n + " is Prime : " + isPrime(n));
    }
  }
}
