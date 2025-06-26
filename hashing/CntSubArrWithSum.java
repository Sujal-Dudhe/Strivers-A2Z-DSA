/*
 Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 */

package hashing;

import java.util.HashMap;
import java.util.Map;

public class CntSubArrWithSum {

  // Time Complexity: O(N)
  // Space Complexity: O(N), in the worst case due to the HashMap potentially storing n prefix sums.
  public static int countSubarray(int[] nums, int k) {
    int n = nums.length;
    Map<Integer, Integer> mp = new HashMap<>();
    mp.put(0, 1);

    int currPrefixSum = 0, count = 0;

    for (int i = 0; i < n; i++) {
      currPrefixSum += nums[i];

      int sumToRemove = currPrefixSum - k;
      count += mp.getOrDefault(sumToRemove, 0);
      mp.put(currPrefixSum, mp.getOrDefault(currPrefixSum, 0) + 1);
    }

    return count;
  }
  public static void main(String[] args) {
    int[] arr = {3, 1, 2, 4};
    int k = 6;

    int result = countSubarray(arr, k);

    System.out.println("The number of subarrays with given sum is: " + result);
  }
}
