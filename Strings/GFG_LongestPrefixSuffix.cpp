/*
Longest Prefix Suffix 
https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1#
*/

// { Driver Code Starts
//Initial template for C++ 
 
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends

//User function template for C++

class Solution{
  public:		
	int lps(string s) {
	    int n = s.length();
	    int lps[n] = {0};
	    lps[0] = 0;
	    
	    int i=1; 
	    int len=0;
	    
	    while(i<n)
	    {
	        if(s[len] == s[i])
	        {
	            len++;
	            lps[i] = len;
	            i++;
	        }
	        else
	        {
	            if(len==0)
	            {
	                lps[i]=0;
	                i++;
	            }
	            else{
	                len = lps[len-1]; // reset len to last ind being matched
	            }
	        }
	    }
	    
	   // for(int i=0; i<n; i++)
	   //     cout<<lps[i]<<" ";
	    
	    return lps[n-1];
	}//end
};

// { Driver Code Starts.

int main() 
{
   

   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   
   	int t;
   	cin >> t;
   	while(t--)
   	{
   		string str;
   		cin >> str;

   		Solution ob;

   		cout << ob.lps(str) << "\n";
   	}

    return 0;
}
  // } Driver Code Ends
