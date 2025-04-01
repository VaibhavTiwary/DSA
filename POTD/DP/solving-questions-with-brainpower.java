// L-2140(1 april)


// You are given a 0-indexed 2D integer array questions where questions[i] = [pointsi, brainpoweri].

// The array describes the questions of an exam, where you have to process the questions in order 
// (i.e., starting from question 0) and make a decision whether to solve or skip each question. 
// Solving question i will earn you pointsi points but you will be unable to solve each of the next 
// brainpoweri questions. If you skip question i, you get to make the decision on the next question.

// For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
// If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
// If instead, question 0 is skipped and question 1 is solved, you will earn 4 points but you will be
//  unable to solve questions 2 and 3.
// Return the maximum points you can earn for the exam.

 

// Example 1:

// Input: questions = [[3,2],[4,3],[4,4],[2,5]]
// Output: 5
// Explanation: The maximum points can be earned by solving questions 0 and 3.
// - Solve question 0: Earn 3 points, will be unable to solve the next 2 questions
// - Unable to solve questions 1 and 2
// - Solve question 3: Earn 2 points
// Total points earned: 3 + 2 = 5. There is no other way to earn 5 or more points.


// DP Array: dp[i] stores the maximum points that can be obtained starting from index i onward.
//  We initialize it with a size of questions.length + 1 to handle the case where we reach the end
//   (out of bounds).

// The time complexity is O(N), where N is the number of questions, because each question is processed 
// at most once due to memoization.


class Solution {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        Arrays.fill(dp, -1);

        return solve(questions, 0, dp);
    }
    long solve(int[][] questions, int index, long[] dp){
        if(index >= questions.length){
            return 0;
        }
        if(dp[index] != -1) return dp[index];

        long pick = questions[index][0] + solve(questions, index + questions[index][1] + 1, dp);
        long notPick = solve(questions, index + 1, dp);

        dp[index] = Math.max(pick, notPick);

        return dp[index];
    }
}