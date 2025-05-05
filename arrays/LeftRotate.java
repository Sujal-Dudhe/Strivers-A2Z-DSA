package arrays;

class LeftRotate {

  //  Left rotate by 1 place
  static void leftRotate(int[] arr) {
    int n = arr.length;
    int temp = arr[0];

    for (int i = 1; i < n; i++) {
      arr[i-1] = arr[i];
    }

    arr[n-1] = temp;
  }

  public static void main(String[] args) {
    int arr[] = {1, 2, 3, 4, 5};

    System.out.print("Given array is: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();

    leftRotate(arr);
    System.out.print("Array after rotation is: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }

  }
}