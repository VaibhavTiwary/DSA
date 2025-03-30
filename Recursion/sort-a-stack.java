// Given a stack, the task is to sort it such that the top of the stack has the greatest element.

// Example 1:

// Input:
// Stack: 3 2 1
// Output: 3 2 1
// Example 2:

// Input:
// Stack: 11 2 32 3 41
// Output: 41 32 11 3 2

// TC- O(N^2)

class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        
        if(s.isEmpty()) return s;
        
        int top = s.pop();
        sort(s);
        insert(s, top);
        return s;
    }
    
    void insert(Stack<Integer> s, int element){
        if(s.isEmpty() || element >= s.peek()){
            s.push(element);
            return;
        }
        int top = s.pop();
        insert(s, element);
        s.push(top);
    }
    
}