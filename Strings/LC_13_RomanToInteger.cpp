/*
https://leetcode.com/problems/roman-to-integer/
13. Roman to Integer
https://binarysearch.com/problems/Roman-Numeral-to-Integer
*/

class Solution {
public:
    int romanToInt_(string s) {
            unordered_map<char,int> mp = {
            {'I', 1},
            {'V', 5},
            {'X', 10},
            {'L', 50},
            {'C', 100},
            {'D', 500},
            {'M', 1000}
        };

        int n = s.length();
        int value = mp[s[n-1]];
        for(int i= n-2; i>=0 ;i--)
        {
            if(mp[s[i]] < mp[s[i+1]])
            {
                value = value - mp[s[i]];
            }
            else
            {
                value = value + mp[s[i]];
            }
        }
        return value;
    }
    
     int romanToInt(string s) {
         int sum = 0;
         int len = s.length();
         
         for(int i=0; i<len; i++)
         {
             if(s[i] == 'M')
                 sum+=1000;
             else if(s[i] == 'D')
                 sum+=500;
             else if(s[i] == 'C')
             {
                 if(s[i+1] == 'M' || s[i+1] == 'D')
                     sum -= 100;
                 else
                     sum += 100;
             }
             else if(s[i] == 'L')
                 sum+=50;
             else if(s[i] == 'X')
             {
                 if(s[i+1] == 'L' || s[i+1] == 'C')
                     sum -= 10;
                 else
                     sum += 10;
             } else if(s[i] == 'V')
                 sum+=5;
             else if(s[i] == 'I')
             {
                 if(s[i+1] == 'X' || s[i+1] == 'V')
                     sum -= 1;
                 else
                     sum += 1;
             }
         }//for
         
         return sum;
     }//end
};