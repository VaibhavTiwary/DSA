// A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.

// Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1.
//  Also, it is guaranteed that the subordination relationships have a tree structure.

// The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, 
// and they will inform their subordinates, and so on until all employees know about the urgent news.

// The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, 
// all his direct subordinates can start spreading the news).

// Return the number of minutes needed to inform all the employees about the urgent news.

 

// Example 1:

// Input: n = 1, headID = 0, manager = [-1], informTime = [0]
// Output: 0
// Explanation: The head of the company is the only employee in the company.
// Example 2:


// Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
// Output: 1
// Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform
//  them all.
// The tree structure of the employees in the company is shown.




class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < manager.length; i++){
            if(manager[i] != -1){
                tree.get(manager[i]).add(i);
            }
        }

        return dfs(headID, informTime, tree);
    }

    int dfs(int curr, int[] informTime, ArrayList<ArrayList<Integer>> tree){
        
        int maxTime = 0;
        for(int childs : tree.get(curr)){
            int childTime = dfs(childs, informTime, tree);
            maxTime = Math.max(maxTime, childTime);
        }

        return informTime[curr] + maxTime;
    }
}

// n = 6;
// headID = 0;
// manager = [-1, 0, 0, 1, 1, 2];
// informTime = [2, 3, 1, 0, 0, 0];

//         0(2)
//       /     \
//     1(3)     2(1)
//    /   \       \
//  3(0)  4(0)    5(0)


// 1.Start from dfs(0)

// 2.First child of 0 → dfs(1)

// 3.First child of 1 → dfs(3)

// 4.3 has no children → skips loop -> return informTime[3] + 0 = 0

// 5.Back to 1 → childTime = 0, update maxTime

// 6.Next child of 1 → dfs(4)

// 7.4 has no children → returns 0

// 8.Back to 1 → update maxTime, return 3

// 9.Back to 0 → maxTime = 3 so far

// 10.Next child of 0 → dfs(2)

// 11.2's only child → dfs(5) → returns 0

// 12.dfs(2) returns 1

// 13.Back to dfs(0) → final maxTime = max(3, 1) = 3

// 14.Return 2 + 3 = 5 to 1 and now its other child 4 is called