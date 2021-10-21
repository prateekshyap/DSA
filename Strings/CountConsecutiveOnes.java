/*https://leetcode.com/problems/number-of-substrings-with-only-1s/*/

class Solution {
   public int numSub(String s) {
        long consecutiveCount = 0, result = 0, mod = 1000000007;
        
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0')
            {
                result += ((consecutiveCount*(consecutiveCount+1))/2)%mod;
                result %= mod;
                consecutiveCount = 0;
            }
            else
            {
                ++consecutiveCount;
            }
        }
        if (s.charAt(s.length()-1) == '1')
        {
            result += ((consecutiveCount*(consecutiveCount+1))/2)%mod;
            result %= mod;
        }
        return (int)(result%mod);
    }
}