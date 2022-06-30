/*https://binarysearch.com/problems/Skip-Tasks-to-Minimize-Work*/

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1 && nums[0] == 0) return 0;
        int i, n = nums.length;
        int[][] table = new int[n][2];
        
        table[0][1] = nums[0];
        for (i = 1; i < n; ++i)
        {
        	/*
        		first row stores the minimum cost by skipping the current task
        		since the current task is skipped, previous task has to be considered
        		so we take the value that we obtained by considering the previous task
        	*/
            table[i][0] = table[i-1][1];

            /*
				second row stores the minimum cost by considering the current task
				since the current task is considered, we can either skip or consider the previous task
				so it will be the minimum of the two
            */
            if (table[i-1][0] < table[i-1][1])
                table[i][1] = nums[i]+table[i-1][0];
            else table[i][1] = nums[i]+table[i-1][1];
        }

        return Math.min(table[n-1][0],table[n-1][1]);
    }
}