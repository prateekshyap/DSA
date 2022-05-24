/*Largest and Smallest Difference

Medium

Given a list of integers nums and an integer k, choose elements from nums to create a list of length k such that the difference between the largest integer in the list and the smallest integer is minimized. Return this difference.

Constraints

    k ≤ n ≤ 100,000 where n is the length of nums

Example 1
Input

nums = [2, 10, 5, 1, 8]

k = 3

Output

4

Explanation

The best list we can make is [1, 2, 5].

https://binarysearch.com/problems/Largest-and-Smallest-Difference
*/

//sliding window solution

import java.util.*;

class Solution {
    public int solve(int[] nums, int k) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums); //sort the given array
        int i, n = nums.length;

        diff = nums[k-1]-nums[0]; //first window difference

        for (i = k; i < n; ++i) //for each of the next windows
            if (nums[i]-nums[i-k+1] < diff) //update the minimum difference
                diff = nums[i]-nums[i-k+1];

        return diff;
    }
}