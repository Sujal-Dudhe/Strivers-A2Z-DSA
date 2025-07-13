/*
 Given an array of integers nums and an integer limit as the threshold value, find the smallest positive integer divisor such that upon dividing all the elements of the array by this divisor, the sum of the division results is less than or equal to the threshold value.
Each result of the division is rounded up to the nearest integer greater than or equal to that element.
 */
package binarysearch;

public class FindSmallestDivisor {  

  // Time Complexity: O(log(max)*N), where max is the maximum element in the array, N is size of the array.
  // Space Complexity: O(1)
  public static int smallestDivisor(int[] nums, int limit) {
    int n = nums.length;
    if (n > limit) return -1;
    int result = -1;

    int maxEle = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      maxEle = Math.max(maxEle, nums[i]);
    }

    int low = 1, high = maxEle;
    while (low <= high) {
      int mid = (low + high) / 2;
      
      if (sumByDivisor(nums, mid) <= limit) {
        result = mid;
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return result;
  }

  private static int sumByDivisor(int[] nums, int divisor) {
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += Math.ceil((double) nums[i] / (double) divisor);
    }

    return sum;
  }
  public static void main(String[] args) {
    int[] nums = {1, 2, 3, 4, 5};
    int limit = 8;

    int result = smallestDivisor(nums, limit);
    System.out.println("The minimum divisor is: " + result);
  }
}
