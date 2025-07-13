/*
 Given n roses and an array nums where nums[i] denotes that the 'ith' rose will bloom on the nums[i]th day, only adjacent bloomed roses can be picked to make a bouquet. Exactly k adjacent bloomed roses are required to make a single bouquet. Find the minimum number of days required to make at least m bouquets, each containing k roses. Return -1 if it is not possible.
*/
package binarysearch;

public class MinDaysToMakeMBouquets {

  // Time Complexity: O((max-min+1) * N), where max is the maximum element of the array, min is the minimum element of the array, N is size of the array.
  // Space Complexity: O(1)
  public static int roseGarden(int n, int[] nums, int k, int m) {
     
    if (n < m * k) return -1;

      int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
      for (int i = 0; i < n; i++) {
        min = Math.min(min, nums[i]);
        max = Math.max(max, nums[i]);
      }

      int low = min, high = max;
      while (low <= high) {
        int mid = low + (high - low) / 2;

        if (possible(nums, mid, k, m)) {
          high = mid - 1;
        } else {
            low = mid + 1;
        }
      }
    return low;
  }

  private static boolean possible(int[] nums, int day, int k, int m) {
    int n = nums.length;
    int count = 0, noOfBouquets = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] <= day) {
        count++;
      } else {
        noOfBouquets += (count / k);
        count = 0;
      }
    }
    noOfBouquets += (count / k);
    return noOfBouquets >= m;
  }

  public static void main(String[] args) {
    int[] arr = {1, 10, 3, 10, 2};
    int n = arr.length;

    // Number of flowers per bouquet
    int k = 1;
    // Number of bouquets needed
    int m = 3;

    int result = roseGarden(n, arr, k, m);

    if (result == -1) {
      System.out.println("We cannot make m bouquets."); 
    } else {
      System.out.println("We can make bouquets on day " + result); 
    }
  }
}
