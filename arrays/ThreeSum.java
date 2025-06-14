package arrays;
import java.util.*;

public class ThreeSum {

  /* 
  // Brute Force Approach
  // Time Complexity: O(N^3 x log(no. of unique triplets)), where N is size of the array.
  // Space Complexity: O(2 x no. of the unique triplets) for using a set data structure and a list to store the triplets.
  public static List<List<Integer>> threeSum(int[] nums) {

    Set<List<Integer>> tripletSet = new HashSet<>();
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (nums[i] + nums[j] + nums[k] == 0) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(nums[j]);
            temp.add(nums[k]);

            Collections.sort(temp);
            tripletSet.add(temp);
          } 
        }
      }
    }
    List<List<Integer>> result = new ArrayList<>(tripletSet); 
    return result;
  }
  */


  /* 
  // Better Approach
  // Time Complexity:  O(N^2 x log(no. of unique triplets)), where N is size of the array.
  // Space Complexity: O(2 x no. of the unique triplets) + O(N) for using a set data structure and a list to store the triplets and extra O(N) for storing the array elements in another set.
  public static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> tripletSet = new HashSet<>();

    int n = nums.length;
    for (int i = 0; i < n; i++) {
      Set<Integer> s = new HashSet<>();

      for (int j = i + 1; j < n; j++) {
        // Calculate the required third element to form a zero-sum triplet.
        int third = -(nums[i] + nums[j]);

        if (s.contains(third)) {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[i]);
          temp.add(nums[j]);
          temp.add(third);

          Collections.sort(temp);
          tripletSet.add(temp);
        }
        s.add(nums[j]);
      }
    }
    List<List<Integer>> result = new ArrayList<>(tripletSet);

    return result;
  }
 */


// Optimal Approach

// Time Complexity: O(NlogN * N^2) As the pointer i, is running for approximately N times. And both the pointers j and k combined can run for approximately N times including the operation of skipping duplicates. So the total time complexity will be O(N^2).

// Space Complexity: O(1), no extra space is used, only the list is used to return the answer.
public static List<List<Integer>> threeSum(int[] nums) {
  List<List<Integer>> triplet = new ArrayList<>();

  int n = nums.length;    
  Arrays.sort(nums);
  for (int i = 0; i < n; i++) {

    if (i > 0 && nums[i] == nums[i - 1]) continue;

    int j = i + 1; 
    int k = n - 1;

    while (j < k) {
      int sum = nums[i] + nums[j] + nums[k];

      if (sum < 0) {
        j++; // Skip duplicate elements to avoid duplicate triplets
                    
      } else if (sum > 0) {
          k--;

      } else {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[i]);
          temp.add(nums[j]);
          temp.add(nums[k]);
          triplet.add(temp);

          // Skip duplicate elements
          j++;
          k--;
          while (j < k && nums[j] == nums[j - 1]) j++;
          while (j < k && nums[k] == nums[k + 1]) k--;
        }
      }
    }

    return triplet;
  }
  

  public static void main(String[] args) {
    int[] arr = {2, -2, 0, 3, -3, 5};

    List<List<Integer>> result = threeSum(arr);

    for (List<Integer> triplet : result) {
      System.out.print("[");
      for (Integer ele : triplet) {
        System.out.print(ele + " ");
      }
      System.out.print("] ");
    }
  }
}