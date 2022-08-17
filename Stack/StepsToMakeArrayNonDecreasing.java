/*https://leetcode.com/problems/steps-to-make-array-non-decreasing/*/

class Solution {
    public int totalSteps(int[] nums) {
        int result = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = nums.length-1; i >= 0; --i)
        {
            if (stack.isEmpty())
                stack.push(new int[]{nums[i],0});
            else
            {
                int count = 0;
                while (!stack.isEmpty() && stack.peek()[0] < nums[i])
                {
                    count = Math.max(count+1,stack.peek()[1]);
                    stack.pop();
                }
                result = Math.max(count,result);
                stack.push(new int[]{nums[i],count});
            }
        }
        return result;
    }
}