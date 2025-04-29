package basicrecursion;

public class Fibonacci {
  public static int printFibo(int n) {
    if (n <=1 ) return n;

    return printFibo(n-1) + printFibo(n-2);
  }
  public static void main(String[] args) {
    System.out.println(printFibo(4));
  }
}