/*https://leetcode.com/problems/array-nesting/*/

class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length, len = 0, max = 0, index;
        boolean[] visited = new boolean[n];
        boolean begin = true;
        for (int i = 0; i < n; ++i)
        {
            if (!visited[i])
            {
                len = 0;
                begin = true;
                index = i;
                visited[index] = true;
                while (begin || index != i)
                {
                    begin = false;
                    ++len;
                    index = nums[index];
                    visited[index] = true;
                }
                max = Math.max(len,max);
            }
        }
        return max;
    }
}