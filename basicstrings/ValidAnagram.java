/*
 Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

package basicstrings;

public class ValidAnagram {

  /* 
  // Brute approach
  // Time Complexity: O(N*logN) + O(M*logM), due to sorting each string.
  // Space Complexity: O(N), due to creation of character arrays.
  public static boolean anagramStrings(String s, String t) {
    
    if (s.length() != t.length()) return false;

    char[] sArray = s.toCharArray();
    char[] tArray = t.toCharArray();
    Arrays.sort(sArray);
    Arrays.sort(tArray);
        
    return Arrays.equals(sArray, tArray);
  }
  */

  // Optimal approach
  // Time Complexity: O(n) due to iterating through the strings and the count array
  // Space Complexity: O(1) because the count array has a fixed size of 26, regardless of the input string size.
  public static boolean anagramStrings(String s, String t) {

    if (s.length() != t.length()) return false;

    int[] count = new int[26];
    for (char c : s.toCharArray()) count[c - 'a']++;
    for (char c : t.toCharArray()) count[c - 'a']--;

    for (int i : count) {
      if (i != 0) return false;
    }

    return true;
  }

  public static void main(String[] args) {
    String str1 = "integer";
    String str2 = "tegerni";

    if (anagramStrings(str1, str2)) System.out.println("The given strings are anagrams.");
    else System.out.println("The given strings are not anagrams.");
  }
}
