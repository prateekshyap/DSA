/*
12. Integer to Roman

https://leetcode.com/problems/integer-to-roman/
*/

class Solution {
public:
    string intToRoman(int num) {
        vector<pair<int,string>> hash = {
            {1, "I"},
            {4, "IV"},
            {5, "V"},
            {9, "IX"},
            {10, "X"},
            
            {40, "XL"},
            {50, "L"},
            
            {90, "XC"},
            {100, "C"},
            
            {400, "CD"},
            {500, "D"},
            
            {900, "CM"},
            {1000, "M"}
        }; 
        string ans;
        
        while(num)
        {  
            for(int i=hash.size()-1; i>=0; i--)
            {
                if(hash[i].first <= num)
                {
                    ans += hash[i].second;
                    num -= hash[i].first;
                    break;
                }
            }
        }
        
        return ans;
    }
};