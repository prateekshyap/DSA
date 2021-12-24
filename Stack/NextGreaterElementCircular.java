/*https://leetcode.com/problems/next-greater-element-ii/*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();

        //push the minimum value for base case
        stack.push(Integer.MIN_VALUE);
        int[] res = new int[nums.length];

        //push all the elements in reverse order
        for (int i = nums.length-1; i >= 0; --i)
            stack.push(nums[i]);

        for (int i = nums.length-1; i >= 0; --i)
        {
            //till we have more elements in stack and stack top is less or equal to current value, pop stack
            while (stack.peek() <= nums[i] && stack.peek() != Integer.MIN_VALUE)
                stack.pop();

            //store stack top as the result of current element
            res[i] = stack.peek() == Integer.MIN_VALUE ? -1 : stack.peek();

            //push the current element to stack
            stack.push(nums[i]);
        }
        return res;
    }
}