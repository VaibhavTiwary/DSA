// You are given a stack St. You have to reverse the stack using recursion.

// Example 1:

// Input:
// St = {3,2,1,7,6}
// Output:
// {6,7,1,2,3}
// Explanation:
// Input stack after reversing will look like the stack in the output.


class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        if(s.size() == 1) return;
        
        int top = s.pop();
        reverse(s);
        insert(s, top);
        return;
    }
    
    static void insert(Stack<Integer> s, int element){
        if(s.isEmpty()){
            s.push(element);
            return;
        }
        
        int temp = s.pop();
        insert(s, element);
        s.push(temp);
    }
}