/*https://leetcode.com/problems/longest-ideal-subsequence/*/

class Solution {
    public int longestIdealString(String s, int k) {
        int n = s.length();
        int[] hash = new int[26];
        char[] a = s.toCharArray();
        int result = 0;
        for (int i = 0; i < n; ++i)
        {
            int curr = a[i]-'a';
            int val = 0;
            for (int j = Math.max(0,curr-k); j <= Math.min(curr+k,25); ++j)
                if (Math.abs(curr-j) <= k)
                    val = Math.max(val,hash[j]+1);
            hash[curr] = Math.max(1,val);
            result = Math.max(hash[curr],result);
        }
        return result;
    }
}