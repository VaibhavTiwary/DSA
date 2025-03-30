// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 
// Example 1:

// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList <String> list = new ArrayList<>();
        int open = n;
        int close = n;
        String op = "";
        return solve(open, close, op, list);
    }
    public List<String> solve(int open, int close, String op, ArrayList<String>list){
        if(open == 0 && close == 0){
            list.add(op);
            return list;
        }
        if(open != 0){
            String op1 = op;
            op1 += "(";
            solve(open-1, close, op1, list);

        }
        if (close > open) {
            String op2 = op;
            op2 += ")";
            solve(open, close-1, op2, list);
        }
        return list;
    }
}