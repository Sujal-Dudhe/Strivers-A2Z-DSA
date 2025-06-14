package arrays;
import java.util.Map;
import java.util.HashMap;

// Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such that they add up to target.
public class TwoSum {

  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> mp = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];

      int moreNeeded = target - num;

      if (mp.containsKey(moreNeeded)) {
        return new int[] {mp.get(moreNeeded), i};
      }

      mp.put(num, i);
    }

    return new int[] {-1, -1};
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 5, -7, 6, -3};
    int target = 0;

    int[] ans = twoSum(arr, target);

    System.out.println("This is the answer: [" + ans[0] + ", " + ans[1] + "]");
  }
}