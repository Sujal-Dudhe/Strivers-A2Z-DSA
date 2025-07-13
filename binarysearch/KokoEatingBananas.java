/*
 A monkey is given n piles of bananas, where the 'ith' pile has nums[i] bananas. An integer h represents the total time in hours to eat all the bananas.
Each hour, the monkey chooses a non-empty pile of bananas and eats k bananas. If the pile contains fewer than k bananas, the monkey eats all the bananas in that pile and does not consume any more bananas in that hour.

Determine the minimum number of bananas the monkey must eat per hour to finish all the bananas within h hours.
 */
package binarysearch;

public class KokoEatingBananas {

  // Time Complexity: O(N*log(max))
  // Space Complexity: O(1)
  public static int minimumRateToEatBananas(int[] nums, int h) {
    int low = 1, high = findMax(nums);
    int result = high;

    while (low <= high) {
      int mid = (low + high) / 2;
      long requiredTime = calculateTotalHours(nums, mid);

      if (requiredTime <= (long) h) {
        result = mid;
        high =  mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return result;
  }

  private static int findMax(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, nums[i]);
    }
    return max;
  } 

  private static long calculateTotalHours(int[] nums, int hourly) {
    long totalHours = 0;
    for (int i = 0; i < nums.length; i++) {
      totalHours += Math.ceil((double) nums[i] / (double) hourly);
    }
    return totalHours;
  }

  public static void main(String[] args) {
    int[] nums = {7, 15, 6, 3};
    int h = 8;

    int result = minimumRateToEatBananas(nums, h);

    System.out.println("Koko should eat at least " + result + " Bananas/hr.");
  }
}
