/*https://leetcode.com/problems/largest-rectangle-in-histogram/*/

class Solution
{
    public int largestRectangleArea(int[] heights)
    {
        int n = heights.length;
    
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];

        Stack<Integer> smallerIdxs = new Stack<>();

        for(int i = 0; i<n; i++)
            solve(heights,i,smallerIdxs,leftSmaller,-1);
        smallerIdxs = new Stack<>();
        for(int i = n-1; i>=0;i--)
            solve(heights,i,smallerIdxs,rightSmaller,n);
        int max = 0;
        for(int i = 0; i<n; i++)
        {
            int val = heights[i];
            int start = leftSmaller[i]+1;
            int end = rightSmaller[i];
            int temp = val*(end-start);
            max = Math.max(max,temp);
        }

        return max;
    }
    
    private void solve(int[] heights,int i,Stack<Integer> smallerIdxs,int[] smaller,int defaultVal )
    {
        int val = heights[i];
        
        while(!smallerIdxs.isEmpty() && heights[smallerIdxs.peek()] >=val)
            smallerIdxs.pop();
        
        smaller[i] = smallerIdxs.isEmpty() ? defaultVal : smallerIdxs.peek();
        
        smallerIdxs.add(i);
    }
}