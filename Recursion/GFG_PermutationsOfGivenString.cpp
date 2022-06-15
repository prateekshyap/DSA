/*
https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1/#
Permutations of a given string 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
	public:
	    
	    vector<string> ans;
	    int n;
		vector<string>find_permutation(string S)
		{
		    
		   sort(S.begin(), S.end());
		   
		   do{
		       ans.push_back(S);
		   }while(next_permutation(S.begin(), S.end()));
		    
		   /* 
		   n = S.size();
		   
		   permute(0,S);
		   
		   sort(ans.begin(), ans.end());
		   
		   */
		    return ans;
		}
		
		void permute(int ind, string &S)
		{
		    if(ind==n-1)
		    {
		        ans.push_back(S);
		        return;
		    }
		    
		    for(int k=ind; k<n; k++)
		    {
		        if(ind<k && S[k]==S[k-1])continue;
		        swap(S[ind], S[k]);
		        permute(ind+1, S);
		        swap(S[ind], S[k]);
		    }
		}
};



// { Driver Code Starts.
int main(){
    int t;
    cin >> t;
    while(t--)
    {
	    string S;
	    cin >> S;
	    Solution ob;
	    vector<string> ans = ob.find_permutation(S);
	    for(auto i: ans)
	    {
	    	cout<<i<<" ";
	    }
	    cout<<"\n";
    }
	return 0;
}
  // } Driver Code Ends