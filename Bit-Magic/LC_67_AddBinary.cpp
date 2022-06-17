/*
https://leetcode.com/problems/add-binary/
67. Add Binary
*/

class Solution {
public:
    string addBinary(string a, string b) {
        
        int i = a.length()-1;
        int j = b.length()-1;
        
        int sum_bit = 0;
        int carry_bit = 0;
        
        string ans;
        
        while(i>=0 || j>=0)
        {
            sum_bit = carry_bit;
            
            if(i>=0) sum_bit += a[i--]-'0';
            if(j>=0) sum_bit += b[j--]-'0';
            
            carry_bit = sum_bit/2;
            sum_bit = sum_bit%2;
            
            ans += sum_bit + '0';
            
        }
        
        if(carry_bit != 0) ans += carry_bit + '0';
        
        reverse(ans.begin(), ans.end());
        
        return ans;
    }//end
};