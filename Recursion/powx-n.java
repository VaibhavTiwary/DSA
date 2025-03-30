//L-50

// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 

// Example 1:

// Input: x = 2.00000, n = 10
// Output: 1024.00000

// TC and SC = O(log n)

class Solution {
    public double myPow(double x, int n) {

        long newn = n;
        return solve(x, newn);
        

    }

    double solve(double x, long newn){
        if(newn == 0) return 1;

        if(newn < 0){
            x = 1/x;
            newn = newn * -1;
        }
        double half = solve(x, newn / 2);
        if(newn % 2 == 1){
            return half * half * x;
        }
        return half * half;
    }
}


//Converting n to long
//for even n we can simply do => x ^ n = x ^ n/2 + x ^ n/2;
//for odd n we can simply do => x ^ n = (x ^ n-1/2) + (x ^ n-1/2) * x
//but we can simply do n/2 for odd too because it also gives floor value.
//for 7 we need 7-1/2 i.e 3 but if we did 7/2 then also we will get 3.