package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    // Time Complexity: O((4^n / sqrt(n))*n)
    // Space Complexity: O((4^n / sqrt(n))*n)
    private static void generate(int open, int close, int n, String current, List<String> result) {

        if (open == close && open + close == 2*n) {
            result.add(current);
            return;
        }

        if (open < n) {
            generate(open + 1, close, n, current + '(', result);
        }

        if (close < open) {
            generate(open, close + 1, n, current + ')', result);
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        
        generate(0, 0, n, "", result);
        return result;
    }

    public static void main(String[] args) {
        int n = 3; 
        List<String> result = generateParenthesis(n);

        System.out.println("All combinations of balanced parentheses for n = " + n + " are:");
        for (String combination : result) {
            System.out.println(combination);
        }
    }
}
