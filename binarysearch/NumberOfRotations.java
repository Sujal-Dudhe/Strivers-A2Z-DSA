/*
 Given an integer array nums of size n, sorted in ascending order with distinct values. The array has been right rotated an unknown number of times, between 0 and n-1 (including). Determine the number of rotations performed on the array.
 */

package binarysearch;

public class NumberOfRotations {

  // Time Complexity: O(log(N))
  // Space Complexity: O(1)
  public static int findRotations(int[] nums) {
    int low = 0, high = nums.length - 1;
    int min = Integer.MAX_VALUE;
    int index = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      // Search space is already sorted
      if (nums[low] <= nums[high]) {
        if (nums[low] < min) {
          min = nums[low];
          index = low;
        }
        break;
      }

      if (nums[low] <= nums[mid]) {
        if (nums[low] < min) {
          min = nums[low];
          index = low;
        }
        low = mid + 1;
      } else {
        if (nums[mid] < min) {
          min = nums[mid];
          index = mid;
        }
        high = mid - 1;
      }
    }

    return index;
  }

  public static void main(String[] args) {
    int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
    int result = findRotations(arr);

    System.out.println("The array is rotated " + result + " times.");
  }
}
