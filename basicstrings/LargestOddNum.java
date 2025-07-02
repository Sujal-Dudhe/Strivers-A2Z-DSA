package basicstrings;

public class LargestOddNum {

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public static String largeOddNum(String s) {

    int index = -1;
    // find the index of last odd digit
    for (int i = s.length() - 1; i >= 0; i--) {
      if ((s.charAt(i) - '0') % 2 == 1) {
        index = i;
        break;
      }
    }

    // If odd digit from last is not found
    if (index == -1) return "";

    // Find index of first non-zero digit from the start
    int i = 0;
    while (i < s.length()) {
      if (s.charAt(i) - '0' <= 0) {
        i++;
      } else {
        break;
      }
    }

    return s.substring(i, index + 1);
  }

  public static void main(String[] args) {
    String num = "00214638";
    String result = largeOddNum(num);
    System.out.println("Largest odd number: " + result);
  }
}
