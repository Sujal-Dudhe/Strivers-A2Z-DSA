/*
 Given an array nums of n integers, return the length of the longest sequence of consecutive integers. The integers in this sequence can appear in any order.
 */

package hashing;

import java.util.Set;
import java.util.HashSet;

public class LongestConsSubsequence {

  // Time Complexity: O(N) + O(2*N) => O(3N)
  // Spcace Complexity: O(N)
  public static int longestSubsequence(int[] nums) {

    int n = nums.length;
    if (n == 0) return 0;

    int longest = 1;
    Set<Integer> s = new HashSet<>();

    for (int num : nums) {
      s.add(num);
    }

    for (Integer it : s) {
      int count = 0;
      if (!s.contains(it - 1)) {

        int x = it;
        count = 1;
        while (s.contains(x + 1)) {
          x++;
          count++;
        }
      }
      longest = Math.max(longest, count);
    }

    return longest;
  }
  
  public static void main(String[] args) {
    int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

    int result = longestSubsequence(arr);

    System.out.println("The longest consecutive sequence is: " + result);
  }
}