/*
 Given a sorted array of integers nums with 0-based indexing, find the index of a specified target integer. If the target is found in the array, return its index. If the target is not found, return -1.
 */

 package binarysearch.fundamentals;

 public class SearchInSortedArr {
 
   // Time Complexity: O(log(N)), as the search space is halved in each iteration
   // Space Complexity: O(1)
   public static int search(int[] nums, int x) {
     int n = nums.length;
     return binarySearch(nums, 0, n - 1, x);
   }
 
   private static int binarySearch(int[] nums, int low, int high, int target) {
 
     while (low <= high) {
       int mid = (low + high) / 2;
 
       if (nums[mid] == target) return mid;
       else if (nums[mid] < target) low = mid + 1;
       else high = mid - 1;
     }
     return -1; 
   }
 
   public static void main(String[] args) {
     int[] arr = {-1, 0, 3, 5, 9, 12};
     int target = 9;
 
     int index = search(arr, target);
     if(index == -1) 
       System.out.println("The target is not present.");
     else 
       System.out.println("The target is at index: " + index);
   }
 }