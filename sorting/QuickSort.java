package sorting;

import java.util.Scanner;

public class QuickSort {

  public static void quickSort(int[] arr, int low, int high) {
    if (low <= high) {
      int partitionIndex = partition(arr, low, high);
      quickSort(arr, low, partitionIndex - 1);  // Sorts the left half
      quickSort(arr, partitionIndex + 1, high); // Sorts the right half
    }
  }

  public static int partition(int[] arr, int low, int high) {
    int pivot = arr[low];
    int i = low;
    int j = high;
    while (i < j) {

      // finding first element greater than pivot
      while (arr[i] <= pivot && i <= high-1) {
        i++;
      }

      // finding first element lower than pivot
      while (arr[j] > pivot && j >= low + 1) {
        j--;
      }

      if (i < j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[low];
    arr[low] = arr[j];
    arr[j] = temp;

    return j;
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

    quickSort(arr, 0, n-1);
    System.out.print("Sorted array: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}