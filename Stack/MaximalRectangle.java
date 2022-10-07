/*https://leetcode.com/problems/maximal-rectangle/*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int[] heights = new int[matrix[0].length];
        int maxArea = -1;
        for (int i = 0; i < matrix.length; ++i)
        {
            for (int j = 0; j < matrix[0].length; ++j)
            {
                if (matrix[i][j] == '0')
                heights[j] = 0;
                else ++heights[j];
            }
            int area = largestRectangleArea(heights);
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
    }
    private int largestRectangleArea(int[] heights) {
        int n = heights.length, largest = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < n; ++i)
        {
            if (stack.peek() == -1 || heights[stack.peek()] <= heights[i])
            {
                stack.push(i);
                largest = Math.max(heights[i],largest);
            }
            else
            {
                while (stack.peek() != -1 && heights[stack.peek()] >= heights[i])
                {
                    int index = stack.pop();
                    largest = Math.max(largest,(i-stack.peek()-1)*heights[index]);
                }
                stack.push(i);
            }
        }
        while (stack.peek() != -1)
        {
            int index = stack.pop();
            largest = Math.max(largest,(n-stack.peek()-1)*heights[index]);
        }
        return largest;
    }
}
