package arrays;

public class KadanesAlgo {

  // Optimal Approach (Kadane's Algorithm)
  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public static int maxSubarraySum(int[] nums) {  
    int max = Integer.MIN_VALUE;

    int sum = 0;

    int start = 0;
    int ansStart = 0, ansEnd = 0;

    for (int i = 0; i < nums.length; i++) {
      
      if (sum == 0) start = i;
      sum += nums[i];

      if (sum > max) {
        max = sum;
        ansStart = start;
        ansEnd = i;
      }
      if (sum < 0) sum = 0;
      
    }

    System.out.print("The subarray is: [");
    for (int i = ansStart; i <= ansEnd; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.print("]");
    System.out.println();

    return max;
  }
  public static void main(String[] args) {
    int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    int maxSum = maxSubarraySum(arr);

    System.out.println("The maximum subarray sum is: " + maxSum);
  }
}