/*
https://leetcode.com/problems/number-of-substrings-with-only-1s/
1513. Number of Substrings With Only 1s

*/

class Solution {
public:
    const int MOD = 1e9+7;
    int numSub(string s) {
        int count=0;
        long cur=0;
        for(char c: s)
        {
            if(c=='1')
            {
                cur++;
            }
            else
            {
                count += (cur*(cur+1)/2)%MOD;
                cur=0;
            }
        }
        count += cur*(cur+1)/2;
        return count%MOD;
    }
};