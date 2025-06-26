/*
 Given an array of n integers, find the most frequent element in it i.e., the element that occurs the maximum number of times. If there are multiple elements that appear a maximum number of times, find the smallest of them.
 */

package basichashing;

import java.util.HashMap;
import java.util.Map;


public class MostFreqElement {

  // Time Complexity: O(N)
  // Spcae Complexity: O(N) – In the worst-case scenario, the HashMap will store all the elements in the array when array elements are unique.
  public static int mostFreqEle(int[] nums) {
    Map<Integer, Integer> frequencyMap = new HashMap<>();

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
    }

    int mostFreqEle = -1, mostFreq = 0;
    for (Map.Entry<Integer, Integer> it : frequencyMap.entrySet()) {
      int ele = it.getKey();
      int freq = it.getValue();
      
      if (freq > mostFreq) {
        mostFreq = freq;
        mostFreqEle = ele;
      } else if (freq == mostFreq) {
        mostFreqEle = Math.min(mostFreqEle, ele);
      }
    }

    return mostFreqEle;
  }
  
  public static void main(String[] args) {
    int[] arr = {4, 4, 5, 5, 6};

    int result = mostFreqEle(arr);

    System.out.println("The highest occurring element in the array is: " + result);
  }
}