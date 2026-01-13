package basicstrings;

public class RemoveOutermostParentheses {

    // Time Complexity: O(N), where N is the length of the string
    // Space Complexity: O(N)
    public static String removeParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) result.append(c);
                balance++;
            } else {
                balance--;
                if (balance > 0) result.append(c);
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "(()())(())";

        String ans = removeParentheses(s);
        System.out.println(ans);
    }
}
