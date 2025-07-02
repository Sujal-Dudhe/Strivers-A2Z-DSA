/*
 Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.
For example, if s = "abcde", then it will be "bcdea" after one shift.
 */

package basicstrings;

public class RotateString {
  
  /* 
  // Brute approach
  // Time Complexity: O(N^2), due to the loop and string concatenation and equals operation, each taking O(n) time.
  // Space Complexity: O(N), due to the creation of the rotated string in each iteration.
  public static boolean rotateString(String s, String goal) {
    
    if (s.length() != goal.length()) return false;

    for (int i = 0; i < s.length(); i++) {
      String rotated = s.substring(i) + s.substring(0, i);
      if (rotated.equals(goal)) return true;
    }
    return false;
  }
  */

  // Optimal approach
  // Time Complexity: O(N), due to string concatenation and contains method.
  // Space Complexity: O(N), due to the creation of doubled string which requires extra space.
  public static boolean rotateString(String s, String goal) {

    if (s.length() != goal.length()) return false;
    String doubledStr = s + s;
    return doubledStr.contains(goal);
  }

  public static void main(String[] args) {
    System.out.println(rotateString("abcde", "cdeab"));  
    System.out.println(rotateString("abcde", "abced"));
  }
}
