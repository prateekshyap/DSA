/*https://leetcode.com/problems/trapping-rain-water/*/
/*https://binarysearch.com/problems/Rain-Catcher*/

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

class Solution {
    public int trap(int[] height) {
        int i, n = height.length;
        int[] leftMax = new int[n], rightMax = new int[n];
        for (i = 1; i < n; ++i)
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        for (i = n-2; i >= 0; --i)
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        int water = 0;
        for (i = 0; i < n; ++i)
            water += Math.max(0,Math.min(leftMax[i],rightMax[i])-height[i]);
        return water;
    }
}

import java.util.*;

class Solution {
    public int solve(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 0;
        int left = 0, right = n-1, border;
        while (left < n-1 && nums[left] <= nums[left+1]) ++left;
        while (right > 0 && nums[right] <= nums[right-1]) --right;
        int water = 0;
        int index = 0, sum, temp;
        while (left < right)
        {
            if (nums[left] < nums[right])
            {
                border = nums[left];
                left++;
                while(nums[left] < border){
                    water += border - nums[left++];
                }
            }
            else
            {
                border = nums[right];
                right--;
                while(nums[right] < border){
                    water += border - nums[right--];
                }
            }
        }
        return water;
    }
}

class Solution {
    public int trap(int[] height) {
        int n = height.length, water = 0, index = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while (index < n)
        {
            while (!stack.isEmpty() && height[index] > height[stack.peek()])
            {
                int stackTop = stack.pop();
                if (stack.isEmpty()) break;
                int distance = index-stack.peek()-1;
                int boundedHeight = Math.min(height[index],height[stack.peek()])-height[stackTop];
                water += distance*boundedHeight;
            }
            stack.push(index++);
        }
        return water;
    }
}