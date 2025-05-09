package arrays;

import java.util.ArrayList;

public class IntersectSortedArr {

  // Bruteforce approach 
  // Time Complexity: O(n1 * n2)
  // Space Complexity: O(n2)
  /* 
  static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;
    int[] visited = new int[n2];
    ArrayList<Integer> result = new ArrayList<>();

    for (int i = 0; i < n1; i++) {
      for (int j = 0; j < n2; j++) {
        if (arr1[i] == arr2[j] && visited[j] == 0) {
          result.add(arr1[i]);
          visited[j] = 1;
          break;
        } 
        if (arr2[j] > arr1[i]) break;
      }
    }

    return result;
  }
  */

  // Optimal approach (using two pointers)
  // Time Complexity: O(n1 + n2)
  // Space Complexity:  O(1)
  static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
    
    int n1 = arr1.length;
    int n2 = arr2.length;
    ArrayList<Integer> result = new ArrayList<>();
    
    int i = 0, j = 0;
    while (i < n1 && j < n2) {
      if (arr1[i] < arr2[j]) {
        i++;
      } else if (arr1[i] < arr2[j]) {
        j++;
      } else {
          result.add(arr1[i]);
          i++;
          j++;
        }
    }
    return result;
  }

  public static void main(String[] args) {
    int arr1[] = {1, 2, 2, 3, 3, 4, 4, 5};
    int arr2[] = {2, 3, 3, 5, 6, 6, 7};

    System.out.print("First array: ");
    for (int i : arr1) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Second array: ");
    for (int i : arr2) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Intersection of two arrays: ");
    for (Integer i : intersection(arr1, arr2)) {
      System.out.print(i + " ");
    }
  }
}