/*
 Given an array of integers nums and an integer k, return the total number of subarrays whose XOR equals to k.
 */

package hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArrWithXorK {

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public static int subarraysWithXorK(int[] nums, int k) {
    int n = nums.length;
    int xor = 0;
    Map<Integer, Integer> mp = new HashMap<>();
    mp.put(xor, mp.getOrDefault(xor, 0) + 1);

    int count = 0;
    for (int i = 0; i < n; i++) {

      xor ^= nums[i];
      int x = xor ^ k;

      count += mp.getOrDefault(x, 0);

      mp.put(xor, mp.getOrDefault(xor, 0) + 1);
    }

    return count;
  }

  public static void main(String[] args) {
    int[] arr = {5, 2, 9};
    int k = 7;

    int result = subarraysWithXorK(arr, k);

    System.out.println("The number of subarrays with XOR " + k + " is: " + result);
  }
}