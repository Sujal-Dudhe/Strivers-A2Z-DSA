package basichashing;

import java.util.HashMap;
import java.util.Map;

public class SumHighLowFreq {
  
  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public static int sumOfHighestAndLowestFreq(int[] nums) {

    Map<Integer, Integer> frequencyMap = new HashMap<>();

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
    }

    int maxFreq = 0, minFreq = n;
    for (int freq : frequencyMap.values()) {
      if (freq > maxFreq) maxFreq = freq;
      if (freq < minFreq) minFreq = freq;
    }

    return maxFreq + minFreq;
  }

  public static void main(String[] args) {
    int[] arr = {10, 9, 7, 7, 8, 8, 8};

    int result = sumOfHighestAndLowestFreq(arr);

    System.out.println("The sum of lowest and highest frequency in the array is: " + result);
  }
}
