// The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

// countAndSay(1) = "1"
// countAndSay(n) is the run-length encoding of countAndSay(n - 1).
// Run-length encoding (RLE) is a string compression method that works by replacing consecutive 
// identical characters (repeated 2 or more times) with the concatenation of the character and 
// the number marking the count of the characters (length of the run). For example, to compress 
// the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and 
// replace "1" with "11". Thus the compressed string becomes "23321511".

// Given a positive integer n, return the nth element of the count-and-say sequence.

 

// Example 1:

// Input: n = 4

// Output: "1211"

// Explanation:

// countAndSay(1) = "1"
// countAndSay(2) = RLE of "1" = "11"
// countAndSay(3) = RLE of "11" = "21"
// countAndSay(4) = RLE of "21" = "1211"

// BC-
// if (n == 1) return "1";
// else if (n == 2) return "11";

// Now the recursion from n = 3 onward:

// String temp = countAndSay(2); -> "11"
// String res = findRLE("11");  -> returns "21"
// return res; -> so countAndSay(3) returns "21"


// String temp = countAndSay(3); -> "21"
// String res = findRLE("21");   -> returns "1211"
// return res; -> so countAndSay(4) returns "1211"

// and the recursive flow goes on...



class Solution {
    StringBuilder builder = new StringBuilder();

    public String countAndSay(int n) {

        if(n == 1) return "1";
        else if(n == 2) return "11";
    
        String temp = countAndSay(n-1);
        String res = findRLE(temp);
        
        return res;


    }

    String findRLE(String temp){
        StringBuilder rle = new StringBuilder();

        int count = 1;
        for(int i = 0; i < temp.length() - 1; i++){
            if(temp.charAt(i) != temp.charAt(i + 1)){
                rle.append(count).append(temp.charAt(i));
                count = 1;
            } else count++;
        }


        rle.append(count).append(temp.charAt(temp.length() - 1));

        return rle.toString();
    }
}