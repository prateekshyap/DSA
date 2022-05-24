/*You are given a list of unique integers nums. Return a sorted two dimensional list of integers where each list represents an inclusive interval summarizing integers that are contiguous in nums.

Constraints

    n ≤ 100,000 where n is the length of nums

Example 1
Input

nums = [1, 3, 2, 7, 6]

Output

[
    [1, 3],
    [6, 7]
]

Variation of merge intervals

https://binarysearch.com/problems/Contiguous-Intervals
*/

import java.util.*;

class Solution {
    public int[][] solve(int[] nums) {
        if (nums.length == 0) return new int[0][0]; //edge case for empty array
        Arrays.sort(nums); //sort
        ArrayList<int[]> list = new ArrayList<int[]>();
        int start = -1, end = -1; //set to -1
        start = end = nums[0]; //initialize with the first element of the current interval
        for (int i = 1; i < nums.length; ++i) //for each element
        {
            if (nums[i] == nums[i-1]+1) end = nums[i]; //if streak exists, update end index
            else //otherwise
            {
                int[] arr = new int[2]; //create a new array of length 2
                arr[0] = start; //store start
                arr[1] = end; //store end
                list.add(arr); //add to list
                start = end = nums[i]; //update start and end to the first index of the next window
            }
        }
        //add the last interval
        int[] arr = new int[2];
        arr[0] = start;
        arr[1] = end;
        list.add(arr);

        //convert from list to 2D array
        int[][] result = new int[list.size()][2];
        int index = 0;
        for (int[] a : list)
        {
            result[index][0] = a[0];
            result[index][1] = a[1];
            index++;
        }
        
        return result;
    }
}