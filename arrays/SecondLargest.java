package arrays;

public class SecondLargest {

  static int secLargest(int[] arr) {
    
    if (arr.length < 2) return -1;

    int max = arr[0];
    int secMax = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) {
        secMax = max;
        max = arr[i];
      } else if (arr[i] < max && arr[i] > secMax) {
        secMax = arr[i];
      }
    }
  
    return secMax;
  }

  public static void main(String[] args) {
    int arr[] = {22, 44, 88, 90, 100};

    System.out.println("Second largest element in the array is: " + secLargest(arr));
  }
}