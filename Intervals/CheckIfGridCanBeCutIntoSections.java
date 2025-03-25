// L-3394

// You are given an integer n representing the dimensions of an n x n grid, with the origin at the bottom-
// left corner of the grid. You are also given a 2D array of coordinates rectangles, where rectangles[i] 
// is in the form [startx, starty, endx, endy], representing a rectangle on the grid. Each rectangle is
//  defined as follows:

// (startx, starty): The bottom-left corner of the rectangle.
// (endx, endy): The top-right corner of the rectangle.
// Note that the rectangles do not overlap. Your task is to determine if it is possible to make either 
// two horizontal or two vertical cuts on the grid such that:

// Each of the three resulting sections formed by the cuts contains at least one rectangle.
// Every rectangle belongs to exactly one section.
// Return true if such cuts can be made; otherwise, return false.

// Example 1:

// Input: n = 5, rectangles = [[1,0,5,2],[0,2,2,4],[3,2,5,3],[0,4,4,5]]

// Output: true

// Explanation:



// The grid is shown in the diagram. We can make horizontal cuts at y = 2 and y = 4. Hence, output is true.
// Given rectangle 1,0,5,2
// here 1,5 is of x-axis and 0,2 is of y-axis
// so we will create 2 lists for both of them
// and check if we can get 3 separate intervals after merging from any one of them either from row or column

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        ArrayList <int[]> listx = new ArrayList<>();
        ArrayList <int[]> listy = new ArrayList<>();

        for(int i = 0; i < rectangles.length; i++){
            listx.add(new int[] {rectangles[i][0], rectangles[i][2]});
            listy.add(new int[] {rectangles[i][1], rectangles[i][3]});
        }

        listx.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);   
            } else {
                return Integer.compare(a[1], b[1]);   
            }
        });

        listy.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);  
            } else {
                return Integer.compare(a[1], b[1]);  
            }
        });

        
        boolean solveRow = solvex(listx, listx.get(0)[0], listx.get(0)[1]);
        boolean solveCol = solvey(listy, listy.get(0)[0], listy.get(0)[1]);
        return solveRow || solveCol;


    }
    boolean solvex(ArrayList <int[]> listx, int start, int end){
        int count = 1;
        for(int i = 1; i < listx.size(); i++){
            if(listx.get(i)[0] < end){
                end = Math.max(end, listx.get(i)[1]);
            }
            else {
                start = listx.get(i)[0];
                end = listx.get(i)[1];
                count++;
            }
        }
        if(count >= 3) return true;
        return false;
    }

    boolean solvey(ArrayList <int[]> listy, int start, int end){
        int count = 1;
        for(int i = 1; i < listy.size(); i++){
            if(listy.get(i)[0] < end){
                end = Math.max(end, listy.get(i)[1]);
            }
            else {
                start = listy.get(i)[0];
                end = listy.get(i)[1];
                count++;
            }
        }
        if(count >= 3) return true;
        return false;
    }

}