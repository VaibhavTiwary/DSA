// You are given a positive integer days representing the total number of days an employee is available
//  for work (starting from day 1). You are also given a 2D array meetings of size n where,
//   meetings[i] = [start_i, end_i] represents the starting and ending days of meeting i (inclusive).

// Return the count of days when the employee is available for work but no meetings are scheduled.

// Note: The meetings may overlap.

// Input: days = 10, meetings = [[5,7],[1,3],[9,10]]

// Output: 2

// Explanation:

// There is no meeting scheduled on the 4th and 8th days.

//TC- O(n log n)
class Solution {
    public int countDays(int days, int[][] meetings) {

        int n = meetings.length;
        Arrays.sort(meetings, (a, b) -> {
            if (a[0] == b[0]) 
                return a[1] - b[1];
            return a[0] - b[0];
        });

        int count = 0;
        int curStart = meetings[0][0];
        int curEnd = meetings[0][1];

        for(int i = 1; i < n; i++){
            if(meetings[i][0] <= curEnd){
                curEnd = Math.max(curEnd, meetings[i][1]);
            }
            else{
                count += (meetings[i][0] - curEnd - 1);
                curStart = meetings[i][0];
                curEnd = meetings[i][1];
            }
        }
        if(days > curEnd){
            count += (days-curEnd);
        }
        count += (meetings[0][0] - 1);
        return count;
        
    }
}