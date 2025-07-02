/*
 Given a string, the task is to reverse it. The string is represented by an array of characters s. Perform the reversal in place with O(1) extra memory.
 */

package basicstrings;

import java.util.Arrays;
import java.util.Vector;

public class ReverseStringII {

  // Time Complexity: O(N)
  // Spcae Complexity: O(1)
  public static void reverseString(Vector<Character> s) {

    int left = 0;
    int  right = s.size() - 1;

    while (left < right) {
      char temp = s.get(left);
      s.set(left, s.get(right));
      s.set(right,  temp);

      left++;
      right--;
    }
  } 

  public static void main(String[] args) {
    Vector<Character> str = new Vector<>(Arrays.asList('h', 'e', 'l', 'l', 'o'));
    
    reverseString(str);

    System.out.print("Reversed string: ");
    for (char c : str) {
      System.out.print(c);
    }
  }
}