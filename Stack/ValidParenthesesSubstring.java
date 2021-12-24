/*https://leetcode.com/problems/longest-valid-parentheses/*/

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, currLen = 0;
        for (int i = 0; i < s.length(); ++i)
        {
            //if open bracket
            if (s.charAt(i) == '(')
            {
                //push the current length and reset it
                stack.push(currLen);
                currLen = 0;
            }

            //if closing bracket and stack is not empty
            else if (s.charAt(i) == ')' && stack.size() > 0)
            {
                //add the popped value to 2
                currLen += stack.pop() + 2;

                //update result
                result = Math.max(result,currLen);
            }

            //if closing bracket and stack is empty
            else if (s.charAt(i) == ')' && stack.size() == 0)
                //reset current length
                currLen = 0;
        }
        return result;
    }
}