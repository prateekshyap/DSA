/*https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/*/

class Solution {
    public int ans = Integer.MAX_VALUE;
    public int minimumSize(int[] nums, int k) {
        int n = nums.length;
        int l = 1;
        int h = Integer.MIN_VALUE;
        int m;
        for (int elem : nums) if (elem > h) h = elem;
        while (l <= h)
        {
            m = ((h-l)/2)+l;
            if (f(nums,m) <= k) 
            {
                ans = m;
                h = m-1;
            }
            else
                l = m+1;
        }
        return ans;
    }
    public int f(int [] nums, int cut)
    {
        int c = 0;
        for (int n : nums)
        {
            if (n > cut)
            {
                c += (n/cut);
                if (n%cut == 0) --c;
            }
        }
        return c;
    }
}