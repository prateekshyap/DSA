/*https://leetcode.com/problems/longest-arithmetic-subsequence/*/

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int range = 500, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, maxDiff = Integer.MIN_VALUE, n = nums.length, diff, result = 1, offset;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int val : nums)
        {
            if (val > max) max = val;
            if (val < min) min = val;
        }
        maxDiff = max-min;
        int[][] table = new int[range+1][2*maxDiff+1];
        for (int i = 0; i <= range; ++i)
            Arrays.fill(table[i],1);
        for (int num : nums)
        {
            for (diff = -maxDiff; diff <= maxDiff; ++diff)
            {
                offset = diff+maxDiff;
                if (num-diff < 0 || num-diff > 500) continue;
                if (table[num-diff][offset]+1 >= table[num][offset] && set.contains(num-diff))
                    table[num][offset] = table[num-diff][offset]+1;
                else table[num][offset] = 1;
                if (table[num][offset] > result) result = table[num][offset];
            }
            set.add(num);
        }
        return result;
    }
}