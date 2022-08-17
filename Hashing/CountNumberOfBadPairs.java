/*https://leetcode.com/problems/count-number-of-bad-pairs/*/

class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> diffCnt = new HashMap<>();
        for(int i = 0; i < n; i ++)
        {
            int diff = nums[i]-i;
            diffCnt.put(diff, diffCnt.getOrDefault(diff,0)+1);
        }
        
        long good = 0l;
        for (int v: diffCnt.values())
            good += ((long)v)*(v-1)/2;
        return ((long)n)*(n-1)/2 - good;
    }
}