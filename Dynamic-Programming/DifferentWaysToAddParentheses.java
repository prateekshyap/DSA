/*https://leetcode.com/problems/different-ways-to-add-parentheses/*/

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        if (expression.length() == 0)
            return result;
        for (int i = 0; i < expression.length(); i++)
        {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*')
            {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for (int l : left)
                {
                    for (int r : right)
                    {
                        switch (c)
                        {
                            case '+':
                                result.add(l+r);
                                break;
                            case '-':
                                result.add(l-r);
                                break;
                            case '*':
                                result.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size() == 0)
            result.add(Integer.parseInt(expression));
        return result;       
    }
}