/*https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/*/

class Solution {
    int maxLen;
    int[] hash;
    public int maxLength(List<String> arr) {
        if (arr.size() == 1)
        {
            boolean flag = true;
            hash = new int[26];
            for (char ch : arr.get(0).toCharArray())
            {
                ++hash[ch-'a'];
                if (hash[ch-'a'] > 1)
                {
                    flag = false;
                    break;
                }
            }
            return flag ? arr.get(0).length() : 0;
        }
        maxLen = 0;
        hash = new int[26];
        solve(arr,0,0,0);
        return maxLen;
    }
    private void solve(List<String> arr, int index, int currLen, int uc)
    {
        if (index >= arr.size() || uc == 26)
        {
            if (currLen > maxLen)
                maxLen = currLen;
            return;
        }
        //include
        boolean flag = true;
        int[] oldHash = new int[26];
        for (int i = 0; i < 26; ++i)
            oldHash[i] = hash[i];
        int oldUc = uc;
        for (char ch : arr.get(index).toCharArray())
        {
            ++hash[ch-'a'];
            if (hash[ch-'a'] == 1) ++uc;
            else if (hash[ch-'a'] > 1)
            {
                flag = false;
                break;
            }
        }
        if (flag) solve(arr,index+1,currLen+arr.get(index).length(),uc);
        hash = oldHash;
        uc = oldUc;
        //exclude
        solve(arr,index+1,currLen,uc);
    }
}