package arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

  // Optimal Approach
  // Time Complexity: O(NlogN * N^3)
  // Space Complexity: O(1), excluding the extra space used for storing the output list.
  public static List<List<Integer>> fourSum(int[] nums, int target) {
  List<List<Integer>> result = new ArrayList<>();
        
  Arrays.sort(nums); // O(N*logN)

  int n = nums.length;
  for (int i = 0; i < n; i++) {
    if (i > 0 && nums[i] == nums[i - 1]) continue;

    for (int j = i + 1; j < n; j++) {
      if (j > i + 1 && nums[j] == nums[j - 1]) continue;

      int k = j + 1;
      int l = n - 1;

      while (k < l) {
        long sum = nums[i] + nums[j];
        sum += nums[k];
        sum += nums[l];

        if (sum < target) {
          k++;

        } else if (sum > target) {
          l--;

        } else {
          List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);

          result.add(temp);

          k++;
          l--;
          while (k < l && nums[k] == nums[k - 1]) k++;
          while (k < l && nums[l] == nums[l + 1]) l--;
        }
      }
    }
  }

    return result;
  }
  public static void main(String[] args) {
    int[] nums = {1, -2, 3, 5, 7, 9};
    int target = 7;

    List<List<Integer>> quad = fourSum(nums, target);

    System.out.print("The quadruplets are: ");
    for (List<Integer> num : quad) {
      System.out.print("[");
      for (Integer ele : num) {
        System.out.print(ele + " ");
      }
      System.out.print("]");
    }
  }
}