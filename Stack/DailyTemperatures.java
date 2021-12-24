/*https://leetcode.com/problems/daily-temperatures/*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        int[] result = new int[temperatures.length];
        result[temperatures.length-1] = 0;
        stack.push(temperatures.length-1);
        for (int i = temperatures.length-1; i >= 0; --i)
        {
            int curr = 0;
            while (stack.peek() != -1 && temperatures[stack.peek()] <= temperatures[i])
                curr = stack.pop();
            curr = stack.peek();
            if (curr != -1)
                result[i] = curr-i;
            stack.push(i);
        }
        return result;
    }
}