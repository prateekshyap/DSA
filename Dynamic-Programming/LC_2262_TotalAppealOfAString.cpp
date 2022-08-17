 /*
https://leetcode.com/problems/total-appeal-of-a-string/
2262. Total Appeal of A String

https://leetcode.com/problems/total-appeal-of-a-string/discuss/2379420/C%2B%2B-Easy-intuitive-Approach-using-Hashing-and-DP

https://leetcode.com/problems/total-appeal-of-a-string/discuss/1996390/
*/
class Solution {
public:
    
    long long appealSum(string s) {
        //aprroach 3
        int n = s.length();
        long long cnt=0; 
        vector<int> last(26, -1);
        for(int i=0; i<n; i++)
        {   int ch= s[i]-'a';  
            cnt += (i-last[ch])*(n-i);
            last[ch] = i;  
            // cout<<s[i]<<" "<<last[ch]<<" "<<cnt<<endl; 
        }
        return cnt;
    }
    
    long long appealSum_(string s) {
        //aprroach 3
        int n = s.length();
        long long cnt=0;
        long total=0;
        vector<int> last(26, 0);
        for(int i=0; i<n; i++)
        {   int ch= s[i]-'a';  
            total = total + (i+1) - last[ch];
            last[ch] = i+1; 
            cnt+=total; // sum total appeal of each index
            // cout<<s[i]<<" "<<last[ch]<<" "<<total<<endl; 
        }
        return cnt;
        
        // Approach 2
//         int n = s.length(); 
//         long long currentTotal=0;
//         vector<int> lastindex(26, -1);
//         long long cnt=0;
        
//         for(int i=0; i<n; i++)
//         {
//             int ch= s[i]-'a';  
//             currentTotal = currentTotal + i - lastindex[ch];
//             cnt+=currentTotal;
//             lastindex[ch] = i;
//             // cout<<i<<" "<<s[i]<<" "<<dp[i+1]<<" "<<endl;
//         }  
//         return cnt;
    }
    
    
    // APproach 1
//     long long appealSum(string s) { 
//         int n = s.length();
//         vector<int> dp(n+1, 0);// total appeal at each index; 
//         vector<int> lastindex(26, -1);
//         long long cnt=0;
        
//         for(int i=0; i<n; i++)
//         {
//             int ch= s[i]-'a';
//             dp[i+1] = dp[i] + i-lastindex[ch];
//             cnt+=dp[i+1]; 
//             lastindex[ch] = i;
//             // cout<<i<<" "<<s[i]<<" "<<dp[i+1]<<" "<<endl;
//         }  
//         return cnt;
//     }
};