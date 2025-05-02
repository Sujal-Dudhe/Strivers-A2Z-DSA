package arrays;

public class SecondSmallest {

  static int secSmallest(int[] arr) {
    int smallest = arr[0];
    int secSmallest = Integer.MAX_VALUE;

    if (arr.length < 2) return -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] < smallest) {
        secSmallest = smallest;
        smallest = arr[i];
      } else if (arr[i] != smallest && arr[i] < secSmallest) {
        secSmallest = arr[i];
      }
    }

    return secSmallest;
  }

  public static void main(String[] args) {
    int arr[] = {22, 56, 84, 90, 100};

    System.out.println("Second smallest element in the array is: " + secSmallest(arr));
  }
}