package basicmaths;
import java.util.Scanner;

// Armstrong num: Sum of cube of digits of a number is equal to the number itself.
public class ArmstrongNum {

  public static int count(int number) {
    int count = 0;
    while (number > 0) {
      count++;
      number /= 10;
    }
    return count;
  } 
  
  public static boolean isArmstrong(int num) {

    if (num < 0) return false;

    int sum = 0;
    int originalNum = num;
    int numDigits = count(num);
    while (num > 0) {
      int lastDigit = num % 10;
      sum += Math.pow(lastDigit, numDigits);
      num /= 10;
    }
    return sum == originalNum;
  }

  public static void main(String[] args) {
    System.out.print("Enter a number : ");
    try(Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println(n + " is Armstrong : " + isArmstrong(n));
    }
  }
}

