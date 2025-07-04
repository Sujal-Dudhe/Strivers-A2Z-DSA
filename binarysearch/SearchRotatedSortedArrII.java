/*
 Given an integer array nums, sorted in ascending order (may contain duplicate values) and a target value k. Now the array is rotated at some pivot point unknown to you. Return True if k is present and otherwise, return False.
 */

package binarysearch;

public class SearchRotatedSortedArrII {

  // Time Complexity: O(log(N)) for best and average cases. O(N/2) int the worst case, where all array elements are same but not the target. we continue to reduce the search space by adjusting the low and high pointers until they intersect, which will end up taking O(N/2) time complexity.

  // Space Complexity: O(1)
  public static boolean search(int[] nums, int target) {

    int n = nums.length;
    int low = 0, high = n - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[mid] == target) return true;

      if ((nums[low] == nums[mid]) && (nums[mid] == nums[high])) {
        low++;
        high--;
        continue;
      }

      if (nums[low] <= nums[mid]) { // check if the left part is sorted

        if (nums[low] <= target && target <= nums[mid]) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      } else {  // Check if the right part is sorted

        if (nums[mid] <= target && target <= nums[high]) {
          low = mid + 1;
        } else {
          high = mid - 1;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    int[] arr = {7, 8, 1, 2, 3, 3, 3, 4, 5, 6};
    int k = 3;

    if (search(arr, k)) {
      System.out.println("Target is present in the array.");
    } else {
      System.out.println("Target is not present.");
    }
  }
}