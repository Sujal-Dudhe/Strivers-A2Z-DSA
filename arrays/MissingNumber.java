package arrays;

public class MissingNumber {

  // Brute Force approach
  // Time Complexity: O(n^2)
  // Space Complexity: O(1)
  /* 
  static int missingNum(int[] arr, int N) {

    for (int i = 1; i <= N; i++) {
      // flag variable to check if an element exists
      int flag = 0;

      for (int j = 0; j < N-1; j++) {
        if (arr[j] == i) {
          // i is present in the array
          flag = 1; 
          break;
        }
      }
      // check if the element is missing i.e flag == 0
      if (flag == 0) return i;
    }
    return -1;
  }
  */

  // Better approach (using Hashing)
  // Time Complexity: O(2n)
  // Space Complexity: O(n)
  /*
  static int missingNum(int[] arr, int N) {
    int hash[] = new int[N+1];

    // storing the frequencies
    for (int i = 0; i < N-1; i++) 
      hash[arr[i]]++;

    //checking the freqencies for numbers 1 to N
    for (int i = 1; i <= N; i++) {
      if (hash[i] == 0) return i;
    }
    return -1;
  }
  */

  // Optimal approach(using sum of natural numbers formula)
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  /* 
  static int missingNum(int[] arr, int N) {
    int n = N-1;
    int sum = (N*(N+1))/2;
    int result = 0;

    for (int i = 0; i < n; i++) result += arr[i];

    return sum - result;
  }
  */

  // Optimal approach (using XOR)
  // Time Complexity: O(n)
  // Space Complexity: O(1)
  static int missingNum(int[] arr, int N) {
    int xor1 = 0, xor2 = 0;
    int n = N-1;

    for(int i = 0; i < n; i++) {
      xor2 = xor2 ^ arr[i];
      xor1 = xor1 ^ (i+1);
    }
    xor1 = xor1 ^ N;
    return xor1 ^ xor2;
  }
  public static void main(String[] args) {
    int arr[] = {1, 2, 4, 5};
    int N = 5;
    
    System.out.print("Given array: ");
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("Missing Number: " + missingNum(arr, N));
  }
}