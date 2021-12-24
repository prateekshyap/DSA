/*https://leetcode.com/problems/valid-parentheses/*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i)
        {
            try{
            //push open brackets
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));

            //if closing brackets are same as the top opening bracket in stack, then pop from stack
            else if (s.charAt(i) == ')' && stack.peek() == '(')
                stack.pop();
            else if (s.charAt(i) == '}' && stack.peek() == '{')
                stack.pop();
            else if (s.charAt(i) == ']' && stack.peek() == '[')
                stack.pop();

            //otherwise return false
            else
                return false;
            }
            catch(Exception e)
            {
                //return false for any other character
                return false;
            }
        }

        //return true if stack is empty
        return stack.empty();
    }
}