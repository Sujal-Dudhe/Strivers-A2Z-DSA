package patterns;

import java.util.Scanner;

public class Pattern17 {
  public static void main(String[] args) {
    /*
        A    
       ABA   
      ABCBA  
     ABCDCBA 
    ABCDEDCBA
    */
    try(Scanner sc = new Scanner(System.in)) {
      System.out.print("Enter the number of rows: ");
      int n = sc.nextInt();
      
      for (int i = 0; i < n; i++) {
        // space
        for (int j = 0; j < n-i-1 ; j++) {
          System.out.print(" ");
        }

        // Characters
        char ch = 'A';
        int breakPoint = (2 * i + 1)/2;
        for (int j = 0; j < 2 * i + 1 ; j++){
          System.out.print(ch);
          if (j < breakPoint) ch++;
          else ch--;
        }
        
        // space
        for (int j = 0; j < n-i-1 ; j++) {
          System.out.print(" ");
        }
        System.out.println();
      }
    }
  }
}
