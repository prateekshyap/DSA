/*https://practice.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1*/

/*https://leetcode.com/problems/evaluate-reverse-polish-notation/*/


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


/*Leetcode*/
class Node
{
    int op;
    Node next;
    Node(int op)
    {
        this.op = op;
    }
}

class OpStack
{
    public Node top;
    public void push(int str)
    {
        if (top == null)
            top = new Node(str);
        else
        {
            Node newNode = new Node(str);
            newNode.next = top;
            top = newNode;
        }
    }
    public int pop()
    {
        if (top == null)
            throw new NullPointerException("Stack is Empty");
        Node returnNode = top;
        top = top.next;
        return returnNode.op;
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        OpStack stack = new OpStack();
        for (int i = 0; i < tokens.length; ++i)
        {
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/"))
                stack.push(Integer.parseInt(tokens[i]));
            else
            {
                int op1 = stack.pop();
                int op2 = stack.pop();
                if (tokens[i].equals("+"))
                    stack.push(op2+op1);
                else if (tokens[i].equals("-"))
                    stack.push(op2-op1);
                else if (tokens[i].equals("*"))
                    stack.push(op2*op1);
                else if (tokens[i].equals("/"))
                    stack.push(op2/op1);
            }
        }
        return stack.pop();
    }
}