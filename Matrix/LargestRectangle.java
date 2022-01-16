/*https://practice.geeksforgeeks.org/problems/max-rectangle/1/*/

class Solution
{
    public int maxArea(int M[][], int n, int m)
    {
        // add code here.
        int result = histogramArea(M[0],m), c = 0;
        for (int i = 1; i < n; ++i)
        {
            for (int j = 0; j < m; ++j)
            {
                if(M[i][j]==1) M[i][j] += M[i-1][j];
            }
            result = Math.max(result,histogramArea(M[i],m));
        }
        return result;
    }
    public int histogramArea(int M[], int m)
    {
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0, height, width;
        for (int j = 0; j <= m; ++j)
        {
            while(!stack.empty() && (j == m || M[stack.peek()] >= M[j]))
            {
                height = M[stack.peek()];
                stack.pop();
                if (stack.isEmpty())
                    width = j;
                else
                    width = j-stack.peek()-1;
                result = Math.max(result,width*height);
            }
            stack.push(j);
        }
        return result;
    }
}