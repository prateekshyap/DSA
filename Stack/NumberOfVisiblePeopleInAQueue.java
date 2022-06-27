/*https://leetcode.com/problems/number-of-visible-people-in-a-queue/*/

class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length, low, high, mid, top = -1, i, j, res = -1;
        
        int[] stack = new int[n];
        int[] result = new int[n];
        if (n == 1) return result;
        
        result[n-1] = 0; stack[++top] = heights[n-1];
        result[n-2] = 1;
        if (n == 2) return result;
        
        if (stack[top] < heights[n-2]) --top;
        stack[++top] = heights[n-2];
        
        for (i = n-3; i >= 0; --i)
        {
            low = 0; high = top; mid = -1; res = 0;
            while (low <= high)
            {
                mid = low+((high-low)/2);
                if (stack[mid] > heights[i])
                {
                    res = mid;
                    low = mid+1;
                }
                else
                    high = mid-1;
            }
            result[i] = top-res+1;
            while (top >= 0 && stack[top] < heights[i]) --top;
            stack[++top] = heights[i];
        }
        
        return result;
    }
}