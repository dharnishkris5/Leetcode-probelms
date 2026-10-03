import java.util.*;

class Solution {

    List<String> l1 = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), 0, 0, n);
        return l1;
    }

    public void backtrack(StringBuilder curr, int op, int cl, int n) {

        if (curr.length() == 2 * n) {
            l1.add(curr.toString());
            return;
        }
        if (op < n) {
            curr.append('(');
            backtrack(curr, op + 1, cl, n);
            curr.deleteCharAt(curr.length() - 1);
        }
        if (cl < op) {
            curr.append(')');
            backtrack(curr, op, cl + 1, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}