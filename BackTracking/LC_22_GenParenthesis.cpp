/*
https://leetcode.com/problems/generate-parentheses/
22. Generate Parentheses
https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1
*/
class Solution {
public:
    string s;
    vector<string> ans;
    int len;
    
    vector<string> generateParenthesis(int n) {
        len = n;
        
        // genParanNt0(n,n); // left paranetheses, right paranetheses remaining
        genParan0ToN(0,0, "");
        return ans;
    }//end
    
    void genParanNt0(int left, int right)
    {
        
        if(left == 0 && right == 0)
        {    
            ans.push_back(s);
            return;
        }
        
        if(left>0)
        {
            s.push_back('(');
                genParanNt0(left-1, right); // one left bracket used
            s.pop_back(); 
        }
        
        if(right > left) 
        {
            s.push_back(')');
                genParanNt0(left, right-1); //one right bracket used
            s.pop_back();
        }
        
    }
    
    void genParan0ToN(int left, int right, string s)
    {
        
        if(left == len && right == len)
        {    
            ans.push_back(s);
            return;
        }
        
        if(left<len)
        {
            // s.push_back('(');
                genParan0ToN(left+1, right, s+'('); // one left bracket used
            // s.pop_back(); 
        }
        
        if(right < left) 
        {
            // s.push_back(')');
                genParan0ToN(left, right+1, s+')'); //one right bracket used
            // s.pop_back();
        }
        
    }
};

//GFG
// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;
vector<string> AllParenthesis(int n) ;


 // } Driver Code Ends
//User function Template for C++

// N is the number of pairs of parentheses
// Return list of all combinations of balanced parantheses
class Solution
{
    public:
    
    int N;
    vector<string> ans;
    
    vector<string> AllParenthesis(int n) 
    {
        N=n;
        countPath(0, 0, "");
        
        return ans;
    }
    
    void countPath(int l, int r, string s) 
    {
        if(l==N && r==N)
        {
            ans.push_back(s);
            return;
        }
        
        if(l<N)
            countPath(l+1, r, s+'(');
        
        if(r<l)
            countPath(l, r+1, s+')');
 
    }
};

// { Driver Code Starts.


int main() 
{ 
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		Solution ob;
		vector<string> result = ob.AllParenthesis(n); 
		sort(result.begin(),result.end());
		for (int i = 0; i < result.size(); ++i)
			cout<<result[i]<<"\n";
	}
	return 0; 
} 
  // } Driver Code Ends