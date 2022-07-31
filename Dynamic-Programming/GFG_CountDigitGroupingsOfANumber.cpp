/*
https://practice.geeksforgeeks.org/problems/count-digit-groupings-of-a-number1520/1/#
Count digit groupings of a number 

Variation of Palindromic Partition
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
	public:
	int TotalCount(string str){
	    
	    vector<vector<int>> memo(str.length(), vector<int>(901, -1));
	   
        return solve(0, 0, str, memo);
	}
    
    int solve(int idx, int prevSum, string &s, vector<vector<int>>& memo)
    {
        if(idx == s.length())
            return 1;
        
        if(memo[idx][prevSum] != -1)
            return memo[idx][prevSum];
            
        int cnt=0;
        int curSum=0;
        for(int i=idx; i<s.length(); i++)
        {
            curSum+= s[i]-'0';
            if(prevSum<= curSum)
            {
                cnt+= solve(i+1, curSum, s, memo);
            }
        }
        
        memo[idx][prevSum] = cnt;
        return cnt;
    }
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		string str;
		cin >> str;
		Solution ob;
		int ans = ob.TotalCount(str);
		cout << ans <<"\n";
	}
	return 0;
}  // } Driver Code Ends