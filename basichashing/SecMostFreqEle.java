package basichashing;

import java.util.HashMap;
import java.util.Map;

public class SecMostFreqEle {
  
  // Time Complexity: O(N)
  // Space Complexity: O(N)
  public static int secMostFreqEle(int[] nums) {

    Map<Integer, Integer> frequencyMap = new HashMap<>();

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
    }

    int mostFreqEle = -1, secEle = -1;
    int mostFreq = 0, secMostFreq = 0;

    for (Map.Entry<Integer, Integer> it : frequencyMap.entrySet()) {
      int ele = it.getKey();
      int freq = it.getValue();

      if (freq > mostFreq) {
        secMostFreq = mostFreq;
        secEle = mostFreqEle;
        mostFreq = freq;
        mostFreqEle = ele;
      } else if (freq == mostFreq) {
        mostFreqEle = Math.min(mostFreqEle, ele);
      } else if (freq > secMostFreq && freq < mostFreq) {
        secMostFreq = freq;
        secEle = ele;
      } else if (freq == secMostFreq) {
        secEle = Math.min(secEle, ele);
      }
    }

    return secEle;
  }
  public static void main(String[] args) {
    int[] arr = {4, 4, 5, 5, 6, 7};

    int result = secMostFreqEle(arr);

    System.out.println("The second highest occuring element in the array is: " + result);
  }
}
