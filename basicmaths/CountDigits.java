package basicmaths;

import java.util.Scanner;
import java.lang.Math;

@SuppressWarnings("unused")
class CountDigits {
  public static int count(int number) {
    // Time complexity : O(log(n))
    int count = 0;
    while (number > 0) {
      count++;
      number /= 10;

    }
    return count;
  } 
  
  // public static int count(int n) {
  //   int count = (int) (Math.log10(n) + 1);
  //   return count;
  // }

  public static void main (String[] args) {
    System.out.print("Enter the number : ");
    try (Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println("Number of digits : " + count(n));
    }
    
  }
}