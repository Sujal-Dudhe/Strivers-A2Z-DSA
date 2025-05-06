package arrays;

import java.util.ArrayList;
@SuppressWarnings("unused")

public class MoveZerosToEnd {

  // Brute force approach
  // Time complexity: O(2*n)
  // Space comlexity: O(n)
  /*
  static int[] moveZeroes(int[] arr) {
    ArrayList<Integer> temp = new ArrayList<>();

    // add non-zero elements to temp array
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) temp.add(arr[i]);
    }
    
    // Move non-zero elements to the original array
    for (int j = 0; j < temp.size(); j++) {
      arr[j] = temp.get(j);
    }

    // Fill zeros at the remaining empty places in original array
    for (int i = temp.size(); i < arr.length; i++) {
      arr[i] = 0;
    }
    return arr;
  }
  */

  // Optimal appraoch
  // Time Complexity: O(n)
  // Space complexity: O(1)
  static int[] moveZeros(int[] arr) {
    int j = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        j = i;
        break;
      }
    }

    for (int i = j + 1; i < arr.length; i++) {
      if (arr[i] != 0) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        j++;
      }
    }
    return arr;
  }
  public static void main(String[] args) {
    int arr[] = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
    
    System.out.print("Given array is: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    int ans[] = moveZeros(arr);
    System.out.print("Array after moving zeros to end: ");
    for (int i : ans) {
      System.out.print(i + " ");
    }
  }
}