package arrays;

// The majority element of an array is an element that appears "more than n/2" times in the array. 
public class MajorityElementI {

  // Time Complexity: O(N) + O(N) => O(N)
  // Space Complexity: O(1)
  public static int majorityElement(int[] nums) {

    int cnt = 0;
    int ele = 0;

    for (int i = 0; i < nums.length; i++) {
      
      if (cnt == 0) {
        ele = nums[i];
        cnt = 1;
      } else if (nums[i] == ele) {
        cnt++;
      } else {
        cnt--;
      }
    }

    int cnt1 = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == ele) cnt1++;
    }

    if (cnt1 > nums.length / 2) return ele;

    return -1;
  }
  public static void main(String[] args) {
    int arr[] = {2, 2, 1, 1, 1, 2, 2};

    int ans = majorityElement(arr);

    System.out.println("The majority element is: " + ans);
  }
}