package arrays;

public class SortZeroOneTwo {
  
  /* 
  // Better Approach
  // Time Complexity: O(N) + O(N) = O(2N), There are 2 traversals in the array to count the frequencies then in second iteration we are overwriting.
  // Space Complexity: O(1), no extra space is used.
  public static void sort_012(int[] nums) {
    int n = nums.length;

    // count the numbers of 0, 1 and 2 in the array
    int cnt0 = 0;
    int cnt1 = 0;
    int cnt2 = 0;

    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) cnt0++; 
      else if (nums[i] == 1) cnt1++;
      else cnt2++;
    }

    // insert 0's
    for (int i = 0; i < cnt0; i++) {
      nums[i] = 0;
    }
    // insert 1's
    for (int j = cnt0; j < cnt0 + cnt1; j++) {
      nums[j] = 1;
    }
    // insert 2's
    for (int k = cnt0 + cnt1; k < cnt0 + cnt1 + cnt2; k++) {
      nums[k] = 2;
    }
  }
  */


  // Optimal Approach (Dutch National flag algorithm)
  // Time Complexity: O(N), as there is single traversal of the array.
  // Space Complexity: O(1)
  public static void sort_012(int[] nums) {
    int low = 0; 
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {

      if (nums[mid] == 0) {
        int temp = nums[mid];
        nums[mid] = nums[low];
        nums[low] = temp;

        low++;
        mid++;

      } else if (nums[mid] == 1) {
        mid++;

      } else {
        int temp = nums[mid];
        nums[mid] = nums[high];
        nums[high] = temp;

        high--;
      }

    }
  }
  public static void main(String[] args) {
    int[] arr = {2, 1, 0, 1, 0, 2, 2, 1};

    sort_012(arr);

    System.out.print("After sorting: ");
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}