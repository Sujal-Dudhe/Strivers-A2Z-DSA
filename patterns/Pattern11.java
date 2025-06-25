package patterns;
import java.util.Scanner;

public class Pattern11 {
  /*
   1 
   0 1 
   1 0 1 
   0 1 0 1 
   1 0 1 0 1 
  */
  public static void main(String[] args) {
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of Rows : ");
      int n = sc.nextInt();

      for (int i = 0; i < n; i++) {
        int start = 1;
        if (i % 2 == 0) start = 1;
        else start = 0;
        for (int j = 0; j <= i; j++) {
          System.out.print(start + " ");
          start = 1 - start; // Flip the value
        }
        System.out.println();
      }
    }
  }
}
