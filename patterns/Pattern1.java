package patterns;

public class Pattern1 {
public static void main(String[] args) {

  // outer loop : rows
  // inner loop : columns
 // print '*' in inner loop 

/*
 * * * * 
 * * * * 
 * * * *
 * * * *
 */
  for (int i = 0; i < 4; i++) {
    for (int j = 0; j < 4; j++) {
      System.out.print("* "); // print 4 * in a single line with space
    }
    System.out.println(); // changes the line
  }
}
  
}
