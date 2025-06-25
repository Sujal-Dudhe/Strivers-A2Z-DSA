/*
 Given two integer arrays nums1 and nums2. Both arrays are sorted in non-decreasing order.

- Merge both the arrays into a single array sorted in non-decreasing order.
- The final sorted array should be stored inside the array nums1 and it should be done in-place.
- nums1 has a length of m + n, where the first m elements denote the elements of nums1 and rest are 0s.
- nums2 has a length of n.
 */

package arrays;
import java.util.Arrays;

public class MergeSortedArr {

  // Time Complexity: O(min(m, n)) + O(m log m) + O(n log n) + O(n)
  // Space Complexity: O(1)
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    
    // end of first array i.e., nums1
    int left = m - 1;
    // start of second array i.e., nums2
    int right = 0;
    
    while (left >= 0 && right < n) {
      if (nums1[left] > nums2[right]) {
        swap(nums1, nums2, left, right);
        left--;
        right++;
      } else {
        break;
      }
    }
    
    Arrays.sort(nums1, 0, m);
    Arrays.sort(nums2);
    
    for (int i = m; i < m + n; i++) {
      nums1[i] = nums2[i - m];
    }
  }

  private static void swap(int[] nums1, int[] nums2, int ind1, int ind2) {
    int temp = nums1[ind1];
    nums1[ind1] = nums2[ind2];
    nums2[ind2] = temp; 
  }

  public static void main(String[] args) {
    int[] arr1 = {0, 2, 7, 8, 0, 0, 0};
    int[] arr2 = {-7, -3, -1};
    int m = 4;
    int n = arr2.length;

    merge(arr1, m, arr2, n);

    System.out.print("The merged arrays are: ");
    System.out.print("nums1[] = ");
    for (int num : arr1) {
      System.out.print(num + " ");
    }
    System.out.println();
  }
}