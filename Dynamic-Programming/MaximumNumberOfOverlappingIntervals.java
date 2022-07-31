/*https://practice.geeksforgeeks.org/problems/intersecting-intervals/1/*/

class Solution {
    public static int overlap(int n, int[][] intervals) {
        // code here
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, i;
        //find the maximum value present in the intervals array
        for (i = 0; i < n; ++i)
        {
            max = Math.max(max,intervals[i][0]);
            max = Math.max(max,intervals[i][1]);
        }
        int[] overlap = new int[max+2]; //create a dp table of length max+2
        for (i = 0; i < n; ++i) //for each interval
        {
            overlap[intervals[i][0]] += 1; //mark the starting point
            overlap[intervals[i][1]+1] += -1; //mark the ending point
        }
        max = overlap[0]; //start from 0th index
        for (i = 1; i < overlap.length; ++i) //till the end
        {
            overlap[i] = overlap[i]+overlap[i-1]; //get the prefix sum
            max = Math.max(max,overlap[i]); //update maximum value
        }
        return max;
    }
}