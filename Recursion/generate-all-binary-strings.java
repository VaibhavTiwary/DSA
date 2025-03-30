// Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

// A binary string is that string which contains only 0 and 1.

// Example 1:

// Input:
// N = 3
// Output:
// 000 , 001 , 010 , 100 , 101
// Explanation:
// None of the above strings contain consecutive 1s. "110" is not an answer as it has '1's occuring consecutively. 


class Solution {
    
    public static List<String> generateBinaryStrings(int n) {
      ArrayList <String> res = new ArrayList<>();
      StringBuilder temp = new StringBuilder();
      solve(n, res, temp);
      return res;
    }
    
    static void solve(int n, ArrayList<String> res, StringBuilder temp){
        if(temp.length() == n){
            res.add(temp.toString());
            return;
        }
    
        temp.append('0');
        solve(n, res, temp);
        temp.deleteCharAt(temp.length()-1);
        
        if(temp.length() == 0 || temp.charAt(temp.length()-1) == '0'){
            temp.append('1');
            solve(n, res, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
  
  
}



//Without BT

class Solution {
    public static List<String> generateBinaryStrings(int n) {
        ArrayList <String> list = new ArrayList<>();
        String op = "";
        solve(n, op, list);
        return list;
    }
    
    static void solve(int n, String op, ArrayList<String> list){
        if(n == 0){
            list.add(op);
            return;
        }
        
        String op1 = op;
        op1 += 0;
        solve(n-1, op1, list);
        
        if(op.isEmpty() || op.charAt(op.length() - 1) == '0'){
            String op2 = op;
            op2 += 1;
            solve(n-1, op2, list);
        }
    } 
  
}
     
     