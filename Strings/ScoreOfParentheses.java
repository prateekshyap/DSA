/*https://leetcode.com/problems/score-of-parentheses/*/

class Solution {
    public int scoreOfParentheses(String s) {
        int currScore = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (char ch : s.toCharArray())
        {
            if (ch == '(')
                stack.push(0);
            else
            {
                currScore = 0;
                while (stack.peek() > 0)
                    currScore += stack.pop();
                stack.pop();
                stack.push(currScore == 0 ? 1 : currScore*2);
            }
        }
        int score = 0;
        while (!stack.isEmpty())
            score += stack.pop();
        return score;
    }
}

