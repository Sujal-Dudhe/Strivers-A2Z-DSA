/*
 Given an integer array nums, sorted in ascending order (with distinct values) and a target value k. The array is rotated at some pivot point that is unknown. Find the index at which k is present and if k is not present return -1.
 */
package binarysearch;

public class SearchRotatedSortedArrI {

  // Time Complexity: O(log(N))
  // Space Complexity: O(1)
  public static int search(int[] nums, int target) {

    int n = nums.length;
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[mid] == target) return mid;

      if (nums[low] <= nums[mid]) { // check if left part is sorted

        if (nums[low] <= target && target <= nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }

      } else { // check if right part is sorted
        
        if (nums[mid] <= target && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {7, 8, 9, 1, 2, 3, 4, 5, 6};
    int k = 1;

    int result = search(arr, k);
    if (result == -1)
      System.out.println("Target is not present.");
    else
      System.out.println("The index is: " + result);
  }
}
