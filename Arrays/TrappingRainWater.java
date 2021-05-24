/*https://leetcode.com/problems/trapping-rain-water/*/

class Solution {
    public int trap(int[] height) {

        //we can't store water unless there are at least 3 blocks
        if (height.length <= 2) return 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int result = 0;

        //find maximum height from left, till that point
        leftMax[0] = -1;
        leftMax[1] = height[0];
        int max = height[0];
        for (int i = 2; i < height.length; ++i)
        {
            if (height[i-1] > max)
                max = height[i-1];
            leftMax[i] = max;
        }

        //find maximum height from right, till that point
        rightMax[height.length-1] = -1;
        rightMax[height.length-2] = height[height.length-1];
        max = height[height.length-1];
        for (int i = height.length-3; i >= 0; --i)
        {
            if (height[i+1] > max)
                max = height[i+1];
            rightMax[i] = max;
        }

        //find how much water we can store at each block
        for (int i = 0; i < height.length; ++i)
        {
            int m = Math.min(leftMax[i],rightMax[i])-height[i];
            if (m > 0) result += m;
        }
        return result;
    }
}