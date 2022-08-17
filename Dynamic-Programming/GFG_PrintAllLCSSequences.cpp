/*
https://practice.geeksforgeeks.org/problems/print-all-lcs-sequences3413/1
Print all LCS sequences
*/

class Solution
{
	public:
	    vector<vector<int>> dp;
	    vector<string> ans;
		vector<string> all_longest_common_subsequences(string s, string t)
		{
		    int m = s.length(), n = t.length();
		    dp.resize(m+1, vector<int>(n+1, 0));
		    for(int i=1; i<=m ; i++) {
		        for(int j=1; j<=n; j++) {
		            if(s[i-1] == t[j-1])
		                dp[i][j] = 1 + dp[i-1][j-1];
		            else
		                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
		        }//for j
		    }//for i
		    
		    a = s;
		    b = t;
		    printlcsRec(m, n, "");
		    sort(ans.begin(), ans.end());
		    return ans;
		}
		
		unordered_set<string> usans, visited;
	    string a,b;
		void printlcsRec(int i, int j, string str)
		{
		    if(i==0 || j==0)
		    {
		        if(usans.find(str) == usans.end())
		        {
		            usans.insert(str);
		            ans.push_back(str);
		        }
		        return ;
		    }
		    string key = to_string(i) + to_string(j) + str;
		    if(visited.find(key) != visited.end()) return; // already visited the cell
		    visited.insert(key);
		    if(a[i-1] == b[j-1])
		    {
		        printlcsRec(i-1, j-1, a[i-1] + str);
		    }
		    else if( dp[i-1][j] > dp[i][j-1]) // up
		    {
		        printlcsRec(i-1, j, str);
		    }
		    else if( dp[i][j-1] > dp[i-1][j]) // left
		    {
		        printlcsRec(i, j-1, str);
		    }
		    else 
		    {
		        printlcsRec(i-1, j, str);
		        printlcsRec(i, j-1, str);
		    }
		
		}
		
};