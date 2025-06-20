package basicmaths;

import java.util.Scanner;

public class PalindromeNum {
  
  public static boolean isPalindrome(int num) {
    int revNum = 0;
    int dup = num;
    while (num > 0) {
      int lastDigit = num % 10;
      revNum = revNum * 10 + lastDigit;
      num /= 10;
    }
    if (dup == revNum) return true;
    else return false;
  }

  public static void main(String[] args) {
    System.out.print("Enter a number : ");
    try(Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(n + " is palindrome : " + isPalindrome(n));
    }
  }
}
