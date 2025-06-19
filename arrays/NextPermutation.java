package arrays;

/* A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1].

*/

public class NextPermutation {

  // Time Complexity: O(N) 
  // Space Complexity: O(1)
  public static void nextPermutation(int[] nums) {

    int n = nums.length;

    int ind = -1;
    for (int i = n - 2; i >= 0; i--) {
      if (nums[i + 1] > nums[i]) {
        ind = i; 
        break;
      }
    }

    if (ind == -1) {
      reverse(nums, 0, n - 1);
      return;
    }

    for (int i = n - 1; i > ind; i--) {
      if (nums[i] > nums[ind]) {
        swap(nums, ind, i);
        break;
      }
    }

    reverse(nums, ind + 1, n - 1);
    return;
  } 

  private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      swap(nums, start, end);
      start++;
      end--;
    }
  }
  public static void main(String[] args) {
    int arr[] = {1, 2, 3};

    System.out.print("Given array: ");
    for (int ele : arr) System.out.print(ele + " ");

    System.out.println();
 
    nextPermutation(arr);

    System.out.print("Next permutation: ");
    for (int ele : arr) System.out.print(ele + " ");
  }
}