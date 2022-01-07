/*https://leetcode.com/problems/find-pivot-index/*/
/*https://practice.geeksforgeeks.org/problems/equilibrium-point-1587115620/1*/

class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        
        //find left sum and right sum for 0th index and check
        for (int i = 1; i < nums.length; ++i)
            rightSum += nums[i];
        if (leftSum == rightSum) return 0;
        
        //for rest of the indices
        for (int i = 1; i < nums.length; ++i)
        {
            //slide the candidate pivot to right by 1
            leftSum += nums[i-1];
            rightSum -= nums[i];
            if (leftSum == rightSum) return i;
        }
        return -1;
    }
}
