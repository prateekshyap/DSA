/*https://binarysearch.com/problems/Set-Split*/

import java.util.*;

class Solution {
    public boolean solve(int[] nums) {
        if (nums.length == 1) return false;
        Arrays.sort(nums);
        int sumLeft = 0, sumRight = 0;
        int i, n = nums.length;
        for (i = 1; i < n; ++i) sumRight += nums[i];
        sumLeft = nums[0];
        if (sumLeft == sumRight && nums[0] != nums[1]) return true;
        for (i = 1; i < n-1; ++i)
        {
            sumLeft += nums[i];
            sumRight -= nums[i];
            if (sumLeft == sumRight && nums[i] != nums[i+1]) return true;
        }
        return false;
    }
}