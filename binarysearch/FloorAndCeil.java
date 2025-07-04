/*
 Given a sorted array nums and an integer x. Find the floor and ceil of x in nums. The floor of x is the largest element in the array which is smaller than or equal to x. The ceiling of x is the smallest element in the array greater than or equal to x. If no floor or ceil exists, output -1.
 */

package binarysearch;

public class FloorAndCeil {

  // Time Complexity: O(log(N))
  // Space Complexity: O(1)
  public static int[] getFloorAndCeil(int[] nums, int x) {
    int floor = getFloor(nums, x);
    int ceil = getCeil(nums, x);

    return new int[] {floor, ceil};
  }

  private static int getFloor(int[] nums, int x) {
    int low = 0, high = nums.length - 1;
    int floor = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[mid] <= x) {
        floor = nums[mid];
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return floor;
  }

  private static int getCeil(int[] nums, int x) {
    int low = 0, high = nums.length - 1;
    int ceil = -1;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (nums[mid] >= x) {
        ceil = nums[mid];
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return ceil;
  }
  
  public static void main(String[] args) {
    int[] arr = {2, 4, 6, 8, 10, 12, 14};
    int x = 1;

    int[] result = getFloorAndCeil(arr, x);

    System.out.println("Floor: " + result[0] + " " + "Ceil: " + result[1]);
  }
}
