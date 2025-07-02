/*
 Given a sorted array of nums and an integer x, write a program to find the upper bound of x.
The upper bound algorithm finds the first and smallest index in a sorted array where the value at that index is greater than a given key i.e. x.
If no such index is found, return the size of the array.
 */

 package binarysearch;

 class LowerBound {
 
   // Time Complexity: O(log(N))
   // Space Complexity: O(1)
   public static int lowerBound(int[] nums, int x) {
     int result = nums.length;
     int low = 0, high = nums.length - 1;
 
     while (low <= high) {
       int mid = (low + high) / 2;
 
       if (nums[mid] >= x) {
         result = mid;
         high = mid - 1;
       } else {
         low = mid + 1;
       }
     }
 
     return result;
   }
 
   public static void main(String[] args) {
     int[] arr = {3,5,8,15,19};
     int x = 9;
 
     int result = lowerBound(arr, x);
     System.out.println("The lower bound is the index: " + result);
   }
 }