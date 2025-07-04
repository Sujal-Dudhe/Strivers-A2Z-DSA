/*
 Given an integer array nums of size N, sorted in ascending order with distinct values, and then rotated an unknown number of times (between 1 and N), find the minimum element in the array.
 */

package binarysearch;

public class MinInRotatedSortedArr {

  // Time Complexity: O(log(N))
  // Space Complexity: O(1)
  public static int findMinimum(int[] nums) {

    int low = 0, high = nums.length - 1;
    int min = Integer.MAX_VALUE;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[low] <= nums[high]) {
        min = Math.min(min, nums[low]);
        break;
      }

      if (nums[low] <= nums[mid]) {
        min = Math.min(min, nums[low]);
        low = mid + 1;
      } else {
        min = Math.min(min, nums[mid]);
        high = mid - 1;
      }

    }
    return min;
  }

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, -7, 1, 2, 3};
    int result = findMinimum(arr);

    System.out.println("The minimum element is: " + result);
  }
}
