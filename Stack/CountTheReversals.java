/*https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1*/

class Sol
{
    int countRev (String s)
    {
        // your code here
        if (s.length()%2 != 0) return -1;
        
        Stack<Boolean> stack = new Stack<Boolean>();
        int i, count = 0;
        char ch;
        
        for (i = 0; i < s.length(); ++i)
        {
            ch = s.charAt(i);
            if (ch == '{') stack.push(true);
            else
            {
                //if stack is empty then that bracket has to be reversed
                if (stack.isEmpty())
                {
                    stack.push(true);
                    ++count;
                }
                else stack.pop();
            }
        }
        
        if (stack.isEmpty()) return count;
        return count+stack.size()/2;
    }
}