/*https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/*/

class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < k-1+(1<<k))
            return false;
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < s.length()-k+1; ++i)
            set.add(s.substring(i,i+k));
        if (set.size() == Math.pow(2,k)) return true;
        return false;
    }
}

class Solution {
    public boolean hasAllCodes(String S, int K) {
        int len = S.length(), count = 1 << K;
        if (K > len) return false;
        int num = K > 1 ? Integer.parseInt(S.substring(len-K+1),2)<<1 : 0;
        boolean[] seen = new boolean[count];
        for (int i = len - K; i >= 0; i--)
        {
            num = (((S.charAt(i)-'0')<<K)+num)>>1;
            if (!seen[num])
            {
                seen[num] = true;
                count--;
            }
            if (count == 0) return true;
            if (i < count) return false;
        }
        return false;
    }
}