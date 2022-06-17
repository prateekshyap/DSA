/*https://leetcode.com/problems/ways-to-make-a-fair-array/*/
 
class Solution {
    public int waysToMakeFair(int[] nums) {
        int leftOdd = 0, rightOdd = 0, leftEven = 0, rightEven = 0, i, j, n = nums.length, count = 0;
        boolean turn = true;
        for (i = 0; i < n; ++i)
        {
            if (turn) rightOdd += nums[i];
            else rightEven += nums[i];
            turn = !turn;
        }
        i = 0;
        turn = true;
        while (i < n)
        {
            if (turn) rightOdd -= nums[i];
            else rightEven -= nums[i];
            
            if (rightOdd+leftEven == leftOdd+rightEven) ++count;
            
            if (turn) leftOdd += nums[i];
            else leftEven += nums[i];
            
            turn = !turn;
            ++i;
        }
        return count;
    }
}

class Solution {
    public int waysToMakeFair(int[] nums) {
        int leftOdd = 0, rightOdd = 0, leftEven = 0, rightEven = 0, i, j, n = nums.length, count = 0;
        for (i = 0; i < n; ++i)
            if ((i&1) == 0) rightOdd += nums[i]; else rightEven += nums[i];
        i = 0;
        while (i < n)
        {
            if ((i&1) == 0) rightOdd -= nums[i]; else rightEven -= nums[i];
            if (rightOdd+leftEven == leftOdd+rightEven) ++count; 
            if ((i&1) == 0) leftOdd += nums[i]; else leftEven += nums[i];
            ++i;
        }
        return count;
    }
}