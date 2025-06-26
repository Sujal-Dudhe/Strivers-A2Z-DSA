/*
 Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.
 */

package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArr {

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public static int longestSubArrWithSumK(int[] nums, int k) {

    int n = nums.length;
    Map<Integer, Integer> prefixSumIndMap = new HashMap<>();

    int prefixSum = 0;
    int maxLen = 0;
    for (int i = 0; i < n; i++) {
      prefixSum += nums[i];

      if (prefixSum == k) maxLen = Math.max(maxLen, i + 1);

      int rem = prefixSum - k;
      if (prefixSumIndMap.containsKey(rem)) {
        int len = i - prefixSumIndMap.get(rem);
        maxLen = Math.max(maxLen, len);
      }

      if (!prefixSumIndMap.containsKey(prefixSum)) {
        prefixSumIndMap.put(prefixSum, i);
      }
    }

    return maxLen;
  }
  
  public static void main(String[] args) {
    int[] arr = {10, 5, 2, 7, 1, 9};
    int k = 15;

    int result = longestSubArrWithSumK(arr, k);

    System.out.println("The length of the longest subarray is: " + result);
  }
}
