/*https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1*/

class Solution
{
    public static int evaluatePostFix(String S)
    {
        Stack<Integer> stack = new Stack<Integer>();
    	for (int i = 0; i < S.length(); ++i)
    	{
    	    char ch = S.charAt(i);
    	    if (ch >= '0' && ch <= '9')	stack.push(ch-'0');
    	    else
    		{
    			int op1 = stack.pop();
    			int op2 = stack.pop();
    			if (ch == '+') stack.push(op2+op1);
    			else if (ch == '-') stack.push(op2-op1);
    			else if (ch == '*') stack.push(op2*op1);
    			else if (ch == '/') stack.push(op2/op1);
    		}
    	}
    	return stack.pop();
    }
}