/*
https://leetcode.com/problems/consecutive-characters/
1446. Consecutive Characters

*/

class Solution {
public:
//     int maxPower(string s) {
//         int len = s.size();
//         vector<int> power(len);
        
//         power[0] = 1;
//         for(int i=1; i<len; i++)
//         {
//             if(s[i] == s[i-1])
//                 power[i] = power[i-1]+1;
//             else
//                 power[i] = 1;
//         }
//         // for(int x: power)
//         //     cout<<x<<" ";
//         return *max_element(power.begin(),power.end());
//     }
    
    int maxPower(string s) {
        int len = s.size();
        int power=0;
        int pre=-1;
        for(int i=0; i<len; i++)
        {
            if(i==len-1 || s[i] != s[i+1])
            {
                power = max(power, i-pre);
                pre = i;
            }
        }
        
        return power;
    }
};