/*https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/*/

class Solution {
    public int longestSubsequence(String s, int k) {
        // cur gives the current value of subsequence
        // cnt gives current bit position
        int n = s.length(),res = 0,cnt = 0;
        long cur = 0;
        for(int i = n-1;i >= 0; --i){
            // add all zeroes to subsequence
            if(s.charAt(i) == '0'){
                ++res;
                ++cnt;
            }
            
            if(s.charAt(i) == '1' && cnt <= 32){
                // add 1 if the value of subsequence will be less than or equal to k
                if(cur + (1L << cnt) <= k){
                    cur += 1L << cnt;
                    ++cnt;
                    ++res;
                }
            }
        }
        return res;
    }
}