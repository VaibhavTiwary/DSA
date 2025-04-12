// You are given two positive integers n and k. A factor of an integer n is defined as an integer i where 
// n % i == 0.

// Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or
//  return -1 if n has less than k factors.

 

// Example 1:

// Input: n = 12, k = 3
// Output: 3
// Explanation: Factors list is [1, 2, 3, 4, 6, 12], the 3rd factor is 3.


// O(N) Solution

class Solution {
    public int kthFactor(int n, int k) {

        int count = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0) count++;
            if(count == k) return i;
        }
        return -1;
    }
}

//Optimized a bit but still O(N)

class Solution {
    public int kthFactor(int n, int k) {

        int count = 0;
        for(int i = 1; i <= n/2; i++){
            if(n % i == 0) count++;
            if(count == k) return i;
        }

        if(count + 1 == k) return n;
        return -1;
    }
}

//Optimized to O(sqrt(n))

class Solution {
    public int kthFactor(int n, int k) {

        ArrayList <Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                list.add(i);
                
                if (i != n / i) {
                    list.add(n / i);
                }
            }
        }
        Collections.sort(list);
        if(list.size() >= k){
            return list.get(k-1);
        }
        return -1;


        
    }
}