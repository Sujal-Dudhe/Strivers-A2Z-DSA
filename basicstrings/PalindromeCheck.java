/*
 You are given a string s. Return true if the string is palindrome, otherwise false. A string is called palindrome if it reads the same forward and backward.
 */

package basicstrings;

public class PalindromeCheck {

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public static boolean isPalindrome(String s) {

    int left = 0;
    int right = s.length() - 1;

    // Convert the entire string to lowercase once for case-insensitive comparison.
    s = s.toLowerCase(); 

    while (left < right) {
      if (s.charAt(left) != s.charAt(right)) return false;
      left++;
      right--;
    }

    return true;
  }

  public static void main(String[] args) {
    String str = "Racecar";

    if (isPalindrome(str)) {
      System.out.println(str + " is a palindrome.");
    } else {
      System.out.println(str + " is not a palindrome.");
    }
  }
}
