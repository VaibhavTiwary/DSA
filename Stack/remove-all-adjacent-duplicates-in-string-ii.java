// You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent 
// and equal letters from s and removing them, causing the left and the right side of the deleted 
// substring to concatenate together.

// We repeatedly make k duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It is guaranteed that
//  the answer is unique.

 

// Example 1:

// Input: s = "abcd", k = 2
// Output: "abcd"
// Explanation: There's nothing to delete.
// Example 2:

// Input: s = "deeedbbcccbdaa", k = 3
// Output: "aa"
// Explanation: 
// First delete "eee" and "ccc", get "ddbbbdaa"
// Then delete "bbb", get "dddaa"
// Finally delete "ddd", get "aa"


class Solution {
    class Pair{
        char ch;
        int count;

        Pair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty() && st.peek().ch == s.charAt(i)){
                Pair p = st.peek();
                p.count++;
                if(p.count == k){
                    st.pop();
                }
            } else {
                st.push(new Pair(s.charAt(i), 1)); 
            }
        }

        while (!st.isEmpty()) {
            Pair p = st.pop();
            for (int i = 0; i < p.count; i++) {
                builder.append(p.ch);
            }
        }
        return builder.reverse().toString();
    }
}
