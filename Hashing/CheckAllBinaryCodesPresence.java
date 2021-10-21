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