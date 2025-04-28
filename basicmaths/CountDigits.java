package basicmaths;

import java.util.Scanner;

public class CountDigits {
  // Brute Force Approach :
  /* 
  public static int count(int num) {
    int count = 0;
    while(num > 0) {
      count++;
      num /= 10;
    }
    return count;
  }
  */

  //  Optimal approach :

  public static int count(int num) {
    int cnt = (int) (Math.log10(num) + 1);
    return cnt;
  } 

  public static void main(String[] args) {
    System.out.print("Enter a number : ");
    @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println("Number of digit(s) : " + count(n));
  }
}
