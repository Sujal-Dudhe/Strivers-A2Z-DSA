package arrays;
import java.util.List;
import java.util.ArrayList;

/* Two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
-It indicates how close an array is to being sorted.
- A sorted array has an inversion count of 0.
- An array sorted in descending order has maximum inversion. */

public class CountInversions {

  // Time Complexity: O(NlogN)
  // Space Complexity: O(N)
  public static long numOfInversions(int[] nums) {
    int n = nums.length;
    return mergeSort(nums, 0, n - 1);
  }

  private static long merge(int[] nums, int low, int mid, int high) {

    long cnt = 0;
    List<Integer> temp = new ArrayList<>();

    int left = low, right = mid + 1;

    while (left <= mid && right <= high) {
      if (nums[left] <= nums[right]) {
        temp.add(nums[left]);
        left++;
      } else {
        temp.add(nums[right]);
        right++;
        
        // Count inversions
        cnt += (mid - left + 1);
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

    return cnt;
  }

  private static long mergeSort(int[] nums, int low, int high) {
    long cnt = 0;
    if (low < high) {
      int mid = low + (high - low) / 2;

      cnt += mergeSort(nums, low, mid);
      cnt += mergeSort(nums, mid + 1, high);
      cnt += merge(nums, low, mid, high);
    }

    return cnt;
  }


  public static void main(String[] args) {
    int[] arr = {2, 3, 7, 1, 3, 5};

    long result = numOfInversions(arr);

    System.out.println("The number of inversions is: " + result);
  }
}