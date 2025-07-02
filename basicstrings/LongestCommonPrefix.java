package basicstrings;

public class LongestCommonPrefix {

  // Time Complexity: O(N * log N + M), where N is the number of strings and M is the minimum length of a string. 
  // Space Complexity: O(M)
  public static String longestCommonPrefix(String[] s) {
    int n = s.length;
    String first = s[0];
    String last = s[n - 1];

    StringBuilder result = new StringBuilder();

    for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
      if (first.charAt(i) != last.charAt(i)) return result.toString();
      result.append(first.charAt(i));
    }

    return result.toString();
  }

  public static void main(String[] args) {
    String[] str = {"flowers" , "flow" , "fly", "flight"};

    String result = longestCommonPrefix(str);

    System.out.println("Longest common prefix: " + result);
  }
}