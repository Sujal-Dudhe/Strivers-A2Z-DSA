/*
 Given a sorted array of nums consisting of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 */

package binarysearch;

public class SearchInsertPos {

  // Time Complexity: O(log(N))
  // Space Complexity: O(1)
  public static int searchInsert(int[] nums, int target) {
    int result = nums.length;
    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[mid] >= target) {
        result = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 6};
    int target = 4;

    int index = searchInsert(nums, target);

    System.out.println("The index is: " + index);
  }
}