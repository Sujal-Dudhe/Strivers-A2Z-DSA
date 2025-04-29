package sorting;

import java.util.Scanner;

public class InsertionSort {
  public static void insertionSort(int[] arr,int n) {
    // Time Complexity: O(n^2)
    // Best case: O(n) i.e. in case of already sorted array, as inner loop will not run in this case.
    // Takes an element and place it in its current position
    for (int i = 0; i <= n - 1; i++) {
      int j = i;
      while (j > 0 && arr[j-1] > arr[j]) {
        int temp = arr[j-1];
        arr[j-1] = arr[j];
        arr[j] = temp;

        j--;
      }
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

    insertionSort(arr, n);
    System.out.print("Sorted array: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}