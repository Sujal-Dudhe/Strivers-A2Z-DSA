package arrays;

import java.util.ArrayList;
import java.util.HashSet;
@SuppressWarnings("unused")

public class UnionOfSortedArrays {
  // Brute force appraoch
  // Time complexity: O((n1+n2)log(n1+n2))
  // Space complexity:  O(n1+n2) If Space of Union ArrayList is considered, Otherwise O(1)
  /*
  static ArrayList<Integer> unionOfArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;
    HashSet<Integer> st = new HashSet<>();

    for (int i = 0; i < n1; i++) {
      st.add(arr1[i]);
    }
    for (int i = 0; i< n2; i++) {
      st.add(arr2[i]);
    }

    ArrayList<Integer> union = new ArrayList<>();

    for (Integer i : st) {
      union.add(i);
    }
    return union;
  }
  */

  // Optimal approaach (using two pointers)
  // Time complexity: O(n1 + n2)
  // Space complexity: O(n1 + n2) if space of union ArrayList is considered, otherwise O(1)
  static ArrayList<Integer> unionOfArrays(int[] arr1, int[] arr2) {
    int n1 = arr1.length;
    int n2 = arr2.length;
    int i = 0;
    int j = 0;
    ArrayList<Integer> union = new ArrayList<>();

    while (i < n1 && j < n2) {
        if (arr1[i] <= arr2[j]) {
            if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        } else {
            if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
    }
 
      while (i < n1) {
        if (union.size() == 0 || union.get(union.size() - 1) != arr1[i]) {
            union.add(arr1[i]);
        }
        i++;
    }

    while (j < n2) {
        if (union.size() == 0 || union.get(union.size() - 1) != arr2[j]) {
            union.add(arr2[j]);
        }
        j++;
    }

    return union;
  }
  public static void main(String[] args) {
    int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int arr2[] = {2, 3, 4, 4, 5, 11, 12};

    System.out.print("First array: ");
    for (int i : arr1) {
      System.out.print(i + " ");
    }
    System.out.println();

    System.out.print("Second array: ");
    for (int i : arr2) {
      System.out.print(i + " ");
    }
    System.out.println();

    ArrayList<Integer> result = unionOfArrays(arr1, arr2);
    System.out.print("Union of two arrays: ");
    for (Integer i : result) {
      System.out.print(i + " ");
    }
  }
}