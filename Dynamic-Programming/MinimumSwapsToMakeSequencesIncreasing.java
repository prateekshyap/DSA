/*https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/*/

class Solution {
    int inf = (int)1e6;
    Integer[][] table;
    public int minSwap(int[] nums1, int[] nums2) {
        table = new Integer[nums1.length+1][2];
        return solve(nums1, nums2, -1, -1, 0, 0);
    }
    private int solve(int[] a, int[] b, int aP, int bP, int i, int swap)
    {
        if (i == a.length) return 0;
        
        if (table[i][swap] != null) return table[i][swap];
        
        int result = inf;
        
        if (a[i] > aP && b[i] > bP)
            result = Math.min(result,solve(a,b,a[i],b[i],i+1,0));
        if (a[i] > bP && b[i] > aP)
            result = Math.min(result,1+solve(a,b,b[i],a[i],i+1,1));
            
        return table[i][swap] = result;
    }
}