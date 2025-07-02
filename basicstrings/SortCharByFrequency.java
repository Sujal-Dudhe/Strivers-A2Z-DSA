package basicstrings;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class SortCharByFrequency {
  
  // Time Complexity: O(n + klogk), where n is the length of the string and k is the number of unique characters.
  // Space Complexity: O(k)
  public static List<Character> sortCharByFreq(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();  
    for (char c : s.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    List<Character> chars = new ArrayList<>(freqMap.keySet());
    chars.sort((a, b) -> {
      int compareFreq = freqMap.get(b) - freqMap.get(a);
      return compareFreq != 0 ? compareFreq : a-b;
    });

    return chars;
  }

  public static void main(String[] args) {
    String s = "tree";
    List<Character> result = sortCharByFreq(s);
    System.out.println(result);
  }
}
