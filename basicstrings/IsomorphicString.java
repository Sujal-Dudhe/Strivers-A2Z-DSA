/*
 Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
*/

package basicstrings;

import java.util.Map;
import java.util.HashMap;

public class IsomorphicString {

  // Time Complexity: O(N)
  // Space Complexity: O(1) as the size of the HashMaps, mp1 and mp2, is bounded by the size of the character set, which is constant.
  public static boolean isIsomorphicStr(String s, String t) {

    // If lengths differ, strings cannot be isomorphic
    if (s.length() != t.length()) return false;

    // charMap: Tracks mappings from characters in 's' to 't'
    // usedChars: Ensures no two characters in 's' map to the same character in 't'
    Map<Character, Character> charMap = new HashMap<>();
    Map<Character, Boolean> usedChars = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      char ch1 = s.charAt(i);
      char ch2 = t.charAt(i);

      // If ch1 is already mapped, check consistency
      if (charMap.containsKey(ch1)) {
        if (charMap.get(ch1) != ch2) {
          return false; // Inconsistent mapping
        }
      } else {
        // If ch2 is already used by another character in 's', reject
        if (usedChars.containsKey(ch2)) {
          return false;
        } else {
          // create new mapping and mark ch2 as used
          charMap.put(ch1, ch2);
          usedChars.put(ch2, true);
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String str1 = "paper";
    String str2 = "title";

    if (isIsomorphicStr(str1, str2)) {
      System.out.println("Strings are isomorphic.");
    } else {
      System.out.println("Strings are not isomorphic.");
    }
  }
}
