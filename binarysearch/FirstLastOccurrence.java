/*
 Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value. If the target is not found in the array, return [-1, -1].
 */

 package binarysearch;

 public class FirstLastOccurrence {

  // Time Complexity: O(log(N))
  // Space Complexity: O(1)
  public static int[] searchRange(int[] nums, int target) {

    int firstOcc = firstOccurrence(nums, target);
    if (firstOcc == -1) return new int[] {-1, -1};
    int lastOcc = lastOccurrence(nums, target);
    return new int[] {firstOcc, lastOcc};
  }

  private static int firstOccurrence(int[] nums, int target) {
    int firstOcc = -1;
    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[mid] == target) {
        firstOcc = mid;
        high = mid - 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return firstOcc;
  }

  private static int lastOccurrence(int[] nums, int target) {
    int lastOcc = -1;
    int low = 0, high = nums.length - 1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[mid] == target) {
        lastOcc = mid;
        low = mid + 1;
      } else if (nums[mid] < target) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return lastOcc;
  }
 
  public static void main(String[] args) {
    int[] arr = {5, 7, 7, 8, 8, 10};
    int target = 8;

    int[] result = searchRange(arr, target);
    System.out.println("First Occurrence index: " + result[0]);
    System.out.println("Last Occurrence index: " + result[1]);
  }
 }