package basicrecursion;

import java.util.Scanner;

public class StringPalindrome {
  public static boolean isPalindrome(String str, int i) {
    int n = str.length();
    if (i >= n/2) return true;
    // Character.toLowerCase() is used to handle case insensitivity by converting both characters to lowercase and then check if they are equal or not.
    // This will handle any type of String input
    if (Character.toLowerCase(str.charAt(i)) != Character.toLowerCase(str.charAt(n-i-1))) return false;
    else return isPalindrome(str, i+1);
    
  }
  public static void main(String[] args) {
    System.out.print("Enter a String: ");
    try (Scanner sc = new Scanner(System.in)) {
      String str = sc.next();

      System.out.print("\""+ str +"\" is palindrome: " + isPalindrome(str, 0));
    }
  }
}