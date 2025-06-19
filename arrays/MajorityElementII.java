package arrays;
import java.util.List;
import java.util.ArrayList;

// Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.

public class MajorityElementII {

  // Time Complexity: O(N)
  // Space Complexity: O(1), for only using a list that stores a maximum of 2 elements. The space used is so small that it can be considered constant.
  public static List<Integer> majorityEleII(int[] nums) {

    int n = nums.length;
    int cnt1 = 0, cnt2 = 0;
    int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {
      
      if (cnt1 == 0 && ele2 != nums[i]) {
        ele1 = nums[i];
        cnt1 = 1;
      } else if (cnt2 == 0 && ele1 != nums[i]) {
        ele2 = nums[i];
        cnt2 = 1;
      } else if (ele1 == nums[i]) {
        cnt1++;
      } else if (ele2 == nums[i]) {
        cnt2++;
      } else {
        cnt1--;
        cnt2--;
      }
    }

    cnt1 = 0;
    cnt2 = 0;
    for (int i = 0; i < n; i++) {
      if (ele1 == nums[i]) cnt1++;
      if (ele2 == nums[i]) cnt2++;
    }

    List<Integer> result = new ArrayList<>();

    int minCount = (n/3) + 1;
    if (cnt1 >= minCount) result.add(ele1); 
    if (cnt2 >= minCount && ele1 != ele2) result.add(ele2);

    return result;
  }
  
  public static void main(String[] args) {
    int arr[] = {11, 33, 33, 11, 33, 11};

    List<Integer> ans = majorityEleII(arr);

    System.out.print("The majority elements are: ");
    for (Integer ele : ans) {
      System.out.print(ele + " ");
    }
    
  }
}