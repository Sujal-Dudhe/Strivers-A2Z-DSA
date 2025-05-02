package arrays; 

public class CheckSorted {

  static boolean isSorted(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] >= arr[i-1]) {

      } else {
          return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5};

    System.out.println("Given array is sorted: " + isSorted(arr));
  }
}