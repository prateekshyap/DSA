/*https://leetcode.com/problems/elimination-game/*/

class Solution
{
    public int lastRemaining(int n)
    {
        if (n == 1) return 1;
        Stack<Integer> stack1 = new Stack<Integer>(), stack2 = new Stack<Integer>();
        int i;
        for (i = 2; i <= n; i += 2) stack2.push(i);
        while (stack2.size() > 1)
        {
            while (!stack2.isEmpty())
            {
                stack2.pop();
                if (!stack2.isEmpty()) stack1.push(stack2.pop());
            }
            stack2 = stack1;
            stack1 = new Stack<Integer>();
        }
        return (Integer)stack2.pop();
    }
}

class Solution
{
    public int lastRemaining(int n)
    {
	    if (n == 1) return 1;
	    final int half = n/2;
	    final int nextLayer = lastRemaining(half);
	    return (half-nextLayer+1)*2;
    }
}