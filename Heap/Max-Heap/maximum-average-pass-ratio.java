// There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array classes, where classes[i] = [passi, totali]. You know beforehand that in the ith class, there are totali total students, but only passi number of students will pass the exam.

// You are also given an integer extraStudents. There are another extraStudents brilliant students that are guaranteed to pass the exam of any class they are assigned to. You want to assign each of the extraStudents students to a class in a way that maximizes the average pass ratio across all the classes.

// The pass ratio of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The average pass ratio is the sum of pass ratios of all the classes divided by the number of the classes.

// Return the maximum possible average pass ratio after assigning the extraStudents students. Answers within 10-5 of the actual answer will be accepted.

 

// Example 1:

// Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
// Output: 0.78333
// Explanation: You can assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
// Example 2:

// Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
// Output: 0.53485


class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = ((a[0]+1.0)/(a[1]+1)) - ((double)a[0]/a[1]);
            double gainB = ((b[0]+1.0)/(b[1]+1)) - ((double)b[0]/b[1]);
            return Double.compare(gainB, gainA);
        });

        
        for(int[] c : classes){
            pq.offer(c);
        }

        while(extraStudents > 0){
            int[] c = pq.poll();   //class with max gain
            c[0] = c[0] + 1;
            c[1] = c[1] + 1;
            pq.offer(c);   //add again after adding 1
            extraStudents--;
        }

        double passRatio = 0.0;
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            passRatio += (double) top[0] / top[1];
        }

        return passRatio / classes.length;
    }
}


//we are using maxheap based on gain
//(a, b) if we add 1 so it becomes (a + 1, b + 1);
//Gain = (a+1/b+1) - (a / b);
//The class that gives maximum gain will be at the top
//We will remove from pq and add a student to that class and then add again until extraStudents becomes 0;