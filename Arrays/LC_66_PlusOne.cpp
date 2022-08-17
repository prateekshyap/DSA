/*
https://leetcode.com/problems/plus-one/
66. Plus One


https://practice.geeksforgeeks.org/problems/plus-one/1/
*/

class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        
        int n = digits.size();
        unsigned int carry=0;
        digits[n-1] += 1;
        
        for(int j=n-1; j>=0; j--)
        {
            digits[j] += carry;
            if(digits[j]<10)
            {
                carry=0;
                break;
            }
            digits[j] %= 10;
            carry = 1;
        }
        
        if(carry)
            digits.insert(digits.begin(), 1);
        
        return digits;
        
    }
    
    vector<int> plusOne_1(vector<int>& digits) {
        
        int n = digits.size();
        
        int sum=0, carry=1;
        
        vector<int> ans;
        
        for(int j=n-1; j>=0; j--)
        {
            sum = carry;
            sum += digits[j];
            carry = sum/10;
            ans.push_back(sum%10);
        }
        
        if(carry)
            ans.push_back(carry);
        
        reverse(ans.begin(), ans.end());
        
        return ans;
        
    }
};