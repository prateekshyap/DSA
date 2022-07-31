/*
https://leetcode.com/problems/count-number-of-homogenous-substrings/
1759. Count Number of Homogenous Substrings

*/

class Solution {
public:
    int countHomogenous_(string s) {
        const int MOD = 1e9+7;
        int count=0;
        long len = 1;
        for(int i=1; i<s.size(); i++)
        {
            if(s[i] == s[i-1])
                len++;
            else
            {
                count += (len*(len+1)/2)%MOD;
                len=1;
            }
        }
        count += (len*(len+1)/2)%MOD;
        return count%MOD;
    }
    int countHomogenous(string s) {
        const int MOD = 1e9+7;
        int count=0;
        int len = 1;
        for(int i=0; i<s.size(); i++)
        {
            if(s[i] != s[i+1])
                len=1;
            else
            {
                len+=1;
            }
            count = (count+len)%MOD;
        }
        
        return count%MOD;
    }
};