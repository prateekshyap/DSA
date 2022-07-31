/*https://leetcode.com/problems/next-greater-element-ii/*/
/*https://binarysearch.com/problems/Circular-Greater-Element-to-the-Right*/

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

import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length, i;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        for (i = n-1; i >= 0; --i)
            stack.push(nums[i]);
        for (i = n-1; i >= 0; --i)
        {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) stack.pop();
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }
}

import java.util.*;

class Solution {
    public int[] solve(int[] nums) {
        int n = nums.length, ans[] = new int[n];
        Arrays.fill(ans, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2 * n; i++)
        {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) ans[stack.pop()] = num;
            stack.push(i % n);
        }
        return ans;
    }
}