package sorting;

import java.util.Scanner;

public class SelectionSort {
  // Time Complexity: O(n^2)
  public static void selSort(int[] arr, int n) {
    for (int i = 0; i <= n- 2; i++) {
      int minIndex = i;
      for (int j = i; j <= n- 1; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }
      int temp = arr[minIndex];
      arr[minIndex] = arr[i];
      arr[i] = temp;
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the size of an array: ");
    int n = sc.nextInt();
    int[] arr = new int[n];
    System.out.print("Enter " + n + " elements: ");
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    sc.close();
    System.out.print("Given array is: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    selSort(arr, n);
    System.out.print("Sorted array: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}