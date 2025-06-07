package arrays;

import java.util.ArrayList;
import java.util.Collections;

// An element in array is a leader/superior if it is greater than all elements present to its right
class LeadersInArr {
  // Brute Force Approach -> Time Complexity - O(N^2)
  /* 
  private static ArrayList<Integer> getLeaders(int[] arr) {
    ArrayList<Integer> ans = new ArrayList<>();
    
    for (int i = 0; i < arr.length; i++) {
      boolean leader = true;
      
      // Compares current ele with all ele on right side
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] >= arr[i]) {
          leader = false;
          break;
        }
      }
        
      if (leader) ans.add(arr[i]);
    }

    return ans;
  }
  */

  // Optimal Approach -> Time Complexity - O(N)
  // Backward iteration
  // Check if current ele is greater than  maximum ele on right side, if yes then it is a leader
  private static ArrayList<Integer> getLeaders(int[] arr) {
    ArrayList<Integer> ans = new ArrayList<>();
    
    int maxOnright = Integer.MIN_VALUE;
    int n = arr.length;

    for (int i = n - 1; i >= 0; i--) {
      if (arr[i] > maxOnright) {
        ans.add(arr[i]);
      }
      // Update the rigth max, if it changes with iteration
      maxOnright = Math.max(maxOnright, arr[i]);
    }

    Collections.reverse(ans);
    return ans;
  }
  public static void main(String[] args) {
    int arr[] = {-3, 4, 5, 1, -4, -5};

    System.out.print("Leaders in array are: " );
    ArrayList<Integer> leaders;
    leaders = getLeaders(arr);

    for (Integer num: leaders) {
      System.out.print(num + " ");
    }
  } 
}