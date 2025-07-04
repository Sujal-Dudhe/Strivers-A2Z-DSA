/*
 Given an array nums sorted in non-decreasing order. Every number in the array except one appears twice. Find the single number in the array.
 */

package binarysearch;

public class SingleElementInArr {

  // Time Complexity: O(log(N))
  // Space Complexiy: O(1)
  public static int findSingleNonDuplicateELe(int[] nums) {
    int n = nums.length;
    if (n == 1) return nums[0];
    if (nums[0] != nums[1]) return nums[0]; // Check for first index
    if (nums[n - 1] != nums[n - 2]) return nums[n - 1]; // Check for last index
    
    int low = 1, high = n - 2;

    while (low <= high) {
      int mid = (low + high) / 2;

      // If nums[mid] is the single element
      if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) return nums[mid];

      // We are in the left part:
      if ((mid % 2 == 1 && nums[mid - 1] == nums[mid])
        || (mid % 2 == 0 && nums[mid + 1] == nums[mid])) {
        // Eliminate the left half
        low = mid + 1;
      } 
      // We are in the right part:
      else {
        // Eliminate the right half
        high = mid - 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
    int result = findSingleNonDuplicateELe(arr);

    System.out.println("The single element is: " + result);
  }
}
