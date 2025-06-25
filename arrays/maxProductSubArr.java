package arrays;

public class maxProductSubArr {

  // Time Complexity: O(N)
  // Space Complexity: O(1)
  public static int maxProduct(int[] nums) {
    int currPrefixProd = 1, currSuffixProd = 1;

    int result = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
        
      // Reset prefix and suffix to 1 when it becomes 0 to start a new subarray.
      if (currPrefixProd == 0) currPrefixProd = 1;
      if (currSuffixProd == 0) currSuffixProd = 1;

      currPrefixProd  *= nums[i];
      currSuffixProd *= nums[nums.length - i - 1];

      result = Math.max(result, Math.max(currPrefixProd, currSuffixProd));
    }
    return result;
  }

  public static void main(String[] args) {
    int[] arr = {1, -2, 3, 4, -4, -3};

    int result = maxProduct(arr);

    System.out.println("The product of elements in maximum product subarray is: " + result);
  }
}