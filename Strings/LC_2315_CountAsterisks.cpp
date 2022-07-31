/*
https://leetcode.com/problems/count-asterisks/
2315. Count Asterisks

*/

class Solution {
public:
    int countAsterisks_(string s) {
        
        int cntpair = 0;
        int cnt=0;
        
        for(char ch: s)
        {
            if(cntpair == 0 && ch == '*')
            {
                cnt++;
            }
            else if (ch == '|')
                cntpair++;
            
            if(cntpair == 2)
                cntpair=0;
        }
        
        return cnt;
    }
    
    int countAsterisks(string s) {
        
        int cntpair = 0;
        int ans=0;
        
        for(char ch: s)
        {
            if(ch == '|')
                cntpair++;
            else if((cntpair%2 == 0) && ch == '*')          
                ans++;
        }
        
        return ans;
    }
    
    
};