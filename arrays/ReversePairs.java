package arrays;

/* An index pair (i, j) is called a reverse pair if:
- 0 <= i < j < nums.length
- nums[i] > 2 * nums[j]. */

import java.util.ArrayList;
import java.util.List;

public class ReversePairs {

  private static int countPairs(int[] nums, int low, int mid, int high) {
    int right = mid + 1;

    int cnt = 0;
    for (int i = low; i <= mid; i++) {
            
      while (right <= high && nums[i] > nums[right] * 2) {
        right++;
      }
      cnt += (right - (mid + 1));
    }

    return cnt;
  }

  private static void merge(int[] nums, int low, int mid, int high) {

    List<Integer> temp = new ArrayList<>();
    int left = low;
    int right = mid + 1;

    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        temp.add(nums[left]);
        left++;
      } else {
          temp.add(nums[right]);
          right++;
      }
    }

    while (left <= mid) {
      temp.add(nums[left]);
      left++;
    }

    while (right <= high) {
      temp.add(nums[right]);
      right++;
    }

    for (int i = low; i <= high; i++) {
      nums[i] = temp.get(i - low);
    }
        
  }

  private static int mergeSort(int[] nums, int low, int high) {
    int cnt = 0;
    if (low >= high) return cnt;

    int mid = low + (high - low) / 2;

    cnt += mergeSort(nums, low, mid);
    cnt += mergeSort(nums, mid + 1, high);
    cnt += countPairs(nums, low, mid, high);
    merge(nums, low, mid, high);

    return cnt;
  }

  // Time Complexity: O(2N * logN)
  // Space Complexity: O(N)
  public static int reversePairs(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    int[] arr = {6, 4, 1, 2, 7};

    int result = reversePairs(arr);
    System.out.println("The number of reverse pairs is: " + result);
  }
}