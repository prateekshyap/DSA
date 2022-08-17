/*
https://leetcode.com/problems/minimum-number-of-frogs-croaking/
1419. Minimum Number of Frogs Croaking

*/

class Solution {
public:
    /*
    int minNumberOfFrogs(string croakOfFrogs) {
        unordered_map<char,int> f;
        f['c']=0;
        f['r']=0;
        f['o']=0;
        f['a']=0;
        f['k']=0;
        
        unordered_map<char,char> prevChar = {
            {'c', 'k'},
            {'r', 'c'},
            {'o', 'r'},
            {'a', 'o'},
            {'k', 'a'}
        };
        char prevch;
        
        for(char ch: croakOfFrogs)
        {
            prevch = prevChar[ch];
            
            if(prevch == 'k' || f[prevch]>0) //first char 'c' OR prevchar is positive value;
            {
                if(prevch == 'k' && f[prevch]==0)
                    f['c']++;
                else
                {
                    f[prevch]--;
                    f[ch]++;
                }
            }
            else
                return -1;
        }
        
        for(auto x: f)
            if(x.first!='k' && x.second>0)
                return -1;
        
        return f['k'];
    }
    */
    int minNumberOfFrogs(string croakOfFrogs) {
        unordered_map<char,int> f;
        
        unordered_map<char,char> prevChar = {
            {'c', 'k'},
            {'r', 'c'},
            {'o', 'r'},
            {'a', 'o'},
            {'k', 'a'}
        };
        char prevch;
        
        for(char ch: croakOfFrogs)
        {
            prevch = prevChar[ch];
            
            if(ch == 'c')
            {
                if(f[prevch]==0) f[ch]++;
                else{
                    f[prevch]--;
                    f[ch]++;
                }
            }
            else if(f[prevch]>0)
            {
                f[prevch]--;
                f[ch]++;
            }
            else
                return -1;
        }
        
        for(auto x: f)
            if(x.first!='k' && x.second>0)
                return -1;
        
        return f['k'];
    }
};