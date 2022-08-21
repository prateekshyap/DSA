/*https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/*/

class Solution {
    public String reverseParentheses(String str) {
        Stack<Integer> stack = new Stack<Integer>();
        char[] a = str.toCharArray();
        int s, e;
        char temp;
        for (int i = 0; i < a.length; ++i)
        {
            if (a[i] == '(')
                stack.push(i);
            else if (a[i] == ')')
            {
                s = stack.pop()+1;
                e = i-1;
                while (s <= e)
                {
                    temp = a[s];
                    a[s] = a[e];
                    a[e] = temp;
                    ++s; --e;
                }
            }
        }
        StringBuilder result = new StringBuilder("");
        for (char ch : a)
            if (ch != '(' && ch != ')')
                result.append(ch);
        return result.toString();
    }
}

