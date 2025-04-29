package basicrecursion;

import java.util.Scanner;

public class ReverseArray {

  /* 
  // Using Two Pointers
  public static void reverse(int[] arr, int start, int end) {
    if (start >= end) return ;
    int temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    reverse(arr, start+1, end-1);
  }
  */

  public static void reverse(int i, int arr[], int n) {
    if (i >= n/2) return;

    int temp = arr[i];
    arr[i] = arr[n-i-1];
    arr[n-i-1] = temp;
    
    reverse(i+1, arr, n);
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

    // int start = 0;
    // int end = n - 1;
    // reverse(arr, start, end);

    reverse(0, arr, n);
    System.out.print("Rversed array: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }

}