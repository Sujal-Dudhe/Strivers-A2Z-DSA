package basicmaths;
import java.util.Scanner;

public class ReverseNumber {

  public static int reverseNum(int num) {
    int revNum = 0;
    while (num > 0) {
      int lastDigit = num % 10;
      revNum = revNum * 10 + lastDigit;
      num /= 10;
    }
    return revNum;
  } 
  public static void main(String[] args) {
    System.out.print("Enter a number : ");
    try(Scanner sc = new Scanner(System.in)) {
      int n = sc.nextInt();
      System.out.println("Reversed number : " + reverseNum(n));
    }
  }
}
