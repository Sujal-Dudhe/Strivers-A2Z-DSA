package arrays;

public class LinearSearch {

  static int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        return i;
      }
    }
    return -1;
  }
  public static void main(String[] args) {
    int arr[] = {6, 7, 8, 4, 1};
    int target = 4;
    
    int result = linearSearch(arr, target);
    
    if (result != -1) {
    System.out.print(target + " is present in given array at index " + result);
    } else {
      System.out.println(target + " is not present in the given array");
    }
  }
}