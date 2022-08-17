/*
https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/
2311. Longest Binary Subsequence Less Than or Equal to K

*/

/*
    
    add all zeroes as they don't contribute anything and we wan't the 
    longest subsequence. So everytime all the zeroes must be included.
    
    Only include  ones which don't exceed the value k. Start from right
    as it's the least significant bit, and one by one include ones.
    
    Everytime include one, check if current value isn't greater than k.
    For doing this, just raise curr index to the power of 2.
    
    Optimisation: We only need to traverse first 32 bits from end, as the 
    the 32nd bit from end, if set will amount to 2^32 which is greater 
    than max possible value of k, so any bit beyond that is useless to us, 
    as we only want subsequences with value <= k.
    
    Increment len everytime we encounter a valid one.
*/

class Solution {
public:
    int longestSubsequence_1(string s, int k) {
        reverse(s.begin(), s.end());
        
        int len=0;
        
        for(int i=0; i<s.size(); i++)
        {
            if(s[i]=='0')
                len++;
            else if(i<30)
            {
                if((1<<i)<=k) // 2^i <=k , if one is there and its value is less than k
                {
                    ++len;
                    k-=(1<<i); // 2^i value is taken now we want k = k-2^i
                }
            }
        }
        
        return len;
    }
    
    int longestSubsequence_2(string s, int k) {
        
        int len= count(s.begin(), s.end(), '0');
        
        for(int i=s.size()-1, j=0; i>=0 && j<=32; i--, j++)
        {
            if(s[i]=='1')
            {
                long long curr_val = pow(2,(s.size()-1-i)); //index 9-8-7-6----1-0
                if(curr_val>k)
                    break;
                k = k-curr_val;
                len++;
            }
        }
        
        return len;
    }
    
    int recur(int it, int len, int currSum, string& s, int k, vector<vector<int>>& dp)
    {
        if(it<0)
            return 0;
        
        if(dp[it][len] != -1)
            return dp[it][len];
        
        int notTakeDigit = recur(it-1, len, currSum, s, k ,dp); //shift to next bit;
        int takeDigit=0;
        // long long value = currSum + (s[it]-'0')*pow(2,len);
        if(currSum + (s[it]-'0')*pow(2,len) <=k)
        {
            takeDigit = 1 + recur(it-1, len+1, currSum + (s[it]-'0')*pow(2,len), s, k, dp);
        }
        
        return dp[it][len] = max(notTakeDigit, takeDigit); // return length
    }
    
    int longestSubsequence(string s, int k) {
        
        int n = s.size();
        vector<vector<int>> dp(n, vector<int>(n,-1));
        
        
        return recur(n-1, 0, 0, s, k, dp);
    }
};