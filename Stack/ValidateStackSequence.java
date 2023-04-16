/*https://leetcode.com/problems/validate-stack-sequences/*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack stack = new Stack();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; ++i)
        {
            stack.push(pushed[i]);
            while (popIndex < popped.length && !stack.isEmpty() && popped[popIndex] == (Integer)stack.peek())
            {
                stack.pop();
                ++popIndex;
            }
        }
        return stack.isEmpty();
    }
}