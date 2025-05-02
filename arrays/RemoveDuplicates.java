// Remove duplicates from the sorted array.
package arrays;

import java.util.HashSet;

@SuppressWarnings("unused")
public class RemoveDuplicates {

  // Brute force approach (using Hashset) 
  // Time compexity: O(nlogn)
  // Space complexity: O(n)
  /* 
  static int removeDuplicates(int[] arr) {
    HashSet <Integer> set = new HashSet<>();
    for (int i = 0; i < arr.length; i++) {
      set.add(arr[i]);
    }
    int k = set.size();
    int j = 0;
    for(int x: set) {
      arr[j] = x;
      j++;
    }
    return k;
  }
  */
  
  // Optimal approach (using Two pointers)
  // Time complexity: O(n)
  // Space comlexity: O(1)
  static int removeDuplicates(int[] arr) {
    int i = 0;
    for (int j = 1; j < arr.length; j++) {
      if (arr[i] != arr[j]) {
        i++;
        arr[i] = arr[j];
      }
    }
    
    return i + 1;
  }

  public static void main(String[] args) {
    int arr[] = {1,1,2,2,2,3,3,4};

    System.out.print("Given array is: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Array after removing the duplicates is: ");
    int j = removeDuplicates(arr);
    for (int i = 0; i < j; i++) {
      System.out.print(arr[i] + " ");
    }

  }
}