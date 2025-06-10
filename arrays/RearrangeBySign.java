package arrays;

class RearrangeBySign {

  // Time Complexity : O(N)
  // Space Complexity : O(1), Extra space for storing the output is not considered.
  private static int[] rearrangeBySign(int[] nums) {
    int n = nums.length; 
    int[] ans = new int[n];

    int posIndex = 0, negIndex = 1; 

    for (int i = 0; i < n; i++) {
      if (nums[i] > 0) {
        ans[posIndex] = nums[i];
        posIndex += 2;  

      } else {

        ans[negIndex] = nums[i];
        negIndex += 2; 
      }
    }

    return ans;
  }
  public static void main(String[] args) {
    int arr[] = {2, 4, 5, -1, -3, -4};
    
    int[] result = rearrangeBySign(arr);

    for (int nums: result) System.out.print(nums + " ");
  }
  
}