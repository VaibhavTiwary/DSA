// You are given a string s consisting of lowercase English letters. A duplicate removal consists of
//  choosing two adjacent and equal letters and removing them.

// We repeatedly make duplicate removals on s until we no longer can.

// Return the final string after all such duplicate removals have been made. It can be proven that 
// the answer is unique.

 

// Example 1:

// Input: s = "abbaca"
// Output: "ca"
// Explanation: 
// For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, 
// and this is the only possible move.  The result of this move is that the string is "aaca", 
// of which only "aa" is possible, so the final string is "ca".


class Solution {
    public String removeDuplicates(String s) {

        Stack <Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty()){
                if(st.peek() == s.charAt(i)){
                    st.pop();
                    continue;
                }
            }
            st.push(s.charAt(i));
        }
        while(!st.isEmpty()){
            ans.append(st.peek());
            st.pop();
        }

        return ans.reverse().toString();
    }
}