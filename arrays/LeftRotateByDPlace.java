package arrays;

public class LeftRotateByDPlace {

  // Brute force approach 
  // Time Complexity : O(n+d)
  // Space Complexity : O(d)
  /* 
  static void RotateByDPlace(int[] arr, int d) {
    int n = arr.length;
    d = d % n;

    int[] temp = new int[d];
    for (int i = 0; i < d; i++) {
      temp[i] = arr[i];
    }

    for (int i = d; i < n; i++) {
      arr[i-d] = arr[i];
    }

    for (int i = n-d; i < n; i++) {
      arr[i] = temp[i - (n-d)];
    }
  }
  */
  
  // Optimal approach
  // Time Complexity : O(n)
  // Space Complexity : O(1)
  static void RotateByDPlace(int[] arr, int d) {
    int n = arr.length;
    d = d % n;

    reverse(arr, 0, d-1); // Reverse first d elementss
    reverse(arr, d, n-1); // Reverse remaining elements
    reverse(arr, 0, n-1); // Reverse entire array
  }

  static void reverse(int[] arr, int start, int end) {  

    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;

      start++;
      end--;
    }

  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5, 6, 7};

    System.out.print("Given array is: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    int d = 3;
    RotateByDPlace(arr, d);
    System.out.print("Array after rotation by " + d + " place is: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}