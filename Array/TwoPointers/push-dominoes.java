
// L-838

// There are n dominoes in a line, and we place each domino vertically upright. In the beginning, 
// we simultaneously push some of the dominoes either to the left or to the right.

// After each second, each domino that is falling to the left pushes the adjacent domino on the left. 
// Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.

// When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance 
// of the forces.

// For the purposes of this question, we will consider that a falling domino expends no additional force 
// to a falling or already fallen domino.

// You are given a string dominoes representing the initial state where:

// dominoes[i] = 'L', if the ith domino has been pushed to the left,
// dominoes[i] = 'R', if the ith domino has been pushed to the right, and
// dominoes[i] = '.', if the ith domino has not been pushed.
// Return a string representing the final state.

 

// Example 1:

// Input: dominoes = "RR.L"
// Output: "RR.L"
// Explanation: The first domino expends no additional force on the second domino.
// Example 2:


// Input: dominoes = ".L.R...LR..L.."
// Output: "LL.RR.LLRRLL.."


class Solution {
    public String pushDominoes(String dominoes) {
        char[] arr = dominoes.toCharArray();
        int n = arr.length;
        int i = 0;

        while (i < n) {
            if (arr[i] == 'L') {
                int j = i - 1;
                while (j >= 0 && arr[j] == '.') {
                    arr[j] = 'L';
                    j--;
                }
                i++;
            } else if (arr[i] == 'R') {
                int j = i + 1;
                while (j < n && arr[j] == '.') {
                    j++;
                }

                if (j < n && arr[j] == 'L') {
                    // handling R.....L case
                    int left = i + 1;
                    int right = j - 1;
                    while (left < right) {
                        arr[left++] = 'R';
                        arr[right--] = 'L';
                    }
                    i = j + 1;
                } else {
                    // handline R...R or R...end case
                    int k = i + 1;
                    while (k < j) {
                        arr[k++] = 'R';
                    }
                    i = j;
                }
            } else {
                i++;
            }
        }

        return new String(arr);
    }
}
