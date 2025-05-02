package arrays;

class Largest {

  static int getLargest(int[] arr) {
    int max = arr[0];
    
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] > max) max = arr[i];
    }

    return max;
  }
  public static void main(String[] args) {
    int arr[] = {1, 2, 4, 12, 8};

    System.out.println("largest element in the array is: " + getLargest(arr));
  }
}