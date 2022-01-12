/*https://practice.geeksforgeeks.org/problems/box-stacking/1/*/

class Solution
{
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        int i = 0, len = 3*n, j = 0, result = 0;
        Box[] maxHeap = new Box[len];
        for (i = 0; i < n; ++i)
        {
            maxHeap[j++] = new Box(Math.max(length[i],width[i]),Math.min(length[i],width[i]),height[i]);
            maxHeap[j++] = new Box(Math.max(length[i],height[i]),Math.min(length[i],height[i]),width[i]);
            maxHeap[j++] = new Box(Math.max(width[i],height[i]),Math.min(width[i],height[i]),length[i]);
        }
        Arrays.sort(maxHeap);
        int[] dp = new int[len];
        for (i = 0; i < len; ++i)
            dp[i] = maxHeap[i].h;
        for (i = 0; i < len; ++i)
        {
            for (j = 0; j < i; ++j)
            {
                if (maxHeap[i].w < maxHeap[j].w && maxHeap[i].l < maxHeap[j].l && dp[i] <= dp[j]+maxHeap[i].h)
                    dp[i] = dp[j]+maxHeap[i].h;
                result = Math.max(dp[i],result);
            }
        }
        return result;
    }
}